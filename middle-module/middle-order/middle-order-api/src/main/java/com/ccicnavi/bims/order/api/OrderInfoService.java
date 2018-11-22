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
    Integer updateOrderInfo(OrderInfoDTO orderInfoDTO);
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
     * @Description 修改委托单
     * @Date 15:30 2018/11/19
     * @Param [orderInfoDTO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    ResultT reNewOrderInfo(OrderInfoDTO orderInfoDTO);
    /**
     * @Author MengZiJie
     * @Description 回显委托单信息(根据委托单uuid)
     * @Date 20:16 2018/11/22
     * @Param [orderInfoDO]
     * @Return com.ccicnavi.bims.order.pojo.OrderInfoDTO
     */
    OrderInfoDTO getOrderInfo(OrderInfoDO orderInfoDO);
    /**委托单状态调整**/

    /**委托单设置为加急**/





}
