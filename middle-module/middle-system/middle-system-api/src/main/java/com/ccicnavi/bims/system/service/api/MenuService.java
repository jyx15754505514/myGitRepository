package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.system.pojo.MenuDO;
import java.util.List;
/* *
 * @Author MengZiJie
 * @Description 菜单管理
 * @Date 20:21 2018/11/15
 */
public interface MenuService {

    /**查询所有菜单*/
    List<MenuDO> listMenu(MenuDO menuDO);
    /**获取指定菜单*/
    MenuDO getMenu(MenuDO menuDO);
    /**新增菜单*/
    Integer insertMenu(MenuDO menuDO);
    /**更新菜单*/
    Integer updateMenu(MenuDO menuDO);
    /**删除菜单*/
    Integer deleteMenu(MenuDO menuDO);
}
