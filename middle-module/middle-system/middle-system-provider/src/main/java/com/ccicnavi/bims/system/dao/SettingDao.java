package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.system.pojo.SettingDO;

import java.util.List;

public interface SettingDao {
    /**
     * 查询系统设置
     * @param settingDO
     * @return
     * @throws Exception
     */
    public List<SettingDO> listSetting(SettingDO settingDO)throws Exception;

    /**
     * 新增系统设置
     * @param settingDO
     * @return
     * @throws Exception
     */
    public Integer insertSetting(SettingDO settingDO) throws Exception;

    /**
     * 更改系统设置
     * @param settingDO
     * @return
     * @throws Exception
     */
    public Integer updateSetting(SettingDO settingDO)throws Exception;

    /**
     * 删除系统设置
     * @param settingDO
     * @return
     * @throws Exception
     */
    public Integer deleteSetting(SettingDO settingDO) throws Exception;

    /**
     * 根据主键获取单个系统设置信息
     * @param settingDO
     * @return
     * @throws Exception
     */
    public  SettingDO getSetting(SettingDO settingDO) throws Exception;
}
