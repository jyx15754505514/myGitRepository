package com.ccicnavi.bims.system.manager.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.manager.UserManager;
import com.ccicnavi.bims.system.pojo.RoleDO;
import com.ccicnavi.bims.system.pojo.UserDO;
import com.ccicnavi.bims.system.service.api.UserService;
import org.springframework.stereotype.Service;

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
            //查角色
            //查部门
            //查权限
            //查菜单
            //查产品线


        }else {
            return ResultT.failure(ResultCode.USER_LOGIN_ERROR);
        }
        return null;
    }
}
