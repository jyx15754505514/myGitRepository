package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.order.pojo.OrderSampleTypeDO;
import java.util.List;
/**
 * @Author heibin
 * @Description 委托样品类型
 * @Date 20:27 2018/11/21
 */
public interface OrderSampleTypeService {
    /**
     * @Author heibin
     * @Description 根据主键id查询委托样品类型
     * @Date 20:29 2018/11/22
     * @Param [orderSampleTypeDO]
     * @Return com.ccicnavi.bims.order.pojo.OrderSampleTypeDO
     */
    OrderSampleTypeDO getOrderSampleType(OrderSampleTypeDO orderSampleTypeDO) ;
    /**
     * @Author heibin
     * @Description 查询全部委托样品类型
     * @Date 20:30 2018/11/22
     * @Param [orderSampleTypeDO]
     * @Return java.util.List<com.ccicnavi.bims.order.pojo.OrderSampleTypeDO>
     */
    List<OrderSampleTypeDO> listOrderSampleType(OrderSampleTypeDO orderSampleTypeDO);
    /**
     * @Author heibin
     * @Description 新增委托样品类型
     * @Date 20:30 2018/11/22
     * @Param [orderSampleTypeDO]
     * @Return java.lang.Integer
     */
    Integer insertOrderSampleType(OrderSampleTypeDO orderSampleTypeDO);
    /**
     * @Author heibin
     * @Description 更新委托样品类型
     * @Date 20:30 2018/11/22
     * @Param [orderSampleTypeDO]
     * @Return java.lang.Integer
     */
    Integer updateOrderSampleType(OrderSampleTypeDO orderSampleTypeDO);
    /**
     * @Author heibin
     * @Description 删除委托样品类型
     * @Date 20:30 2018/11/22
     * @Param [orderSampleTypeDO]
     * @Return java.lang.Integer
     */
    Integer deleteOrderSampleType(OrderSampleTypeDO orderSampleTypeDO);
}
