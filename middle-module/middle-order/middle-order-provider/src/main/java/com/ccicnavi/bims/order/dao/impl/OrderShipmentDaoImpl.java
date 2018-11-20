package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.order.dao.OrderShipmentDao;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import com.ccicnavi.bims.order.pojo.OrderShipmentDO;
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
        return EqlUtils.getInstance("DEFAULT").insert("insertOrderShipment").params(orderInfoDTO).returnType(OrderShipmentDO.class).execute();
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
        return EqlUtils.getInstance("DEFAULT").update("updateOrderShipment").params(orderInfoDTO).returnType(OrderShipmentDO.class).execute();
    }
}
