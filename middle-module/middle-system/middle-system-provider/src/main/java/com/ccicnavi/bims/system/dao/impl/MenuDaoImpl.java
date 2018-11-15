package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.system.dao.MenuDao;
import com.ccicnavi.bims.system.pojo.MenuDO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuDaoImpl implements MenuDao {

    /* *
     * @Author MengZiJie
     * @Description 查询所有菜单
     * @Date 19:24 2018/11/15
     * @Param [menuDO]
     * @Return java.util.List<com.ccicnavi.bims.system.pojo.MenuDO>
     */
    @Override
    public List<MenuDO> listMenu(MenuDO menuDO) throws Exception {
        return null;
    }

    /* *
     * @Author MengZiJie
     * @Description
     * @Date 19:25 2018/11/15
     * @Param [menuDO]
     * @Return com.ccicnavi.bims.system.pojo.MenuDO
     */
    @Override
    public MenuDO getMenu(MenuDO menuDO) throws Exception {
        return null;
    }

    @Override
    public Integer insertMenu(MenuDO areaDO) throws Exception {
        return null;
    }

    @Override
    public Integer updateMenu(MenuDO areaDO) throws Exception {
        return null;
    }

    @Override
    public Integer deleteMenu(MenuDO areaDO) throws Exception {
        return null;
    }
}
