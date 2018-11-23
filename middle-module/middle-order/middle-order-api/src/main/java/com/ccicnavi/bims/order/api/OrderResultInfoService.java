package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.order.pojo.OrderResultInfoDO;
import java.util.List;
/**
 * @Author heibin
 * @Description 证书结果
 * @Date 20:27 2018/11/22
 */
public interface OrderResultInfoService {
    /**
     * @Author heibin
     * @Description 根据主键id查询证书结果信息
     * @Date 20:26 2018/11/22
     * @Param [orderResultInfoDO]
     * @Return com.ccicnavi.bims.order.pojo.OrderResultInfoDO
     */
    OrderResultInfoDO getOrderResultInfo(OrderResultInfoDO orderResultInfoDO) ;
    /**
     * @Author heibin
     * @Description 查询全部证书结果信息
     * @Date 20:26 2018/11/22
     * @Param [orderResultInfoDO]
     * @Return java.util.List<com.ccicnavi.bims.order.pojo.OrderResultInfoDO>
     */
    List<OrderResultInfoDO> listOrderResultInfo(OrderResultInfoDO orderResultInfoDO);
    /**
     * @Author heibin
     * @Description 新增证书结果
     * @Date 20:26 2018/11/22
     * @Param [orderResultInfoDO]
     * @Return java.lang.Integer
     */
    Integer insertOrderResultInfo(OrderResultInfoDO orderResultInfoDO);
    /**
     * @Author heibin
     * @Description 更新证书结果
     * @Date 20:27 2018/11/22
     * @Param [orderResultInfoDO]
     * @Return java.lang.Integer
     */
    Integer updateOrderResultInfo(OrderResultInfoDO orderResultInfoDO);
    /**
     * @Author heibin
     * @Description 删除证书结果
     * @Date 20:27 2018/11/22
     * @Param [orderResultInfoDO]
     * @Return java.lang.Integer
     */
    Integer deleteOrderResultInfo(OrderResultInfoDO orderResultInfoDO);

}
