package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.SubcQualifiDao;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.junit.jupiter.api.Test;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubcQualifiDaoImpl implements SubcQualifiDao {

    @Override
    public List<SubcQualifiDO> listSubcuQuali(SubcQualifiDO subcuQuali) {
        return EqlUtils.getInstance("druid").select("listSubcuQuali").params(subcuQuali).execute();
    }

    @Override
    public int saveSubcuQuali(SubcQualifiDO subcuQuali) {
        return EqlUtils.getInstance("druid").insert("saveSubcuQuali").params(subcuQuali).execute();
    }

    @Override
    public int removeSubcuQuali(String subcQualifiUuid) {
        Map<String,Object> data=new HashMap<>();
        data.put("ids",subcQualifiUuid.split(","));
        return EqlUtils.getInstance("druid").update("removeSubcuQuali").params(data).execute();
    }

    @Override
    public int updateSubcuQuali(SubcQualifiDO subcuQuali) {
        return EqlUtils.getInstance("druid").update("updateSubcuQualicuQuali").params(subcuQuali).execute();
    }

    @Override
    public SubcQualifiDO getSubcQuali(SubcQualifiDO subcQuali) {
        return EqlUtils.getInstance("druid").select("getSubcQuali").params(subcQuali).execute();
    }

    /**
     * ----------------------------Junit测试--------------------------------------
     */

    @Test
    public void testlistSubcuQuali(){
        List<SubcQualifiDO> subcQualifiDOListTest=EqlUtils.getInstance("druid").select("listSubcuQuali").execute();
        System.out.println(subcQualifiDOListTest.get(1));
        System.out.println(subcQualifiDOListTest.get(2));
        System.out.println(subcQualifiDOListTest.size());
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
            int count=EqlUtils.getInstance("druid").insert("saveSubcuQuali").params(subcQualifiDOTest).execute();
            System.out.println(count);
        }
    }

    @Test
    public void testRemoveSubcuQuali(){
        String uuid="wzy1,wzy2,wzy10";
        String[] ids=uuid.split(",");
        Map<String,Object> data=new HashMap<>();
        data.put("ids",ids);
        int count=EqlUtils.getInstance("druid").delete("removeSubcuQuali").params(data).execute();
        System.out.println(count);
    }

    @Test
    public void testUpdateSubcuQuali(){
        SubcQualifiDO subcQualifiDOTest=new SubcQualifiDO();
        subcQualifiDOTest.setSubcQualifiUuid("wzy5");
        int count=EqlUtils.getInstance("druid").update("updateSubcuQuali").params(subcQualifiDOTest).execute();
        System.out.println(count);
    }

    @Test
    public void testGetSubcQuali(){
        SubcQualifiDO subcQualifiDOGetTest=new SubcQualifiDO();
        subcQualifiDOGetTest.setSubcQualifiUuid("wzy9");
        SubcQualifiDO subcQualifiDOData=EqlUtils.getInstance("druid").selectFirst("getSubcQuali").params(subcQualifiDOGetTest).returnType(SubcQualifiDO.class).execute();
        System.out.println(subcQualifiDOData);
    }

}
