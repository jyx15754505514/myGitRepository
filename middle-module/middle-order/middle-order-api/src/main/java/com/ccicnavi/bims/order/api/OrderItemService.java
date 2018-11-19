package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.order.pojo.OrderItemDO;
/* *
 * @Author MengZiJie
 * @Description 委托单服务项
 * @Date 15:30 2018/11/19
 */
public interface OrderItemService {

    /**新增服务项信息*/
    Integer insertOrderItem(OrderItemDO orderItemDO);
    /**更新服务项信息*/
    Integer updateOrderItem(OrderItemDO orderItemDO);

}
