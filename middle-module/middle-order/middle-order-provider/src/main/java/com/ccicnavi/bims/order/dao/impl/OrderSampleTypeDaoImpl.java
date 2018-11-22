package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderSampleTypeDao;
import com.ccicnavi.bims.order.pojo.OrderSampleTypeDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Author heibin
 * @Description 委托样品类型
 * @Date 20:27 2018/11/21
 */
@Service
public class OrderSampleTypeDaoImpl implements OrderSampleTypeDao {
    /**
     * @Author heibin
     * @Description 根据主键id查询单个委托样品类型
     * @Date 20:59 2018/11/21
     * @Param [orderSampleTypeDO]
     * @Return OrderSampleTypeDO
     */
    @Override
    public OrderSampleTypeDO getOrderSampleType(OrderSampleTypeDO orderSampleTypeDO) throws Exception {
        return new Eql().select("getOrderSampleType").params(orderSampleTypeDO).returnType(OrderSampleTypeDO.class).execute();
    }
    /**
     * @Author heibin
     * @Description 查询所有委托样品类型
     * @Date 21:01 2018/11/21
     * @Param [orderSampleTypeDO]
     * @Return List<OrderSampleTypeDO>
     */
    @Override
    public List<OrderSampleTypeDO> listOrderSampleType(OrderSampleTypeDO orderSampleTypeDO) throws Exception {
        return new Eql().select("listOrderSampleType").params(orderSampleTypeDO).returnType(OrderSampleTypeDO.class).execute();
    }
    /**
     * @Author heibin
     * @Description 新增委托样品类型
     * @Date 21:03 2018/11/21
     * @Param [orderSampleTypeDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderSampleType(OrderSampleTypeDO orderSampleTypeDO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).update("insertOrderSampleType").params(orderSampleTypeDO).returnType(Integer.class).execute();
        }
        return eql.update("insertOrderSampleType").params(orderSampleTypeDO).returnType(Integer.class).execute();
    }

    /**
     * @Author heibin
     * @Description 更新委托样品类型
     * @Date 21:05 2018/11/21
     * @Param [orderSampleTypeDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderSampleType(OrderSampleTypeDO orderSampleTypeDO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).update("updateOrderSampleType").params(orderSampleTypeDO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderSampleType").params(orderSampleTypeDO).returnType(Integer.class).execute();
    }

    /**
     * @Author heibin
     * @Description 删除委托样品类型
     * @Date 21:07 2018/11/21
     * @Param [orderSampleTypeDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderSampleType(OrderSampleTypeDO orderSampleTypeDO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).update("deleteOrderSampleType").params(orderSampleTypeDO).returnType(Integer.class).execute();
        }
        return eql.delete("deleteOrderSampleType").params(orderSampleTypeDO).returnType(Integer.class).execute();
    }
}
