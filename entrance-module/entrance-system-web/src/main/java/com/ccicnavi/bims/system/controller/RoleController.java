package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.RoleDO;
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
@RequestMapping("system")
@Slf4j
public class RoleController {

    @Reference(url = "dubbo://127.0.0.1:20881",timeout = 10000)
    RoleService roleService;

    /**
    * 条件查询角色列表
    * @Author TXW
    * @Date  2018/11/16 10:49
    * @Param [pageParameter]
    * @return com.ccicnavi.bims.common.ResultT
    **/
    @PostMapping(value = "listRole")
    public ResultT listRole(@RequestBody PageParameter<RoleDO> pageParameter){
        try {
            PageBean<RoleDO> roleDOList = roleService.listRole(pageParameter);
            return ResultT.success(roleDOList);
        } catch (Exception e) {
            log.error("查询角色列表失败",e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }

    }

}
