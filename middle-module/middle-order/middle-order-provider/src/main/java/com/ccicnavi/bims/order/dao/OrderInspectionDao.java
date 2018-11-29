package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import com.ccicnavi.bims.order.pojo.OrderInspectionDO;
import com.ccicnavi.bims.order.pojo.OrderInspectionDTO;
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
    Integer insertOrderInspection(OrderInspectionDO orderInspectionDO, EqlTran tran) throws Exception;
    /**
     * @Author MengZiJie
     * @Description 更新运输方式（参数：OrderInfoDTO）
     * @Date 20:35 2018/11/20
     * @Param [orderInfoDTO, tran]
     * @Return java.lang.Integer
     */
    Integer updateOrderInspection(OrderInspectionDO orderInspectionDO, EqlTran tran) throws Exception;
    /**
     * @Author MengZiJie
     * @Description 删除运输方式
     * @Data 2018/11/28 10:21
     * @Param [orderInspectionDO, tran]
     * @Return java.lang.Integer
     */
    Integer deleteOrderInspection(OrderInspectionDTO orderInspectionDTO, EqlTran tran) throws Exception;
    /**
     * @Author heibin
     * @Description 得到委托单运输方式
     * @Date 20:07 2018/11/29
     * @Param [orderInfoDO]
     * @Return com.ccicnavi.bims.order.pojo.OrderInspectionDO
     */
    OrderInspectionDO getOrderInspection(OrderInfoDO orderInfoDO) throws Exception;


}
