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
    /**
     * @Author heibin
     * @Description 根据主键id查询委托服务项-证书关系
     * @Date 14:55 2018/11/20
     * @Param [orderResultItemDO]
     * @Return com.ccicnavi.bims.order.pojo.OrderResultItemDO
     */
    OrderResultItemDO getOrderResultItem(OrderResultItemDO orderResultItemDO) throws Exception;
    /**
     * @Author heibin
     * @Description 查询全部委托服务项-证书关系
     * @Date 14:55 2018/11/20
     * @Param [orderResultItemDO]
     * @Return java.util.List<com.ccicnavi.bims.order.pojo.OrderResultItemDO>
     */
    List<OrderResultItemDO> listOrderResultItem(OrderResultItemDO orderResultItemDO) throws Exception;
    /**
     * @Author heibin
     * @Description 新增委托服务项-证书关系
     * @Date 14:55 2018/11/20
     * @Param [orderResultItemDO, tran]
     * @Return java.lang.Integer
     */
    Integer insertOrderResultItem(OrderResultItemDO orderResultItemDO,EqlTran tran) throws Exception;
    /**
     * @Author heibin
     * @Description 更新委托服务项-证书关系
     * @Date 14:55 2018/11/20
     * @Param [orderResultItemDO, tran]
     * @Return java.lang.Integer
     */
    Integer updateOrderResultItem(OrderResultItemDO orderResultItemDO,EqlTran tran) throws Exception;
    /**
     * @Author heibin
     * @Description 删除委托服务项-证书关系
     * @Date 14:55 2018/11/20
     * @Param [orderResultItemDOm, tran]
     * @Return java.lang.Integer
     */
    Integer deleteOrderResultItem(OrderResultItemDO orderResultItemDOm,EqlTran tran) throws Exception;
}
