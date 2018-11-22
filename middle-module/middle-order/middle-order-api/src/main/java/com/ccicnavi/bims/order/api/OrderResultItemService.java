package com.ccicnavi.bims.order.api;


import com.ccicnavi.bims.order.pojo.OrderResultItemDO;

import java.util.List;

/**
 * @Author heibin
 * @Description 委托服务项-证书关系
 * @Date 20:12 2018/11/20
 */
public interface OrderResultItemService {
    /**根据主键id查询委托服务项-证书关系*/
    OrderResultItemDO getOrderResultItem(OrderResultItemDO orderResultItemDO) ;
    /**查询全部委托服务项-证书关系*/
    List<OrderResultItemDO> listOrderResultItem(OrderResultItemDO orderResultItemDO);
    /**新增委托服务项-证书关系*/
    Integer insertOrderResultItem(OrderResultItemDO orderResultItemDO);
    /**更新委托服务项-证书关系*/
    Integer updateOrderResultItem(OrderResultItemDO orderResultItemDO);
    /**删除委托服务项-证书关系*/
    Integer deleteOrderResultItem(OrderResultItemDO orderResultItemDO);
}
