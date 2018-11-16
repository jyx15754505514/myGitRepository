package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.SubcontractorDao;
import com.ccicnavi.bims.customer.pojo.SubcontractorDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author WangYingLing
 * @Description 分包方信息DaoImpl
 * @Date 16:48 2018/11/14
 */

@Service
public class SubcontractorDaoImpl implements SubcontractorDao {

    /** *
     * @Author WangYingLing
     * @Description 查询所有分包方信息
     * @Date 16:48 2018/11/14
     * @Param [subcontractor]
     * @Return java.util.List<com.ccicnavi.bims.customer.pojo.SubcontractorDO>
     */
    @Override
    public List<SubcontractorDO> listSubcontractor(SubcontractorDO subcontractor) {
        return EqlUtils.getInstance("druid").select("listSubcontractor").params(subcontractor).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 新增分包方信息
     * @Date 16:48 2018/11/14
     * @Param [subcontractor]
     * @Return java.lang.Integer
     */
    @Override
    public int saveSubcontractor(SubcontractorDO subcontractor) {
        return EqlUtils.getInstance("druid").insert("saveSubcontractor").params(subcontractor).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 删除分包方信息
     * @Date 16:48 2018/11/14
     * @Param [data]
     * @Return java.lang.Integer
     */
    @Override
    public int removeSubcontractor(String subcontractorUuid) {
        Map<String,Object> data=new HashMap<>();
        data.put("ids",subcontractorUuid.split(","));
        return EqlUtils.getInstance("druid").update("removeSubcontractor").params(data).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 修改分包方信息
     * @Date 16:48 2018/11/14
     * @Param [subcontractor]
     * @Return java.lang.Integer
     */
    @Override
    public int updateSubcontractor(SubcontractorDO subcontractor) {
        return EqlUtils.getInstance("druid").update("updateSubcontractor").params(subcontractor).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 查询分包方信息（根据主键获取）
     * @Date 16:48 2018/11/14
     * @Param [subcontractor]
     * @Return com.ccicnavi.bims.customer.pojo.SubcontractorDO
     */
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

    

