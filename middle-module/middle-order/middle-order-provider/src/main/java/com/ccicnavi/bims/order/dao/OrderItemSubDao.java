package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderItemDTO;
import com.ccicnavi.bims.order.pojo.OrderItemSubDO;
import org.n3r.eql.EqlTran;
import java.util.List;
/**
 * @Author heibin
 * @Description 委托单最小服务项子项（最小颗粒度）
 * @Date 9:52 2018/11/20
 */
public interface OrderItemSubDao {

    /**
     * @Author heibin
     * @Description 新增最小颗粒度
     * @Date 9:52 2018/11/20
     * @Param [orderItemSubDO, tran]
     * @Return java.lang.Integer
     */
    Integer insertOrderItemSub(OrderItemSubDO orderItemSubDO, EqlTran tran) throws Exception;
    /**
     * @Author heibin
     * @Description 更新最小颗粒度
     * @Date 9:52 2018/11/20
     * @Param [orderItemSubDO, tran]
     * @Return java.lang.Integer
     */
    Integer updateOrderItemSub(OrderItemSubDO orderItemSubDO, EqlTran tran) throws Exception;
    /**
     * @Author heibin
     * @Description 物理删除最小颗粒度
     * @Date 9:52 2018/11/20
     * @Param [orderItemSubDO, tran]
     * @Return java.lang.Integer
     */
    Integer deleteOrderItemSub(OrderItemSubDO orderItemSubDO, EqlTran tran) throws Exception;
    /**
     * @Author heibin
     * @Description 根据最小服务项查询该服务项下的所有的最小颗粒度
     * @Date 9:52 2018/11/20
     * @Param [orderItemDTO]
     * @Return java.util.List<com.ccicnavi.bims.order.pojo.OrderItemSubDO>
     */
    List<OrderItemSubDO> listOrderItemSub(OrderItemDTO orderItemDTO) throws Exception;
}
