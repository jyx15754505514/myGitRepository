package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.order.pojo.OrderInfoDO;

/* *
 * @Author MengZiJie
 * @Description 委托单
 * @Date 15:30 2018/11/19
 */
public interface OrderInfoService {

    /**新增委托单信息*/
    Integer insertOrderInfo(OrderInfoDO orderInfoDO);
    /**更新委托单信息*/
    Integer updateOrderInfo(OrderInfoDO orderInfoDO);

}
