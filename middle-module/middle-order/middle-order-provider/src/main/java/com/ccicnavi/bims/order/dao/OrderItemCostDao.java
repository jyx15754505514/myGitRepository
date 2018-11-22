package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderItemCostDo;
import org.n3r.eql.EqlTran;

/**
 * @Author songyateng
 * @Description 成本单服务项Dao
 * @Date 14:21 2018/11/22
 * @Param
 * @Return
 */

public interface OrderItemCostDao {
    /**
     * @Author songyateng
     * @Description 新增成本单
     * @Date 14:27 2018/11/22
     * @Param [orderItemCostDo, tran]
     * @Return java.lang.Integer
     */
    Integer insertOrderItemCost(OrderItemCostDo orderItemCostDo, EqlTran tran) throws Exception;
    /**
     * @Author songyateng
     * @Description 修改成本单
     * @Date 14:28 2018/11/22
     * @Param [orderItemCostDo, tran]
     * @Return java.lang.Integer
     */

    Integer updateOrderItemCost(OrderItemCostDo orderItemCostDo, EqlTran tran) throws Exception;
}
