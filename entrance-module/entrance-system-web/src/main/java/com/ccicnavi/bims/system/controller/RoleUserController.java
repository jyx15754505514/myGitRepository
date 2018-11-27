package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.pojo.RolePermissionDTO;
import com.ccicnavi.bims.system.pojo.RoleUserDTO;
import com.ccicnavi.bims.system.service.api.RoleUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: bims-backend
 * @description: 角色用户controller
 * @author: zqq
 * @create: 2018-11-22 14:20
 */
@RestController
@RequestMapping("/roleuser")
public class RoleUserController {

    private final static Logger log = LoggerFactory.getLogger(RolePermissionController.class);

//    @Reference(url = "dubbo://127.0.0.1:20881", timeout = 5000)
    @Reference
    private RoleUserService roleUserService;


    @RequestMapping(value = "/insertRoleUser",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertRoleUser(@RequestBody RoleUserDTO roleUserDTO){
        if(StringUtils.isEmpty(roleUserDTO.getRoleUuid())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            Integer integer = roleUserService.insertRoleUser(roleUserDTO);
            return ResultT.success();
        } catch (Exception e) {
            log.error("新增角色按钮失败",e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }
}
