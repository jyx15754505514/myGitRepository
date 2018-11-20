package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import com.ccicnavi.bims.order.pojo.OrderShipmentDO;
import org.n3r.eql.EqlTran;
/* *
 * @Author MengZiJie
 * @Description 委托单运输方式
 * @Date 16:01 2018/11/19
 * @Param
 * @Return
 */
public interface OrderShipmentDao {

    /**新增运输方式*/
    Integer insertOrderShipment(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception;
    /**更新运输方式*/
    Integer updateOrderShipment(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception;

}
