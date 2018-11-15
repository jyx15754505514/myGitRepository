package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.system.pojo.SettingDO;

import java.util.List;

public interface SettingDao {
    /**
     * 查询系统设置
     * @param settingDO
     * @return
     */
    public List<SettingDO> listSetting(SettingDO settingDO);

    /**
     * 新增系统设置
     * @param settingDO
     * @return
     */
    public Integer insertSetting(SettingDO settingDO);

    /**
     * 更改系统设置
     * @param settingDO
     * @return
     */
    public Integer updateSetting(SettingDO settingDO);

    /**
     * 删除系统设置
     * @param settingDO
     * @return
     */
    public Integer deleteSetting(SettingDO settingDO);

    /**
     * 根据主键获取单个系统设置信息
     * @param settingDO
     * @return
     */
    public  SettingDO getSetting(SettingDO settingDO);
}
