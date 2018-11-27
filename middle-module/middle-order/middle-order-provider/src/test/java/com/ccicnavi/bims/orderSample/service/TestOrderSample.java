package com.ccicnavi.bims.orderSample.service;

import com.ccicnavi.bims.order.dao.impl.OrderSampleDaoImpl;
import com.ccicnavi.bims.order.pojo.OrderSampleDO;
import org.junit.Test;
import java.util.Date;

/**
 * @Author songyateng
 * @Description 测试样品单
 * @Date 17:32 2018/11/22
 */
public class TestOrderSample {
    OrderSampleDaoImpl order = new OrderSampleDaoImpl();
    /**
      * @author songyateng
      * @description 保存样品信息
      * @date 2018/11/23 9:43
      */
    @Test
    public void insertOrderSample(){
        try {
            OrderSampleDO orderSampleDO = new OrderSampleDO();
            orderSampleDO.setSampleUuid("yangpin");
            orderSampleDO.setOrderUuid("AAA");
            orderSampleDO.setSampleCode("DD");
            orderSampleDO.setSampleName("大红包");
            orderSampleDO.setSampleSpec("AA");
            orderSampleDO.setSampleType("类型");
            orderSampleDO.setSamplePlace("xx");
            orderSampleDO.setSampleUnit("xxxxx");
            orderSampleDO.setSendPerson("xxxx");
            orderSampleDO.setSendTime(new Date());
            orderSampleDO.setReceivePerson("aa");
            orderSampleDO.setReceiveTime(new Date());
            orderSampleDO.setReceiptPerson("va");
            orderSampleDO.setReceiptTime(new Date());
            orderSampleDO.setReceiptType("leixing");
            orderSampleDO.setDisposer("fa");
            orderSampleDO.setDisposerTime(new Date());
            orderSampleDO.setDisposerMethod("hhhhh");
            orderSampleDO.setSampleFile("wenjian");
            orderSampleDO.setComments("备注");
            orderSampleDO.setIsDeleted("N");
            orderSampleDO.setCreatedTime(new Date());
            orderSampleDO.setCreatedUuid("gss");
            orderSampleDO.setCreatedName("hbvgakbj");
            orderSampleDO.setUpdatedTime(new Date());
            orderSampleDO.setUpdatedUuid("gengxinrenid");
            orderSampleDO.setUpdatedName("gengxinrenname");
            orderSampleDO.setProdCatalogUuid("chanpinxianid");
            orderSampleDO.setOrgUuid("opnnn");
            orderSampleDO.setAppSysUuid("ddddd");
            System.err.print(order.insertOrderSample(orderSampleDO, null));
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
      * @author songyateng
      * @description 删除样品
      * @date 2018/11/23 10:35
      */
    @Test
    public void deleteOrderSample(){
        try {
            OrderSampleDO orderSampleDO = new OrderSampleDO();
            orderSampleDO.setSampleUnit("yangpin");
            System.err.print(order.deleteOrderSample(orderSampleDO, null));
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
      * @author songyateng
      * @description 查询全部样品
      * @date 2018/11/23 14:48
      */
    @Test
    public void listOrderSample(){
        try {
            OrderSampleDO orderSampleDO = new OrderSampleDO();
            orderSampleDO.setSampleUuid("yangpin");
            System.err.print(order.listOrderSample(orderSampleDO));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @Author songyateng
     * @Description 更新样品数据
     * @Date 2018/11/27 23:35
     */
    @Test
    public void updateOrderSample(){
        try {
            OrderSampleDO orderSampleDO = new OrderSampleDO();
            orderSampleDO.setSampleUuid("AAA");
            orderSampleDO.setSampleName("BBB");
            System.err.print(order.updateOrderSample(orderSampleDO,null));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
