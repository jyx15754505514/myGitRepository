package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderTypeDO;
import org.n3r.eql.EqlTran;

/**
 * @Author songyateng
 * @Description 订单类型
 * @Date 17:40 2018/11/22
 * @Param
 * @Return
 */
public interface OrderTypeDao {
    /**新增订单类型*/
    Integer insertOrderType(OrderTypeDO orderTypeDO, EqlTran tran) throws Exception;
    /**删除订单类型*/
    Integer deleteOrderType(OrderTypeDO orderTypeDO, EqlTran tran) throws Exception;

}
