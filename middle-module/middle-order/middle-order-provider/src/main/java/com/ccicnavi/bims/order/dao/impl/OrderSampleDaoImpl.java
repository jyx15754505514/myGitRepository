package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderSampleDao;
import com.ccicnavi.bims.order.pojo.OrderSampleDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
/* *
 * @Author MengZiJie
 * @Description 标准样品库
 * @Date 16:28 2018/11/14
 */
@Service
public class OrderSampleDaoImpl implements OrderSampleDao {

    /* *
     * @Author MengZiJie
     * @Description 保存样品信息
     * @Date 17:07 2018/11/20
     * @Param [orderSampleDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderSample(OrderSampleDO orderSampleDO,EqlTran tran) {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).insert("insertOrderSample").params(orderSampleDO).returnType(Integer.class).execute();
        }
        return eql.insert("insertOrderSample").params(orderSampleDO).returnType(Integer.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 删除样品
     * @Date 17:09 2018/11/20
     * @Param [orderSampleDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderSample(OrderSampleDO orderSampleDO,EqlTran tran) {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).update("deleteOrderSample").params(orderSampleDO).returnType(Integer.class).execute();
        }
        return eql.update("deleteOrderSample").params(orderSampleDO).returnType(Integer.class).execute();
    }
}
