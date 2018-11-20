package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.order.dao.OrderItemDao;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import com.ccicnavi.bims.order.pojo.OrderItemDO;
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
    public Integer insertOrderItem(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception {
        return EqlUtils.getInstance("DEFAULT").insert("insertOrderItem").params(orderInfoDTO).returnType(OrderItemDO.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 更改服务项信息
     * @Date 15:50 2018/11/19
     * @Param [orderItemInfo, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderItem(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception {
        return EqlUtils.getInstance("DEFAULT").insert("updateOrderItem").params(orderInfoDTO).returnType(OrderItemDO.class).execute();
    }
}
