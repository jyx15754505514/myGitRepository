package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.RemindDao;
import com.ccicnavi.bims.system.dao.impl.RemindDaoImpl;
import com.ccicnavi.bims.system.pojo.RemindDO;
import com.ccicnavi.bims.system.service.api.RemindService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 提醒设置api实现
 * @author: zqq
 * @create: 2018-11-15 11:06
 */
@Service
public class RemindServiceImpl implements RemindService {

    private final static Logger log = LoggerFactory.getLogger(RemindDaoImpl.class);

    @Autowired
    private RemindDao sysRemindDao;
    @Override
    public List<RemindDO> listRemind(RemindDO remind) throws Exception {
        try {
            return sysRemindDao.listRemind(remind);
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public Integer insertRemind(RemindDO remind) throws Exception {
        try {
            return sysRemindDao.insertRemind(remind);
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public Integer updateRemind(RemindDO remind) throws Exception {
        try {
            return sysRemindDao.updateRemind(remind);
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public Integer deleteRemind(RemindDO remind) throws Exception {
        try {
             return sysRemindDao.deleteRemind(remind);
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public RemindDO getRemind(RemindDO remind) throws Exception {
        try {
            return sysRemindDao.getRemind(remind);
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }
}
