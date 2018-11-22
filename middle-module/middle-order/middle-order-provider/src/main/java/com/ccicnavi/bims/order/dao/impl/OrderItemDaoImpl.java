package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderItemDao;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import com.ccicnavi.bims.order.pojo.OrderItemDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Author MengZiJie
 * @Description 委托单服务项
 * @Date 16:28 2018/11/14
 */
@Service
public class OrderItemDaoImpl implements OrderItemDao {

    /**
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

    /**
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
            return eql.useTran(tran).update("updateOrderItem").params(orderItemDTO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderItem").params(orderItemDTO).returnType(Integer.class).execute();
    }

    /**
     * 功能描述: 根据委托单信息查询其下的服务项目信息
     * @auther: fandongsheng
     * @date: 2018/11/21 14:37
     */
    @Override
    public List<OrderItemDTO> listOrderItemDTO(OrderInfoDO orderInfoDO) throws Exception {
        Eql eql = new Eql("DEFAULT");
        return  eql.select("listOrderItem").params(orderInfoDO).returnType(OrderItemDTO.class).execute();
    }

    /**
     * @Author heibin
     * @Description 删除服务项信息
     * @Date 14:14 2018/11/22
     * @Param [orderItemDTO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderItem(OrderItemDTO orderItemDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).update("deleteOrderItem").params(orderItemDTO).returnType(Integer.class).execute();
        }
        return eql.update("deleteOrderItem").params(orderItemDTO).returnType(Integer.class).execute();
    }
}
