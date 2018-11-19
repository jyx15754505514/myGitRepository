package com.ccicnavi.bims.order.dao;

import org.n3r.eql.EqlTran;
/* *
 * @Author MengZiJie
 * @Description 委托单运输方式
 * @Date 16:01 2018/11/19
 * @Param
 * @Return
 */
public interface OrderShipmentDao {

    /**新增委托单信息*/
    Integer insertOrderInfo(OrderInfoDO orderInfoDO, EqlTran tran) throws Exception;
    /**更新委托单信息*/
    Integer updateOrderInfo(OrderInfoDO orderInfoDO, EqlTran tran) throws Exception;

}
