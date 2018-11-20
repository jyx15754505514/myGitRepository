package com.ccicnavi.bims.orderReview.service;

import com.alibaba.fastjson.JSONObject;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.dao.impl.OrderReviewDaoImpl;
import com.ccicnavi.bims.order.pojo.OrderReviewDO;
import org.junit.Test;


//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = ApplicationTest.class)
public class ApplicationTest {
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