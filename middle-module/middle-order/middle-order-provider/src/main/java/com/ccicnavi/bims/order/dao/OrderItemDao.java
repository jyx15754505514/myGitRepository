package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import com.ccicnavi.bims.order.pojo.OrderItemDTO;
import org.n3r.eql.EqlTran;
import java.util.List;

/**
 * @Author MengZiJie
 * @Description 委托单服务项
 * @Date 15:30 2018/11/19
 */
public interface OrderItemDao {

    /**
     * @Author MengZiJie
     * @Description 新增服务项信息
     * @Date 20:36 2018/11/19
     * @Param [orderItemDTO, tran]
     * @Return java.lang.Integer
     */
    Integer insertOrderItem(OrderItemDTO orderItemDTO, EqlTran tran) throws Exception;
    /**
     * @Author MengZiJie
     * @Description 更新服务项信息
     * @Date 20:36 2018/11/19
     * @Param [orderItemDTO, tran]
     * @Return java.lang.Integer
     */
    Integer updateOrderItem(OrderItemDTO orderItemDTO, EqlTran tran) throws Exception;
    /**
     * @Author MengZiJie
     * @Description 查询所有的服务项信息
     * @Date 20:36 2018/11/22
     * @Param [orderInfoDO]
     * @Return java.util.List<com.ccicnavi.bims.order.pojo.OrderItemDTO>
     */
    List<OrderItemDTO> listOrderItemDTO (OrderInfoDO orderInfoDO)throws  Exception;
    /**
     * @Author MengZiJie
     * @Description 删除服务项信息
     * @Date 20:36 2018/11/22
     * @Param [orderItemDTO, tran]
     * @Return java.lang.Integer
     */
    Integer deleteOrderItem(OrderItemDTO orderItemDTO, EqlTran tran) throws Exception;
    /**
     * @Author heibin
     * @Description 业务查询分页列表
     * @Date 15:13 2018/11/28
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.order.pojo.OrderItemDTO>
     */
    PageBean<OrderItemDTO> listOrderItemPage(PageParameter<OrderItemDTO> pageParameter);
}
