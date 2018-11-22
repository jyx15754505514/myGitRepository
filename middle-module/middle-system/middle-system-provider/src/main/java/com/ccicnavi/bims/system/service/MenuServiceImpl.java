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
            //查询所有一级菜单
            List<MenuDTO> list =menuDao.listMenuByProdCatalogUuid(menuDTO);
            //递归调用
            if(list != null && list.size() >0){
                listChildMenu(menuDTO,list);
            }
            return list;
        } catch (Exception e) {
            log.error("查询菜单失败",e);
            return null;
        }
    }

    @Override
    public List<MenuDTO> listMenuWithBtn(MenuDTO menuDTO) {
        List<MenuButtonDTO> resultList = new ArrayList<>();
        try {
            List<String> list = new ArrayList<String>();
            //查询菜单和按钮的中间表，获取所有的最底层的菜单对象
            List<MenuDTO> menuList = menuDao.listMenuButton(menuDTO);
            for (MenuDTO menu : menuList) {
                //获取并解析最底层菜单对象的所有父级UUID
                String parentAllUuid = menu.getParentAllUuid();
                if(!StringUtils.isEmpty(parentAllUuid)){
                    String[] split = parentAllUuid.split(",");
                    if(split !=null && split.length>0){
                        for(int i=0;i<split.length;i++){
                            list.add(split[i]);
                        }
                    }
                }
            }
            menuDTO.setMenuUuidList(list);
            List<MenuDTO> menuDOList =new ArrayList<MenuDTO>();
            if(list!=null && list.size()>0){
                menuDOList = menuDao.listMenuWithSort(menuDTO);
                if(menuDOList != null && menuDOList.size() >0){
                    for(MenuDTO menu :menuDOList){
                        menuDTO.setMenuUuid(menu.getMenuUuid());
                        List<MenuButtonDO> menuButtonList = menuButtonDao.listMenuButtonByRole(menuDTO);
                        menu.setMenuButtonDOList(menuButtonList);
                    }
                }
            }
            return menuDOList;
        } catch (Exception e) {
            log.error("查询菜单失败", e);
            return null;
        }
    }
    //递归查询菜单
    private void listChildMenu(MenuDTO menuDTO, List<MenuDTO> menuDTOList) throws Exception {
        List<MenuDTO> childList = new  ArrayList<MenuDTO>();
        for (MenuDTO menu : menuDTOList) {
            String parentUuid = menu.getMenuUuid();
            menuDTO.setParentUuid(parentUuid);
            childList  = menuDao.listMenuByParent(menuDTO);
            if (childList != null && childList.size() > 0) {
                menu.setMenuDTO(childList);
                listChildMenu(menuDTO, childList);
            }else{
                menu.setMenuDTO(childList);
                MenuButtonDO menuButtonDO = new MenuButtonDO();
                menuButtonDO.setMenuUuid(menu.getMenuUuid());
                //菜单所对应的所有按钮
                List<MenuButtonDO> menuButtonDOList=menuButtonDao.listMenuButton(menuButtonDO);
                menu.setMenuButtonDOList(menuButtonDOList);
                menuDTO.setMenuUuid(menu.getMenuUuid());
                List<MenuButtonDO> selectmenuButtonDOList =  menuButtonDao.listMenuButtonByRole(menuDTO);
                menu.setSelectdMenuButtonDOList(selectmenuButtonDOList);
            }
        }
    }

}
