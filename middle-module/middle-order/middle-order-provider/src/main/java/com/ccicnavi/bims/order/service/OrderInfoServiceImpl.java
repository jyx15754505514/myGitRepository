package com.ccicnavi.bims.order.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.api.OrderInfoService;
import com.ccicnavi.bims.order.dao.*;
import com.ccicnavi.bims.order.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;

/**
 * @Author MengZiJie
 * @Description 委托单
 * @Date 17:06 2018/11/19
 */
@Slf4j
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoDao orderInfoDao;

    @Autowired
    private OrderInspectionDao orderInspectionDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    OrderItemSubDao orderItemSubDao;

    @Autowired
    OrderSampleTypeDao orderSampleTypeDao;

    @Reference(url = "dubbo://127.0.0.1:20880",timeout = 1000)
    IdWorkerService idWorkerService;

    /**
     * @Author MengZiJie
     * @Description 新增委托单
     * @Date 17:31 2018/11/19
     * @Param [orderInfoDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderInfo(OrderInfoDTO orderInfoDTO) {
        EqlTran eqlTran = null;
        Integer orderInfo = null;
        try {
            orderInfo = orderInfoDao.insertOrderInfo(orderInfoDTO,eqlTran);
            if(orderInfo > 0){
                return orderInfo;
            }
        } catch (Exception e) {
            log.error("新增委托单失败",e);
        }
        return -1;
    }

    /**
     * @Author MengZiJie
     * @Description 总的更新委托单
     * @Date 17:31 2018/11/19
     * @Param [orderInfoDO]
     * @Return java.lang.Integer
     */
    @Override
    public ResultT updateOrderInfo(OrderInfoDTO orderInfoDTO) {
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        Integer orderInfo = null;
        Integer shipment = null;
        Integer orderItem = null;
        Integer itemSub = null;
        boolean result=true;
        Integer orderSampleTypeResult =null;
        try {
            if(orderInfoDTO.getOrderInspectionDO()!=null){
                orderInfoDTO.getOrderInspectionDO().setOrderUuid(orderInfoDTO.getOrderUuid());
              //更新委托单运输信息
                shipment = orderInspectionDao.updateOrderInspection(orderInfoDTO.getOrderInspectionDO(), eqlTran);
                if(shipment!=1){
                    result=false;
                }
            }
            //页面传过来的最小服务项
            List<OrderItemDTO> orderItemDTO = orderInfoDTO.getOrderItemDTO();
            if(orderItemDTO!=null){
                OrderItemDTO item=new OrderItemDTO();
                item.setOrderUuid(orderInfoDTO.getOrderUuid());
                //逻辑删除数据库中存的最小服务项
                Integer orderItemResult=orderItemDao.deleteOrderItem(item,eqlTran);
                if(orderItemResult<0){
                    result=false;
                }

                for (int i = 0; i < orderItemDTO.size(); i++) {
                    if(orderItemDTO.get(i).getOrderItemUuid()!=null){
                        orderItemDTO.get(i).setIsDeleted("N");
                        //判断标识
                        orderItemDTO.get(i).setFlag("1");
                        //更新服务项信息
                        orderItem =orderItemDao.updateOrderItem(orderItemDTO.get(i),eqlTran);
                        if(orderItem!=1){
                            result=false;
                        }
                        if(orderItemDTO.get(i).getOrderItemSubDO() != null){
                            OrderItemSubDO orderItemSub =new OrderItemSubDO ();
                            orderItemSub.setItemUuid(orderItemDTO.get(i).getOrderItemUuid());
                            //物理删除服务子项信息
                            Integer orderItemSubResult=orderItemSubDao.deleteOrderItemSub(orderItemSub,eqlTran);
                            if(orderItemSubResult<0){
                                result=false;
                            }
                            List<OrderItemSubDO> orderItemSubDO = orderItemDTO.get(i).getOrderItemSubDO();
                            for (int j = 0; j < orderItemSubDO.size(); j++) {
                                String orderItemSubUuid = idWorkerService.getId(new Date());
                                orderItemSubDO.get(j).setSubItemUuid(orderItemSubUuid);
                                //更新服务子项信息
                                itemSub = orderItemSubDao.insertOrderItemSub(orderItemSubDO.get(j),eqlTran);
                                if(itemSub!=1){
                                    result=false;
                                }
                            }
                        }
                    }
                    //新增操作(之前没有选择的最小服务项和最小颗粒度)
                    if(orderItemDTO.get(i).getOrderItemUuid()==null){
                        String orderItemUuid = idWorkerService.getId(new Date());
                        orderItemDTO.get(i).setOrderItemUuid(orderItemUuid);//生成服务项主键
                        orderItemDTO.get(i).setOrderUuid(orderInfoDTO.getOrderUuid());
                        //添加委托单服务项
                        orderItem = orderItemDao.insertOrderItem(orderItemDTO.get(i),eqlTran);
                        if(orderItem!=1){
                            result=false;
                        }
                        if(orderItemDTO.get(i).getOrderItemSubDO() != null){
                            List<OrderItemSubDO> orderItemSubDO = orderItemDTO.get(i).getOrderItemSubDO();
                            for (int j = 0; j < orderItemSubDO.size(); j++) {
                                String orderItemSubUuid = idWorkerService.getId(new Date());
                                orderItemSubDO.get(j).setSubItemUuid(orderItemSubUuid);//生成子项主键id
                                orderItemSubDO.get(j).setItemUuid(orderItemUuid);//生成服务项id
                                //添加子项信息
                                itemSub = orderItemSubDao.insertOrderItemSub(orderItemSubDO.get(j),eqlTran);
                                if(itemSub!=1){
                                    result=false;
                                }
                            }
                        }
                    }
                }
            }
            //更新委托样品类型
            List<OrderSampleTypeDO> orderSampleTypeDO=orderInfoDTO.getOrderSampleTypeDO();
            if(orderSampleTypeDO!=null){
                //物理删除委托样品类型
                OrderSampleTypeDO sampleType=new OrderSampleTypeDO ();
                sampleType.setOrderUuid(orderInfoDTO.getOrderUuid());
                orderSampleTypeResult=orderSampleTypeDao.deleteOrderSampleType(sampleType,eqlTran);
                if(orderSampleTypeResult<0){
                    result=false;
                }
                for(OrderSampleTypeDO o :orderSampleTypeDO){
                    OrderSampleTypeDO orderSampleType=new  OrderSampleTypeDO();
                    String orderSplUuid = idWorkerService.getId(new Date());
                    orderSampleType.setOrderSplUuid(orderSplUuid);
                    orderSampleType.setOrderUuid(orderInfoDTO.getOrderUuid());
                    orderSampleType.setSplPurposeType(o.getSplPurposeType());
                    orderSampleType.setSplPurposeQty(o.getSplPurposeQty());
                    orderSampleTypeResult= orderSampleTypeDao.insertOrderSampleType(orderSampleType,eqlTran);
                    if(orderSampleTypeResult!=1){
                        result=false;
                    }
                }
            }
            //更新委托单详情
            orderInfo = orderInfoDao.updateOrderInfo(orderInfoDTO,eqlTran);
            if(orderInfo!=1){
                result=false;
            }
            if(result){
                eqlTran.commit();
                return ResultT.success();
            }
        } catch (Exception e) {
            log.error("更新委托单信息",e);
        }finally {
            eqlTran.close();
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

    /**
     * @Author MengZiJie
     * @Description 分页查看委托单
     * @Date 17:31 2018/11/19
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.order.pojo.OrderInfoDO>
     */
    @Override
    public PageBean<OrderInfoDO> listOrderInfo(PageParameter<OrderInfoDO> pageParameter) {
        try {
            return orderInfoDao.listOrderInfoPage(pageParameter);
        } catch (Exception e) {
            log.error("委托单分页查询失败",e);
            return null;
        }
    }

    /**
     * @Author MengZiJie
     * @Description 保存委托单
     * @Date 9:55 2018/11/20
     * @Param [orderInfoDTO]
     * @Return java.lang.Integer
     */
    @Override
    public ResultT saveOrderInfo(OrderInfoDTO orderInfoDTO) {
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        Integer shipment = null;
        Integer orderItem = null;
        Integer itemSub = null;
        Integer orderInfo = null;
        Integer orderSampleTypeResult =null;
        Integer updateOrderStatus=null;
        boolean result=true;
        try {
            eqlTran.start();
            String orderUuid = idWorkerService.getId(new Date());
            orderInfoDTO.setOrderUuid(orderUuid); //生成委托单id
            //委托单运输信息
            if(orderInfoDTO.getOrderInspectionDO()!=null){
                orderInfoDTO.getOrderInspectionDO().setOrderUuid(orderUuid);
                //添加委托单运输信息
                shipment = orderInspectionDao.insertOrderInspection(orderInfoDTO.getOrderInspectionDO(),eqlTran);
                if(shipment!=1){
                    result=false;
                }
            }
            //委托单服务项
            List<OrderItemDTO> orderItemDTO = orderInfoDTO.getOrderItemDTO();
            if(orderItemDTO!=null){
                for (int i = 0; i < orderItemDTO.size(); i++) {
                    String orderItemUuid = idWorkerService.getId(new Date());
                    orderItemDTO.get(i).setOrderItemUuid(orderItemUuid);//生成服务项主键
                    orderItemDTO.get(i).setOrderUuid(orderUuid);//委托单id
                    //添加委托单服务项
                    orderItem = orderItemDao.insertOrderItem(orderItemDTO.get(i),eqlTran);
                    if(orderItem!=1){
                        result=false;
                    }
                    if(orderItemDTO.get(i).getOrderItemSubDO() != null){
                        List<OrderItemSubDO> orderItemSubDO = orderItemDTO.get(i).getOrderItemSubDO();
                        for (int j = 0; j < orderItemSubDO.size(); j++) {
                            String orderItemSubUuid = idWorkerService.getId(new Date());
                            orderItemSubDO.get(j).setSubItemUuid(orderItemSubUuid);//生成子项主键id
                            orderItemSubDO.get(j).setItemUuid(orderItemUuid);//生成服务项id
                            //添加子项信息
                            itemSub = orderItemSubDao.insertOrderItemSub(orderItemSubDO.get(j),eqlTran);
                            if(itemSub!=1){
                                result=false;
                            }
                        }
                    }
                }
            }
          /*  //添加委托样品类型
            List<OrderSampleTypeDO> orderSampleTypeDO=orderInfoDTO.getOrderSampleTypeDO();
            if(orderSampleTypeDO!=null){
                for(OrderSampleTypeDO o :orderSampleTypeDO){
                    OrderSampleTypeDO orderSampleType=new  OrderSampleTypeDO();
                    String orderSplUuid = idWorkerService.getId(new Date());
                    orderSampleType.setOrderSplUuid(orderSplUuid);
                    orderSampleType.setOrderUuid(orderUuid);
                    orderSampleType.setSplPurposeType(o.getSplPurposeType());
                    orderSampleType.setSplPurposeQty(o.getSplPurposeQty());
                    orderSampleTypeResult= orderSampleTypeDao.insertOrderSampleType(orderSampleType,eqlTran);
                    if(orderSampleTypeResult!=1){
                        result=false;
                    }
                }
            }*/
            //添加委托单详情
            orderInfo = orderInfoDao.insertOrderInfo(orderInfoDTO,eqlTran);
            if(orderInfo!=1){
                result=false;
            }
            //提交操作执行修改状态
            if("2".equals(orderInfoDTO.getFlag())){
                 updateOrderStatus = orderInfoDao.updateOrderStatus(orderInfoDTO,eqlTran);
                 if(updateOrderStatus!=1){
                     result=false;
                 }
                 //55555555555
            }
            if(result){
                eqlTran.commit();
                return ResultT.success();
             }
        } catch (Exception e) {
            log.error("委托单保存失败",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
        return ResultT.failure(ResultCode.ADD_FAILURE);
    }
    /**
     * 功能描述: 根据委托单主键回显委托单相应信息
     * @param: orderInfoDO
     * @return: OrderInfoDTO
     * @auther: fandongsheng
     * @date: 2018/11/21 14:08
     */
    @Override
    public OrderInfoDTO getOrderInfo(OrderInfoDO orderInfoDO) {
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        try {
            if(orderInfoDO.getOrderUuid()!=null){
                //查询所有的委托单信息
               orderInfoDTO = orderInfoDao.getOrderInfo(orderInfoDO);
                //根据委托单主键查询服务项目信息 返回list
               List<OrderItemDTO> orderItemDTOList = orderItemDao.listOrderItemDTO(orderInfoDO);
               if(orderItemDTOList!=null){
                   for(int i=0;i<orderItemDTOList.size();i++){
                       List<OrderItemSubDO> orderItemSubDOList = orderItemSubDao.listOrderItemSub(orderItemDTOList.get(i));
                       if(orderItemSubDOList!=null){
                           orderItemDTOList.get(i).setOrderItemSubDO(orderItemSubDOList);
                       }
                   }
                   orderInfoDTO.setOrderItemDTO(orderItemDTOList);
               }
            }
        } catch (Exception e) {
           log.error("委托单回显失败",e);
           return null;
        }
        return orderInfoDTO;
    }

    /**
     * @Author MengZiJie
     * @Description 改变委托单状态
     * @Data 2018/11/27 17:19
     * @Param [orderInfoDTO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderStatus(OrderInfoDTO orderInfoDTO) {
        try {
            Integer orderInfo = orderInfoDao.updateOrderStatus(orderInfoDTO, null);
            if(orderInfo > 0){
                return orderInfo;
            }
        } catch (Exception e) {
            log.error("操作失败！",e);
        }
        return -1;
    }
    
    /**
     * @Author MengZiJie
     * @Description 删除委托单
     * @Data 2018/11/28 9:41
     * @Param [orderInfoDTO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer removeOrderInfo(OrderInfoDTO orderInfoDTO) {
        EqlTran eqlTran = new Eql().newTran();
        OrderInspectionDTO orderInspectionDTO = new OrderInspectionDTO();
        Boolean status = true;
        try {
            eqlTran.start();
            List<String> orderUuids = orderInfoDTO.getOrderUuids();
            if (orderUuids.size() > 0) {
                /**删除委托单信息*/
                Integer orderInfo = orderInfoDao.removeOrderInfo(orderInfoDTO,eqlTran);
                if (orderInfo <= 0) {
                    status = false;
                }
                /**删除运输方式*/
                orderInspectionDTO.setOrderUuids(orderUuids);
                Integer orderInspection = orderInspectionDao.deleteOrderInspection(orderInspectionDTO, eqlTran);
                if (orderInspection <= 0) {
                    status = false;
                }
            }
            if (status = true) {
                return 1;
            }
        } catch (Exception e) {
            log.error("删除失败",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
        return -1;
    }
}
