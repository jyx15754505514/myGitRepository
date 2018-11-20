package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.order.dao.OrderItemSubDao;
import com.ccicnavi.bims.order.pojo.OrderItemSubDO;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
/* *
 * @Author heibin
 * @Description 委托单最小服务项子项
 * @Date 10:11 2018/11/20
 */
@Service
public class OrderItemSubDaoImpl implements OrderItemSubDao {
    /* *
     * @Author heibin
     * @Description 新增委托单最小服务项子项
     * @Date 10:12 2018/11/20
     * @Param [orderItemSubDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderItemSub(OrderItemSubDO orderItemSubDO, EqlTran tran) throws Exception {
        return EqlUtils.getInstance("DEFAULT").insert("insertOrderItemSub").params(orderItemSubDO).returnType(OrderItemSubDO.class).execute();
    }
    /* *
     * @Author heibin
     * @Description 更新委托单最小服务项子项
     * @Date 10:12 2018/11/20
     * @Param [orderItemSubDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderItemSub(OrderItemSubDO orderItemSubDO, EqlTran tran) throws Exception {
        return EqlUtils.getInstance("DEFAULT").update("updateOrderItemSub").params(orderItemSubDO).returnType(OrderItemSubDO.class).execute();
    }
}
