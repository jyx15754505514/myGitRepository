package com.ccicnavi.bims.orderInfo.service;

import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.dao.impl.OrderInfoDaoImpl;
import com.ccicnavi.bims.order.dao.impl.OrderReviewDaoImpl;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import org.junit.Test;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/20 20:31
 * @Description:
 */
public class TestOrderInfo {
    /**委托单列表**/
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
}
