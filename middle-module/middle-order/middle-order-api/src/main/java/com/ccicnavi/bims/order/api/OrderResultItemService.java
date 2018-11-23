package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.order.pojo.OrderResultItemDO;
import java.util.List;
/**
 * @Author heibin
 * @Description 委托服务项-证书关系
 * @Date 20:29 2018/11/22
 */
public interface OrderResultItemService {
    /**
     * @Author heibin
     * @Description 根据主键id查询委托服务项-证书关系
     * @Date 20:28 2018/11/22
     * @Param [orderResultItemDO]
     * @Return com.ccicnavi.bims.order.pojo.OrderResultItemDO
     */
    OrderResultItemDO getOrderResultItem(OrderResultItemDO orderResultItemDO) ;
    /**
     * @Author heibin
     * @Description 查询全部委托服务项-证书关系
     * @Date 20:28 2018/11/22
     * @Param [orderResultItemDO]
     * @Return java.util.List<com.ccicnavi.bims.order.pojo.OrderResultItemDO>
     */
    List<OrderResultItemDO> listOrderResultItem(OrderResultItemDO orderResultItemDO);
    /**
     * @Author heibin
     * @Description 新增委托服务项-证书关系
     * @Date 20:28 2018/11/22
     * @Param [orderResultItemDO]
     * @Return java.lang.Integer
     */
    Integer insertOrderResultItem(OrderResultItemDO orderResultItemDO);
    /**
     * @Author heibin
     * @Description 更新委托服务项-证书关系
     * @Date 20:28 2018/11/22
     * @Param [orderResultItemDO]
     * @Return java.lang.Integer
     */
    Integer updateOrderResultItem(OrderResultItemDO orderResultItemDO);
    /**
     * @Author heibin
     * @Description 删除委托服务项-证书关系
     * @Date 20:28 2018/11/22
     * @Param [orderResultItemDO]
     * @Return java.lang.Integer
     */
    Integer deleteOrderResultItem(OrderResultItemDO orderResultItemDO);
}
