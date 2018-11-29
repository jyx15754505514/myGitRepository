package com.ccicnavi.bims.orderWorksheet.service;

import com.ccicnavi.bims.order.dao.impl.OrderWorksheetDaoImpl;
import com.ccicnavi.bims.order.pojo.OrderWorksheetDTO;
import org.junit.Test;

import java.util.Date;

/**
 * @Author songyateng
 * @Description Test 工作单相关测试
 * @Date 9:01 2018/11/22
 */
public class TestOrderWorksheet {
        OrderWorksheetDaoImpl order = new OrderWorksheetDaoImpl();
    /**
     * @Author songyateng
     * @Description 新增工作单
     * @Date 9:52 2018/11/22
     */
    @Test
    public void insertOrderWorksheet() {
        try {
            OrderWorksheetDTO orderWorksheetDTO = new OrderWorksheetDTO();
            orderWorksheetDTO.setWorksheetUuid("bbbbb");
            orderWorksheetDTO.setAssignUserUuid("cccccc");
            orderWorksheetDTO.setAssignTime(new Date());
            orderWorksheetDTO.setAssignComments("分配说明");
            orderWorksheetDTO.setPlanStartDate(new Date());
            orderWorksheetDTO.setPlanEndDate(new Date());
            orderWorksheetDTO.setImplDeptUuid("bvc");
            orderWorksheetDTO.setImplMgrUuid("nnnn");
            orderWorksheetDTO.setImplStartDate(new Date());
            orderWorksheetDTO.setImplEndDate(new Date());
            orderWorksheetDTO.setComments("备注");
            orderWorksheetDTO.setIsDeleted("N");
            orderWorksheetDTO.setCreatedTime(new Date());
            orderWorksheetDTO.setCreatedUuid("chuangshirenid");
            orderWorksheetDTO.setCreatedName("创建人");
            orderWorksheetDTO.setUpdatedTime(new Date());
            orderWorksheetDTO.setUpdatedUuid("gengxinrenuuid");
            orderWorksheetDTO.setUpdatedName("更新人");
            orderWorksheetDTO.setOrgUuid("jigouuuid");
            orderWorksheetDTO.setAppSysUuid("xitongid");
            System.err.print(order.insertOrderWorksheet(orderWorksheetDTO, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @Author songyateng 
     * @Description 删除工作单
     * @Date 10:14 2018/11/22
     */
    @Test
    public void deleteOrderWorksheet() {
        try {
            OrderWorksheetDTO orderWorksheetDTO = new OrderWorksheetDTO();
            orderWorksheetDTO.setWorksheetUuid("aaaaa");
            System.err.print(order.deleteOrderWorksheet(orderWorksheetDTO, null));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @Author songyateng 
     * @Description 修改工作单
     * @Date 10:58 2018/11/22
     */
    @Test
    public void updateOrderWorksheet() {
        try {
            OrderWorksheetDTO orderWorksheetDTO = new OrderWorksheetDTO();
            orderWorksheetDTO.setWorksheetUuid("aaaaa");
            orderWorksheetDTO.setAssignUserUuid("123");
            orderWorksheetDTO.setAppSysUuid("666");
            System.err.print(order.updateOrderWorksheet(orderWorksheetDTO, null));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
