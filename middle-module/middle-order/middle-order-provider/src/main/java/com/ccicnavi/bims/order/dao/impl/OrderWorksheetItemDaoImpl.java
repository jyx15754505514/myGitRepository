package com.ccicnavi.bims.order.dao.impl;/* *
 * @Author heibin
 * @Description
 * @Date
 * @Param
 */


import com.ccicnavi.bims.order.dao.OrderWorksheetItemDao;
import com.ccicnavi.bims.order.pojo.OrderWorksheetItemDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
/**
 * @Author songyateng 
 * @Description /工作单与服务项的关系
 * @Date 17:48 2018/11/21
 * @Param 
 * @Return 
 */

@Service
public class OrderWorksheetItemDaoImpl implements OrderWorksheetItemDao {

    /**
     * @Author songyateng
     * @Description 新增工作单与服务项的关系
     * @Date 17:49 2018/11/21
     * @Param [orderWorksheetItemDO, tran]
     * @Return java.lang.Integer
     */

    @Override
    public Integer insertOrderWorksheet(OrderWorksheetItemDO orderWorksheetItemDO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).insert("insertOrderWorksheetItem").params(orderWorksheetItemDO).returnType(Integer.class).execute();
        }
        return eql.insert("insertOrderWorksheetItem").params(orderWorksheetItemDO).returnType(Integer.class).execute();
    }
    /**
     * @Author songyateng
     * @Description 删除工作单与服务项的关系
     * @Date 17:50 2018/11/21
     * @Param [orderWorksheetItemDO, tran]
     * @Return java.lang.Integer
     */

    @Override
    public Integer deleteOrderWorksheet(OrderWorksheetItemDO orderWorksheetItemDO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).update("deleteOrderWorksheetItem").params(orderWorksheetItemDO).returnType(Integer.class).execute();
        }
        return eql.delete("deleteOrderWorksheetItem").params(orderWorksheetItemDO).returnType(Integer.class).execute();
    }
}
