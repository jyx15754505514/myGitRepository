package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.order.pojo.OrderShipmentDO;

/* *
 * @Author MengZiJie
 * @Description 委托单运输方式
 * @Date 16:01 2018/11/19
 * @Param
 * @Return
 */
public interface OrderShipmentDao {

    /**新增运输方式*/
    Integer insertOrderShipment(OrderShipmentDO orderShipmentDO);
    /**更新运输方式*/
    Integer updateOrderShipment(OrderShipmentDO orderShipmentDO);

}
