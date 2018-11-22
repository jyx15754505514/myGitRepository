package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderSampleTypeDO;
import org.n3r.eql.EqlTran;
import java.util.List;
/**
 * @Author heibin
 * @Description 委托样品类型
 * @Date 20:27 2018/11/21
 */
public interface OrderSampleTypeDao {
    /**
     * @Author heibin
     * @Description 根据主键id查询委托样品类型
     * @Date 20:27 2018/11/21
     * @Param [orderSampleTypeDO]
     * @Return com.ccicnavi.bims.order.pojo.OrderSampleTypeDO
     */
    OrderSampleTypeDO getOrderSampleType(OrderSampleTypeDO orderSampleTypeDO) throws Exception;
    /**
     * @Author heibin
     * @Description 查询全部委托样品类型
     * @Date 20:27 2018/11/21
     * @Param [orderSampleTypeDO]
     * @Return java.util.List<com.ccicnavi.bims.order.pojo.OrderSampleTypeDO>
     */
    List<OrderSampleTypeDO> listOrderSampleType(OrderSampleTypeDO orderSampleTypeDO) throws Exception;
    /**
     * @Author heibin
     * @Description 新增委托样品类型
     * @Date 20:27 2018/11/21
     * @Param [orderSampleTypeDO, tran]
     * @Return java.lang.Integer
     */
    Integer insertOrderSampleType(OrderSampleTypeDO orderSampleTypeDO, EqlTran tran) throws Exception;
    /**
     * @Author heibin
     * @Description 更新委托样品类型
     * @Date 20:27 2018/11/21
     * @Param [orderSampleTypeDO, tran]
     * @Return java.lang.Integer
     */
    Integer updateOrderSampleType(OrderSampleTypeDO orderSampleTypeDO, EqlTran tran) throws Exception;
    /**
     * @Author heibin
     * @Description 删除委托样品类型
     * @Date 20:27 2018/11/21
     * @Param [orderSampleTypeDO, tran]
     * @Return java.lang.Integer
     */
    Integer deleteOrderSampleType(OrderSampleTypeDO orderSampleTypeDO, EqlTran tran) throws Exception;
}
