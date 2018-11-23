package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import org.n3r.eql.EqlTran;
/**
 * @Author MengZiJie
 * @Description 委托单运输方式
 * @Date 20:35 2018/11/20
 */
public interface OrderInspectionDao {

    /**
     * @Author MengZiJie
     * @Description 新增运输方式
     * @Date 20:34 2018/11/20
     * @Param [orderInfoDTO, tran]
     * @Return java.lang.Integer
     */
    Integer insertOrderInspection(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception;
    /**
     * @Author MengZiJie
     * @Description 更新运输方式
     * @Date 20:35 2018/11/20
     * @Param [orderInfoDTO, tran]
     * @Return java.lang.Integer
     */
    Integer updateOrderInspection(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception;

}
