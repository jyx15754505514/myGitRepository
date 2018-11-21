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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* *
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

    /* *
     * @Author MengZiJie
     * @Description 新增委托单
     * @Date 17:31 2018/11/19
     * @Param [orderInfoDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderInfo(OrderInfoDTO orderInfoDTO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            integer = orderInfoDao.insertOrderInfo(orderInfoDTO,eqlTran);
        } catch (Exception e) {
            log.error("新增委托单失败",e);
        }
        return integer;
    }

    /* *
     * @Author MengZiJie
     * @Description 更新委托单
     * @Date 17:31 2018/11/19
     * @Param [orderInfoDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderInfo(OrderInfoDTO orderInfoDTO) {
        EqlTran eqlTran = null;
        Integer integer = null;
        try {
            integer = orderInfoDao.updateOrderInfo(orderInfoDTO,eqlTran);
        } catch (Exception e) {
            log.error("更新委托单信息",e);
        }
        return integer;
    }

    @Override
    public PageBean<OrderInfoDO> listOrderInfo(PageParameter<OrderInfoDO> pageParameter) {
        try {
            return orderInfoDao.listOrderInfoPage(pageParameter);
        } catch (Exception e) {
            log.error("委托单分页查询失败");
            return null;
        }
    }

    /* *
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
        boolean result=true;
        try {
            eqlTran.start();
            if(orderInfoDTO.getOrderUuid() != null && !orderInfoDTO.getOrderUuid().equals("")){
                //更新委托单运输信息
                shipment = orderInspectionDao.updateOrderInspection(orderInfoDTO, eqlTran);
                if(shipment!=1){
                    result=false;
                }
                List<OrderItemDTO> orderItemDTO = orderInfoDTO.getOrderItemDTO();
                if(orderItemDTO.size() > 0){
                    for (int i = 0; i < orderItemDTO.size(); i++) {
                        //更新服务项信息
                        orderItem =orderItemDao.updateOrderItem(orderItemDTO.get(i),eqlTran);
                        if(orderItem!=1){
                            result=false;
                        }
                        if(orderItemDTO.get(i).getOrderItemSubDO() != null){
                            List<OrderItemSubDO> orderItemSubDO = orderItemDTO.get(i).getOrderItemSubDO();
                            for (int j = 0; j < orderItemSubDO.size(); j++) {
                                //更新服务子项信息
                                itemSub = orderItemSubDao.insertOrderItemSub(orderItemSubDO.get(j),eqlTran);
                                if(itemSub!=1){
                                    result=false;
                                }
                            }
                        }
                    }
                }
                //更新委托单详情*/
                orderInfo = orderInfoDao.updateOrderInfo(orderInfoDTO,eqlTran);
                if(orderInfo!=1){
                    result=false;
                }
                if(result){
                    eqlTran.commit();
                    return ResultT.success();
                }
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
            String orderUuid = idWorkerService.getId(new Date());
            orderInfoDTO.setOrderUuid(orderUuid); //生成委托单id
            //添加委托单运输信息
            shipment = orderInspectionDao.insertOrderInspection(orderInfoDTO,eqlTran);
            if(shipment!=1){
                result=false;
            }
            List<OrderItemDTO> orderItemDTO = orderInfoDTO.getOrderItemDTO();
            if(orderItemDTO.size() > 0){
                for (int i = 0; i < orderItemDTO.size(); i++) {
                    String orderItemUuid = idWorkerService.getId(new Date());
                    orderItemDTO.get(i).setOrderItemUuid(orderItemUuid);//生成服务项主键
                    orderItemDTO.get(i).setOrderUuid(orderUuid);//委托单id

                    orderItemDTO.get(i).setOrderItemNo("");//生成服务单编号
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

                            orderItemSubDO.get(j).setSubItemNo("");//生成子项编号
                            //添加子项信息
                            itemSub = orderItemSubDao.insertOrderItemSub(orderItemSubDO.get(j),eqlTran);
                            if(itemSub!=1){
                                result=false;
                            }
                        }
                    }
                }
            }

            orderInfoDTO.setOrderNo("");//生成委托单号
            //添加委托单详情
            orderInfo = orderInfoDao.insertOrderInfo(orderInfoDTO,eqlTran);
            if(orderInfo!=1){
                result=false;
            }
            if(result){
                eqlTran.commit();
                return ResultT.success();
             }
        } catch (Exception e) {
            log.error("保存失败",e);
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
               orderInfoDTO = orderInfoDao.getOrderInfo(orderInfoDO);//查询所有的委托单信息
               List<OrderItemDTO> orderItemDTOList = orderItemDao.listOrderItemDTO(orderInfoDO);//根据委托单主键查询服务项目信息 返回list
               if(orderItemDTOList!=null){
                   for(OrderItemDTO orderItemDTO:orderItemDTOList){
                       List<OrderItemSubDO> orderItemSubDOList = orderItemSubDao.listOrderItemSub(orderItemDTO);
                       if(orderItemSubDOList!=null){
                           orderItemDTO.setOrderItemSubDO(orderItemSubDOList);
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
}
