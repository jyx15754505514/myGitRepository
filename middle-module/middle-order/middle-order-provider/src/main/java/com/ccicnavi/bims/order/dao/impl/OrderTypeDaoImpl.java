package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderTypeDao;
import com.ccicnavi.bims.order.pojo.OrderTypeDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

@Service
public class OrderTypeDaoImpl implements OrderTypeDao {
    /**
     * @Author songyateng 
     * @Description 新增订单类型
     * @Date 17:53 2018/11/22
     * @Param [orderTypeDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderType(OrderTypeDO orderTypeDO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if (tran != null) {
            return eql.useTran(tran).update("insertOrderType").params(orderTypeDO).returnType(Integer.class).execute();
        }
        return eql.update("insertOrderType").params(orderTypeDO).returnType(Integer.class).execute();
    }

    /**
     * @Author songyateng
     * @Description 删除订单类型
     * @Date 17:54 2018/11/22
     * @Param [orderTypeDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderType(OrderTypeDO orderTypeDO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("deleteOrderSampleType").params(orderTypeDO).returnType(Integer.class).execute();
        }
        return eql.delete("deleteOrderSampleType").params(orderTypeDO).returnType(Integer.class).execute();
    }
}
