package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.RemindDao;
import com.ccicnavi.bims.system.dao.impl.RemindDaoImpl;
import com.ccicnavi.bims.system.pojo.SysRemindDO;
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
    public List<SysRemindDO> listSysremind(SysRemindDO sysremind) throws Exception {
        try {
            return sysRemindDao.listSysremind(sysremind);
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public Integer insertSysremind(SysRemindDO sysremind) throws Exception {
        try {
            return sysRemindDao.insertSysremind(sysremind);
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public Integer updateSysremind(SysRemindDO sysremind) throws Exception {
        try {
            return sysRemindDao.updateSysremind(sysremind);
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public Integer deleteSysremind(SysRemindDO sysremind) throws Exception {
        try {
            return sysRemindDao.deleteSysremind(sysremind);
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }

    @Override
    public SysRemindDO getSysremind(SysRemindDO sysremind) throws Exception {
        try {
            return sysRemindDao.getSysremind(sysremind);
        }catch (Exception e) {
            log.error("", e);
            return null;
        }
    }
}
