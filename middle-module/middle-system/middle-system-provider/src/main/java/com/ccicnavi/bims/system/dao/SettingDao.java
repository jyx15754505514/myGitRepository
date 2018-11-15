package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.system.pojo.SettingDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 系统设置dao接口
 * @author: zhangxingbiao
 * @create: 2018-11-14 23:33
 **/
public interface SettingDao {

    /**
    *@Description: 查询系统设置信息
    *@Param: [settingDO]
    *@return: List<SettingDO>
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    public List<SettingDO> listSetting(SettingDO settingDO)throws Exception;

    /**
    *@Description: 新增系统设置
    *@Param: [settingDO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    public Integer insertSetting(SettingDO settingDO)throws Exception;

    /**
    *@Description: 更新系统设置信息
    *@Param: [settingDO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    public Integer updateSetting(SettingDO settingDO)throws Exception;

    /**
    *@Description: 删除系统设置信息
    *@Param: [settingDO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    public Integer deleteSetting(SettingDO settingDO)throws Exception;

    /**
    *@Description: 根据主键获取单个系统设置信息
    *@Param: [settingDO]
    *@return: SettingDO
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    public  SettingDO getSetting(SettingDO settingDO)throws Exception;
}
