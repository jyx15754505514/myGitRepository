package com.ccicnavi.bims.orderResultInfo.service;

import com.ccicnavi.bims.order.dao.impl.OrderResultInfoDaoImpl;
import com.ccicnavi.bims.order.pojo.OrderResultInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author songyateng
 * @Description 测试更新证书
 * @Date $time$ $date$
 * @Param $param$
 * @Return $return$
 */
@Slf4j
public class TestOrderResultInfo {
    /**
     * @Author songyateng
     * @Description  测试更新证书
     * @Date 2018/11/28 0:04
     */
    @Test
    public void updateOrderResultInfo(){
        try {
            OrderResultInfoDaoImpl order = new OrderResultInfoDaoImpl();
            OrderResultInfoDO orderResultInfoDO = new OrderResultInfoDO();
            orderResultInfoDO.setResultUuid("AAA");
            orderResultInfoDO.setResultNo("BBB");
            System.err.print(order.updateOrderResultInfo(orderResultInfoDO, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
