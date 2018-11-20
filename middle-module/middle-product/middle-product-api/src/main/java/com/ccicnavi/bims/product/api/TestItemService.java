package com.ccicnavi.bims.product.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.TestItemDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 检测指标信息接口定义
 * @author: WangYingLing
 * @create: 2018-11-15 09:19
 */
public interface TestItemService {

    /**查询全部检测指标信息*/
    List<TestItemDO> listTestItemDo(TestItemDO testItemDO);

    /**新增检测指标信息*/
    int saveTestItemDo(TestItemDO testItemDO);

    /**删除检测指标信息*/
    int removeTestItemDo(TestItemDO testItemDO);

    /**修改检测指标信息*/
    int updateTestItemDo(TestItemDO testItemDO);

    /**根据主键获取检测指标信息*/
    TestItemDO getTestItemDo(TestItemDO testItemDO);

    /**分页查询检测指标信息*/
    PageBean<TestItemDO> listTestItemPage(PageParameter<TestItemDO> pageParameter);

}
