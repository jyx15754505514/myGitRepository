package com.ccicnavi.bims.orderInfo.service;

import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.dao.OrderInfoDao;
import com.ccicnavi.bims.order.dao.OrderInspectionDao;
import com.ccicnavi.bims.order.dao.impl.OrderInfoDaoImpl;
import com.ccicnavi.bims.order.dao.impl.OrderInspectionDaoImpl;
import com.ccicnavi.bims.order.dao.impl.OrderReviewDaoImpl;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import com.ccicnavi.bims.order.pojo.OrderItemDTO;
import com.ccicnavi.bims.order.pojo.OrderItemSubDO;
import com.ccicnavi.bims.order.service.OrderInfoServiceImpl;
import org.junit.Test;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;

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
        boolean result=true;
        try {
            OrderInspectionDaoImpl orderInspectionDaoImpl=new OrderInspectionDaoImpl();
            OrderInfoServiceImpl order = new OrderInfoServiceImpl();
            OrderInfoDaoImpl orderInfoDao=new OrderInfoDaoImpl();
            OrderInfoDTO orderInfoDTO=new OrderInfoDTO();
            eqlTran.start();
          //  String orderUuid = idWorkerService.getId(new Date());
            orderInfoDTO.setOrderUuid("3"); //生成委托单id
            orderInfoDTO.setShippingTypeId("11");
            orderInfoDTO.setProdCatalogUuid("11");
            orderInfoDTO.setOrgUuid("11");
            orderInfoDTO.setAppSysUuid("111");
            Integer shipment = orderInspectionDaoImpl.insertOrderInspection(orderInfoDTO,eqlTran);
            if(shipment!=1){
                result=false;
            }
            System.out.println(shipment);
            Integer orderInfo = orderInfoDao.insertOrderInfo(orderInfoDTO,eqlTran);
            if(orderInfo!=1){
                result=false;
            }
            System.out.println(orderInfo);
            if(result){
                eqlTran.commit();
            }

            /* List<OrderItemDTO> orderItemDTO = orderInfoDTO.getOrderItemDTO();
            if(orderItemDTO.size() > 0){
                for (int i = 0; i < orderItemDTO.size(); i++) {
                    String orderItemUuid = idWorkerService.getId(new Date());
                    orderItemDTO.get(i).setOrderItemUuid(orderItemUuid);//生成服务项主键
                    orderItemDTO.get(i).setOrderUuid(orderUuid);//委托单id

                    orderItemDTO.get(i).setOrderItemNo("");//生成服务单编号
                    //添加委托单服务项
                    orderItem += orderItemDao.insertOrderItem(orderItemDTO.get(i),eqlTran);
                    if(orderItemDTO.get(i).getOrderItemSubDO() != null){
                        List<OrderItemSubDO> orderItemSubDO = orderItemDTO.get(i).getOrderItemSubDO();
                        for (int j = 0; j < orderItemSubDO.size(); j++) {
                            String orderItemSubUuid = idWorkerService.getId(new Date());
                            orderItemSubDO.get(j).setSubItemUuid(orderItemSubUuid);//生成子项主键id
                            orderItemSubDO.get(j).setItemUuid(orderItemUuid);//生成服务项id

                            orderItemSubDO.get(j).setSubItemNo("");//生成子项编号
                            //添加子项信息
                            itemSub += orderItemSubDao.insertOrderItemSub(orderItemSubDO.get(j),eqlTran);
                        }
                    }
                }
            }

            orderInfoDTO.setOrderNo("");//生成委托单号
            //添加委托单详情
            orderInfo = orderInfoDao.insertOrderInfo(orderInfoDTO,eqlTran);

            order.saveOrderInfo(orderInfoDTO);*/
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            eqlTran.close();
        }

    }
}
