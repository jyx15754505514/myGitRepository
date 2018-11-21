package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderSampleTypeDO;
import org.n3r.eql.EqlTran;

import java.util.List;

/* *
 * @Author heibin
 * @Description 委托样品类型
 * @Date 20:27 2018/11/21
 */
public interface OrderSampleTypeDao {
    /**根据主键id查询委托样品类型*/
    OrderSampleTypeDO getOrderSampleType(OrderSampleTypeDO orderSampleTypeDO) throws Exception;
    /**查询全部委托样品类型*/
    List<OrderSampleTypeDO> listOrderSampleType(OrderSampleTypeDO orderSampleTypeDO) throws Exception;
    /**新增委托样品类型*/
    Integer insertOrderSampleType(OrderSampleTypeDO orderSampleTypeDO, EqlTran tran) throws Exception;
    /**更新委托样品类型*/
    Integer updateOrderSampleType(OrderSampleTypeDO orderSampleTypeDO, EqlTran tran) throws Exception;
    /**删除委托样品类型*/
    Integer deleteOrderSampleType(OrderSampleTypeDO orderSampleTypeDO, EqlTran tran) throws Exception;
}
