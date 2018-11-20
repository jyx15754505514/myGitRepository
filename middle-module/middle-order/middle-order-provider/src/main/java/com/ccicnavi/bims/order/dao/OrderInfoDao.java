package com.ccicnavi.bims.order.dao;

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

}
