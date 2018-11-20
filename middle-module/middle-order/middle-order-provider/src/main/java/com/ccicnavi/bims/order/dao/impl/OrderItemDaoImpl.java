package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderItemDao;
import com.ccicnavi.bims.order.pojo.OrderItemDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

/* *
 * @Author MengZiJie
 * @Description 委托单服务项
 * @Date 16:28 2018/11/14
 */
@Service
public class OrderItemDaoImpl implements OrderItemDao {

    /* *
     * @Author MengZiJie
     * @Description 新增服务项
     * @Date 15:50 2018/11/19
     * @Param [orderItemInfo, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderItem(OrderItemDTO orderItemDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).insert("insertOrderItem").params(orderItemDTO).returnType(Integer.class).execute();
        }
        return eql.insert("insertOrderItem").params(orderItemDTO).returnType(Integer.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 更改服务项信息
     * @Date 15:50 2018/11/19
     * @Param [orderItemInfo, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderItem(OrderItemDTO orderItemDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).insert("updateOrderItem").params(orderItemDTO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderItem").params(orderItemDTO).returnType(Integer.class).execute();
    }
}
