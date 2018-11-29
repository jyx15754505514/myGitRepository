package com.ccicnavi.bims.order.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.api.OrderWorksheetService;
import com.ccicnavi.bims.order.dao.OrderWorksheetDao;
import com.ccicnavi.bims.order.pojo.OrderWorksheetDTO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *@program: bims-backend
 *@description: 工作单Service实现
 *@author: zhangxingbiao
 *@create: 2018-11-29 17:05
 */
@Slf4j
@Service
public class OrderWorksheetServiceImpl implements OrderWorksheetService {

    @Autowired
    OrderWorksheetDao orderWorksheetDao;
    /**
    *@Description: 查询工作单
    *@Param: [pageParameter]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangxingbiao
    *@date: 2018/11/29
    */
    @Override
    public ResultT listOrderWorksheet(PageParameter<OrderWorksheetDTO> pageParameter) {
        try {
            PageBean<OrderWorksheetDTO> pageBean = orderWorksheetDao.listOrderWorksheet(pageParameter);
            if (pageBean != null) {
                return ResultT.success(pageBean);
            }
        } catch (Exception e) {
            log.error("查询工作单信息失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }
    /**
    *@Description: 新增工作单
    *@Param: [orderWorksheetDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/29
    */
    @Override
    public Integer insertOrderWorksheet(OrderWorksheetDTO orderWorksheetDTO) throws Exception {
        EqlTran tran = new Eql("DEFAULT").newTran();
        try {
            return orderWorksheetDao.insertOrderWorksheet(orderWorksheetDTO, tran);
        } catch (Exception e) {
            log.error("新增工作单失败",e);
            return null;
        }
    }
    /**
    *@Description: 删除工作单
    *@Param: [orderWorksheetDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/29
    */
    @Override
    public Integer deleteOrderWorksheet(OrderWorksheetDTO orderWorksheetDTO) throws Exception {
        EqlTran tran = new Eql("DEFAULT").newTran();
        try {
            return orderWorksheetDao.deleteOrderWorksheet(orderWorksheetDTO, tran);
        } catch (Exception e) {
            log.error("删除工作单失败",e);
            return null;
        }
    }

    /**
    *@Description: 更新工作单
    *@Param: [orderWorksheetDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/29
    */
    @Override
    public Integer updateOrderWorksheet(OrderWorksheetDTO orderWorksheetDTO) throws Exception {
        EqlTran tran = new Eql("DEFAULT").newTran();
        try {
            return orderWorksheetDao.updateOrderWorksheet(orderWorksheetDTO, tran);
        } catch (Exception e) {
            log.error("更新工作单失败",e);
            return null;
        }
    }
}
