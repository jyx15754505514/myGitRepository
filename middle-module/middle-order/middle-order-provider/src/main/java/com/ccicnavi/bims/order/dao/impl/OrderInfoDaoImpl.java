package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderInfoDao;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

/* *
 * @Author MengZiJie
 * @Description 委托单
 * @Date 16:28 2018/11/14
 */
@Service
public class OrderInfoDaoImpl implements OrderInfoDao {

    /* *
     * @Author MengZiJie
     * @Description 新增委托单
     * @Date 15:35 2018/11/19
     * @Param [orderInfoDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderInfo(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).insert("insertOrderInfo").params(orderInfoDTO).returnType(Integer.class).execute();
        }
        return eql.insert("insertOrderInfo").params(orderInfoDTO).returnType(Integer.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 更新委托单信息
     * @Date 15:37 2018/11/19
     * @Param [orderInfoDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderInfo(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).update("updateOrderInfo").params(orderInfoDTO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderInfo").params(orderInfoDTO).returnType(Integer.class).execute();
    }
    
}
