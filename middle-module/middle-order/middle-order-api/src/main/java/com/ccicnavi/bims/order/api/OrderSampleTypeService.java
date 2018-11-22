package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.order.pojo.OrderSampleTypeDO;

import java.util.List;

/**
 * @Author heibin
 * @Description 委托样品类型
 * @Date 20:27 2018/11/21
 */
public interface OrderSampleTypeService {
    /**根据主键id查询委托样品类型*/
    OrderSampleTypeDO getOrderSampleType(OrderSampleTypeDO orderSampleTypeDO) ;
    /**查询全部委托样品类型*/
    List<OrderSampleTypeDO> listOrderSampleType(OrderSampleTypeDO orderSampleTypeDO);
    /**新增委托样品类型*/
    Integer insertOrderSampleType(OrderSampleTypeDO orderSampleTypeDO);
    /**更新委托样品类型*/
    Integer updateOrderSampleType(OrderSampleTypeDO orderSampleTypeDO);
    /**删除委托样品类型*/
    Integer deleteOrderSampleType(OrderSampleTypeDO orderSampleTypeDO);
}
