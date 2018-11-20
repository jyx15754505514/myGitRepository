package com.ccicnavi.bims.orderReview.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.api.OrderReviewService;
import com.ccicnavi.bims.order.pojo.OrderReviewDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
public class ApplicationTest {

    @Reference(timeout = 1000000,url = "dubbo://127.0.0.1:20881")
    OrderReviewService orderReviewService;
    @Test
    public void insertOrderReview() {
        PageParameter<OrderReviewDO> pageParameter = new PageParameter<>();
        pageParameter.startPage = 1;
        pageParameter.pageRows = 2;
        OrderReviewDO orderReviewDO = new OrderReviewDO();
        orderReviewDO.setIsPass("Y");
         pageParameter.setParameter(orderReviewDO);

        String rpageParameterString = JSONObject.toJSONString(pageParameter);
        PageBean<OrderReviewDO> orderReviewDOPageBean = orderReviewService.testPage(pageParameter);
        String orderReviewString = JSONObject.toJSONString(orderReviewDOPageBean);

        System.out.println(orderReviewString);

    }
}