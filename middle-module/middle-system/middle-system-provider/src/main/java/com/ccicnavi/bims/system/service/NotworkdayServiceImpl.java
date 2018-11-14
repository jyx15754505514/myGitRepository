package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.NotworkdayDao;
import com.ccicnavi.bims.system.dao.impl.NotworkdayDaoImpl;
import com.ccicnavi.bims.system.pojo.NotworkdayDO;
import com.ccicnavi.bims.system.service.api.NotworkdayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class NotworkdayServiceImpl implements NotworkdayService {

    private final static Logger log = LoggerFactory.getLogger(NotworkdayDaoImpl.class);

    @Autowired
    private NotworkdayDao notworkdayDao;

    @Override
    public List<NotworkdayDO> listNotworkday(NotworkdayDO notworkday) throws Exception {
        try{
            return notworkdayDao.listNotworkday(notworkday);
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public Integer insertNotworkday(NotworkdayDO notworkday) throws Exception {
        try{
            return notworkdayDao.insertNotworkday(notworkday);
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public Integer updateNotworkday(NotworkdayDO notworkday) throws Exception {
        try{
            return notworkdayDao.updateNotworkday(notworkday);
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public Integer deleteNotworkday(NotworkdayDO notworkday) throws Exception {
        try{
            return notworkdayDao.deleteNotworkday(notworkday);
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public NotworkdayDO getNotworkday(NotworkdayDO notworkday) throws Exception {
        try{
            return notworkdayDao.getNotworkday(notworkday);
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }
}
