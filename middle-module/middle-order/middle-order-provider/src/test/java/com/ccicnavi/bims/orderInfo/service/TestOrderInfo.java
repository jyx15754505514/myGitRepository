package com.ccicnavi.bims.orderInfo.service;

import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.dao.OrderInfoDao;
import com.ccicnavi.bims.order.dao.OrderInspectionDao;
import com.ccicnavi.bims.order.dao.impl.*;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import com.ccicnavi.bims.order.pojo.OrderItemDTO;
import com.ccicnavi.bims.order.pojo.OrderItemSubDO;
import com.ccicnavi.bims.order.service.OrderInfoServiceImpl;
import org.junit.Test;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/20 20:31
 * @Description:
 */
public class TestOrderInfo {
    @Autowired
    IdWorkerService idWorkerService;
    @Autowired
    private OrderInspectionDao orderInspectionDao;
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
        Integer shipment = null;
        Integer orderItem = null;
        Integer itemSub = null;
        Integer orderInfo = null;
        boolean result=true;
        OrderInspectionDaoImpl orderInspectionDaoImpl = new OrderInspectionDaoImpl();
        OrderItemSubDaoImpl orderItemSubDaoImpl=new OrderItemSubDaoImpl();
        OrderInfoDaoImpl orderInfoDao = new OrderInfoDaoImpl();
        OrderItemDaoImpl orderItemDaoImpl = new OrderItemDaoImpl();
        List<OrderItemSubDO> orderItemSubList = new ArrayList<>();
        List<OrderItemDTO> orderItemDTOList = new ArrayList<OrderItemDTO>();
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        OrderItemDTO orderItemDTO1 = new OrderItemDTO();
        OrderItemSubDO orderItemSubDO1 = new OrderItemSubDO();
        //orderItemSubDO.setSubItemUuid("11");
        orderItemSubList.add(orderItemSubDO1);
        orderItemDTO1.setOrderItemSubDO(orderItemSubList);
       // orderItemDTO1.setOrderItemUuid("11");
        orderItemDTOList.add(orderItemDTO1);
        orderInfoDTO.setOrderItemDTO(orderItemDTOList);
        orderInfoDTO.setProdCatalogUuid("555");
        orderInfoDTO.setOrgUuid("555");
        orderInfoDTO.setAppSysUuid("555");
        try {
            eqlTran.start();
            //String orderUuid = idWorkerService.getId(new Date());
            orderInfoDTO.setOrderUuid("5555"); //生成委托单id
            //添加委托单运输信息
            shipment = orderInspectionDaoImpl.insertOrderInspection(orderInfoDTO,eqlTran);
            if(shipment!=1){
                result=false;
            }
            List<OrderItemDTO> orderItemDTO = orderInfoDTO.getOrderItemDTO();
            if(orderItemDTO.size() > 0){
                for (int i = 0; i < orderItemDTO.size(); i++) {
                    //String orderItemUuid = idWorkerService.getId(new Date());
                    orderItemDTO.get(i).setOrderItemUuid("55555");//生成服务项主键
                    orderItemDTO.get(i).setOrderUuid("5555");//委托单id

                    orderItemDTO.get(i).setOrderItemNo("");//生成服务单编号
                    //添加委托单服务项
                    orderItem = orderItemDaoImpl.insertOrderItem(orderItemDTO.get(i),eqlTran);
                    if(orderItem!=1){
                        result=false;
                    }
                    if(orderItemDTO.get(i).getOrderItemSubDO() != null){
                        List<OrderItemSubDO> orderItemSubDO = orderItemDTO.get(i).getOrderItemSubDO();
                        for (int j = 0; j < orderItemSubDO.size(); j++) {
                           // String orderItemSubUuid = idWorkerService.getId(new Date());
                            orderItemSubDO.get(j).setSubItemUuid("555555");//生成子项主键id
                            orderItemSubDO.get(j).setItemUuid("55555");//生成服务项id

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
}
