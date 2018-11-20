package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.order.pojo.OrderResultInfoDO;

/* *
 * @Author heibin
 * @Description 证书结果
 * @Date 14:17 2018/11/20
 */
public interface OrderResultInfoService {
    /**新增证书结果*/
    Integer insertOrderResultInfo(OrderResultInfoDO orderResultInfoDO);
    /**更新证书结果*/
    Integer updateOrderResultInfo(OrderResultInfoDO orderResultInfoDO);
    /**删除证书结果*/
    Integer deleteOrderResultInfo(OrderResultInfoDO orderResultInfoDO);

}
