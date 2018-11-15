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
     * @throws Exception
     */
    public List<SettingDO> listSetting(SettingDO settingDO)throws Exception;

    /**
     * 新增系统设置
     * @param settingDO
     * @return Integer
     * @throws Exception
     */
    public Integer insertSetting(SettingDO settingDO)throws Exception;

    /**
     * 更改系统设置
     * @param settingDO
     * @return Integer
     * @throws Exception
     */
    public Integer updateSetting(SettingDO settingDO)throws Exception;

    /**
     * 删除系统设置
     * @param settingDO
     * @return Integer
     * @throws Exception
     */
    public Integer deleteSetting(SettingDO settingDO)throws Exception;

    /**
     * 根据主键获取单个系统设置信息
     * @param settingDO
     * @return SettingDO
     * @throws Exception
     */
    public  SettingDO getSetting(SettingDO settingDO)throws Exception;
}
