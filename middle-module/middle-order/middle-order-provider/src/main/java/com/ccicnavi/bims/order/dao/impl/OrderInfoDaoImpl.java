package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.order.dao.OrderInfoDao;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

/* *
 * @Author MengZiJie
 * @Description 日志管理
 * @Date 16:28 2018/11/14
 */
@Service
public class OrderInfoDaoImpl implements OrderInfoDao {

    /* *
     * @Author MengZiJie
     * @Description 新增委托单
     * @Date 15:35 2018/11/19
     * @Param [orderInfoDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderInfo(OrderInfoDO orderInfoDO, EqlTran tran) throws Exception {
        return EqlUtils.getInstance("DEFAULT").insert("insertOrderInfo").params(orderInfoDO).returnType(OrderInfoDO.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 更新委托单信息
     * @Date 15:37 2018/11/19
     * @Param [orderInfoDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderInfo(OrderInfoDO orderInfoDO, EqlTran tran) throws Exception {
        return EqlUtils.getInstance("DEFAULT").update("updateOrderInfo").params(orderInfoDO).returnType(OrderInfoDO.class).execute();
    }
}
