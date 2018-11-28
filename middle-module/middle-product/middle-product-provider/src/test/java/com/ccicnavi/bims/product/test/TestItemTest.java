package com.ccicnavi.bims.product.test;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.dao.Impl.TestItemDaoImpl;
import com.ccicnavi.bims.product.pojo.TestItemDO;
import com.ccicnavi.bims.product.pojo.TestItemDTO;
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
        TestItemDTO testItemDTO=new TestItemDTO();
        testItemDTO.setItemName("检测指标");
        List<TestItemDO> testItemDOS=testItemDaoImpl.listTestItem(testItemDTO);
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
            count=testItemDaoImpl.saveTestItem(testItemDO);
            System.out.println(count);
        }
    }

    @Test
    public void removeTestItemTest(){
        int count=0;
        TestItemDO testItemDO=new TestItemDO();
        testItemDO.setItemUuid("item_10");
        count= testItemDaoImpl.removeTestItem(testItemDO);
        System.out.println(count);
    }

    @Test
    public void updateTestItemTest(){
        TestItemDO testItemDO=new TestItemDO();
        testItemDO.setItemUuid("item_5");
        testItemDO.setComments("多了备注，修改成功，666");
        int count=testItemDaoImpl.updateTestItem(testItemDO);
        System.out.println(count);
    }

    @Test
    public void getTestItemTest(){
        TestItemDO testItemDO=new TestItemDO();
//        testItemDO.setItemUuid("item_9");
        testItemDO.setItemName("检测指标");
        TestItemDO testItemDOResult=testItemDaoImpl.getTestItem(testItemDO);
        System.out.println(testItemDOResult);
    }

    @Test
    public void pageTestItemTest(){
        PageParameter<TestItemDTO> page=new PageParameter<>();
        TestItemDTO testItemDO=new TestItemDTO();
        testItemDO.setPublicOrgUuid("CCIC");
        testItemDO.setOrgUuid("XN102");
        testItemDO.setItemName("检测指标1");
        page.setStartIndex(1);
        page.setPageRows(4);
        page.setStartPage(1);
        page.setParameter(testItemDO);
        PageBean<TestItemDO> testItemDOPageBean=testItemDaoImpl.listTestItemPage(page);
        System.out.println(testItemDOPageBean);
    }

}
