package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.order.pojo.OrderInspectionDO;

/**
 * @Author MengZiJie
 * @Description 委托单运输方式
 * @Date 16:01 2018/11/19
 */
public interface OrderInspectionService {

   /**
    * @Author songyateng
    * @Description 新增运输方式
    * @Date 2018/11/27 21:06
    * @Param [orderInfoDTO]
    * @Return java.lang.Integer
    */
    Integer insertOrderInspection(OrderInspectionDO orderInspectionDO);
    /**
     * @Author songyateng
     * @Description 更新运输方式（参数：OrderInfoDTO）
     * @Date 2018/11/27 21:05
     * @Param [orderInfoDTO]
     * @Return java.lang.Integer
     */
    Integer updateOrderInspection(OrderInspectionDO orderInspectionDO);
}
