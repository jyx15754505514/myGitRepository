package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.SettingDO;
import com.ccicnavi.bims.system.pojo.UserDTO;

/**
 *@program: bims-backend
 *@description: 系统设置的api接口
 *@author: zhangxingbiao
 *@create: 2018-11-15 14:45
 */
public interface SettingService {
    /**
     * 查询系统设置
     * @param pageParameter
     * @return List<SettingDO>
     */
    public PageBean<SettingDO> listSetting(PageParameter<SettingDO> pageParameter);

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
     * @param userDTO
     * @return SettingDO
     */
    public  SettingDO getSetting(UserDTO userDTO);
}
