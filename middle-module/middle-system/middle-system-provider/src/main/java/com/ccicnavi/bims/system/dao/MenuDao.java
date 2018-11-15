package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.system.pojo.MenuDO;
import java.util.List;

/* *
 * @Author MengZiJie
 * @Description 菜单管理
 * @Date 16:48 2018/11/14
 */
public interface MenuDao {

    /**查询所有菜单*/
    List<MenuDO> listMenu(MenuDO menuDO) throws Exception;
    /**获取指定菜单*/
    MenuDO getMenu(MenuDO menuDO) throws Exception;
    /**新增菜单*/
    Integer insertMenu(MenuDO menuDO) throws Exception;
    /**更新菜单*/
    Integer updateMenu(MenuDO menuDO) throws Exception;
    /**删除菜单*/
    Integer deleteMenu(MenuDO menuDO) throws Exception;
}
