package com.ccicnavi.bims.product.service;

import com.ccicnavi.bims.product.dao.Impl.TestItemDaoImpl;
import com.ccicnavi.bims.product.pojo.TestItemDO;
import org.junit.Test;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: 本人姓名
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
        for (int i=1;i<=10;i++)
        {
            TestItemDO testItemDO=new TestItemDO();
            testItemDO.setItemUuid("item_"+i);
            testItemDO.setItemName("检测指标"+i);
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

}
