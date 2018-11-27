package com.ccicnavi.bims.orderInspection.service;

import com.ccicnavi.bims.order.dao.impl.OrderInspectionDaoImpl;
import com.ccicnavi.bims.order.pojo.OrderInspectionDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author songyateng
 * @Description 运输方式
 * @Date 2018/11/27 21:22
 * @Param  
 * @Return  
 */
@Slf4j
public class TestOrderInspection {
    /**
     * @Author songyateng
     * @Description 测试运输方式信息保存
     * @Date 2018/11/27 21:21
     * @Param
     * @Return
     */
    @Test
    public void updateInspection() {
        try {
            //456
            OrderInspectionDaoImpl order = new OrderInspectionDaoImpl();
            OrderInspectionDO orderInspectionDO = new OrderInspectionDO();
            orderInspectionDO.setOrderUuid("181127170753");
            orderInspectionDO.setVesselName("名称");
            System.err.print(order.updateInspection(orderInspectionDO, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}