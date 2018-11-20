package com.ccicnavi.bims.order.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;

/* *
 * @Author MengZiJie
 * @Description 委托单
 * @Date 15:30 2018/11/19
 */
public interface OrderInfoService {


    /**新增委托单信息*/
    Integer insertOrderInfo(OrderInfoDTO orderInfoDTO);
    /**更新委托单信息*/
    Integer updateOrderInfo(OrderInfoDTO orderInfoDTO);
    /**委托单分页列表**/
    PageBean<OrderInfoDO> listOrderInfo(PageParameter<OrderInfoDO> pageParameter);
    /**保存委托单*/
    ResultT saveOrderInfo(OrderInfoDTO orderInfoDTO);
    /**委托单置为无效**/

    /**委托单设置为加急**/





}
