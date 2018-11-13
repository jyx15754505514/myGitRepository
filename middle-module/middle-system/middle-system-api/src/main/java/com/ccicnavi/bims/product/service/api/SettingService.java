package com.ccicnavi.bims.product.service.api;

import java.util.List;
import com.ccicnavi.bims.product.service.api.*;
import com.ccicnavi.bims.system.pojo.SettingDO;


public interface SettingService {
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
