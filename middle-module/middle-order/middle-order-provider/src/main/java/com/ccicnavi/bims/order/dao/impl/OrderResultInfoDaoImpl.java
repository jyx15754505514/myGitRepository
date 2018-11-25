package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderResultInfoDao;
import com.ccicnavi.bims.order.pojo.OrderResultInfoDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Author heibin
 * @Description 证书结果
 * @Date 15:02 2018/11/20
 */
@Service
public class OrderResultInfoDaoImpl implements OrderResultInfoDao {
    /**
     * @Author heibin
     * @Description 根据主键id查询单个证书结果对象
     * @Date 17:45 2018/11/20
     * @Param [orderResultInfoDO]
     * @Return OrderResultInfoDO
     */
    @Override
    public OrderResultInfoDO getOrderResultInfo(OrderResultInfoDO orderResultInfoDO) throws Exception {
        return new Eql().select("getOrderResultInfo").params(orderResultInfoDO).returnType(OrderResultInfoDO.class).execute();
    }

    /**
     * @Author heibin
     * @Description 查询所有证书结果
     * @Date 17:09 2018/11/20
     * @Param [orderResultInfoDO]
     * @Return List<OrderResultInfoDO>
     */
    @Override
    public List<OrderResultInfoDO> listOrderResultInfo(OrderResultInfoDO orderResultInfoDO) throws Exception {
        return new Eql().select("listOrderResultInfo").params(orderResultInfoDO).returnType(OrderResultInfoDO.class).execute();
    }

    /**
     * @Author heibin
     * @Description 新增证书结果
     * @Date 15:06 2018/11/20
     * @Param [orderResultInfoDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderResultInfo(OrderResultInfoDO orderResultInfoDO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("insertOrderResultInfo").params(orderResultInfoDO).returnType(Integer.class).execute();
        }
        return eql.update("insertOrderResultInfo").params(orderResultInfoDO).returnType(Integer.class).execute();
    }

    /**
     * @Author heibin
     * @Description 更新证书结果
     * @Date 15:06 2018/11/20
     * @Param [orderResultInfoDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderResultInfo(OrderResultInfoDO orderResultInfoDO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("updateOrderResultInfo").params(orderResultInfoDO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderResultInfo").params(orderResultInfoDO).returnType(Integer.class).execute();
    }

    /**
     * @Author heibin
     * @Description 删除证书结果
     * @Date 15:55 2018/11/20
     * @Param [orderResultInfoDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderResultInfo(OrderResultInfoDO orderResultInfoDO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("deleteOrderResultInfo").params(orderResultInfoDO).returnType(Integer.class).execute();
        }
        return eql.update("deleteOrderResultInfo").params(orderResultInfoDO).returnType(Integer.class).execute();
    }
}
