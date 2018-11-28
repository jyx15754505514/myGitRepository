package com.ccicnavi.bims.product.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.TestItemDO;
import com.ccicnavi.bims.product.pojo.TestItemDTO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 检测指标信息接口定义
 * @author: WangYingLing
 * @create: 2018-11-15 09:19
 */
public interface TestItemService {

    /**
     * @description 查询全部检测指标信息
     * @param testItemDTO
     * @return List<TestItemDO>
     */
    List<TestItemDO> listTestItem(TestItemDTO testItemDTO);

    /**
     * @description 新增检测指标信息
     * @param testItemDO
     * @return int
     */
    int saveTestItem(TestItemDO testItemDO);

    /**
     * @description 删除检测指标信息
     * @param testItemDO
     * @return int
     */
    int removeTestItem(TestItemDO testItemDO);

    /**
     * @description 修改检测指标信息
     * @param testItemDO
     * @return int
     */
    int updateTestItem(TestItemDO testItemDO);

    /**
     * @description 根据主键获取检测指标信息
     * @param testItemDO
     * @return TestItemDO
     */
    TestItemDO getTestItem(TestItemDO testItemDO);

    /**
     * @description 分页查询检测指标信息
     * @param pageParameter
     * @return PageBean<TestItemDO>
     */
    PageBean<TestItemDO> listTestItemPage(PageParameter<TestItemDTO> pageParameter);

}
