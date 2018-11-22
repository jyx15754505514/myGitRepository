package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderItemCostDao;
import com.ccicnavi.bims.order.pojo.OrderItemCostDo;
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
     * @Param [orderItemCostDo, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderItemCost(OrderItemCostDo orderItemCostDo, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).insert("insertOrderItemCost").params(orderItemCostDo).returnType(Integer.class).execute();
        }
        return eql.insert("insertOrderItemCost").params(orderItemCostDo).returnType(Integer.class).execute();
    }

    @Override
    public Integer updateOrderItemCost(OrderItemCostDo orderItemCostDo, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).update("updateOrderItemCost").params(orderItemCostDo).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderItemCost").params(orderItemCostDo).returnType(Integer.class).execute();
    }
}
