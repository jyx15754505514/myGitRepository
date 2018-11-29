package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderInspectionDao;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import com.ccicnavi.bims.order.pojo.OrderInspectionDO;
import com.ccicnavi.bims.order.pojo.OrderInspectionDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
/**
 * @Author MengZiJie
 * @Description 委托单运输方式
 * @Date 16:28 2018/11/14
 */
@Service
public class OrderInspectionDaoImpl implements OrderInspectionDao {

    /**
     * @Author MengZiJie
     * @Description 新增运输方式
     * @Date 16:27 2018/11/19
     * @Param [orderShipmentDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderInspection(OrderInspectionDO orderInspectionDO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).insert("insertOrderInspection").params(orderInspectionDO).returnType(Integer.class).execute();
        }
        return eql.insert("insertOrderInspection").params(orderInspectionDO).returnType(Integer.class).execute();
    }

    /**
     * @Author MengZiJie
     * @Description 更新运输方式信息（参数：OrderInfoDTO）
     * @Date 16:27 2018/11/19
     * @Param [orderShipmentDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderInspection(OrderInspectionDO orderInspectionDO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("updateOrderInspection").params(orderInspectionDO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderInspection").params(orderInspectionDO).returnType(Integer.class).execute();
    }
    /**
     * @Author MengZiJie
     * @Description 删除运输方式
     * @Data 2018/11/28 10:23
     * @Param [orderInspectionDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderInspection(OrderInspectionDTO orderInspectionDTO, EqlTran tran) throws Exception {
        if (tran != null) {
           return new Eql().useTran(tran).update("deleteOrderInspection").params(orderInspectionDTO).returnType(Integer.class).execute();
        }
        return new Eql().update("deleteOrderInspection").params(orderInspectionDTO).returnType(Integer.class).execute();
    }
    /**
     * @Author heibin
     * @Description 得到委托单运输方式
     * @Date 20:07 2018/11/29
     * @Param [orderInfoDO]
     * @Return com.ccicnavi.bims.order.pojo.OrderInspectionDO
     */
    @Override
    public OrderInspectionDO getOrderInspection(OrderInfoDO orderInfoDO) throws Exception {
        return new Eql().selectFirst("getOrderInspection").params(orderInfoDO).returnType(OrderInspectionDO.class).execute();
    }
}
