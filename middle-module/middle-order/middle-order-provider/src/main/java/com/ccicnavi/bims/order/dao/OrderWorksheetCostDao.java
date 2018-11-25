package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderWorksheetCostDO;
import org.n3r.eql.EqlTran;
/**
 * @Author songyateng
 * @Description 成本表
 * @Date 16:30 2018/11/21
 */
public interface OrderWorksheetCostDao {

    /**
     * @Author songyateng
     * @Description 新增成本
     * @Date 16:33 2018/11/21
     * @Param [orderWorksheetCostDo, tran]
     * @Return java.lang.Integer
     */
    Integer insertOrderWorksheetCost(OrderWorksheetCostDO orderWorksheetCostDo, EqlTran tran) throws Exception;

    /**
     * @Author songyateng
     * @Description 修改成本
     * @Date 16:33 2018/11/21
     * @Param [orderWorksheetCostDo, tran]
     * @Return java.lang.Integer
     */
    Integer updateOrderWorksheetCost(OrderWorksheetCostDO orderWorksheetCostDo, EqlTran tran) throws Exception;
}
