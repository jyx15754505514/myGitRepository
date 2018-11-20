package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderShipmentDao;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

/* *
 * @Author MengZiJie
 * @Description 委托单运输方式
 * @Date 16:28 2018/11/14
 */
@Service
public class OrderShipmentDaoImpl implements OrderShipmentDao {

    /* *
     * @Author MengZiJie
     * @Description 新增运输方式
     * @Date 16:27 2018/11/19
     * @Param [orderShipmentDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderShipment(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).insert("insertOrderShipment").params(orderInfoDTO).returnType(Integer.class).execute();
        }
        return eql.insert("insertOrderShipment").params(orderInfoDTO).returnType(Integer.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 更新运输方式信息
     * @Date 16:27 2018/11/19
     * @Param [orderShipmentDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderShipment(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).update("updateOrderShipment").params(orderInfoDTO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderShipment").params(orderInfoDTO).returnType(Integer.class).execute();
    }
}
