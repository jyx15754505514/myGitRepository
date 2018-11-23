package com.ccicnavi.bims.orderWorksheet.service;

import com.ccicnavi.bims.order.dao.impl.OrderWorksheetDaoImpl;
import com.ccicnavi.bims.order.pojo.OrderWorksheetDO;
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
            OrderWorksheetDO orderWorksheetDO = new OrderWorksheetDO();
            orderWorksheetDO.setWorksheetUuid("bbbbb");
            orderWorksheetDO.setAssignUserUuid("cccccc");
            orderWorksheetDO.setAssignTime(new Date());
            orderWorksheetDO.setAssignComments("分配说明");
            orderWorksheetDO.setPlanStartDate(new Date());
            orderWorksheetDO.setPlanEndDate(new Date());
            orderWorksheetDO.setImplDeptUuid("bvc");
            orderWorksheetDO.setImplMgrUuid("nnnn");
            orderWorksheetDO.setImplStartDate(new Date());
            orderWorksheetDO.setImplEndDate(new Date());
            orderWorksheetDO.setComments("备注");
            orderWorksheetDO.setIsDeleted("N");
            orderWorksheetDO.setCreatedTime(new Date());
            orderWorksheetDO.setCreatedUuid("chuangshirenid");
            orderWorksheetDO.setCreatedName("创建人");
            orderWorksheetDO.setUpdatedTime(new Date());
            orderWorksheetDO.setUpdatedUuid("gengxinrenuuid");
            orderWorksheetDO.setUpdatedName("更新人");
            orderWorksheetDO.setOrgUuid("jigouuuid");
            orderWorksheetDO.setAppSysUuid("xitongid");
            System.err.print(order.insertOrderWorksheet(orderWorksheetDO, null));
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
            OrderWorksheetDO orderWorksheetDO = new OrderWorksheetDO();
            orderWorksheetDO.setWorksheetUuid("aaaaa");
            System.err.print(order.deleteOrderWorksheet(orderWorksheetDO, null));
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
            OrderWorksheetDO orderWorksheetDO = new OrderWorksheetDO();
            orderWorksheetDO.setWorksheetUuid("aaaaa");
            orderWorksheetDO.setAssignUserUuid("123");
            orderWorksheetDO.setAppSysUuid("666");
            System.err.print(order.updateOrderWorksheet(orderWorksheetDO, null));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
