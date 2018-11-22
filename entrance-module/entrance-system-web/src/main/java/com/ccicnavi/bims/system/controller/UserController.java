package com.ccicnavi.bims.system.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.manager.UserManager;
import com.ccicnavi.bims.system.pojo.UserDO;
import com.ccicnavi.bims.system.pojo.UserDTO;
import com.ccicnavi.bims.system.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: bims-backend
 * @description: 登录用户的Controller层
 * @author: zhaotao
 * @create: 2018-11-15 19:38
 */
@RestController
@Slf4j
@RequestMapping(value = "/user")
public class UserController {

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20881")
    private UserService userService;

    @Autowired
    private UserManager userManager;

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20880")
    IdWorkerService idWorkerService;

    /**
    *@Description: 查询登录用户信息(条件查询)
    *@Param: [UserDO]
    *@return: ResultT
    *@Author: zhaotao
    *@date: 2018/11/16
    */
    @RequestMapping(value = "/listUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listUser(@RequestBody PageParameter<UserDO> pageParameter) {
        try {
            return userService.listUser(pageParameter);
        } catch (Exception e) {
            log.error("根据条件查询登录用户信息失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
    *@Description: 查询单个登录用户信息(主键查询)
    *@Param: [UserDO]
    *@return: ResultT
    *@Author: zhaotao
    *@date: 2018/11/16
    */
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public ResultT getUser(@RequestBody UserDO UserDO) {
        UserDO User = null;
        try {
            User = userService.getUser(UserDO);
            return ResultT.success(User);
        } catch (Exception e) {
            log.error("根据主键查询登录用户信息失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    /**
    *@Description: 新增登录用户信息
    *@Param: [UserDO]
    *@return: ResultT
    *@Author: zhaotao
    *@date: 2018/11/16
    */
    @RequestMapping(value = "/insertUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertUser(@RequestBody UserDO UserDO) {
        Integer integer = null;
        try {
            integer = userService.insertUser(UserDO);
            return ResultT.success();
        } catch (Exception e) {
            log.error("新增登录用户信息失败",e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
    *@Description: 更新登录用户信息
    *@Param: [UserDO]
    *@return: ResultT
    *@Author: zhaotao
    *@date: 2018/11/16
    */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ResultT updateUser(@RequestBody UserDO UserDO) {
        Integer integer = null;
        try {
            integer = userService.updateUser(UserDO);
            return ResultT.success();
        } catch (Exception e) {
            log.error("更新登录用户信息失败", e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /**
    *@Description: 删除登录用户信息
    *@Param: [UserDO]
    *@return: ResultT
    *@Author: zhaotao
    *@date: 2018/11/16
    */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ResultT deleteUser(@RequestBody UserDTO userDTO) {
        Integer integer = null;
        try {
            integer = userService.deleteUser(userDTO);
            return ResultT.success();
        } catch (Exception e) {
            log.error("删除登录用户信息失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    /**
    *@Description: 删除登录用户信息
    *@Param: [UserDO]
    *@return: ResultT
    *@Author: zhaotao
    *@date: 2018/11/16
    */
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public ResultT userLogin(@RequestBody UserDO UserDO) {
        try {
            return userManager.userLogin(UserDO);
        } catch (Exception e) {
            log.error("用户登录失败", e);
            return ResultT.failure(ResultCode.USER_LOGIN_ERROR);
        }
    }

    /**
    *@Description: 保存登录用户信息
    *@Param: [userDTO]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangxingbiao
    *@date: 2018/11/21
    */
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT saveUser(@RequestBody UserDTO userDTO) {
        Integer integer = null;
        try {
            if (StringUtils.isEmpty(userDTO.getUserUuid())) {
                String userUuid = idWorkerService.getId(new Date());
                userDTO.setUserUuid(userUuid);
                integer = userService.saveUser(userDTO);
            } else {
                integer = userService.updateUser(userDTO);
            }
            if (integer != null) {
                return ResultT.success(integer);
            }
        } catch (Exception e) {
            log.error("新建用户失败", e);
        }
        return ResultT.failure(ResultCode.ADD_FAILURE);
    }

    /**
    *@Description: 更改启用禁用状态
    *@Param: [userDO]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangxingbiao
    *@date: 2018/11/22
    */

    @RequestMapping(value = "/updateIsEnabled", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateIsEnabled(@RequestBody UserDTO userDTO) {
        Integer integer = null;
        try {
            integer = userService.updateIsEnabled(userDTO);
            return ResultT.success();
        } catch (Exception e) {
            log.error("更改启用禁用状态失败", e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

}
