package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.dao.MenuButtonDao;
import com.ccicnavi.bims.system.dao.MenuDao;
import com.ccicnavi.bims.system.pojo.MenuButtonDO;
import com.ccicnavi.bims.system.pojo.MenuButtonDTO;
import com.ccicnavi.bims.system.pojo.MenuDO;
import com.ccicnavi.bims.system.pojo.MenuDTO;
import com.ccicnavi.bims.system.service.api.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
    private MenuDao menuDao;

    @Autowired
    private MenuButtonDao menuButtonDao;

    /* *
     * @Author MengZiJie
     * @Description 查询所有菜单
     * @Date 20:26 2018/11/15
     * @Param [menuDO]
     * @Return java.util.List<com.ccicnavi.bims.system.pojo.MenuDO>
     */
    @Override
    public ResultT listMenu(MenuDO menuDO) {
        try {
            List<MenuDO> listMenu = menuDao.listMenu(menuDO);
            if(listMenu!=null){
                return ResultT.success(listMenu);
            }else{
                return ResultT.failure(ResultCode.LIST_FAILURE);
            }
        } catch (Exception e) {
            log.error("查询菜单失败",e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
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
            log.error("获取菜单失败",e);
           return null;
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
            log.error("新增菜单失败",e);
           return null;
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
            log.error("更细菜单失败",e);
            return null;
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
            log.error("删除菜单失败",e);
           return null;
        }
        return menu;
    }

    @Override
    public List<MenuDTO> listMenuRoleUuid(MenuDTO menuDTO) {

        try {
            return menuDao.listMenuRoleUuid(menuDTO);
        } catch (Exception e) {
            log.error("查询菜单失败",e);
            return null;
        }
    }

    @Override
    public List<MenuDTO> listMenuByProdCatalogUuid(MenuDTO menuDTO) {
        try {
            return menuDao.listMenuByProdCatalogUuid(menuDTO);
        } catch (Exception e) {
            log.error("查询菜单失败",e);
            return null;
        }
    }


    public List<MenuButtonDTO> listMenuWithBtn(MenuDTO menuDTO) {
        List<MenuButtonDTO> resultList = new ArrayList<>();
        try {
            //查询菜单和按钮的中间表，获取所有的最底层的菜单对象
            List<MenuDTO> menuList = menuDao.listMenuButton(menuDTO);
            for (MenuDTO menu : menuList) {
                //获取并解析最底层菜单对象的所有父级UUID
                String parentAllUuid = menu.getParentAllUuid();
                String[] split = StringUtils.split(",", parentAllUuid);
                menuDTO.setMenuUuids(split);
                menuDTO.setMenuUuid(menu.getMenuUuid());
                //根据菜单UUID集合排序查询顶级到底层菜单集合
                List<MenuDO> menuDOList = menuDao.listMenuWithSort(menuDTO);
                //根据角色和最底层的菜单查询所有按钮
                List<MenuButtonDO> menuButtonList = menuButtonDao.listMenuButtonByRole(menuDTO);
                MenuButtonDTO menuBtn = new MenuButtonDTO();
                menuBtn.setMenuList(menuDOList);
                menuBtn.setMenuButtonList(menuButtonList);
                resultList.add(menuBtn);
            }
            return resultList;
        } catch (Exception e) {
            log.error("查询菜单失败", e);
            return null;
        }
    }

}
