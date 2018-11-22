package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.system.pojo.MenuDO;
import com.ccicnavi.bims.system.pojo.MenuDTO;
import com.ccicnavi.bims.system.pojo.UserDO;

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

    /**
    * 根据角色查询所有的菜单
    * @Author zhaotao
    * @Date  2018/11/19 11:24
    * @Param [userDO]
    * @return java.util.List<java.lang.String>
    **/
    List<MenuDO> listMenuByUser(UserDO userDO) throws Exception;
    /**
     *@Description: 根据角色id查询菜单
     *@Param: menuDTO
     *@return: List<MenuDTO>
     *@Author: zqq
     *@date: 2018/11/20
     */

    List<MenuDTO> listMenuRoleUuid(MenuDTO menuDTO);

    List<MenuDTO> listMenuByProdCatalogUuid(MenuDTO menuDTO);

    /*
    * 根据产品线或角色查询所有拥有按钮的菜单
    * @Author zhaotao
    * @Date  2018/11/21 21:07
    * @Param [MenuDTO]
    * @return java.util.List<com.ccicnavi.bims.system.pojo.MenuDTO>
    **/
    List<MenuDTO> listMenuButton(MenuDTO menuDTO);

    /*
    * 排序查询菜单
    * @Author zhaotao
    * @Date  2018/11/21 21:23
    * @Param [menuDTO]
    * @return java.util.List<com.ccicnavi.bims.system.pojo.MenuDO>
    **/
    List<MenuDO> listMenuWithSort(MenuDTO menuDTO);
}
