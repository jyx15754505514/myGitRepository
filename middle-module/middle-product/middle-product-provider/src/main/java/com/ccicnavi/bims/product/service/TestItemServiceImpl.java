package com.ccicnavi.bims.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.product.dao.TestItemDao;
import com.ccicnavi.bims.product.api.TestItemService;
import com.ccicnavi.bims.product.pojo.TestItemDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: 本人姓名
 * @create: 2018-11-19 18:06
 */
@Service
@Slf4j
public class TestItemServiceImpl implements TestItemService {

    @Autowired
    TestItemDao testItemDao;

    @Override
    public List<TestItemDO> listTestItemDo(TestItemDO testItemDO){
        List<TestItemDO> testItemDOS=null;
        try {
            testItemDOS=testItemDao.listTestItemDO();
        } catch (Exception e) {
            log.error("查询检测指标信息失败",e);
            e.printStackTrace();
        }
        return testItemDOS;
    }

    @Override
    public int saveTestItemDo(TestItemDO testItemDO){
        Integer count=0;
        try {
            count=testItemDao.saveTestItemDO(testItemDO);
        } catch (Exception e) {
            log.error("新增检测指标信息失败",e);
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int removeTestItemDo(TestItemDO testItemDO){
        Integer count=0;
        try {
            count=testItemDao.removeTestItemDO(testItemDO);
        } catch (Exception e) {
            log.error("删除检测指标信息失败",e);
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int updateTestItemDo(TestItemDO testItemDO){
        Integer count=0;
        try {
            count=testItemDao.updateTestItemDO(testItemDO);
        } catch (Exception e) {
            log.error("修改检测指标信息失败",e);
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public TestItemDO getTestItemDo(TestItemDO testItemDO){
        TestItemDO testItemDOResult=null;
        try {
            testItemDOResult=testItemDao.getTestItemDO(testItemDO);
        } catch (Exception e) {
            log.error("获取检测指标信息失败",e);
            e.printStackTrace();
        }
        return testItemDOResult;
    }
}
