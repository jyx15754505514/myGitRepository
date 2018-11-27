package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import com.ccicnavi.bims.order.pojo.OrderInspectionDO;
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
     * @Description 更新运输方式（参数：OrderInfoDTO）
     * @Date 20:35 2018/11/20
     * @Param [orderInfoDTO, tran]
     * @Return java.lang.Integer
     */
    Integer updateOrderInspection(OrderInfoDTO orderInfoDTO, EqlTran tran) throws Exception;
    /**
     * @Author songyateng
     * @Description 新运输方式（参数：OrderInspectionDO）
     * @Date 2018/11/27 21:14
     * @Param [orderInspectionDO, tran]
     * @Return java.lang.Integer
     */
    Integer updateInspection(OrderInspectionDO orderInspectionDO, EqlTran tran) throws Exception;

}
