package com.ccicnavi.bims.system.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.impl.SettingDaoImpl;
import com.ccicnavi.bims.system.pojo.UserDTO;
import com.ccicnavi.bims.system.service.api.SettingService;
import com.ccicnavi.bims.system.dao.SettingDao;
import com.ccicnavi.bims.system.pojo.SettingDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *@program: bims-backend
 *@description: 系统设置api实现类
 *@author: zhangxingbiao
 *@create: 2018-11-15 14:45
 */
@Service
public class SettingServiceImpl implements SettingService{

    private final static Logger log = LoggerFactory.getLogger(SettingDaoImpl.class);

    @Autowired
    private SettingDao settingDao;

    /**
    *@Description: 查询系统设置信息
    *@Param: [settingDO]
    *@return: List<SettingDO>
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */

    @Override
    public PageBean<SettingDO> listSetting(PageParameter<SettingDO> pageParameter){
        try{
            PageBean<SettingDO> pageBean = settingDao.listSetting(pageParameter);
            return pageBean;
        }catch (Exception e){
            log.error("查询系统设置信息失败", e);
        }
        return null;
    }



    /**
    *@Description: 新增系统设置信息
    *@Param: [settingDO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public Integer insertSetting(SettingDO settingDO){
        try {
            return settingDao.insertSetting(settingDO);
        }catch (Exception e){
            log.error("新增系统设置信息失败",e);
            return null;
        }
    }

    /**
    *@Description: 更新系统设置信息
    *@Param: settingDO
    *@return: SettingDO
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public Integer updateSetting(SettingDO settingDO){
        try {
            return settingDao.updateSetting(settingDO);
        } catch (Exception e) {
            log.error("更新系统设置信息失败",e);
            return null;

        }
    }

    /**
    *@Description: 删除系统设置信息
    *@Param: settingDO
    *@return: SettingDO
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public Integer deleteSetting(SettingDO settingDO){
        try {
            return settingDao.deleteSetting(settingDO);
        } catch (Exception e) {
            log.error("删除系统设置信息失败",e);
            return null;
        }
    }

    /**
    *@Description: 根据主键获取系统设置信息
    *@Param: [settingDO]
    *@return: SettingDO
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */

    @Override
    public SettingDO getSetting(UserDTO userDTO){
        try {
            return settingDao.getSetting(userDTO);
        } catch (Exception e) {
            log.error("根据主键获取系统设置信息失败",e);
            return null;
        }
    }
}
