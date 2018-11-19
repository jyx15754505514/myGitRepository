package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import com.ccicnavi.bims.order.pojo.OrderItemInfo;
import org.n3r.eql.EqlTran;

/* *
 * @Author MengZiJie
 * @Description 委托单服务项
 * @Date 15:30 2018/11/19
 */
public interface OrderItemDao {

    /**新增服务项信息*/
    Integer insertOrderItem(OrderItemInfo orderItemInfo, EqlTran tran) throws Exception;
    /**更新服务项信息*/
    Integer updateOrderItem(OrderItemInfo orderItemInfo, EqlTran tran) throws Exception;

}
