package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.pojo.MenuDO;

import com.ccicnavi.bims.system.pojo.MenuDTO;
import com.ccicnavi.bims.system.pojo.UserDTO;

import java.util.List;
/* *
 * @Author MengZiJie
 * @Description 菜单管理
 * @Date 20:21 2018/11/15
 */
public interface MenuService {

    /* *
     * @Author MengZiJie
     * @Description 查询菜单
     * @Date 20:21 2018/11/15
     * @Param [menuDO]
     * @Return java.util.List<com.ccicnavi.bims.system.pojo.MenuDO>
     */
    ResultT listMenu(MenuDO menuDO);
    /* *
     * @Author MengZiJie
     * @Description 获取菜单
     * @Date 20:21 2018/11/15
     * @Param [menuDO]
     * @Return com.ccicnavi.bims.system.pojo.MenuDO
     */
    MenuDO getMenu(MenuDO menuDO);
    /* *
     * @Author MengZiJie
     * @Description 新增菜单
     * @Date 20:21 2018/11/15
     * @Param [menuDO]
     * @Return java.lang.Integer
     */
    Integer insertMenu(MenuDO menuDO);
    /* *
     * @Author MengZiJie
     * @Description 更新菜单
     * @Date 20:21 2018/11/15
     * @Param [menuDO]
     * @Return java.lang.Integer
     */
    Integer updateMenu(MenuDO menuDO);
    /* *
     * @Author MengZiJie
     * @Description 删除菜单
     * @Date 20:21 2018/11/15
     * @Param [menuDO]
     * @Return java.lang.Integer
     */
    Integer deleteMenu(MenuDO menuDO);

    /*
    * 根据用户的UUID查询所有的菜单UUID
    * @Author zhaotao
    * @Date  2018/11/19 11:21
    * @Param [userDO]
    * @return java.util.List<java.lang.String>
    **/
   // List<MenuDO> listMenuByUser(UserDO userDO);
    
    /**
    *@Description: 根据用户角色查询菜单
    *@Param: menuDTO
    *@return: List<MenuDTO>
    *@Author: zqq
    *@date: 2018/11/20
    */
    
    List<MenuDTO> listMenuRoleUuid(MenuDTO menuDTO);
    /**
    *@Description: 根據大宗线id查詢菜单
    *@Param: menuDTO
    *@return: List<MenuDTO>
    *@Author: 本人姓名
    *@date: 2018/11/20
    */

    List<MenuDTO> listMenuByProdCatalogUuid(MenuDTO menuDTO);


    /**
    *@Description: 根据主键查询菜单
    *@Param: menuDTO
    *@return: List<MenuDTO>
    *@Author: zqq
    *@date: 2018/11/22
    */
    public List<MenuDTO> listMenuWithBtn(MenuDTO menuDTO);

    /*
    * 根据角色查询按钮的url
    * @Author zhaotao
    * @Date  2018/11/22 23:00
    * @Param [userDTO]
    * @return java.util.List<java.lang.String>
    **/
    List<String> listButtonUrlByRole(UserDTO userDTO);
}
