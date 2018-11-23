package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.TestItemDO;

import java.util.List;

public interface TestItemDao {

    List<TestItemDO> listTestItem() throws Exception;

    int saveTestItem(TestItemDO testItemDO) throws Exception;

    int removeTestItem(TestItemDO testItemDO) throws Exception;

    int updateTestItem(TestItemDO testItemDO) throws Exception;

    TestItemDO getTestItem(TestItemDO testItemDO) throws Exception;

    PageBean<TestItemDO> listTestItemPage(PageParameter<TestItemDO> pageParameter);

}
