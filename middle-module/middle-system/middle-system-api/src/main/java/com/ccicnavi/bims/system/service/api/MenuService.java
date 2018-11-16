package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.system.pojo.MenuDO;
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
    List<MenuDO> listMenu(MenuDO menuDO);
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
}
