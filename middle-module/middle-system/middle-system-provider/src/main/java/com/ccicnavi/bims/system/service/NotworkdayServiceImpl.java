package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.NotworkdayDao;
import com.ccicnavi.bims.system.pojo.NotworkdayDO;
import com.ccicnavi.bims.system.service.api.NotworkdayService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class NotworkdayServiceImpl implements NotworkdayService {

    @Autowired
    private NotworkdayDao notworkdayDao;

    @Override
    public List<NotworkdayDO> listNotworkday(NotworkdayDO notworkday) throws Exception {
        return notworkdayDao.listNotworkday(notworkday);
    }

    @Override
    public Integer insertNotworkday(NotworkdayDO notworkday) throws Exception {
        return notworkdayDao.insertNotworkday(notworkday);
    }

    @Override
    public Integer updateNotworkday(NotworkdayDO notworkday) throws Exception {
        return notworkdayDao.updateNotworkday(notworkday);
    }

    @Override
    public Integer deleteNotworkday(NotworkdayDO notworkday) throws Exception {
        return notworkdayDao.deleteNotworkday(notworkday);
    }

    @Override
    public NotworkdayDO getNotworkday(NotworkdayDO notworkday) throws Exception {
        return notworkdayDao.getNotworkday(notworkday);
    }
}
