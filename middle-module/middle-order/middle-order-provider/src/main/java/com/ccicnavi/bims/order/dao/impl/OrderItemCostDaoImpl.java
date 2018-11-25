package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderItemCostDao;
import com.ccicnavi.bims.order.pojo.OrderItemCostDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
/**
 * @Author songyateng
 * @Description 成本单服务项
 * @Date 14:30 2018/11/22
 */
@Service
public class OrderItemCostDaoImpl implements OrderItemCostDao {
    /**
     * @Author songyateng
     * @Description 新增成本单
     * @Date 14:31 2018/11/22
     * @Param [orderItemCostDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderItemCost(OrderItemCostDO orderItemCostDO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).insert("insertOrderItemCost").params(orderItemCostDO).returnType(Integer.class).execute();
        }
        return eql.insert("insertOrderItemCost").params(orderItemCostDO).returnType(Integer.class).execute();
    }

    /**
     * @Author songyateng 
     * @Description 修改成本单
     * @Date 15:23 2018/11/22
     * @Param [orderItemCostDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderItemCost(OrderItemCostDO orderItemCostDO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("updateOrderItemCost").params(orderItemCostDO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderItemCost").params(orderItemCostDO).returnType(Integer.class).execute();
    }
}
