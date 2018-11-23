package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
/**
 * @Author MengZiJie
 * @Description 委托单运输方式
 * @Date 16:01 2018/11/19
 */
public interface OrderInspectionService {

    /**
     * @Author MengZiJie
     * @Description 新增运输方式
     * @Date 16:03 2018/11/19
     * @Param [orderInfoDTO]
     * @Return java.lang.Integer
     */
    Integer insertOrderInspection(OrderInfoDTO orderInfoDTO);
    /**
     * @Author MengZiJie
     * @Description 更新运输方式
     * @Date 16:07 2018/11/19
     * @Param [orderInfoDTO]
     * @Return java.lang.Integer
     */
    Integer updateOrderInspection(OrderInfoDTO orderInfoDTO);

}
