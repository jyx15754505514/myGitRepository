package com.ccicnavi.bims.product.api;

import com.ccicnavi.bims.product.pojo.TestItemDO;

import java.util.List;

public interface TestItemService {

    List<TestItemDO> listTestItemDo(TestItemDO testItemDO) throws Exception;

    int saveTestItemDo(TestItemDO testItemDO) throws Exception;

    int removeTestItemDo(TestItemDO testItemDO) throws Exception;

    int updateTestItemDo(TestItemDO testItemDO) throws Exception;

    TestItemDO getTestItemDo(TestItemDO testItemDO) throws Exception;

}
