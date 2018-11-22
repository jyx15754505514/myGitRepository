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
import com.ccicnavi.bims.system.service.api.DepartmentService;
import com.ccicnavi.bims.system.service.api.MenuService;
import com.ccicnavi.bims.system.service.api.RoleService;
import com.ccicnavi.bims.system.service.api.UserService;
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

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20888")
    private HashTemplate hashTemplate;

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
        try {
            userDTO = userService.getUser(userDTO);
            //对用户depteUuid和orgUuid进行判断，如果被禁用，返回被禁用
            if(userDTO != null) {
                //判断账号是否被禁用
                if("N".equals(userDTO.getIsEnabled()) || "Y".equals(userDTO.getIsDeleted())) {
                    return ResultT.failure(ResultCode.USER_ACCOUNT_FORBIDDEN);
                }
                String password = userDTO.getCurrentPassword();
                //获取盐值
                String salt = userDTO.getSalt();
                //根据用户的盐值，验证密码是否正确
                boolean verify = passwdService.verify(userDTO.getCurrentPassword(), password, salt);
                //密码错误
                if(!verify) {
                    //记录登录失败次数
                    Integer failedLogins = userDTO.getFailedLogins();
                    failedLogins += 1;
                    userDTO.setFailedLogins(failedLogins);
                    //失败5次处理逻辑
                    if(failedLogins >= 5) {

                    }
                    userService.updateUser(userDTO);
                    return ResultT.failure(ResultCode.USER_LOGIN_ERROR);
                }
                SSOUser ssoUser = new SSOUser();
                getUserBaseData(userDTO, ssoUser);
                //调用SSO服务登录操作
                ReturnT<String> login = ssoService.login(ssoUser);
                if(login.getCode() == 200) {
                    //SSO返回200 登录成功
                    return ResultT.success(login.getData());
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
        //查角色
        List<RoleDTO> roleDTOList = roleService.listRoleByUser(userDTO);
        //查部门
        List<DepartmentDTO> deptList = deptService.listDeptByUser(userDTO);
        //查权限
        MenuDTO menuDTO = new MenuDTO();
        List<String> roleUuids = new ArrayList<>();
        for (RoleDTO roleDTO : roleDTOList) {
            roleUuids.add(roleDTO.getRoleUuid());
        }
        menuDTO.setRoleUuids(roleUuids);
        List<String> buttonUrlList = menuService.listButtonUrlByRole(userDTO);
        ssoUser.setRoleList(roleDTOList);
        ssoUser.setDepartmentList(deptList);
        ssoUser.setBtnUrlList(buttonUrlList);
    }
}
