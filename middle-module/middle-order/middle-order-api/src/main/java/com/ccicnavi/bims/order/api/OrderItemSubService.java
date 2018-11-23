package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.order.pojo.OrderItemSubDO;
/**
 * @Author heibin
 * @Description 委托单最小颗粒度（最小服务项子项）
 * @Date 9:31 2018/11/20
 */
public interface OrderItemSubService {
    /**
     * @Author heibin
     * @Description 新增最小颗粒度
     * @Date 20:26 2018/11/22
     * @Param [orderItemSubDO]
     * @Return java.lang.Integer
     */
    Integer insertOrderItemSub(OrderItemSubDO orderItemSubDO);
    /**
     * @Author heibin
     * @Description 更新最小颗粒度
     * @Date 20:26 2018/11/22
     * @Param [orderItemSubDO]
     * @Return java.lang.Integer
     */
    Integer updateOrderItemSub(OrderItemSubDO orderItemSubDO);
    /**
     * @Author heibin
     * @Description 物理删除最小颗粒度
     * @Date 20:26 2018/11/22
     * @Param [orderItemSubDO]
     * @Return java.lang.Integer
     */
    Integer deleteOrderItemSub(OrderItemSubDO orderItemSubDO);
}
