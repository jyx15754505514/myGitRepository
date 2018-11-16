package com.ccicnavi.bims.system.dao.impl;


import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.SettingDao;
import com.ccicnavi.bims.system.pojo.SettingDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 系统设置dao实现类
 * @author: zhangxingbiao
 * @create: 2018-11-14 23:33
 **/

@Service
@Slf4j
public class SettingDaoImpl implements SettingDao {

    /**
    *@Description: 查询系统设置信息
    *@Param: [settingDO]
    *@return: List<SettingDO>
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public List<SettingDO> listSetting(SettingDO settingDO)throws Exception{
        return EqlUtils.getInstance("DEFAULT").select("listSet").params(settingDO).returnType(SettingDO.class).execute();
    }

    /**
    *@Description: 新增系统设置信息
    *@Param: [settingDO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public Integer insertSetting(SettingDO settingDO) throws Exception{
        return EqlUtils.getInstance("DEFAULT").insert("insertSet").params(settingDO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 更新系统设置信息
    *@Param: [settingDO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public Integer updateSetting(SettingDO settingDO)throws Exception{
        return  EqlUtils.getInstance("DEFAULT").update("updateSet").params(settingDO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 删除系统设置信息
    *@Param: [settingDO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public Integer deleteSetting(SettingDO settingDO)throws Exception{
        return  EqlUtils.getInstance("DEFAULT").delete("deleteSet").params(settingDO).returnType(Integer.class).execute();

    }


    /**
    *@Description: 根据主键获取系统设置
    *@Param: [settingDO]
    *@return: SettingDO
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public SettingDO getSetting(SettingDO settingDO)throws Exception{
       return EqlUtils.getInstance("DEFAULT").selectFirst("getSet").params(settingDO).returnType(SettingDO.class).execute();
    }
}
