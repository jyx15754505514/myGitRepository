package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.order.pojo.OrderItemDTO;
/**
 * @Author MengZiJie
 * @Description 委托单服务项
 * @Date 15:30 2018/11/19
 */
public interface OrderItemService {

    /**
     * @Author MengZiJie
     * @Description 新增服务项信息
     * @Date 20:25 2018/11/22
     * @Param [orderItemDTO]
     * @Return java.lang.Integer
     */
    Integer insertOrderItem(OrderItemDTO orderItemDTO);
    /**
     * @Author MengZiJie
     * @Description 更新服务项信息
     * @Date 20:25 2018/11/22
     * @Param [orderItemDTO]
     * @Return java.lang.Integer
     */
    Integer updateOrderItem(OrderItemDTO orderItemDTO);
    /**
     * @Author MengZiJie
     * @Description 指派任务
     * @Date 20:25 2018/11/22
     * @Param [orderItemDTO]
     * @Return java.lang.Integer
     */
    Integer assignOrderItem(OrderItemDTO orderItemDTO);
    /**
     * @Author MengZiJie
     * @Description 外包任务
     * @Date 20:25 2018/11/22
     * @Param [orderItemDTO]
     * @Return java.lang.Integer
     */
    Integer outsourcOrderItem(OrderItemDTO orderItemDTO);

}
