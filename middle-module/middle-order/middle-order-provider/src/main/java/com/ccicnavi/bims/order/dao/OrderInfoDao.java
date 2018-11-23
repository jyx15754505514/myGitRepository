package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import org.n3r.eql.EqlTran;
/**
 * @Author MengZiJie
 * @Description 委托单
 * @Date 20:34 2018/11/20
 */
public interface OrderInfoDao {

    /**
     * @Author MengZiJie
     * @Description 新增委托单信息
     * @Date 20:34 2018/11/20
     * @Param [orderInfoDTO, tran]
     * @Return java.lang.Integer
     */
    Integer insertOrderInfo(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception;
    /**
     * @Author MengZiJie
     * @Description 更新委托单信息
     * @Date 20:34 2018/11/20
     * @Param [orderInfoDTO, tran]
     * @Return java.lang.Integer
     */
    Integer updateOrderInfo(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception;
    /**
     * @Author MengZiJie
     * @Description 得到委托单信息
     * @Date 20:34 2018/11/20
     * @Param [orderInfoDO]
     * @Return com.ccicnavi.bims.order.pojo.OrderInfoDTO
     */
    OrderInfoDTO getOrderInfo(OrderInfoDO orderInfoDO) throws Exception;
    /**
     * @Author MengZiJie
     * @Description 查询全部委托单信息信息
     * @Date 20:34 2018/11/20
     * @Param [orderInfoDO]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.order.pojo.OrderInfoDO>
     */
    PageBean<OrderInfoDO> listOrderInfoPage(PageParameter<OrderInfoDO> orderInfoDO) throws Exception;

}
