package com.ccicnavi.bims.product.service;

import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.dao.Impl.TestItemDaoImpl;
import com.ccicnavi.bims.product.pojo.TestItemDO;
import org.junit.Test;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 检测指标测试
 * @author: WangYingLing
 * @create: 2018-11-19 20:38
 */
public class TestItemTest {

    TestItemDaoImpl testItemDaoImpl=new TestItemDaoImpl();

    @Test
    public void listTestItemTest(){
        List<TestItemDO> testItemDOS=testItemDaoImpl.listTestItemDO();
        System.out.println(testItemDOS);
    }

    @Test
    public void saveTestItemTest(){
        int count=0;
        for (int i=1;i<=20;i++)
        {
            TestItemDO testItemDO=new TestItemDO();
            testItemDO.setItemUuid("item_"+i);
            testItemDO.setItemName("检测指标"+i);
            testItemDO.setProdCatalogUuid("prodc_"+i);
            testItemDO.setOrgUuid("NX102");
            testItemDO.setAppSysUuid(i+"号系统");
            count=testItemDaoImpl.saveTestItemDO(testItemDO);
            System.out.println(count);
        }
    }

    @Test
    public void removeTestItemTest(){
        int count=0;
        TestItemDO testItemDO=new TestItemDO();
        testItemDO.setItemUuid("item_10");
        count= testItemDaoImpl.removeTestItemDO(testItemDO);
        System.out.println(count);
    }

    @Test
    public void updateTestItemTest(){
        TestItemDO testItemDO=new TestItemDO();
        testItemDO.setItemUuid("item_5");
        testItemDO.setComments("多了备注，修改成功，666");
        int count=testItemDaoImpl.updateTestItemDO(testItemDO);
        System.out.println(count);
    }

    @Test
    public void getTestItemTest(){
        TestItemDO testItemDO=new TestItemDO();
        testItemDO.setItemUuid("item_9");
        TestItemDO testItemDOResult=testItemDaoImpl.getTestItemDO(testItemDO);
        System.out.println(testItemDOResult);
    }

    @Test
    public void pageTestItemTest(){
        TestItemDO testItemDO=null;
        testItemDO.setItemUuid("item");
        testItemDO.setItemName("检测指标");
        testItemDO.setProdCatalogUuid("prodc_");
        testItemDO.setOrgUuid("NX102");
        testItemDO.setAppSysUuid("号系统");
        PageParameter<TestItemDO> page=new PageParameter<>();
        page.setStartIndex(1);
        page.setStartPage(1);
        page.setStartPage(4);
        page.setParameter(testItemDO);
        System.out.println(testItemDaoImpl.listTestItemPage(page));

    }

}
