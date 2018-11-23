package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.MenuButtonDao;
import com.ccicnavi.bims.system.pojo.MenuButtonDO;
import com.ccicnavi.bims.system.pojo.MenuButtonDTO;
import com.ccicnavi.bims.system.service.api.MenuButtonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 菜单按钮api实现类
 * @author: zqq
 * @create: 2018-11-20 12:04
 */
@Service
@Slf4j
public class MenuButtonServiceImpl implements MenuButtonService {

    @Autowired
    private MenuButtonDao menuButtonDao;
    @Override
    public List<MenuButtonDTO> listMenuButton(MenuButtonDTO menuButtonDTO) {
        try {
            return menuButtonDao.listMenuButton(menuButtonDTO);
        } catch (Exception e) {
            log.error("查询菜单按钮失败",e);
            return null;
        }
    }

    @Override
    public Integer insertMenuButton(MenuButtonDTO menuButtonDTO) {
        try {
            return menuButtonDao.insertMenuButton(menuButtonDTO,null);
        } catch (Exception e) {
            log.error("新增菜单按钮失败",e);
            return 0;
        }
    }

    @Override
    public Integer updateMenuButton(MenuButtonDTO menuButtonDTO) {
        try {
            return menuButtonDao.updateMenuButton(menuButtonDTO,null);
        } catch (Exception e) {
            log.error("修改菜单按钮失败",e);
            return 0;
        }
    }

    @Override
    public Integer deleteMenuButton(MenuButtonDTO menuButtonDTO) {
        try {
            return menuButtonDao.deleteMenuButton(menuButtonDTO,null);
        } catch (Exception e) {
            log.error("删除菜单按钮失败",e);
            return 0;
        }
    }

    @Override
    public MenuButtonDTO getMenuButton(MenuButtonDTO menuButtonDTO) {
        try {
            return menuButtonDao.getMenuButton(menuButtonDTO);
        } catch (Exception e) {
            log.error("根据主键查询菜单按钮失败",e);
            return null;
        }
    }
}
