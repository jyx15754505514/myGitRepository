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
    /**
     * @Author FanDongSheng
     * @Description //TODO 新增分包方信息
     * @Date 17:25 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void insertSubcontractor() {
        for (int i = 1; i <= 300; i++) {
            SubcontractorDO subcontractorDO = new SubcontractorDO();
            subcontractorDO.setSubcontractorUuid("8888" + i);
            subcontractorDO.setSubcCode("分包方代码" + i);
            subcontractorDO.setLegalRep("法人" + i);
            subcontractorDO.setRegCapital("注册资本"+i);
            subcontractorDO.setName("分包方名称"+i);
            subcontractorDO.setEnName("分包方英文名称"+i);
            subcontractorDO.setAppSysUuid("BIMS");
            subcontractorDO.setOrgUuid("CCIC");
            subcontractorDO.setCreatedUuid("fands");
            subcontractorDO.setCreatedName("樊东升");
            int count = subcontractorDaoTest.insertSubcontractor(subcontractorDO);
            System.out.println("count-----" + count);
        }
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 分页查询分包方信息
     * @Date 17:26 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void listSubcontractor() {
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

   
    /**
     * @Author FanDongSheng
     * @Description //TODO 修改分包方信息
     * @Date 17:42 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void testUpdateSubcontractor() {
        SubcontractorDO subcontractorDO = new SubcontractorDO();
        subcontractorDO.setSubcontractorUuid("0000001");
        subcontractorDO.setName("分包方名称修改啦~");
        int count = subcontractorDaoTest.updateSubcontractor(subcontractorDO);
        System.out.println(count);
    }

    /**
     * @Author FanDongSheng
     * @Description //TODO 删除分包方信息
     * @Date 17:42 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void testRemoveSubcontractor() {
//        String uuids = "asd1,asd10,asd2";
//        String[] ids = uuids.split(",");
//        Map<String, Object> data = new HashMap<String, Object>();
//        data.put("ids", ids);
        SubcontractorDO subcontractorDO=new SubcontractorDO();
        subcontractorDO.setSubcontractorUuid("0000001");
        int count = subcontractorDaoTest.removeSubcontractor(subcontractorDO);
        System.out.println(count);
    }
    /**
     * @Author FanDongSheng
     * @Description //TODO 查询一条分包方信息
     * @Date 17:45 2018/11/23
     * @Param []
     * @Return void
     */
    @Test
    public void testGetSubcontractor() {
        SubcontractorDO subcontractorDO = new SubcontractorDO();
        subcontractorDO.setSubcontractorUuid("00000010");
        SubcontractorDO getSubcontractor = subcontractorDaoTest.getSubcontractor(subcontractorDO);
        System.out.println(getSubcontractor);
    }

}
