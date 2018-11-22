package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderTypeDO;
import org.n3r.eql.EqlTran;
/**
 * @Author songyateng
 * @Description 订单类型
 * @Date 17:40 2018/11/22
 */
public interface OrderTypeDao {

    /**
     * @Author songyateng
     * @Description 新增订单类型
     * @Date 17:40 2018/11/22
     * @Param [orderTypeDO, tran]
     * @Return java.lang.Integer
     */
    Integer insertOrderType(OrderTypeDO orderTypeDO, EqlTran tran) throws Exception;
    /**
     * @Author songyateng
     * @Description 删除订单类型
     * @Date 17:40 2018/11/22
     * @Param [orderTypeDO, tran]
     * @Return java.lang.Integer
     */
    Integer deleteOrderType(OrderTypeDO orderTypeDO, EqlTran tran) throws Exception;

}
