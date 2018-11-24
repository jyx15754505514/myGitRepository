package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.system.dao.MenuButtonDao;
import com.ccicnavi.bims.system.pojo.*;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @program: bims-backend
 * @description: 菜单按钮dao实现类
 * @author: zqq
 * @create: 2018-11-20 10:56
 */
@Service
public class MenuButtonDaoImpl implements MenuButtonDao {
    @Override
    public List<MenuButtonDTO> listMenuButton(MenuButtonDTO menuButtonDTO) {
        return new Eql().select("listMenuButton").params(menuButtonDTO).returnType(MenuButtonDO.class).execute();
    }

    @Override
    public Integer insertMenuButton(MenuButtonDTO menuButtonDTO, EqlTran tran) {
        Eql eql = new  Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.insert("insertMenuButton").params(menuButtonDTO).returnType(Integer.class).execute();
    }

    @Override
    public Integer updateMenuButton(MenuButtonDTO menuButtonDTO,EqlTran tran) {
        Eql eql = new  Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.update("updateMenuButton").params(menuButtonDTO).returnType(Integer.class).execute();
    }

    @Override
    public Integer deleteMenuButton(MenuButtonDTO menuButtonDTO,EqlTran tran) {
        Eql eql = new  Eql();
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.delete("deleteMenuButton").params(menuButtonDTO).returnType(Integer.class).execute();
    }

    @Override
    public MenuButtonDTO getMenuButton(MenuButtonDTO menuButtonDTO) {
        return new Eql().selectFirst("getMenuButton").params(menuButtonDTO).returnType(MenuButtonDO.class).execute();
    }

    @Override
    public List<MenuButtonDTO> listMenuButtonByRole(MenuDTO menuDTO) {
        return new Eql().select("listMenuButtonByRole").params(menuDTO).returnType(MenuButtonDO.class).execute();
    }

    @Override
    public List<String> listButtonUrlByRole(UserDTO userDTO) throws Exception {
        return new Eql().select("listButtonUrlByRole").params(userDTO).returnType(MenuButtonDO.class).execute();
    }

}
