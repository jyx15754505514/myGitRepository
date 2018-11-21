package com.ccicnavi.bims.order.dao.impl;/* *
 * @Author heibin
 * @Description
 * @Date
 * @Param
 */

import com.ccicnavi.bims.order.dao.OrderWorksheetDao;
import com.ccicnavi.bims.order.pojo.OrderWorksheetDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
/**
 * @Author songyateng
 * @Description
 * @Date 15:56 2018/11/21
 * @Param
 * @Return
 */

@Service
public class OrderWorksheetDaoImpl implements OrderWorksheetDao {

    /**
     * @Author songyateng
     * @Description 新增工作单
     * @Date 16:10 2018/11/21
     * @Param [orderWorksheetDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderWorksheet(OrderWorksheetDO orderWorksheetDO, EqlTran tran) {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).insert("insertOrderWorksheet").params(orderWorksheetDO).returnType(Integer.class).execute();
        }
        return eql.insert("insertOrderWorksheet").params(orderWorksheetDO).returnType(Integer.class).execute();
    }

    /**
     * @Author songyateng
     * @Description 删除工作单
     * @Date 16:14 2018/11/21
     * @Param [orderWorksheetDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderWorksheet(OrderWorksheetDO orderWorksheetDO, EqlTran tran) {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            return eql.useTran(tran).update("deleteOrderWorksheet").params(orderWorksheetDO).returnType(Integer.class).execute();
        }
        return eql.update("deleteOrderWorksheet").params(orderWorksheetDO).returnType(Integer.class).execute();
    }

    /**
     * @Author songyateng
     * @Description 修改工作单
     * @Date 16:17 2018/11/21
     * @Param [orderReviewDO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderWorksheet(OrderWorksheetDO orderWorksheetDO, EqlTran tran) throws Exception {
        Eql eql = new Eql("DEFAULT");
        if (tran !=null){
            return eql.useTran(tran).update("updateOrderWorksheet").params(orderWorksheetDO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderWorksheet").params(orderWorksheetDO).returnType(Integer.class).execute();
    }
}
