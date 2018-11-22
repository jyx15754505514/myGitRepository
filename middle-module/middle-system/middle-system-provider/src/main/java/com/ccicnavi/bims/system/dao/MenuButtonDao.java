package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.system.pojo.MenuButtonDO;
import com.ccicnavi.bims.system.pojo.MenuDTO;
import org.n3r.eql.EqlTran;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 菜单按钮dao
 * @author: zqq
 * @create: 2018-11-20 10:50
 */
public interface MenuButtonDao {

    /**
    *@Description: 查询菜单按钮列表
    *@Param: menuButtonDO
    *@return: List<MenuButtonDO>
    *@Author: zqq
    *@date: 2018/11/20
    */
    public List<MenuButtonDO> listMenuButton(MenuButtonDO menuButtonDO);

    /**
    *@Description: 新增菜单按钮
    *@Param: menuButtonDO
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/20
    */
    public Integer insertMenuButton(MenuButtonDO menuButtonDO, EqlTran tran);

    /**
    *@Description: 修改菜单按钮
    *@Param: menuButtonDO
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/20
    */

    public Integer updateMenuButton(MenuButtonDO menuButtonDO,EqlTran tran);

    /**
    *@Description: 删除菜单按钮
    *@Param: MenuButtonDO menuButtonDO
    *@return: Integer
    *@Author: 本人姓名
    *@date: 2018/11/20
    */

    public Integer deleteMenuButton(MenuButtonDO menuButtonDO,EqlTran tran);

    /**
    *@Description: 根据主键获取菜单按钮
    *@Param: menuButtonDO
    *@return: MenuButtonDO
    *@Author: zqq
    *@date: 2018/11/20
    */
    public MenuButtonDO getMenuButton(MenuButtonDO menuButtonDO);

    /*
    * 根据菜单和角色查询所有按钮
    * @Author zhaotao
    * @Date  2018/11/21 21:40
    * @Param [menuDTO]
    * @return java.util.List<com.ccicnavi.bims.system.pojo.MenuButtonDO>
    **/
    List<MenuButtonDO> listMenuButtonByRole(MenuDTO menuDTO);
}
