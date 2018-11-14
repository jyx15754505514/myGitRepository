package com.ccicnavi.bims.system.dao.impl;


import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.SettingDao;
import com.ccicnavi.bims.system.pojo.SettingDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SettingDaoImpl implements SettingDao {
    @Override
    public List<SettingDO> listSetting(SettingDO settingDO)  {
        List<SettingDO> row = null;
        try{
            row = EqlUtils.getInstance("DEFAULT").select("listSet").params(settingDO).returnType(SettingDO.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer insertSetting(SettingDO settingDO)  {
        Integer integer = null;
        try{
            integer = EqlUtils.getInstance("DEFAULT").insert("insertSet").params(settingDO).returnType(Integer.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public Integer updateSetting(SettingDO settingDO)  {
        Integer integer = null;
        try{
            integer = EqlUtils.getInstance("DEFAULT").update("updateSet").params(settingDO).returnType(Integer.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public Integer deleteSetting(SettingDO settingDO)  {
        Integer integer = null;
        try{
            integer = EqlUtils.getInstance("DEFAULT").delete("deleteSet").params(settingDO).returnType(Integer.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public SettingDO getSetting(SettingDO settingDO)  {
        SettingDO settingDO1 = null;
        try{
            settingDO1 = EqlUtils.getInstance("DEFAULT").selectFirst("getSet").params(settingDO).returnType(SettingDO.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return settingDO1;
    }
}
