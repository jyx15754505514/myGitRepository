package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.NotworkdayDao;
import com.ccicnavi.bims.system.pojo.NotworkdayDO;
import com.ccicnavi.bims.system.service.api.NotworkdayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 非工作日api实现类
 * @author: zhaotao
 * @create: 2018-11-14 23:33
 **/
@Service
@Slf4j
public class NotworkdayServiceImpl implements NotworkdayService {

    @Autowired
    private NotworkdayDao notworkdayDao;

    @Override
    public List<NotworkdayDO> listNotworkday(NotworkdayDO notworkday) {
        try {
            return notworkdayDao.listNotworkday(notworkday);
        } catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public Integer insertNotworkday(NotworkdayDO notworkday) {
        try {
            return notworkdayDao.insertNotworkday(notworkday);
        } catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public Integer updateNotworkday(NotworkdayDO notworkday) {
        try {
            return notworkdayDao.updateNotworkday(notworkday);
        } catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public Integer deleteNotworkday(NotworkdayDO notworkday) {
        try {
            return notworkdayDao.deleteNotworkday(notworkday);
        } catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public NotworkdayDO getNotworkday(NotworkdayDO notworkday) {
        try {
            return notworkdayDao.getNotworkday(notworkday);
        } catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

}
