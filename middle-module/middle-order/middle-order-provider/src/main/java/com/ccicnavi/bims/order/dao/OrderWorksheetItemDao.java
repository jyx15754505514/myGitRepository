package com.ccicnavi.bims.order.dao;/* *
 * @Author heibin
 * @Description
 * @Date
 * @Param
 */

import com.ccicnavi.bims.order.pojo.OrderWorksheetItemDO;
import org.n3r.eql.EqlTran;
/**
 * @Author songyateng 
 * @Description 工作单与服务项的关系
 * @Date 17:46 2018/11/21
 * @Param 
 * @Return 
 */

public interface OrderWorksheetItemDao {
    /**新增工作单与服务项的关系*/
    Integer insertOrderWorksheet(OrderWorksheetItemDO orderWorksheetItemDO, EqlTran tran) throws Exception;
    /**删除工作单与服务项的关系*/
    Integer deleteOrderWorksheet(OrderWorksheetItemDO orderWorksheetItemDO,EqlTran tran) throws Exception;

}
