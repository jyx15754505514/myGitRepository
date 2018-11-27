package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderInspectionDao;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import com.ccicnavi.bims.order.pojo.OrderInspectionDO;
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
    public Integer insertOrderInspection(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).insert("insertOrderInspection").params(orderInfoDTO).returnType(Integer.class).execute();
        }
        return eql.insert("insertOrderInspection").params(orderInfoDTO).returnType(Integer.class).execute();
    }

    /**
     * @Author MengZiJie
     * @Description 更新运输方式信息
     * @Date 16:27 2018/11/19
     * @Param [orderShipmentDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderInspection(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("updateOrderInspection").params(orderInfoDTO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderInspection").params(orderInfoDTO).returnType(Integer.class).execute();
    }

    @Override
    public Integer updateInspection(OrderInspectionDO orderInspectionDO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("updateInspection").params(orderInspectionDO).returnType(Integer.class).execute();
        }
        return eql.update("updateInspection").params(orderInspectionDO).returnType(Integer.class).execute();
    }
}
