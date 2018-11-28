package com.ccicnavi.bims.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.dao.TestItemDao;
import com.ccicnavi.bims.product.api.TestItemService;
import com.ccicnavi.bims.product.pojo.TestItemDO;
import com.ccicnavi.bims.product.pojo.TestItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 检测指标ServiceImpl
 * @author: WangYingLing
 * @create: 2018-11-19 18:06
 */
@Service
@Slf4j
public class TestItemServiceImpl implements TestItemService {

    @Autowired
    TestItemDao testItemDao;

    @Override
    public List<TestItemDO> listTestItem(TestItemDTO testItemDTO){
        try {
            return testItemDao.listTestItem(testItemDTO);
        } catch (Exception e) {
            log.error("查询检测指标信息失败",e);
            return null;
        }
    }

    @Override
    public int saveTestItem(TestItemDO testItemDO){
        try {
            return testItemDao.saveTestItem(testItemDO);
        } catch (Exception e) {
            log.error("新增检测指标信息失败",e);
            return 0;
        }
    }

    @Override
    public int removeTestItem(TestItemDO testItemDO){
        try {
            return testItemDao.removeTestItem(testItemDO);
        } catch (Exception e) {
            log.error("删除检测指标信息失败",e);
            return 0;
        }
    }

    @Override
    public int updateTestItem(TestItemDO testItemDO){
        try {
            return testItemDao.updateTestItem(testItemDO);
        } catch (Exception e) {
            log.error("修改检测指标信息失败",e);
            return 0;
        }
    }

    @Override
    public TestItemDO getTestItem(TestItemDO testItemDO){
        try {
            return testItemDao.getTestItem(testItemDO);
        } catch (Exception e) {
            log.error("获取检测指标信息失败",e);
            return null;
        }
    }

    @Override
    public PageBean<TestItemDO> listTestItemPage(PageParameter<TestItemDTO> pageParameter) {
        try {
            return testItemDao.listTestItemPage(pageParameter);
        } catch (Exception e) {
            log.error("分页查询检测指标信息失败",e);
            return null;
        }
    }
}
