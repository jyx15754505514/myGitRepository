package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.order.dao.OrderWorksheetCostDao;
import com.ccicnavi.bims.order.pojo.OrderWorksheetCostDo;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
/**
 * @Author songyateng
 * @Description 成本表
 * @Date 16:36 2018/11/21
 */
@Service
public class OrderWorksheetCostDaoImpl implements OrderWorksheetCostDao {
    /**
     * @Author songyateng
     * @Description  新增成本表
     * @Date 16:45 2018/11/21
     * @Param [orderWorksheetCostDo, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderWorksheetCost(OrderWorksheetCostDo orderWorksheetCostDo, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).insert("insertOrderWorksheetCost").params(orderWorksheetCostDo).returnType(Integer.class).execute();
        }
        return eql.insert("insertOrderWorksheetCost").params(orderWorksheetCostDo).returnType(Integer.class).execute();
    }
    /**
     * @Author songyateng
     * @Description 修改成本表
     * @Date 16:45 2018/11/21
     * @Param [orderWorksheetCostDo, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderWorksheetCost(OrderWorksheetCostDo orderWorksheetCostDo, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).update("updateOrderWorksheetCost").params(orderWorksheetCostDo).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderWorksheetCost").params(orderWorksheetCostDo).returnType(Integer.class).execute();
    }
}

