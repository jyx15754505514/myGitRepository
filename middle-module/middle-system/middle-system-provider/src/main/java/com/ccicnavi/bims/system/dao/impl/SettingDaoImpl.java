package com.ccicnavi.bims.system.dao.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.SettingDao;
import com.ccicnavi.bims.system.pojo.DepartmentDO;
import com.ccicnavi.bims.system.pojo.SettingDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;

import java.util.List;

@Service
@Slf4j
public class SettingDaoImpl implements SettingDao {
    @Override
    public List<SettingDO> listSetting(SettingDO settingDO) throws Exception {
        List<SettingDO> row = null;
        try{
            row = new Eql().select("listSet").params(settingDO).returnType(SettingDO.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer insertSetting(SettingDO settingDO) throws Exception {
        Integer integer = null;
        try{
            integer = new Eql().insert("insertSet").params(settingDO).returnType(Integer.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public Integer updateSetting(SettingDO settingDO) throws Exception {
        Integer integer = null;
        try{
            integer = new Eql().update("updateSet").params(settingDO).returnType(Integer.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public Integer deleteSetting(SettingDO settingDO) throws Exception {
        Integer integer = null;
        try{
            integer = new Eql().delete("deleteSet").params(settingDO).returnType(Integer.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public SettingDO getSetting(SettingDO settingDO) throws Exception {
        SettingDO settingDO1 = null;
        try{
            settingDO1 = new Eql().selectFirst("getSet").params(settingDO).returnType(SettingDO.class).execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return settingDO1;
    }
}
