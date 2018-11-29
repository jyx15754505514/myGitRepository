package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.dao.OrderWorksheetItemDao;
import com.ccicnavi.bims.order.pojo.OrderWorksheetItemDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author songyateng 
 * @Description /工作单与服务项的关系
 * @Date 17:48 2018/11/21
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
    public Integer insertOrderWorksheetItem(OrderWorksheetItemDO orderWorksheetItemDO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
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
    public Integer deleteOrderWorksheetItem(OrderWorksheetItemDO orderWorksheetItemDO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).delete("deleteOrderWorksheetItem").params(orderWorksheetItemDO).returnType(Integer.class).execute();
        }
        return eql.delete("deleteOrderWorksheetItem").params(orderWorksheetItemDO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 更改工作单与服务项的关系
    *@Param: [orderWorksheetItemDO, tran]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/29
    */
    @Override
    public Integer updateOrderWorksheetItem(OrderWorksheetItemDO orderWorksheetItemDO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.update("updateOrderWorksheetItem").params(orderWorksheetItemDO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 查询工作单与服务项的关系
    *@Param: [pageParameter]
    *@return: OrderWorksheetItemDO
    *@Author: zhangxingbiao
    *@date: 2018/11/29
    */
    @Override
    public PageBean<OrderWorksheetItemDO> listOrderWorksheetItem(PageParameter<OrderWorksheetItemDO> pageParameter) throws Exception {
        EqlPage eqlPage = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        List<OrderWorksheetItemDO> orderWorksheetItemDOListList = new Eql("DEFAULT").select("listOrderWorksheetItem").params(pageParameter.getParameter()).limit(eqlPage).returnType(OrderWorksheetItemDO.class).execute();
        if(orderWorksheetItemDOListList != null) {
            return  new PageBean<OrderWorksheetItemDO>(eqlPage.getTotalRows(),eqlPage.getTotalPages(), eqlPage.getCurrentPage(), eqlPage.getPageRows(), eqlPage.getStartIndex(), orderWorksheetItemDOListList);
        }else {
            return null;
        }
    }
}
