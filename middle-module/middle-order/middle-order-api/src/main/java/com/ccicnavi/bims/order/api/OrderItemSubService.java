package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.order.pojo.OrderItemSubDO;

/* *
 * @Author heibin
 * @Description 委托单最小颗粒度（最小服务项子项）
 * @Date 9:31 2018/11/20
 */
public interface OrderItemSubService {
    /**新增最小颗粒度*/
    Integer insertOrderItemSub(OrderItemSubDO orderItemSubDO);
    /**更新最小颗粒度*/
    Integer updateOrderItemSub(OrderItemSubDO orderItemSubDO);
}
