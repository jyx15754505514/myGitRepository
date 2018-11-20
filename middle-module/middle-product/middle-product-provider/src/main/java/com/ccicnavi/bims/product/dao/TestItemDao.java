package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.TestItemDO;

import java.util.List;

public interface TestItemDao {

    List<TestItemDO> listTestItemDO() throws Exception;

    int saveTestItemDO(TestItemDO testItemDO) throws Exception;

    int removeTestItemDO(TestItemDO testItemDO) throws Exception;

    int updateTestItemDO(TestItemDO testItemDO) throws Exception;

    TestItemDO getTestItemDO(TestItemDO testItemDO) throws Exception;

    PageBean<TestItemDO> listTestItemPage(PageParameter<TestItemDO> pageParameter);

}
