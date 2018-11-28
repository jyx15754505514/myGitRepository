package com.ccicnavi.bims.order.api;
import com.ccicnavi.bims.order.pojo.OrderSampleDO;

/**
 * @Author songyateng
 * @Description 委托样品实体
 * @Date 2018/11/27 14:34
 */
public interface OrderSampleService {

    /**
     * @Author songyateng
     * @Description 样品信息保存
     * @Date 2018/11/27 23:20
     * @Param [orderSampleDO]
     * @Return java.lang.Integer
     */
    Integer updateOrderSample(OrderSampleDO orderSampleDO);
}
