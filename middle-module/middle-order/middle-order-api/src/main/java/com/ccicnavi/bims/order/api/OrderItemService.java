package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import com.ccicnavi.bims.order.pojo.OrderItemDTO;

/**
 * @Author MengZiJie
 * @Description 委托单服务项
 * @Date 15:30 2018/11/19
 */
public interface OrderItemService {

    /**新增服务项信息*/
    Integer insertOrderItem(OrderItemDTO orderItemDTO);
    /**更新服务项信息*/
    Integer updateOrderItem(OrderItemDTO orderItemDTO);
    /**指派任务*/
    Integer assignOrderItem(OrderItemDTO orderItemDTO);
    /**外包任务*/
    Integer outsourcOrderItem(OrderItemDTO orderItemDTO);

}
