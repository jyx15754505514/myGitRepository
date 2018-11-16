package com.ccicnavi.bims.system.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.pojo.DepartmentDO;
import com.ccicnavi.bims.system.service.api.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@program: bims-backend
 *@description: 部门信息的Controller层
 *@author: zhangxingbiao
 *@create: 2018-11-15 19:38
 */

@RestController
@RequestMapping(value = "/dept")
public class DepartmentController {

    private final static Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @Reference(timeout = 30000,url = "dubbo://127.0.0.1:20881")
    DepartmentService departmentService;


    /**
     * 查询列表
     * @param departmentDO
     * @return
     */
    @RequestMapping(value = "/listDepartment", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listDepartment(@RequestBody DepartmentDO departmentDO){
        List<DepartmentDO> dept = null;
        try {
            dept = departmentService.listDepartment(departmentDO);
            return ResultT.success(dept);
        }catch (Exception e){
            log.error("根据条件查询部门信息失败",e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    @RequestMapping(value = "/getDepartment", method = RequestMethod.POST)
    public ResultT getDepartment(@RequestBody DepartmentDO departmentDO){
        DepartmentDO departmentDO1 = null;
        try {
            departmentDO1 = departmentService.getDepartment(departmentDO);
            return ResultT.success(departmentDO1);
        }catch (Exception e){
            log.error("根据主键查询部门信息失败",e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }

    }

    @RequestMapping(value = "/insertDepartment", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT insertDepartment(@RequestBody DepartmentDO departmentDO){
        Integer integer = null;
        try {
            integer = departmentService.insertDepartment(departmentDO);
            return ResultT.success(departmentDO);
        }catch (Exception e){
            log.error("添加部门信息失败",e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }

    }

    @RequestMapping(value = "/updateDepartment", method = RequestMethod.POST)
    public ResultT updateDepartment(@RequestBody DepartmentDO departmentDO){
        Integer integer = null;
        try {
            integer = departmentService.updateDepartment(departmentDO);
            return  ResultT.success(departmentDO);
        }catch (Exception e){
           log.error("更新部门信息失败",e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }

    }

    @RequestMapping(value = "/deleteDepartment", method = RequestMethod.POST)
    public ResultT deleteDepartment(@RequestBody DepartmentDO departmentDO){
        Integer integer = null;
        try {
            integer = departmentService.deleteDepartment(departmentDO);
            return  ResultT.success(departmentDO);
        }catch (Exception e){
           log.error("删除部门信息失败",e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }
}
