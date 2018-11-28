package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderSampleDao;
import com.ccicnavi.bims.order.pojo.OrderSampleDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Author MengZiJie
 * @Description 标准样品库
 * @Date 16:28 2018/11/14
 */
@Service
public class OrderSampleDaoImpl implements OrderSampleDao {
    /**
     * @Author MengZiJie
     * @Description 保存样品信息
     * @Date 17:07 2018/11/20
     * @Param [orderSampleDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderSample(OrderSampleDO orderSampleDO,EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).insert("insertOrderSample").params(orderSampleDO).returnType(Integer.class).execute();
        }
        return eql.insert("insertOrderSample").params(orderSampleDO).returnType(Integer.class).execute();
    }

    /**
     * @Author MengZiJie
     * @Description 删除样品
     * @Date 17:09 2018/11/20
     * @Param [orderSampleDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderSample(OrderSampleDO orderSampleDO,EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("deleteOrderSample").params(orderSampleDO).returnType(Integer.class).execute();
        }
        return eql.update("deleteOrderSample").params(orderSampleDO).returnType(Integer.class).execute();
    }
    /**
      * @author songyateng
      * @description 查询样品
      * @date 2018/11/23 14:46
      * @Param [orderSampleDO]
      * @return java.util.List<com.ccicnavi.bims.order.pojo.OrderSampleDO>
      */
    @Override
    public List<OrderSampleDO> listOrderSample(OrderSampleDO orderSampleDO) throws Exception {
        return new Eql().select("listOrderSample").params(orderSampleDO).returnType(OrderSampleDO.class).execute();
    }
    /**
     * @Author songyateng
     * @Description 更新样品信息
     * @Date 2018/11/27 23:30
     * @Param [orderSampleDO, eqlTran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderSample(OrderSampleDO orderSampleDO,EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("updateOrderSample").params(orderSampleDO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderSample").params(orderSampleDO).returnType(Integer.class).execute();
    }
}
