package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
/* *
 * @Author MengZiJie
 * @Description 委托单运输方式
 * @Date 16:01 2018/11/19
 * @Param
 * @Return
 */
public interface OrderShipmentService {

    /**新增运输方式*/
    Integer insertOrderShipment(OrderInfoDTO orderInfoDTO);
    /**更新运输方式*/
    Integer updateOrderShipment(OrderInfoDTO orderInfoDTO);

}
