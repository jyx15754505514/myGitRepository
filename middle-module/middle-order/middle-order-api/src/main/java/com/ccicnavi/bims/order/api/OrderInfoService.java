package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;

/* *
 * @Author MengZiJie
 * @Description 委托单
 * @Date 15:30 2018/11/19
 */
public interface OrderInfoService {

    /**新增委托单信息*/
    Integer insertOrderInfo(OrderInfoDTO orderInfoDTO);
    /**更新委托单信息*/
    Integer updateOrderInfo(OrderInfoDTO orderInfoDTO);
    /**保存委托单*/
    ResultT saveOrderInfo(OrderInfoDTO orderInfoDTO);

}
