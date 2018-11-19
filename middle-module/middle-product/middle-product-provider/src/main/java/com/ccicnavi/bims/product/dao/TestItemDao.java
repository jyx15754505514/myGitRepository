package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.product.pojo.TestItemDO;

import java.util.List;

public interface TestItemDao {

    List<TestItemDO> listTestItemDO() throws Exception;

    int saveTestItemDO(TestItemDO testItemDO) throws Exception;

    int removeTestItemDO(TestItemDO testItemDO) throws Exception;

    int updateTestItemDO(TestItemDO testItemDO) throws Exception;

    TestItemDO getTestItemDO(TestItemDO testItemDO) throws Exception;

}
