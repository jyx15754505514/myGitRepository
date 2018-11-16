package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.system.dao.MenuDao;
import com.ccicnavi.bims.system.pojo.MenuDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuDaoImpl implements MenuDao {

    /* *
     * @Author MengZiJie
     * @Description 查询所有菜单
     * @Date 19:24 2018/11/15
     * @Param [menuDO]
     * @Return java.util.List<com.ccicnavi.bims.system.pojo.MenuDO>
     */
    @Override
    public List<MenuDO> listMenu(MenuDO menuDO) throws Exception {
        return new Eql().select("listMenu").params(menuDO).returnType(MenuDO.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 获取菜单信息
     * @Date 19:25 2018/11/15
     * @Param [menuDO]
     * @Return com.ccicnavi.bims.system.pojo.MenuDO
     */
    @Override
    public MenuDO getMenu(MenuDO menuDO) throws Exception {
       return new Eql().selectFirst("getMenu").params(menuDO).returnType(MenuDO.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 新增菜单
     * @Date 20:10 2018/11/15
     * @Param [menuDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertMenu(MenuDO menuDO) throws Exception {
        return new Eql().insert("insertMenu").params(menuDO).returnType(Integer.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 更新菜单
     * @Date 20:10 2018/11/15
     * @Param [menuDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateMenu(MenuDO menuDO) throws Exception {
        return new Eql().update("updateMenu").params(menuDO).returnType(Integer.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 删除菜单
     * @Date 20:10 2018/11/15
     * @Param [areaDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteMenu(MenuDO menuDO) throws Exception {
        return new Eql().delete("deleteMenu").params(menuDO).returnType(Integer.class).execute();
    }
}
