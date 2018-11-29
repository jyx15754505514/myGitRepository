package com.ccicnavi.bims.order.dao.impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.dao.OrderWorksheetDao;
import com.ccicnavi.bims.order.pojo.OrderWorksheetDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author songyateng
 * @Description 工作单
 * @Date 15:56 2018/11/21
 */
@Service
public class OrderWorksheetDaoImpl implements OrderWorksheetDao {

    /**
     * @Author songyateng
     * @Description 新增工作单
     * @Date 16:10 2018/11/21
     * @Param [orderWorksheetDTO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertOrderWorksheet(OrderWorksheetDTO orderWorksheetDTO, EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).insert("insertOrderWorksheet").params(orderWorksheetDTO).returnType(Integer.class).execute();
        }
        return eql.insert("insertOrderWorksheet").params(orderWorksheetDTO).returnType(Integer.class).execute();
    }

    /**
     * @Author songyateng
     * @Description 删除工作单
     * @Date 16:14 2018/11/21
     * @Param [orderWorksheetDTO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteOrderWorksheet(OrderWorksheetDTO orderWorksheetDTO, EqlTran tran) {
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("deleteOrderWorksheet").params(orderWorksheetDTO).returnType(Integer.class).execute();
        }
        return eql.update("deleteOrderWorksheet").params(orderWorksheetDTO).returnType(Integer.class).execute();
    }

    /**
     * @Author songyateng
     * @Description 修改工作单
     * @Date 16:17 2018/11/21
     * @Param [orderReviewDTO, tran]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateOrderWorksheet(OrderWorksheetDTO orderWorksheetDTO, EqlTran tran) throws Exception {
        Eql eql = new Eql();
        if (tran !=null){
            return eql.useTran(tran).update("updateOrderWorksheet").params(orderWorksheetDTO).returnType(Integer.class).execute();
        }
        return eql.update("updateOrderWorksheet").params(orderWorksheetDTO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 查询工作单信息
    *@Param: [pageParameter]
    *@return: OrderWorksheetDTO
    *@Author: zhangxingbiao
    *@date: 2018/11/29
    */
    @Override
    public PageBean<OrderWorksheetDTO> listOrderWorksheet(PageParameter<OrderWorksheetDTO> pageParameter) throws Exception {
        EqlPage eqlPage = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        List<OrderWorksheetDTO> orderWorksheetDTOList = new Eql("DEFAULT").select("listOrderWorksheet").params(pageParameter.getParameter()).limit(eqlPage).returnType(OrderWorksheetDTO.class).execute();
        if(orderWorksheetDTOList != null) {
            return  new PageBean<OrderWorksheetDTO>(eqlPage.getTotalRows(),eqlPage.getTotalPages(), eqlPage.getCurrentPage(), eqlPage.getPageRows(), eqlPage.getStartIndex(), orderWorksheetDTOList);
        }else {
            return null;
        }
    }
}
