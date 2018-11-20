package com.ccicnavi.bims.orderReview.service;

import com.ccicnavi.bims.order.dao.impl.OrderReviewDaoImpl;
import com.ccicnavi.bims.order.pojo.OrderReviewDO;
import org.junit.Test;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/20 22:01
 * @Description:
 */
public class TestOrderReview {
    /***新增评审信息*/
    @Test
    public void insertOrderReview() {
        try {
            OrderReviewDaoImpl order = new OrderReviewDaoImpl();
            OrderReviewDO orderReviewDO = new OrderReviewDO();
            orderReviewDO.setOrderUuid("111");
            orderReviewDO.setReviewSuggest("222");
            orderReviewDO.setReviewUserUuid("333");
            System.err.print(order.insertOrderReview(orderReviewDO,null));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
