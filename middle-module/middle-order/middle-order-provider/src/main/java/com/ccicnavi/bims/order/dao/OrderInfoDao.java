package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import org.n3r.eql.EqlTran;

/* *
 * @Author MengZiJie
 * @Description 委托单
 * @Date 15:30 2018/11/19
 */
public interface OrderInfoDao {

    /**新增委托单信息*/
    Integer insertOrderInfo(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception;
    /**更新委托单信息*/
    Integer updateOrderInfo(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception;
    /**得到委托单信息*/
    OrderInfoDTO getOrderInfo(OrderInfoDO orderInfoDO) throws Exception;

    /**查询全部委托单信息信息*/
    PageBean<OrderInfoDO> listOrderInfoPage(PageParameter<OrderInfoDO> orderInfoDO) throws Exception;

}
