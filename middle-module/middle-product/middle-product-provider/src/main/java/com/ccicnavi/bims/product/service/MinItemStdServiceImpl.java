package com.ccicnavi.bims.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.product.api.MinItemStdService;
import com.ccicnavi.bims.product.dao.MinItemStdDao;
import com.ccicnavi.bims.product.pojo.MinItemStdDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: bims-backend
 * @description: 最小服务项与标准接口实现
 * @author: LiJie
 * @create: 2018-11-22 14:45
 */
@Service
@Slf4j
public class MinItemStdServiceImpl implements MinItemStdService {

    @Autowired
    MinItemStdDao minItemStdDao;

    @Override
    public int saveMinItemStd(MinItemStdDO minItemStd) {
        try {
            return minItemStdDao.saveMinItemStd(minItemStd);
        } catch (Exception e) {
            log.error("新增最小服务项与标准关系失败~",e);
            return 0;
        }
    }

    @Override
    public int removeMinItemStd(MinItemStdDO minItemStd) {
        try {
            return minItemStdDao.removeMinItemStd(minItemStd);
        } catch (Exception e) {
            log.error("删除最小服务项与标准关系失败~",e);
            return 0;
        }
    }


}
