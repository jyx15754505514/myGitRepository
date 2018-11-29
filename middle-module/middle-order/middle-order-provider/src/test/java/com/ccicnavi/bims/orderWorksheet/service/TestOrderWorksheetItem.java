package com.ccicnavi.bims.orderWorksheet.service;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.dao.impl.OrderWorksheetItemDaoImpl;
import com.ccicnavi.bims.order.pojo.OrderWorksheetItemDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;

/**
 * @Author songyateng
 * @Description Test 工作单相关测试
 * @Date 9:01 2018/11/22
 */
@Slf4j
public class TestOrderWorksheetItem {
    OrderWorksheetItemDaoImpl order = new OrderWorksheetItemDaoImpl();
        /**
        * @author songyateng
        * @description 新增工作单与服务项
        * @date 2018/11/22 22:08
        */
    @Test
    public void insertOrderWorksheetItem(){
        try {
             OrderWorksheetItemDO orderWorksheetItemDO = new OrderWorksheetItemDO();
            orderWorksheetItemDO.setWorksheetItemUuid("悟空");
             orderWorksheetItemDO.setWorksheetUuid("孙悟空");
             orderWorksheetItemDO.setOrderItemUuid("uuid");
             System.err.print(order.insertOrderWorksheetItem(orderWorksheetItemDO, null));
        } catch (Exception e){
                e.printStackTrace();
        }
    }

     /**
       * @author songyateng
       * @description 删除工作单与服务项
       * @date 2018/11/22 22:29
       */
    @Test
    public void deleteOrderWorksheetItem(){
            try {
            OrderWorksheetItemDO orderWorksheetItemDO = new OrderWorksheetItemDO();
            orderWorksheetItemDO.setWorksheetItemUuid("悟空");
            System.err.print(order.deleteOrderWorksheetItem(orderWorksheetItemDO, null));
            }catch (Exception e){
                 e.printStackTrace();
            }
        }
    @Test
    public void updateOrderWorksheetItem(){
        try {
            OrderWorksheetItemDO orderWorksheetItemDO = new OrderWorksheetItemDO();
            orderWorksheetItemDO.setWorksheetItemUuid("悟空");
            orderWorksheetItemDO.setOrderItemUuid("wwww");
            System.err.print(order.updateOrderWorksheetItem(orderWorksheetItemDO, null));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
