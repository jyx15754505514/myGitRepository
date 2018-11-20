package com.ccicnavi.bims.system.manager.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.breeder.api.PasswdService;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.shiba.api.HashTemplate;
import com.ccicnavi.bims.system.manager.UserManager;
import com.ccicnavi.bims.system.pojo.*;
import com.ccicnavi.bims.system.service.api.DepartmentService;
import com.ccicnavi.bims.system.service.api.MenuService;
import com.ccicnavi.bims.system.service.api.RoleService;
import com.ccicnavi.bims.system.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: UserManagerImpl
 * @description: TODO
 * @author: zhaotao
 * @create: 2018-11-19 10:50
 **/
@Service
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
    
    /*
    * 用户登录
    * @Author zhaotao
    * @Date  2018/11/19 10:55
    * @Param [UserDO]
    * @return com.ccicnavi.bims.common.ResultT
    **/
    @Override
    public ResultT userLogin(UserDO userDO) {
        UserDO user = userService.getUser(userDO);
        if(user != null) {
            //判断账号是否被禁用
            if("N".equals(user.getIsEnabled())) {
                return ResultT.failure(ResultCode.USER_ACCOUNT_FORBIDDEN);
            }
            String password = userDO.getCurrentPassword();
            //获取盐值
            String salt = "";
            boolean verify = passwdService.verify(user.getCurrentPassword(), password, salt);
            //密码错误
            if(!verify) {
                Integer failedLogins = userDO.getFailedLogins();
                failedLogins += 1;
                userDO.setFailedLogins(failedLogins);
                //失败5次处理逻辑
                if(failedLogins >= 5) {

                }
                userService.updateUser(userDO);
                return ResultT.failure(ResultCode.USER_LOGIN_ERROR);
            }
            getUserBaseData(userDO, user);
            //设置过期时间
            //响应结果
            return ResultT.success(user);
        }else {
            //账号不存在
            return ResultT.failure(ResultCode.USER_LOGIN_ERROR);
        }
    }

    /*
    * 获取用户的基础信息，角色，部门，权限菜单
    * @Author zhaotao
    * @Date  2018/11/19 15:11
    * @Param [userDO, user]
    * @return void
    **/
    private void getUserBaseData(UserDO userDO, UserDO user) {
        //创建jsessionID
        String jsessionID = "";
        //查角色
        List<RoleUserDO> roleList = roleService.listRoleByUser(userDO);
        //查部门
        List<DepartmentDO> deptList = deptService.listDeptByUser(userDO);
        //查权限
        List<MenuDO> menuList = menuService.listMenuByUser(userDO);
        //查菜单,根据角色查询菜单List，去除重复
        //查产品线
        user.setDeptList(deptList);
        user.setRoleList(roleList);
        user.setMenuList(menuList);
        //保存到Redis中
        hashTemplate.put(jsessionID, user.getUserUuid(), user);
    }
}
