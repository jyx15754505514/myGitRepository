package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.system.pojo.MenuButtonDO;
import com.ccicnavi.bims.system.pojo.MenuButtonDTO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 菜单按钮的api
 * @author: zqq
 * @create: 2018-11-20 11:59
 */
public interface MenuButtonService {
    /**
    *@Description: 查询菜单按钮列表
    *@Param: menuButtonDO
    *@return:  List<MenuButtonDO>
    *@Author: zqq
    *@date: 2018/11/20
    */

     public List<MenuButtonDTO> listMenuButton(MenuButtonDTO menuButtonDTO);

     /**
     *@Description: 新增菜单按钮
     *@Param: menuButtonDO
     *@return: Integer
     *@Author: zqq
     *@date: 2018/11/20
     */

     public Integer insertMenuButton(MenuButtonDTO menuButtonDTO);

     /**
     *@Description: 修改菜单按钮
     *@Param: menuButtonDO
     *@return: Integer
     *@Author: zqq
     *@date: 2018/11/20
     */

     public Integer updateMenuButton(MenuButtonDTO menuButtonDTO);

     /**
     *@Description: 删除菜单按钮
     *@Param: menuButtonDO
     *@return: Integer
     *@Author: zqq
     *@date: 2018/11/20
     */

     public Integer deleteMenuButton(MenuButtonDTO menuButtonDTO);

     /**
     *@Description: 根据主键获取菜单按钮
     *@Param:  menuButtonDO
     *@return: MenuButtonDO
     *@Author: zqq
     *@date: 2018/11/20
     */

     public MenuButtonDTO getMenuButton(MenuButtonDTO menuButtonDTO);
}
