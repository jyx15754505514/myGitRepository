package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.service.api.SettingService;
import com.ccicnavi.bims.system.dao.SettingDao;
import com.ccicnavi.bims.system.pojo.SettingDO;

import java.util.List;

@Service
public class SettingServiceImpl implements SettingService {
    @Reference
    SettingDao settingDao;
    @Override
    public List<SettingDO> listSetting(SettingDO settingDO) throws Exception {
        return settingDao.listSetting(settingDO);
    }

    @Override
    public Integer insertSetting(SettingDO settingDO) throws Exception {
        return settingDao.insertSetting(settingDO);
    }

    @Override
    public Integer updateSetting(SettingDO settingDO) throws Exception {
        return settingDao.updateSetting(settingDO);
    }

    @Override
    public Integer deleteSetting(SettingDO settingDO) throws Exception {
        return settingDao.deleteSetting(settingDO);
    }

    @Override
    public SettingDO getSetting(SettingDO settingDO) throws Exception {
        return settingDao.getSetting(settingDO);
    }
}
