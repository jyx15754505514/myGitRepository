package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.product.pojo.MinItemTestDO;
import com.ccicnavi.bims.product.pojo.MinItemTestDTO;
import com.ccicnavi.bims.product.pojo.TestItemDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 最小服务项与检测指标关系接口定义
 * @author: LiJie
 * @create: 2018-11-19 21:25
 */
public interface MinItemTestDao {

    /**新增最小服务项与检测指标关系信息*/
    int saveMinItemTest(MinItemTestDO MinItemTest) throws Exception;

    /**删除最小服务项与检测指标关系信息*/
    int removeMinItemTest(MinItemTestDO MinItemTest) throws Exception;

    /**根据最小服务项ID查询出对应的检测指标关系*/
    List<TestItemDO> findTestItemByMinItemUuid(MinItemTestDTO minItemTestDTO) throws Exception;
}
