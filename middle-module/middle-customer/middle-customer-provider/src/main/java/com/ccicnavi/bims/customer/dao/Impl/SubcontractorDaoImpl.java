package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.SubcontractorDao;
import com.ccicnavi.bims.customer.pojo.SubcontractorDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubcontractorDaoImpl implements SubcontractorDao {
    @Override
    public List<SubcontractorDO> listSubcontractor(SubcontractorDO subcontractor) {
        return EqlUtils.getInstance("druid").select("listSubcontractor").params(subcontractor).execute();
    }

    @Override
    public int saveSubcontractor(SubcontractorDO subcontractor) {
        return EqlUtils.getInstance("druid").insert("saveSubcontractor").params(subcontractor).execute();
    }

    @Override
    public int removeSubcontractor(String subcontractorUuid) {
        Map<String,Object> data=new HashMap<>();
        data.put("ids",subcontractorUuid.split(","));
        return EqlUtils.getInstance("druid").update("removeSubcontractor").params(data).execute();
    }

    @Override
    public int updateSubcontractor(SubcontractorDO subcontractor) {
        return EqlUtils.getInstance("druid").update("updateSubcontractor").params(subcontractor).execute();
    }

    @Override
    public SubcontractorDO getSubcontractor(SubcontractorDO subcontractor) {
        return EqlUtils.getInstance("druid").select("getSubcontractor").params(subcontractor).execute();
    }

    /**
     * ————————————Junit测试————————————————————————
     */

    @Test
    public void testListSubcontractor() {
        List<SubcontractorDO> subcontractorDOList = EqlUtils.getInstance("druid").select("listSubcontractor").returnType(SubcontractorDO.class).execute();
        System.out.println(subcontractorDOList);
    }

    @Test
    public void testSaveSubcontractor() {
        for (int i = 1; i <= 10; i++) {
            SubcontractorDO SubcontractorDO = new SubcontractorDO();
            SubcontractorDO.setSubcontractorUuid("asd" + i);
            SubcontractorDO.setBusinessLine("类型" + i);
            SubcontractorDO.setOrgUuid("另一个"+i);
            SubcontractorDO.setAppSysUuid("DeptUuid"+i);
            SubcontractorDO.setCreatedUuid("cud"+i);
            SubcontractorDO.setCreatedName("徐"+i);
            int count = EqlUtils.getInstance("druid").insert("saveSubcontractor").params(SubcontractorDO).execute();
            System.out.println("count-----" + count);
        }
    }

    @Test
    public void testUpdateSubcontractor() {
        SubcontractorDO SubcontractorDO = new SubcontractorDO();
        SubcontractorDO.setSubcontractorUuid("asd4");
        SubcontractorDO.setCreatedName("徐4被修改了~");
        int count = EqlUtils.getInstance("druid").update("updateSubcontractor").params(SubcontractorDO).execute();
        System.out.println(count);
    }


    @Test
    public void testRemoveSubcontractor() {
        String uuids = "asd1,asd10,asd2";
        String[] ids = uuids.split(",");
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("ids", ids);
        int count = EqlUtils.getInstance("druid").update("removeSubcontractor").params(data).execute();
        System.out.println(count);
    }

    @Test
    public void testGetSubcontractor() {
        SubcontractorDO SubcontractorDO = new SubcontractorDO();
        SubcontractorDO.setSubcontractorUuid("asd9");
        SubcontractorDO getSubcontractor = EqlUtils.getInstance("druid").selectFirst("getSubcontractor").params(SubcontractorDO).returnType(SubcontractorDO.class).execute();
        System.out.println(getSubcontractor);
    }

}

    

