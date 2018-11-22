package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderItemDTO;
import com.ccicnavi.bims.order.pojo.OrderItemSubDO;
import org.n3r.eql.EqlTran;
import java.util.List;

/**
 * @Author heibin
 * @Description 委托单最小服务项子项（最小颗粒度）
 * @Date 9:52 2018/11/20
 * @Param
 * @Return
 */
public interface OrderItemSubDao {
    /**新增最小颗粒度*/
    Integer insertOrderItemSub(OrderItemSubDO orderItemSubDO, EqlTran tran) throws Exception;
    /**更新最小颗粒度*/
    Integer updateOrderItemSub(OrderItemSubDO orderItemSubDO, EqlTran tran) throws Exception;
    /**物理删除最小颗粒度*/
    Integer deleteOrderItemSub(OrderItemSubDO orderItemSubDO, EqlTran tran) throws Exception;
    /**根据最小服务项查询该服务项下的所有的最小颗粒度**/
    List<OrderItemSubDO> listOrderItemSub(OrderItemDTO orderItemDTO) throws Exception;
}
