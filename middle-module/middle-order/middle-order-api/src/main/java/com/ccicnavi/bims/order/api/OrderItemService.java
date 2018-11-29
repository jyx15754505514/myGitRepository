package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
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
    /**
     * @Author songyateng
     * @Description 删除服务项信息
     * @Date 2018/11/28 10:39
     * @Param [orderItemDTO]
     * @Return java.lang.Integer
     */
    Integer deleteOrderItem(OrderItemDTO orderItemDTO);
    /**
     * @Author heibin
     * @Description 业务查询分页列表
     * @Date 15:13 2018/11/28
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.order.pojo.OrderItemDTO>
     */
    PageBean<OrderItemDTO> listOrderItemPage(PageParameter<OrderItemDTO> pageParameter);
    /**
     * @Author MengZiJie
     * @Description 更改服务项状态
     * @Data 2018/11/29 16:24
     * @Param [orderItemDTO]
     * @Return java.lang.Integer
     */
    Integer updateOrderItemStatus(OrderItemDTO orderItemDTO);
}
