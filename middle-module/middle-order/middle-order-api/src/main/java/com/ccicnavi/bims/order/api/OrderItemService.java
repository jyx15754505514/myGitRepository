package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
/* *
 * @Author MengZiJie
 * @Description 委托单服务项
 * @Date 15:30 2018/11/19
 */
public interface OrderItemService {

    /**新增服务项信息*/
    Integer insertOrderItem(OrderInfoDTO orderInfoDTO);
    /**更新服务项信息*/
    Integer updateOrderItem(OrderInfoDTO orderInfoDTO);

}
