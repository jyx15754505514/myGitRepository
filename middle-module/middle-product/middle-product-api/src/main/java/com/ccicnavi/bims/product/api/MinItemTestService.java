package com.ccicnavi.bims.product.api;

import com.ccicnavi.bims.product.pojo.MinItemTestDO;
import com.ccicnavi.bims.product.pojo.TestItemDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 最小服务项与检测指标定义
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
public interface MinItemTestService {

    /**
     * 新增最小服务项与检测指标关系信息
     */
    int saveMinItemTest(MinItemTestDO minItemTestDO);

    /**
     * 删除最小服务项与检测指标关系信息
     */
    int removeMinItemTest(MinItemTestDO minItemTestDO);

    /**
     * 根据最小服务项ID查询出对应检测指标
     * @param minItemTestDO
     */
     List<TestItemDO> findTestItemByMinItemUuid(MinItemTestDO minItemTestDO);
}
