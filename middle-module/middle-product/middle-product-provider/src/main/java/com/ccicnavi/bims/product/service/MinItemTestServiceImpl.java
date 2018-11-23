package com.ccicnavi.bims.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.product.api.MinItemTestService;
import com.ccicnavi.bims.product.dao.MinItemTestDao;
import com.ccicnavi.bims.product.pojo.MinItemTestDO;
import com.ccicnavi.bims.product.pojo.TestItemDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 最小服务项与检测指标关系接口实现
 * @author: LiJie
 * @create: 2018-11-22 15:20
 */
@Service
@Slf4j
public class MinItemTestServiceImpl implements MinItemTestService {

    @Autowired
    MinItemTestDao minItemTestDao;

    @Override
    public int saveMinItemTest(MinItemTestDO minItemTestDO) {
        try {
            return minItemTestDao.saveMinItemTest(minItemTestDO);
        } catch (Exception e) {
            log.error("新增最小服务项与检测指标关系失败~",e);
            return 0;
        }
    }

    @Override
    public int removeMinItemTest(MinItemTestDO minItemTestDO) {
        try {
            return minItemTestDao.removeMinItemTest(minItemTestDO);
        } catch (Exception e) {
            log.error("删除最小服务项与检测指标关系失败~",e);
            return 0;
        }
    }

    /**
     * 根据最小服务项ID查询出对应的检测指标信息
     * @param minItemTestDO
     * @return
     */
    @Override
    public List<TestItemDO> findTestItemByMinItemUuid(MinItemTestDO minItemTestDO) {
        try {
            return minItemTestDao.findTestItemByMinItemUuid(minItemTestDO);
        } catch (Exception e) {
            log.error("根据最小服务项ID查询出对应的检测指标信息失败~",e);
            return null;
        }
    }
}
