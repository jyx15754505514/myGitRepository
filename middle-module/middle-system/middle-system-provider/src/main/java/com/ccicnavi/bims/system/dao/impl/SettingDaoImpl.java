package com.ccicnavi.bims.system.dao.impl;


import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.SettingDao;
import com.ccicnavi.bims.system.pojo.SettingDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
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
    public PageBean<SettingDO> listSetting(PageParameter<SettingDO> pageParameter){
        EqlPage eqlPage = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        List<SettingDO> settingDOListList = new Eql("DEFAULT").select("listSetting").params(pageParameter.getParameter()).limit(eqlPage).returnType(SettingDO.class).execute();
        if(settingDOListList != null) {
            return  new PageBean<SettingDO>(eqlPage.getTotalRows(),eqlPage.getTotalPages(), eqlPage.getCurrentPage(), eqlPage.getPageRows(), eqlPage.getStartIndex(), settingDOListList);
        }else {
            return null;
        }
    }

    /**
    *@Description: 新增系统设置信息
    *@Param: [settingDO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    @Override
    public Integer insertSetting(SettingDO settingDO) {
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
    public Integer updateSetting(SettingDO settingDO){
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
    public Integer deleteSetting(SettingDO settingDO){
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
    public SettingDO getSetting(SettingDO settingDO){
       return EqlUtils.getInstance("DEFAULT").selectFirst("getSet").params(settingDO).returnType(SettingDO.class).execute();
    }
}
