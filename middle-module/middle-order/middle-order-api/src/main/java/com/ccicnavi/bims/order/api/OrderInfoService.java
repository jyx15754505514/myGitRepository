package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
/**
 * @Author MengZiJie
 * @Description 委托单
 * @Date 15:30 2018/11/19
 */
public interface OrderInfoService {

    /**
     * @Author MengZiJie
     * @Description 新增委托单信息
     * @Date 15:30 2018/11/19
     * @Param [orderInfoDTO]
     * @Return java.lang.Integer
     */
    Integer insertOrderInfo(OrderInfoDTO orderInfoDTO);
    /**
     * @Author MengZiJie
     * @Description 更新委托单信息
     * @Date 15:30 2018/11/19
     * @Param [orderInfoDTO]
     * @Return java.lang.Integer
     */
    ResultT updateOrderInfo(OrderInfoDTO orderInfoDTO);
    /**
     * @Author MengZiJie
     * @Description 委托单分页列表
     * @Date 15:30 2018/11/19
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.order.pojo.OrderInfoDO>
     */
    PageBean<OrderInfoDO> listOrderInfo(PageParameter<OrderInfoDO> pageParameter);
    /**
     * @Author MengZiJie
     * @Description 保存委托单
     * @Date 15:30 2018/11/19
     * @Param [orderInfoDTO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    ResultT saveOrderInfo(OrderInfoDTO orderInfoDTO);
    /**
     * @Author MengZiJie
     * @Description 回显委托单信息(根据委托单uuid)
     * @Date 20:16 2018/11/22
     * @Param [orderInfoDO]
     * @Return com.ccicnavi.bims.order.pojo.OrderInfoDTO
     */
    OrderInfoDTO getOrderInfo(OrderInfoDO orderInfoDO);
    /**
     * @Author MengZiJie
     * @Description 更改委托单状态
     * @Data 2018/11/27 17:16
     * @Param [orderInfoDTO]
     * @Return java.lang.Integer
     */
    Integer updateOrderStatus(OrderInfoDTO orderInfoDTO);
    /**
     * @Author MengZiJie
     * @Description 删除委托单
     * @Data 2018/11/28 9:39
     * @Param [orderInfoDTO]
     * @Return java.lang.Integer
     */
    Integer removeOrderInfo(OrderInfoDTO orderInfoDTO);

}
