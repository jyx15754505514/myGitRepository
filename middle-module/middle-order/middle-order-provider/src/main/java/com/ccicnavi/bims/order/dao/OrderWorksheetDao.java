package com.ccicnavi.bims.order.dao;/* *
 * @Author heibin
 * @Description
 * @Date
 * @Param
 */


import com.ccicnavi.bims.order.pojo.OrderWorksheetDO;
import org.n3r.eql.EqlTran;

/**
 * @Author songyateng
 * @Description 工作单
 * @Date 15:49 2018/11/21
 * @Param
 * @Return
 */


public interface OrderWorksheetDao {
    /**
     * @Author songyateng
     * @Description 添加工作单信息
     * @Date 15:49 2018/11/21
     * @Param
     * @Return
     */
    Integer insertOrderWorksheet(OrderWorksheetDO orderWorksheetDO, EqlTran tran) throws Exception;

    /**
     * @Author songyateng
     * @Description 删除信息
     * @Date 15:52 2018/11/21
     * @Param
     * @Return
     */
    Integer deleteOrderWorksheet(OrderWorksheetDO orderWorksheetDO,EqlTran tran) throws Exception;

    /**
     * @Author songyateng
     * @Description 修改工作单
     * @Date 16:16 2018/11/21
     * @Param
     * @Return
     */
    Integer updateOrderWorksheet(OrderWorksheetDO orderReviewDO, EqlTran tran) throws Exception;

}
