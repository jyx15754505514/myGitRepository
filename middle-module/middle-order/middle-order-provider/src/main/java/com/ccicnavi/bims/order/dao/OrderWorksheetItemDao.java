package com.ccicnavi.bims.order.dao;

import com.ccicnavi.bims.order.pojo.OrderWorksheetItemDO;
import org.n3r.eql.EqlTran;
/**
 * @Author songyateng 
 * @Description 工作单与服务项关系
 * @Date 17:46 2018/11/21
 */
public interface OrderWorksheetItemDao {

    /**
     * @Author songyateng
     * @Description 新增工作单与服务项关系
     * @Date 17:46 2018/11/21
     * @Param [orderWorksheetItemDO, tran]
     * @Return java.lang.Integer
     */
    Integer insertOrderWorksheet(OrderWorksheetItemDO orderWorksheetItemDO, EqlTran tran) throws Exception;

    /**
     * @Author songyateng
     * @Description 删除工作单与服务项关系
     * @Date 17:46 2018/11/21
     * @Param [orderWorksheetItemDO, tran]
     * @Return java.lang.Integer
     */
    Integer deleteOrderWorksheet(OrderWorksheetItemDO orderWorksheetItemDO,EqlTran tran) throws Exception;

}
