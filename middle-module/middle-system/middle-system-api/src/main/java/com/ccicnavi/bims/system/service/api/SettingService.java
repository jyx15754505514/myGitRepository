package com.ccicnavi.bims.system.service.api;

import java.util.List;
import com.ccicnavi.bims.system.pojo.SettingDO;

/**
 *@program: bims-backend
 *@description: 系统设置的api接口
 *@author: zhangxingbiao
 *@create: 2018-11-15 14:45
 */
public interface SettingService {
    /**
     * 查询系统设置
     * @param settingDO
     * @return List<SettingDO>
     */
    public List<SettingDO> listSetting(SettingDO settingDO);

    /**
     * 新增系统设置
     * @param settingDO
     * @return Integer
     */
    public Integer insertSetting(SettingDO settingDO);

    /**
     * 更改系统设置
     * @param settingDO
     * @return Integer
     */
    public Integer updateSetting(SettingDO settingDO);

    /**
     * 删除系统设置
     * @param settingDO
     * @return Integer
     */
    public Integer deleteSetting(SettingDO settingDO);

    /**
     * 根据主键获取单个系统设置信息
     * @param settingDO
     * @return SettingDO
     */
    public  SettingDO getSetting(SettingDO settingDO);
}
