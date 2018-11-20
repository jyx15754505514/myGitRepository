package com.ccicnavi.bims.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.dao.TestItemDao;
import com.ccicnavi.bims.product.api.TestItemService;
import com.ccicnavi.bims.product.pojo.TestItemDO;
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
    public List<TestItemDO> listTestItemDo(TestItemDO testItemDO){
        try {
            return testItemDao.listTestItemDO();
        } catch (Exception e) {
            log.error("查询检测指标信息失败",e);
            return null;
        }
    }

    @Override
    public int saveTestItemDo(TestItemDO testItemDO){
        try {
            return testItemDao.saveTestItemDO(testItemDO);
        } catch (Exception e) {
            log.error("新增检测指标信息失败",e);
            return 0;
        }
    }

    @Override
    public int removeTestItemDo(TestItemDO testItemDO){
        try {
            return testItemDao.removeTestItemDO(testItemDO);
        } catch (Exception e) {
            log.error("删除检测指标信息失败",e);
            return 0;
        }
    }

    @Override
    public int updateTestItemDo(TestItemDO testItemDO){
        try {
            return testItemDao.updateTestItemDO(testItemDO);
        } catch (Exception e) {
            log.error("修改检测指标信息失败",e);
            return 0;
        }
    }

    @Override
    public TestItemDO getTestItemDo(TestItemDO testItemDO){
        try {
            return testItemDao.getTestItemDO(testItemDO);
        } catch (Exception e) {
            log.error("获取检测指标信息失败",e);
            return null;
        }
    }

    @Override
    public PageBean<TestItemDO> listTestItemPage(PageParameter<TestItemDO> pageParameter) {
        try {
            return testItemDao.listTestItemPage(pageParameter);
        } catch (Exception e) {
            log.error("分页查询检测指标信息失败",e);
            return null;
        }
    }
}
