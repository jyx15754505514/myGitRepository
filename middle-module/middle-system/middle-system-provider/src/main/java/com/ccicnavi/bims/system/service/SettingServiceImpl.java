package com.ccicnavi.bims.system.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.service.api.SettingService;
import com.ccicnavi.bims.system.dao.SettingDao;
import com.ccicnavi.bims.system.pojo.SettingDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SettingServiceImpl implements SettingService{
    @Autowired
    private SettingDao settingDao;

    /**
     * 查询系统设置信息
     * @param settingDO
     * @return
     */
    @Override
    public List<SettingDO> listSetting(SettingDO settingDO){
        return settingDao.listSetting(settingDO);
    }

    /**
     * 新增系统设置信息
     * @param settingDO
     * @return
     */
    @Override
    public Integer insertSetting(SettingDO settingDO){
        return settingDao.insertSetting(settingDO);
    }

    /**
     * 更新系统设置信息
     * @param settingDO
     * @return
     */
    @Override
    public Integer updateSetting(SettingDO settingDO){
        return settingDao.updateSetting(settingDO);
    }

    /**
     * 删除系统设置信息
     * @param settingDO
     * @return
     */
    @Override
    public Integer deleteSetting(SettingDO settingDO){
        return settingDao.deleteSetting(settingDO);
    }

    /**
     * 根据主键获取系统设置信息
     * @param settingDO
     * @return
     */
    @Override
    public SettingDO getSetting(SettingDO settingDO){
        return settingDao.getSetting(settingDO);
    }
}
