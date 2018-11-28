package com.ccicnavi.bims.orderInspection.service;

import com.ccicnavi.bims.order.dao.impl.OrderInspectionDaoImpl;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import com.ccicnavi.bims.order.pojo.OrderInspectionDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author songyateng
 * @Description 运输方式
 * @Date 2018/11/27 21:22
 */
@Slf4j
public class TestOrderInspection {
    OrderInspectionDaoImpl order = new OrderInspectionDaoImpl();
    /**
     * @Author songyateng
     * @Description 测试运输方式信息保存(参数：OrderInspectionDO)
     * @Date 2018/11/27 21:21
     */
    @Test
    public void updateInspection() {
        try {
            OrderInspectionDO orderInspectionDO = new OrderInspectionDO();
            orderInspectionDO.setOrderUuid("181127170753");
            orderInspectionDO.setVesselName("名称");
            System.err.print(order.updateInspection(orderInspectionDO, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @Author songyateng
     * @Description 测试运输方式信息保存(参数：OrderInfoDTO)
     * @Date 2018/11/28 10:09
     */
    @Test
    public void updateOrderInspection(){
        try {
            OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
            orderInfoDTO.setOrderUuid("xinzengyunshifangshi");
            orderInfoDTO.setVesselName("修改DTO");
            System.err.print(order.updateOrderInspection(orderInfoDTO, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author songyateng
     * @Description 测试新增运输方式
     * @Date 2018/11/28 9:48
     */
    @Test
    public void insertOrderInspection(){
        try {
            OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
            orderInfoDTO.setOrderUuid("xinzengyunshUfangshi");
            orderInfoDTO.setVesselName("运输方式");
            System.err.print(order.insertOrderInspection(orderInfoDTO,null));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}