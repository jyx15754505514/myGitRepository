package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderItemSubDao;
import com.ccicnavi.bims.order.pojo.OrderItemDTO;
import com.ccicnavi.bims.order.pojo.OrderItemSubDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Author heibin
 * @Description 委托单最小服务项子项
 * @Date 10:11 2018/11/20
 */
@Service
public class OrderItemSubDaoImpl implements OrderItemSubDao {
    /**
     * @Author heibin
     * @Description 新增委托单最小服务项子项
     * @Date 10:12 2018/11/20
     * @Param [orderItemSubDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderItemSub(OrderItemSubDO orderItemSubDO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).insert("insertOrderItemSub").params(orderItemSubDO).returnType(Integer.class).execute();
        }
        return eql.insert("insertOrderItemSub").params(orderItemSubDO).returnType(Integer.class).execute();
    }

    /**
     * @Author heibin
     * @Description 更新委托单最小服务项子项
     * @Date 10:12 2018/11/20
     * @Param [orderItemSubDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderItemSub(OrderItemSubDO orderItemSubDO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).update("updateOrderItemSub").params(orderItemSubDO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderItemSub").params(orderItemSubDO).returnType(Integer.class).execute();
    }

    /**
     * @Author heibin
     * @Description 删除委托单最小服务项子项
     * @Date 10:12 2018/11/20
     * @Param [orderItemSubDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderItemSub(OrderItemSubDO orderItemSubDO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).delete("deleteOrderItemSub").params(orderItemSubDO).returnType(Integer.class).execute();
        }
        return eql.delete("deleteOrderItemSub").params(orderItemSubDO).returnType(Integer.class).execute();
    }

    /**
     * @param orderItemDTO
     * @return  List<OrderItemSubDO>
     * @throws Exception
     */
    @Override
    public List<OrderItemSubDO> listOrderItemSub(OrderItemDTO orderItemDTO) throws Exception {
        Eql eql = new Eql("DEFAULT");
        return eql.select("listOrderItemSub").params(orderItemDTO).returnType(OrderItemSubDO.class).execute();
    }
}
