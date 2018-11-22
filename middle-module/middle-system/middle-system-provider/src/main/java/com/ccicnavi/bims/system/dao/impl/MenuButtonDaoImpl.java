package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.system.dao.MenuButtonDao;
import com.ccicnavi.bims.system.pojo.MenuButtonDO;
import com.ccicnavi.bims.system.pojo.MenuDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 菜单按钮dao实现类
 * @author: zqq
 * @create: 2018-11-20 10:56
 */
@Service
public class MenuButtonDaoImpl implements MenuButtonDao {
    @Override
    public List<MenuButtonDO> listMenuButton(MenuButtonDO menuButtonDO) {
        return new Eql().select("listMenuButton").params(menuButtonDO).returnType(MenuButtonDO.class).execute();
    }

    @Override
    public Integer insertMenuButton(MenuButtonDO menuButtonDO, EqlTran tran) {
        Eql eql = new  Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.insert("insertMenuButton").params(menuButtonDO).returnType(Integer.class).execute();
    }

    @Override
    public Integer updateMenuButton(MenuButtonDO menuButtonDO,EqlTran tran) {
        Eql eql = new  Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.update("updateMenuButton").params(menuButtonDO).returnType(Integer.class).execute();
    }

    @Override
    public Integer deleteMenuButton(MenuButtonDO menuButtonDO,EqlTran tran) {
        Eql eql = new  Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.delete("deleteMenuButton").params(menuButtonDO).returnType(Integer.class).execute();
    }

    @Override
    public MenuButtonDO getMenuButton(MenuButtonDO menuButtonDO) {
        return new Eql().selectFirst("getMenuButton").params(menuButtonDO).returnType(MenuButtonDO.class).execute();
    }

    @Override
    public List<MenuButtonDO> listMenuButtonByRole(MenuDTO menuDTO) {
        return new Eql().selectFirst("listMenuButtonByRole").params(menuDTO).returnType(MenuButtonDO.class).execute();
    }
}
