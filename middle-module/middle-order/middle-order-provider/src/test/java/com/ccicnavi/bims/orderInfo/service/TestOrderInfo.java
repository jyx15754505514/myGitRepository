package com.ccicnavi.bims.orderInfo.service;

import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.dao.OrderInfoDao;
import com.ccicnavi.bims.order.dao.OrderInspectionDao;
import com.ccicnavi.bims.order.dao.impl.*;
import com.ccicnavi.bims.order.pojo.*;
import com.ccicnavi.bims.order.service.OrderInfoServiceImpl;
import org.junit.Test;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/20 20:31
 * @Description:
 */
public class TestOrderInfo {

    private static SimpleDateFormat timeFormat = new SimpleDateFormat("yyMMddHHmmss");





    @Test
    public void getOrderInfo(){
        try {
            OrderInfoDaoImpl orderInfoDaoImpl = new OrderInfoDaoImpl();
            OrderItemDaoImpl orderItemDaoImpl = new OrderItemDaoImpl();
            OrderItemSubDaoImpl orderItemSubDaoImpl = new OrderItemSubDaoImpl();
            OrderInfoDO orderInfoDO = new OrderInfoDO();
            orderInfoDO.setOrderUuid("orderUuid1");
            OrderInfoDTO orderInfoDTO = orderInfoDaoImpl.getOrderInfo(orderInfoDO);//查询所有的委托单信息
            List<OrderItemDTO> orderItemDTOList = orderItemDaoImpl.listOrderItemDTO(orderInfoDO);//根据委托单主键查询服务项目信息 返回list
            if(orderItemDTOList!=null && orderInfoDTO!=null){
                for(OrderItemDTO orderItemDTO:orderItemDTOList){
                    List<OrderItemSubDO> orderItemSubDOList = orderItemSubDaoImpl.listOrderItemSub(orderItemDTO);
                    if(orderItemSubDOList!=null){
                        orderItemDTO.setOrderItemSubDO(orderItemSubDOList);
                    }
                }
                orderInfoDTO.setOrderItemDTO(orderItemDTOList);
            }
            System.err.println(orderInfoDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 委托单列表
     **/
    @Test
    public void listOrderInfo() {
        try {
            OrderInfoDaoImpl order = new OrderInfoDaoImpl();
            PageParameter<OrderInfoDO> pageParameter = new PageParameter<>();
            pageParameter.startPage = 1;
            pageParameter.pageRows = 2;
            OrderInfoDO orderInfoDO = new OrderInfoDO();
            pageParameter.setParameter(orderInfoDO);
            order.listOrderInfoPage(pageParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 保存委托单
     */
    @Test
    public void saveOrderInfo() {
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        //委托单
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        orderInfoDTO.setOrderName("委托名称Q");
        orderInfoDTO.setProdCatalogUuid("大宗线");
        orderInfoDTO.setOrgUuid("CCIC");
        orderInfoDTO.setAppSysUuid("BIMS");
        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();
        //最小服务项目
        for(int j=0;j<3;j++){
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setOrderItemNo("服务单编号Q"+j);//服务单编号
            //最小颗粒度
            List<OrderItemSubDO> orderItemSubList = new ArrayList<>();
            for(int i=0;i<2;i++){
                OrderItemSubDO orderItemSubDO = new OrderItemSubDO();
                orderItemSubDO.setItemName("最小颗粒度名称Q"+i);
                orderItemSubDO.setSubItemNo("最小颗粒度编号Q"+i);
                orderItemSubList.add(orderItemSubDO);
            }
            orderItemDTO.setOrderItemSubDO(orderItemSubList);
            orderItemDTOList.add(orderItemDTO);
        }
        orderInfoDTO.setOrderItemDTO(orderItemDTOList);
        //委托样品类型
        List<OrderSampleTypeDO> orderSampleTypeDOList=new ArrayList<OrderSampleTypeDO>();
        for(int k=1;k<4;k++){
            OrderSampleTypeDO orderSampleTypeDO=new OrderSampleTypeDO();
            orderSampleTypeDO.setSplPurposeType("样品类型id"+k);
            orderSampleTypeDO.setSplPurposeQty(k);
            orderSampleTypeDOList.add(orderSampleTypeDO);
        }
        orderInfoDTO.setOrderSampleTypeDO(orderSampleTypeDOList);
        Integer shipment = null;
        Integer orderItem = null;
        Integer itemSub = null;
        Integer orderInfo = null;
        Integer orderSampleTypeResult = null;
        boolean result=true;
        OrderInspectionDaoImpl orderInspectionDaoImpl = new OrderInspectionDaoImpl();
        OrderItemSubDaoImpl orderItemSubDaoImpl=new OrderItemSubDaoImpl();
        OrderInfoDaoImpl orderInfoDao = new OrderInfoDaoImpl();
        OrderItemDaoImpl orderItemDaoImpl = new OrderItemDaoImpl();
        OrderSampleTypeDaoImpl orderSampleTypeDaoImpl =new OrderSampleTypeDaoImpl();
        try {
            eqlTran.start();
            //String orderUuid = idWorkerService.getId(new Date());
            Date currentTime = new Date();
            String orderUuid = timeFormat.format(currentTime);
            orderInfoDTO.setOrderUuid(orderUuid);
            //添加委托单运输信息
            shipment = orderInspectionDaoImpl.insertOrderInspection(orderInfoDTO,eqlTran);
            if(shipment!=1){
                result=false;
            }
            List<OrderItemDTO> orderItemDTO = orderInfoDTO.getOrderItemDTO();
            if(orderItemDTO.size() > 0){
                for (int i = 0; i < orderItemDTO.size(); i++) {
                    String orderItemUuid = orderUuid + i;
                    orderItemDTO.get(i).setOrderItemUuid(orderItemUuid);//给当前对象 服务项放主键
                    orderItemDTO.get(i).setOrderUuid(orderUuid);//给当前对象 委托单放主键
                    orderItemDTO.get(i).setOrderItemNo("服务项编号"+i);//生成服务单编号
                    //添加委托单服务项
                    orderItem = orderItemDaoImpl.insertOrderItem(orderItemDTO.get(i),eqlTran);
                    if(orderItem!=1){
                        result=false;
                    }
                    if(orderItemDTO.get(i).getOrderItemSubDO() != null){
                        List<OrderItemSubDO> orderItemSubDO = orderItemDTO.get(i).getOrderItemSubDO();
                        for (int j = 0; j < orderItemSubDO.size(); j++) {
                            Date currentTime1 = new Date();
                            String orderItemSubUuid = timeFormat.format(currentTime1);
                            orderItemSubDO.get(j).setSubItemUuid(orderItemSubUuid+j);//生成最小颗粒度id
                            orderItemSubDO.get(j).setItemUuid(orderItemUuid);//生成服务项id
                            orderItemSubDO.get(j).setSubItemNo("最小颗粒度NO."+j);//生成z最小颗粒度的编号
                            //添加子项信息
                            itemSub = orderItemSubDaoImpl.insertOrderItemSub(orderItemSubDO.get(j),eqlTran);
                            if(itemSub!=1){
                                result=false;
                            }
                        }
                    }
                }
            }
            //添加委托样品类型
            List<OrderSampleTypeDO> orderSampleTypeDO=orderInfoDTO.getOrderSampleTypeDO();
            if(orderSampleTypeDO.size()>0){
                for(OrderSampleTypeDO o :orderSampleTypeDO){
                    OrderSampleTypeDO orderSampleType=new  OrderSampleTypeDO();
                    String orderSplUuid = timeFormat.format(new Date());
                    orderSampleType.setOrderSplUuid(orderSplUuid);
                    orderSampleType.setOrderUuid(orderUuid);
                    orderSampleType.setSplPurposeType(o.getSplPurposeType());
                    orderSampleType.setSplPurposeQty(o.getSplPurposeQty());
                    orderSampleTypeResult= orderSampleTypeDaoImpl.insertOrderSampleType(orderSampleType,eqlTran);
                    if(orderSampleTypeResult!=1){
                        result=false;
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
               // return ResultT.success();
            }
        } catch (Exception e) {
            //log.error("保存失败",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
       // return ResultT.failure(ResultCode.ADD_FAILURE);
    }

/**
 * 更新委托单
 */
    @Test
    public void updateOrderInfo() {
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        OrderInspectionDaoImpl orderInspectionDaoImpl = new OrderInspectionDaoImpl();
        OrderItemSubDaoImpl orderItemSubDaoImpl=new OrderItemSubDaoImpl();
        OrderInfoDaoImpl orderInfoDao = new OrderInfoDaoImpl();
        OrderItemDaoImpl orderItemDaoImpl = new OrderItemDaoImpl();
        OrderSampleTypeDaoImpl orderSampleTypeDaoImpl =new OrderSampleTypeDaoImpl();
        Integer shipment = null;
        Integer orderItem = null;
        Integer itemSub = null;
        Integer orderInfo = null;
        boolean result=true;
        Integer orderSampleTypeResult =null;
        //委托单
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        orderInfoDTO.setOrderName("委托名称Q+1");
        orderInfoDTO.setProdCatalogUuid("大宗线+1");
        orderInfoDTO.setOrgUuid("CCIC"+1);
        orderInfoDTO.setAppSysUuid("BIMS+1");
        orderInfoDTO.setOrderUuid("181121222505");
        orderInfoDTO.setShippingTypeId("111");
        //委托样品类型
        List<OrderSampleTypeDO> orderSampleTypeDOList=new ArrayList<OrderSampleTypeDO>();
        for(int k=1;k<4;k++){
            OrderSampleTypeDO orderSampleTypeDO=new OrderSampleTypeDO();
            orderSampleTypeDO.setSplPurposeType("样品类型id"+k);
            orderSampleTypeDO.setSplPurposeQty(k);
            orderSampleTypeDOList.add(orderSampleTypeDO);
        }
        orderInfoDTO.setOrderSampleTypeDO(orderSampleTypeDOList);
        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();
        //最小服务项目
        for(int j=0;j<3;j++){
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            if(j==0){
                orderItemDTO.setOrderItemUuid("1811212225050");
            }
            orderItemDTO.setOrderItemNo("服务单编号Q1"+j);//服务单编号
            //最小颗粒度
            List<OrderItemSubDO> orderItemSubList = new ArrayList<>();
            for(int i=0;i<2;i++){
                OrderItemSubDO orderItemSubDO = new OrderItemSubDO();
                orderItemSubDO.setItemName("最小颗粒度名称Q1"+i);
                orderItemSubDO.setSubItemNo("最小颗粒度编号Q1"+i);
                orderItemSubList.add(orderItemSubDO);
            }
            orderItemDTO.setOrderItemSubDO(orderItemSubList);
            orderItemDTOList.add(orderItemDTO);
        }
        orderInfoDTO.setOrderItemDTO(orderItemDTOList);



        try {
            //更新委托单运输信息
            shipment = orderInspectionDaoImpl.updateOrderInspection(orderInfoDTO, eqlTran);
            if(shipment!=1){
                result=false;
            }
            OrderItemDTO item=new OrderItemDTO();
            item.setOrderUuid(orderInfoDTO.getOrderUuid());
            //逻辑删除数据库中存的最小服务项
            Integer orderItemResult=orderItemDaoImpl.deleteOrderItem(item,eqlTran);
            if(orderItemResult<0){
                result=false;
            }
            //页面传过来的最小服务项
            List<OrderItemDTO> orderItemDTO = orderInfoDTO.getOrderItemDTO();
         //   System.out.println(orderItemDTO.size());
            if(orderItemDTO!=null){
                for (int i = 0; i < orderItemDTO.size(); i++) {
                    if(orderItemDTO.get(i).getOrderItemUuid()!=null){
                        orderItemDTO.get(i).setIsDeleted("N");
                        //判断标识
                        orderItemDTO.get(i).setFlag("1");
                        //更新服务项信息
                        orderItem =orderItemDaoImpl.updateOrderItem(orderItemDTO.get(i),eqlTran);
                        if(orderItem!=1){
                            result=false;
                        }
                        if(orderItemDTO.get(i).getOrderItemSubDO() != null){
                            OrderItemSubDO orderItemSub =new OrderItemSubDO ();
                            orderItemSub.setItemUuid(orderItemDTO.get(i).getOrderItemUuid());
                            //物理删除服务子项信息
                            Integer orderItemSubResult=orderItemSubDaoImpl.deleteOrderItemSub(orderItemSub,eqlTran);
                            if(orderItemSubResult<0){
                                result=false;
                            }
                            List<OrderItemSubDO> orderItemSubDO = orderItemDTO.get(i).getOrderItemSubDO();
                            for (int j = 0; j < orderItemSubDO.size(); j++) {
                                String orderItemSubUuid = timeFormat.format(new Date());
                                orderItemSubDO.get(j).setSubItemUuid(orderItemSubUuid);
                                orderItemSubDO.get(j).setItemUuid(orderItemDTO.get(i).getOrderItemUuid());
                                //更新服务子项信息
                                itemSub = orderItemSubDaoImpl.insertOrderItemSub(orderItemSubDO.get(j),eqlTran);
                                if(itemSub!=1){
                                    result=false;
                                }
                            }
                        }
                    }
                    //新增操作(之前没有选择的最小服务项和最小颗粒度)
                    if(orderItemDTO.get(i).getOrderItemUuid()==null){
                        String orderItemUuid = timeFormat.format(new Date());
                        System.out.println("============"+orderItemUuid);
                        orderItemDTO.get(i).setOrderItemUuid(orderItemUuid);//生成服务项主键
                        orderItemDTO.get(i).setOrderItemNo("");//生成服务单编号
                        //添加委托单服务项
                        orderItem = orderItemDaoImpl.insertOrderItem(orderItemDTO.get(i),eqlTran);
                        if(orderItem!=1){
                            result=false;
                        }
                        if(orderItemDTO.get(i).getOrderItemSubDO() != null){
                            List<OrderItemSubDO> orderItemSubDO = orderItemDTO.get(i).getOrderItemSubDO();
                            for (int j = 0; j < orderItemSubDO.size(); j++) {
                                String orderItemSubUuid = timeFormat.format(new Date());
                                orderItemSubDO.get(j).setSubItemUuid(orderItemSubUuid);//生成子项主键id
                                orderItemSubDO.get(j).setItemUuid(orderItemUuid);//生成服务项id
                                orderItemSubDO.get(j).setSubItemNo("");//生成子项编号
                                //添加子项信息
                                itemSub = orderItemSubDaoImpl.insertOrderItemSub(orderItemSubDO.get(j),eqlTran);
                                if(itemSub!=1){
                                    result=false;
                                }
                            }
                        }
                    }
                }
            }
            //物理删除委托样品类型
            OrderSampleTypeDO sampleType=new OrderSampleTypeDO ();
            sampleType.setOrderUuid(orderInfoDTO.getOrderUuid());
            orderSampleTypeResult=orderSampleTypeDaoImpl.deleteOrderSampleType(sampleType,eqlTran);
            if(orderSampleTypeResult<0){
                result=false;
            }
            //添加委托样品类型
            List<OrderSampleTypeDO> orderSampleTypeDO=orderInfoDTO.getOrderSampleTypeDO();
            if(orderSampleTypeDO!=null){
                for(OrderSampleTypeDO o :orderSampleTypeDO){
                    OrderSampleTypeDO orderSampleType=new  OrderSampleTypeDO();
                    String orderSplUuid = timeFormat.format(new Date());
                    orderSampleType.setOrderSplUuid(orderSplUuid);
                    orderSampleType.setOrderUuid(orderInfoDTO.getOrderUuid());
                    orderSampleType.setSplPurposeType(o.getSplPurposeType());
                    orderSampleType.setSplPurposeQty(o.getSplPurposeQty());
                    orderSampleTypeResult= orderSampleTypeDaoImpl.insertOrderSampleType(orderSampleType,eqlTran);
                    if(orderSampleTypeResult!=1){
                        result=false;
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
               // return ResultT.success();
            }
        } catch (Exception e) {
          //  log.error("修改失败",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
      //  return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }
}
