package com.ccicnavi.bims.order.dao;

        import com.ccicnavi.bims.order.pojo.OrderItemDTO;
        import org.n3r.eql.EqlTran;

/* *
 * @Author MengZiJie
 * @Description 委托单服务项
 * @Date 15:30 2018/11/19
 */
public interface OrderItemDao {

    /**新增服务项信息*/
    Integer insertOrderItem(OrderItemDTO orderItemDTO, EqlTran tran) throws Exception;
    /**更新服务项信息*/
    Integer updateOrderItem(OrderItemDTO orderItemDTO, EqlTran tran) throws Exception;

}
