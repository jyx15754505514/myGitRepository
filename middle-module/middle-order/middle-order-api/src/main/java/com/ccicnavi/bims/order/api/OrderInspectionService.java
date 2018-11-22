package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
/**
 * @Author MengZiJie
 * @Description 委托单运输方式
 * @Date 16:01 2018/11/19
 */
public interface OrderInspectionService {

    /**新增运输方式*/
    Integer insertOrderInspection(OrderInfoDTO orderInfoDTO);
    /**更新运输方式*/
    Integer updateOrderInspection(OrderInfoDTO orderInfoDTO);

}
