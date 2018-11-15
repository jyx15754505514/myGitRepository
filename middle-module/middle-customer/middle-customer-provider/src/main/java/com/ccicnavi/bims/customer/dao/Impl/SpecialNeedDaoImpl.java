package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.SpecialNeedDao;
import com.ccicnavi.bims.customer.pojo.SpecialNeedDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author WangYingLing
 * @Description 客户特殊需求信息DaoImpl
 * @Date 16:48 2018/11/14
 */

@Service
public class SpecialNeedDaoImpl implements SpecialNeedDao {

    /** *
     * @Author WangYingLing
     * @Description 查询所有客户特殊需求信息
     * @Date 16:48 2018/11/14
     * @Param [specialNeed]
     * @Return java.util.List<com.ccicnavi.bims.customer.pojo.SpecialNeedDO>
     */
    @Override
    public List<SpecialNeedDO> listSpecialNeed(SpecialNeedDO specialNeed) {
        return EqlUtils.getInstance("druid").select("listSpecialNeed").params(specialNeed).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 新增客户特殊需求信息
     * @Date 16:48 2018/11/14
     * @Param [specialNeed]
     * @Return java.lang.Integer
     */
    @Override
    public int saveSpecialNeed(SpecialNeedDO specialNeed) {
        return EqlUtils.getInstance("druid").insert("saveSpecialNeed").params(specialNeed).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 删除客户特殊需求信息
     * @Date 16:48 2018/11/14
     * @Param [data]
     * @Return java.lang.Integer
     */
    @Override
    public int removeSpecialNeed(String needUuid) {
        Map<String, Object> data = new HashMap<>();
        data.put("ids", needUuid.split(","));
        return EqlUtils.getInstance("druid").update("removeSpecialNeed").params(data).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 修改客户特殊需求信息
     * @Date 16:48 2018/11/14
     * @Param [specialNeed]
     * @Return java.lang.Integer
     */
    @Override
    public int updateSpecialNeed(SpecialNeedDO specialNeed) {
        return EqlUtils.getInstance("druid").update("updateSpecialNeed").params(specialNeed).execute();
    }

    /** *
     * @Author WangYingLing
     * @Description 查询客户特殊需求信息（根据主键获取）
     * @Date 16:48 2018/11/14
     * @Param [specialNeed]
     * @Return com.ccicnavi.bims.customer.pojo.SpecialNeedDO
     */
    @Override
    public SpecialNeedDO getSpecialNeed(SpecialNeedDO specialNeed) {
        return EqlUtils.getInstance("druid").select("getSpecialNeed").params(specialNeed).execute();
    }


    /**
     * ————————————Junit测试————————————————————————
     */

    @Test
    public void testListSpecialNeed() {
        List<SpecialNeedDO> specialNeedList = EqlUtils.getInstance("druid").select("listSpecialNeed").returnType(SpecialNeedDO.class).execute();
        System.out.println(specialNeedList);
    }

    @Test
    public void testSaveSpecialNeed() {
        for (int i = 1; i <= 15; i++) {
            SpecialNeedDO specialNeedDO = new SpecialNeedDO();
            specialNeedDO.setNeedUuid("asd" + i);
            specialNeedDO.setCustUuid("asd" + i);
            specialNeedDO.setNeedType("类型" + i);
            specialNeedDO.setNeedContent("另一个"+i);
            specialNeedDO.setDeptUuid("DeptUuid"+i);
            specialNeedDO.setCreatedUuid("cud"+i);
            specialNeedDO.setCreatedName("徐"+i);
            int count = EqlUtils.getInstance("druid").insert("saveSpecialNeed").params(specialNeedDO).execute();
            System.out.println("count-----" + count);
        }
    }

    @Test
    public void testUpdateSpecialNeed() {
        SpecialNeedDO specialNeedDO = new SpecialNeedDO();
        specialNeedDO.setNeedUuid("asd4");
        specialNeedDO.setCreatedName("徐4被修改了~");
        int count = EqlUtils.getInstance("druid").update("updateSpecialNeed").params(specialNeedDO).execute();
    }


    @Test
    public void testRemoveSpecialNeed() {
        String uuids = "asd1,asd10,asd2";
        String[] ids = uuids.split(",");
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("ids", ids);
        int count = EqlUtils.getInstance("druid").update("removeSpecialNeed").params(data).execute();
        System.out.println(count);
    }

    @Test
    public void testGetSpecialNeed() {
        SpecialNeedDO specialNeedDO = new SpecialNeedDO();
        specialNeedDO.setNeedUuid("asd9");
        SpecialNeedDO getCustAddr = EqlUtils.getInstance("druid").selectFirst("getSpecialNeed").params(specialNeedDO).returnType(SpecialNeedDO.class).execute();
        System.out.println(getCustAddr);
    }

}
