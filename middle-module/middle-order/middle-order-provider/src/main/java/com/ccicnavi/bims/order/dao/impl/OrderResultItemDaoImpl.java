package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderResultItemDao;
import com.ccicnavi.bims.order.pojo.OrderResultItemDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Author heibin
 * @Description 委托服务项-证书关系
 * @Date 20:40 2018/11/20
 */
@Service
public class OrderResultItemDaoImpl implements OrderResultItemDao {
    /**
     * @Author heibin
     * @Description 根据主键id查询单个委托服务项-证书关系对象
     * @Date 20:41 2018/11/20
     * @Param [orderResultItemDO]
     * @Return OrderResultItemDO
     */
    @Override
    public OrderResultItemDO getOrderResultItem(OrderResultItemDO orderResultItemDO) throws Exception {
        return new Eql().select("getOrderResultItem").params(orderResultItemDO).returnType(OrderResultItemDO.class).execute();
    }

    /**
     * @Author heibin
     * @Description 查询所有委托服务项-证书关系
     * @Date 20:43 2018/11/20
     * @Param [orderResultItemDO]
     * @Return List<OrderResultItemDO>
     */
    @Override
    public List<OrderResultItemDO> listOrderResultItem(OrderResultItemDO orderResultItemDO) throws Exception {
        return new Eql().select("listOrderResultItem").params(orderResultItemDO).returnType(OrderResultItemDO.class).execute();
    }

    /**
     * @Author heibin
     * @Description 新增委托服务项-证书关系
     * @Date 20:46 2018/11/20
     * @Param [orderResultItemDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderResultItem(OrderResultItemDO orderResultItemDO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("insertOrderResultItem").params(orderResultItemDO).returnType(Integer.class).execute();
        }
        return eql.update("insertOrderResultItem").params(orderResultItemDO).returnType(Integer.class).execute();
    }

    /**
     * @Author heibin
     * @Description 更新委托服务项-证书关系
     * @Date 20:48 2018/11/20
     * @Param [orderResultItemDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderResultItem(OrderResultItemDO orderResultItemDO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("updateOrderResultItem").params(orderResultItemDO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderResultItem").params(orderResultItemDO).returnType(Integer.class).execute();
    }

    /**
     * @Author heibin
     * @Description 删除委托服务项-证书关系
     * @Date 20:49 2018/11/20
     * @Param [orderResultItemDOm, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderResultItem(OrderResultItemDO orderResultItemDOm, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("deleteOrderResultItem").params(orderResultItemDOm).returnType(Integer.class).execute();
        }
        return eql.delete("deleteOrderResultItem").params(orderResultItemDOm).returnType(Integer.class).execute();
    }
}
