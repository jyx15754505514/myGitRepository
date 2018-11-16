package com.ccicnavi.bims.product.service;

import com.ccicnavi.bims.customer.dao.Impl.SubcQualifiDaoImpl;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.junit.jupiter.api.Test;
import org.n3r.eql.Eql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: bims-backend
 * @description: 分包方资质信息测试
 * @author: WangYingLing
 * @create: 2018-11-16 15:15
 */
public class SubcQualifiTest {

    SubcQualifiDaoImpl subcQualifiDaoTest=new SubcQualifiDaoImpl();

    @Test
    public void testlistSubcuQuali(){
        List<SubcQualifiDO> subcQualifiDOListTest= subcQualifiDaoTest.listSubcuQuali();
    }

    @Test
    public void testsaveSubcuQuali(){
        SubcQualifiDO subcQualifiDOTest=new SubcQualifiDO();
        for (int i=1;i<=10;i++)
        {
            subcQualifiDOTest.setSubcQualifiUuid("wzy"+i);
            subcQualifiDOTest.setSubcUuid("sub"+i);
            subcQualifiDOTest.setBusinessLine("化工"+i+"号线");
            subcQualifiDOTest.setOrgUuid("wylzsyforever");
            subcQualifiDOTest.setAppSysUuid("wylzsyeveryday");
            int count=subcQualifiDaoTest.saveSubcuQuali(subcQualifiDOTest);
            System.out.println(count);
        }
    }

    @Test
    public void testRemoveSubcuQuali(){
        String uuid="wzy1,wzy2,wzy10";
//        String[] ids=uuid.split(",");
//        Map<String,Object> data=new HashMap<>();
//        data.put("ids",ids);
        int count=subcQualifiDaoTest.removeSubcuQuali(uuid);
        System.out.println(count);
    }

    @Test
    public void testUpdateSubcuQuali(){
        SubcQualifiDO subcQualifiDOTest=new SubcQualifiDO();
        subcQualifiDOTest.setSubcQualifiUuid("wzy5");
        subcQualifiDOTest.setQualifiRange("99");
        int count=subcQualifiDaoTest.updateSubcuQuali(subcQualifiDOTest);
        System.out.println(count);
    }

    @Test
    public void testGetSubcQuali(){
        SubcQualifiDO subcQualifiDOGetTest=new SubcQualifiDO();
        subcQualifiDOGetTest.setSubcQualifiUuid("wzy9");
        SubcQualifiDO subcQualifiDOData=subcQualifiDaoTest.getSubcQuali(subcQualifiDOGetTest);
        System.out.println(subcQualifiDOData);
    }

}
