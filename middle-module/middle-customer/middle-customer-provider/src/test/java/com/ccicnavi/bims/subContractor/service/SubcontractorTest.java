package com.ccicnavi.bims.subContractor.service;

import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.dao.Impl.SubcontractorDaoImpl;
import com.ccicnavi.bims.customer.pojo.SubcontractorDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: bims-backend
 * @description: 分包方信息测试
 * @author: WangYingLing
 * @create: 2018-11-16 14:21
 */
public class SubcontractorTest {

    SubcontractorDaoImpl subcontractorDaoTest=new SubcontractorDaoImpl();

    @Test
    public void testListSubcontractor() {
        try{
            PageParameter<SubcontractorDO> pageParameter = new PageParameter<>();
            pageParameter.startPage = 1;
            pageParameter.pageRows = 2;
            SubcontractorDO subcontractorDO = new SubcontractorDO();
            pageParameter.setParameter(subcontractorDO);
            subcontractorDaoTest.listSubcontractor(pageParameter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testSaveSubcontractor() {
        for (int i = 1; i <= 10; i++) {
            SubcontractorDO subcontractorDO = new SubcontractorDO();
            subcontractorDO.setSubcontractorUuid("asd" + i);
            subcontractorDO.setProdCatalogUuid("类型" + i);
            subcontractorDO.setOrgUuid("另一个"+i);
            subcontractorDO.setAppSysUuid("DeptUuid"+i);
            subcontractorDO.setCreatedUuid("cud"+i);
            subcontractorDO.setCreatedName("徐"+i);
            int count = subcontractorDaoTest.insertSubcontractor(subcontractorDO);
            System.out.println("count-----" + count);
        }
    }

    @Test
    public void testUpdateSubcontractor() {
        SubcontractorDO subcontractorDO = new SubcontractorDO();
        subcontractorDO.setSubcontractorUuid("asd4");
        subcontractorDO.setCreatedName("徐4被修改了~");
        int count = subcontractorDaoTest.updateSubcontractor(subcontractorDO);
        System.out.println(count);
    }


    @Test
    public void testRemoveSubcontractor() {
//        String uuids = "asd1,asd10,asd2";
//        String[] ids = uuids.split(",");
//        Map<String, Object> data = new HashMap<String, Object>();
//        data.put("ids", ids);
        SubcontractorDO subcontractorDO=new SubcontractorDO();
        subcontractorDO.setSubcontractorUuid("asd4");
        int count = subcontractorDaoTest.removeSubcontractor(subcontractorDO);
        System.out.println(count);
    }

    @Test
    public void testGetSubcontractor() {
        SubcontractorDO subcontractorDO = new SubcontractorDO();
        subcontractorDO.setSubcontractorUuid("asd9");
        SubcontractorDO getSubcontractor = subcontractorDaoTest.getSubcontractor(subcontractorDO);
        System.out.println(getSubcontractor);
    }

}
