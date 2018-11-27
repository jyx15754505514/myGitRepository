package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.RoleDO;
import com.ccicnavi.bims.system.pojo.RoleDTO;
import com.ccicnavi.bims.system.pojo.UserDTO;
import com.ccicnavi.bims.system.service.api.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @program: bims-backend
 * @description:
 * @author: TXW
 * @create: 2018-11-15 21:04
 */
@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {

    @Reference(url = "dubbo://127.0.0.1:20881", timeout = 5000)
    private RoleService roleService;

    /**
     * 条件查询角色列表
     *
     * @return com.ccicnavi.bims.common.ResultT
     * @Author TXW
     * @Date 2018/11/16 10:49
     * @Param [pageParameter]
     **/
    @RequestMapping(value = "/listRole", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listRole(@RequestBody PageParameter<RoleDO> pageParameter) {
        try {
            PageBean<RoleDO> roleDOList = roleService.listRole(pageParameter);
            if(roleDOList != null) {
                log.info("查询成功",JSONObject.toJSONString(roleDOList));
                return ResultT.success(roleDOList);
            }
        } catch (Exception e) {
            log.error("查询角色列表失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /**
     * 新增角色
     *
     * @return com.ccicnavi.bims.common.ResultT
     * @Author TXW
     * @Date 2018/11/16 15:21
     * @Param [role]
     **/
    @RequestMapping(value = "/insertRole", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertRole(@RequestBody RoleDO role) {
        try {
            Integer integer = roleService.insertRole(role);
            if (integer > 0) {
                return ResultT.success("新增角色成功");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("新增角色失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }


    /**
     * 单个或批量更新角色
     * @Author zhaotao
     * @Date  2018/11/15 22:03
     * @Param [roleDO]
     * @return com.ccicnavi.bims.common.ResultT
     **/
    @RequestMapping(value = "/updateRole", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateRole(@RequestBody RoleDO roleDO) {
        try {
            Integer updateResult = roleService.updateRole(roleDO);
            if(updateResult != null && updateResult != 0) {
                return ResultT.success();
            }
        }catch (Exception e) {
            log.debug("更新角色失败", e);
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

    /**
     * 单个或批量删除角色
     * @Author zhaotao
     * @Date  2018/11/15 22:03
     * @Param [roleDO]
     * @return com.ccicnavi.bims.common.ResultT
     **/
    @RequestMapping(value = "/deleteRole", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteRole(@RequestBody RoleDTO roleDO) {
        try {

            Integer deleteResult = roleService.deleteRole(roleDO);
            if(deleteResult != null && deleteResult != 0) {
                return ResultT.success();
            }
        }catch (Exception e) {
            log.debug("删除角色失败", e);
        }
        return ResultT.failure(ResultCode.DELETE_FAILURE);
    }

    /**
     * 获取指定角色
     * @Author zhaotao
     * @Date  2018/11/15 22:03
     * @Param [roleDO]
     * @return com.ccicnavi.bims.common.ResultT
     **/
    @RequestMapping(value = "/getRole", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getRole(@RequestBody RoleDTO roleDO) {
        try {
            RoleDTO resultBean = roleService.getRole(roleDO);
            if(resultBean != null) {
                return ResultT.success(resultBean);
            }
        }catch (Exception e) {
            log.debug("获取指定角色失败", e);
        }
        return ResultT.failure(ResultCode.GET_FAILURE);
    }

    /**
     * 获取用户下的所有角色
     * @Author zhaotao
     * @Date  2018/11/15 22:03
     * @Param [roleDO]
     * @return com.ccicnavi.bims.common.ResultT
     **/
    @RequestMapping(value = "/listRoleByUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listRoleByUser(@RequestBody UserDTO userDO) {
        try {
            List<RoleDTO> roleDTOList = roleService.listRoleByUser(userDO);
            if(roleDTOList != null) {
                return ResultT.success(roleDTOList);
            }
        }catch (Exception e) {
            log.debug("获取指定角色失败", e);
        }
        return ResultT.failure(ResultCode.GET_FAILURE);
    }




}
