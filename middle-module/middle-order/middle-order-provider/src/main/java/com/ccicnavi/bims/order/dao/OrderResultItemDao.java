package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderResultItemDO;
import org.n3r.eql.EqlTran;
import java.util.List;

/**
 * @Author heibin
 * @Description 证书与服务项关系
 * @Date 14:55 2018/11/20
 */
public interface OrderResultItemDao {
    /**根据主键id查询委托服务项-证书关系*/
    OrderResultItemDO getOrderResultItem(OrderResultItemDO orderResultItemDO) throws Exception;
    /**查询全部委托服务项-证书关系*/
    List<OrderResultItemDO> listOrderResultItem(OrderResultItemDO orderResultItemDO) throws Exception;
    /**新增委托服务项-证书关系*/
    Integer insertOrderResultItem(OrderResultItemDO orderResultItemDO,EqlTran tran) throws Exception;
    /**更新委托服务项-证书关系*/
    Integer updateOrderResultItem(OrderResultItemDO orderResultItemDO,EqlTran tran) throws Exception;
    /**删除委托服务项-证书关系*/
    Integer deleteOrderResultItem(OrderResultItemDO orderResultItemDOm,EqlTran tran) throws Exception;
}
