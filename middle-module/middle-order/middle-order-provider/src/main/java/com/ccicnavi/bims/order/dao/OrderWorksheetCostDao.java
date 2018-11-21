package com.ccicnavi.bims.order.dao;/* *
 * @Author heibin
 * @Description
 * @Date
 * @Param
 */
import com.ccicnavi.bims.order.pojo.OrderWorksheetCostDo;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

/**
 * @Author songyateng
 * @Description 成本表
 * @Date 16:30 2018/11/21
 * @Param
 * @Return
 */
@Service
public interface OrderWorksheetCostDao {

    /**
     * @Author songyateng
     * @Description 新增成本
     * @Date 16:33 2018/11/21
     * @Param [orderWorksheetCostDo, tran]
     * @Return java.lang.Integer
     */

    Integer insertOrderWorksheetCost(OrderWorksheetCostDo orderWorksheetCostDo, EqlTran tran) throws Exception;

    /**
     * @Author songyateng
     * @Description 修改成本
     * @Date 16:33 2018/11/21
     * @Param [orderWorksheetCostDo, tran]
     * @Return java.lang.Integer
     */

    Integer updateOrderWorksheetCost(OrderWorksheetCostDo orderWorksheetCostDo, EqlTran tran) throws Exception;
}
