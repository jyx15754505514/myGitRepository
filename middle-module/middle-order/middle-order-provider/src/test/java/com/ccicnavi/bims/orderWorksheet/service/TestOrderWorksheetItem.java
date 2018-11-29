package com.ccicnavi.bims.orderWorksheet.service;

import com.ccicnavi.bims.order.dao.impl.OrderWorksheetItemDaoImpl;
import com.ccicnavi.bims.order.pojo.OrderWorksheetItemDO;
import org.junit.Test;

/**
 * @Author songyateng
 * @Description Test 工作单相关测试
 * @Date 9:01 2018/11/22
 */
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
            orderWorksheetItemDO.setWorksheetItemUuid("zhujian");
             orderWorksheetItemDO.setWorksheetUuid("gongzuodanid");
             orderWorksheetItemDO.setOrderItemUuid("uuid");
             System.err.print(order.insertOrderWorksheet(orderWorksheetItemDO, null));
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
    public void deleteOrderWorksheet(){
            try {
            OrderWorksheetItemDO orderWorksheetItemDO = new OrderWorksheetItemDO();
            orderWorksheetItemDO.setWorksheetItemUuid("zhujian");
            System.err.print(order.deleteOrderWorksheet(orderWorksheetItemDO, null));
            }catch (Exception e){
                 e.printStackTrace();
            }
        }
}
