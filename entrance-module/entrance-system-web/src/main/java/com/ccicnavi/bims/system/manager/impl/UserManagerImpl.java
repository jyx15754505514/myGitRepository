package com.ccicnavi.bims.system.manager.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.breeder.api.PasswdService;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.shiba.api.HashTemplate;
import com.ccicnavi.bims.sso.api.SSOService;
import com.ccicnavi.bims.sso.common.pojo.SSOUser;
import com.ccicnavi.bims.sso.common.result.ReturnT;
import com.ccicnavi.bims.system.manager.UserManager;
import com.ccicnavi.bims.system.pojo.*;
import com.ccicnavi.bims.system.service.api.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserManagerImpl
 * @description: 用户业务逻辑管理层
 * @author: zhaotao
 * @create: 2018-11-19 10:50
 **/
@Service
@Slf4j
public class UserManagerImpl implements UserManager {

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20881")
    private UserService userService;

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20881")
    private RoleService roleService;

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20881")
    private DepartmentService deptService;

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20881")
    private MenuService menuService;

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20881")
    private CatalogOrgService catalogOrgService;

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20880")
    private PasswdService passwdService;

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20896")
    private SSOService ssoService;
    /*
    * 用户登录
    * @Author zhaotao
    * @Date  2018/11/19 10:55
    * @Param [UserDO]
    * @return com.ccicnavi.bims.common.ResultT
    **/
    @Override
    public ResultT userLogin(UserDTO userDTO) {
        SSOUser ssoUser = new SSOUser();
        try {
            ssoUser = userService.login(userDTO);
            //对用户depteUuid和orgUuid进行判断，如果被禁用，返回被禁用
            if(ssoUser != null) {
                //判断账号是否被禁用
                if("N".equals(ssoUser.getIsEnabled()) || "Y".equals(ssoUser.getIsDeleted())) {
                    return ResultT.failure(ResultCode.USER_ACCOUNT_FORBIDDEN);
                }
                //获取登录密码
                String password = userDTO.getCurrentPassword();
                //获取盐值
                String salt = ssoUser.getSalt();
                //根据用户的盐值，验证密码是否正确
                boolean verify = passwdService.verify(ssoUser.getCurrentPassword(), password, salt);
                //密码错误
                if(!verify) {
                    //记录登录失败次数
                    Integer failedLogins = userDTO.getFailedLogins();
                    failedLogins += 1;
                    userDTO.setFailedLogins(failedLogins);
                    userDTO.setUserUuid(ssoUser.getUserUuid());
                    userDTO.setOrgUuid(ssoUser.getOrgUuid());
                    userDTO.setAppSysUuid(ssoUser.getAppSysUuid());
                    //失败5次处理逻辑
                    if(failedLogins >= 5) {

                    }
                    userService.updateUser(userDTO);
                    return ResultT.failure(ResultCode.USER_LOGIN_ERROR);
                }
                getUserBaseData(userDTO, ssoUser);
                //调用SSO服务登录操作
                ReturnT<String> login = ssoService.login(ssoUser);
                ssoUser.setJsessionID(login.getData());
                if(login.getCode() == 1) {
                    //SSO返回1 登录成功
                    return ResultT.success(ssoUser);
                }else {
                    //SSO服务登录失败
                    return ResultT.failure(ResultCode.SSO_LOGIN_FAILURE);
                }
            }else {
                //账号不存在
                return ResultT.failure(ResultCode.USER_LOGIN_ERROR);
            }
        }catch (Exception e) {
            log.error("用户登录失败", e);
            return ResultT.failure(ResultCode.USER_LOGIN_FAILURE);
        }
    }

    /*
    * 获取用户的基础信息，角色，部门，权限菜单
    * @Author zhaotao
    * @Date  2018/11/19 15:11
    * @Param [userDO, user]
    * @return void
    **/
    private void getUserBaseData(UserDTO userDTO, SSOUser ssoUser) {
        userDTO.setUserUuid(ssoUser.getUserUuid());
        userDTO.setOrgUuid(ssoUser.getOrgUuid());
        //查角色
        List<RoleDTO> roleDTOList = roleService.listRoleByUser(userDTO);
        //查部门
        List<DepartmentDTO> deptList = deptService.listDeptByUser(userDTO);
        //查产品线
        CatalogOrgDO catalogOrgDO = new CatalogOrgDO();
        catalogOrgDO.setOrganizationUuid(ssoUser.getOrgUuid());
        List<String> prodCatalogList = catalogOrgService.listCatalogOrgDO(catalogOrgDO);
        //查权限
        MenuDTO menuDTO = new MenuDTO();
        List<String> roleUuids = new ArrayList<>();
        for (RoleDTO roleDTO : roleDTOList) {
            roleUuids.add(roleDTO.getRoleUuid());
        }
        menuDTO.setRoleUuids(roleUuids);
        menuDTO.setProdCatalogList(prodCatalogList);
        menuDTO.setOrgUuid(ssoUser.getOrgUuid());
        //根据产品线和角色查询所有的菜单和按钮，selectdMenuButtonDOList为角色所拥有的按钮
        List<MenuDTO> menuList = menuService.listMenuByProdCatalogUuid(menuDTO);
        //递归查询，删除所有按钮集合为空的菜单
        deleteMenu(menuList);
        //获取当前用户所拥有的权限url
        List<String> buttonUrlList = menuService.listButtonUrlByRole(userDTO);
        ssoUser.setRoleList(roleDTOList);
        ssoUser.setDepartmentList(deptList);
        ssoUser.setBtnUrlList(buttonUrlList);
        ssoUser.setProdCatalogList(prodCatalogList);
        ssoUser.setMenuList(menuList);
    }


    //递归删除没有下级菜单且没有按钮的MenuDTO对象
    private void deleteMenu(List<MenuDTO> menuList) {
        if(menuList != null && menuList.size() > 0) {
            for (int i = 0; i < menuList.size(); i++) {
                MenuDTO me = menuList.get(i);
                List<MenuDTO> menuDTOList = me.getMenuDTO();
                List<MenuButtonDTO> buttonList = me.getSelectdMenuButtonDOList();
                //有下级菜单时继续递归
                if(menuDTOList != null && menuDTOList.size() > 0) {
                    deleteMenu(menuDTOList);
                }
                //没有下级 菜单，且没有按钮时删除菜单
                if((menuDTOList == null || menuDTOList.size() == 0) && (buttonList == null || buttonList.size() ==0)) {
                    menuList.remove(me);
                    i--;
                    continue;
                }
            }
        }
    }
}
