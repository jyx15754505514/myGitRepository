package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.MenuDao;
import com.ccicnavi.bims.system.pojo.MenuDO;
import com.ccicnavi.bims.system.service.api.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/* *
 * @Author MengZiJie
 * @Description 菜单管理
 * @Date 20:27 2018/11/15
 */
@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;

    /* *
     * @Author MengZiJie
     * @Description 查询所有菜单
     * @Date 20:26 2018/11/15
     * @Param [menuDO]
     * @Return java.util.List<com.ccicnavi.bims.system.pojo.MenuDO>
     */
    @Override
    public List<MenuDO> listMenu(MenuDO menuDO) {
        List<MenuDO> menu = null;
        try {
            menu = menuDao.listMenu(menuDO);
        } catch (Exception e) {
            log.debug("查询菜单失败",e);
            e.printStackTrace();
        }
        return menu;
    }

    /* *
     * @Author MengZiJie
     * @Description 获取指定菜单
     * @Date 20:26 2018/11/15
     * @Param [menuDO]
     * @Return com.ccicnavi.bims.system.pojo.MenuDO
     */
    @Override
    public MenuDO getMenu(MenuDO menuDO) {
        MenuDO menu = null;
        try {
            menu = menuDao.getMenu(menuDO);
        } catch (Exception e) {
            log.debug("获取菜单失败",e);
            e.printStackTrace();
        }
        return menu;
    }

    /* *
     * @Author MengZiJie
     * @Description 新增菜单
     * @Date 20:30 2018/11/15
     * @Param [menuDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertMenu(MenuDO menuDO) {
        Integer menu = null;
        try {
            menu = menuDao.insertMenu(menuDO);
        } catch (Exception e) {
            log.debug("新增菜单失败",e);
            e.printStackTrace();
        }
        return menu;
    }

    /* *
     * @Author MengZiJie
     * @Description 更新菜单
     * @Date 20:30 2018/11/15
     * @Param [menuDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateMenu(MenuDO menuDO) {
        Integer menu = null;
        try {
            menu = menuDao.updateMenu(menuDO);
        } catch (Exception e) {
            log.debug("更细菜单失败",e);
            e.printStackTrace();
        }
        return menu;
    }

    /* *
     * @Author MengZiJie
     * @Description 删除菜单
     * @Date 20:31 2018/11/15
     * @Param [menuDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteMenu(MenuDO menuDO) {
        Integer menu = null;
        try {
            menu = menuDao.deleteMenu(menuDO);
        } catch (Exception e) {
            log.debug("删除菜单失败",e);
            e.printStackTrace();
        }
        return menu;
    }
}
