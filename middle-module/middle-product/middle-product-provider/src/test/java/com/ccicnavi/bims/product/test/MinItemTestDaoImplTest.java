package com.ccicnavi.bims.product.test;

import com.ccicnavi.bims.product.dao.Impl.MinItemTestDaoImpl;
import com.ccicnavi.bims.product.pojo.MinItemTestDO;
import com.ccicnavi.bims.product.pojo.TestItemDO;
import org.junit.jupiter.api.Test;

import java.util.List;

class MinItemTestDaoImplTest {

    @Test
    void saveMinItemTest() {
    }

    @Test
    void removeMinItemTest() {
    }

    /**
     * 根据最小服务项ID和所属机构ID查询出对应的检测指标信息
     */
    @Test
    void findTestItemByMinItemUuid() {
        MinItemTestDaoImpl minItemTestDaoImpl=new MinItemTestDaoImpl();
        MinItemTestDO minItemTestDO =new MinItemTestDO();
        minItemTestDO.setMinItemUuid("KC_MT_JM_JC");
        minItemTestDO.setOrgUuid("HD601");
        minItemTestDO.setAppSysUuid("BIMS2.0");
        List<TestItemDO> testItemByMinItemUuid = minItemTestDaoImpl.findTestItemByMinItemUuid(minItemTestDO);
        System.out.println(testItemByMinItemUuid);
    }


}