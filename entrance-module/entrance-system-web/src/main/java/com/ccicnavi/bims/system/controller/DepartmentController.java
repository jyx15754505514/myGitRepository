package com.ccicnavi.bims.system.controller;


import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.DepartmentDTO;
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

    @Reference(timeout = 60000,url = "dubbo://127.0.0.1:20881")
    DepartmentService departmentService;



    /**
     *@Description: 查询部门信息(条件查询)
     *@Param: [departmentDO]
     *@return: ResultT
     *@Author: zhangxingbiao
     *@date: 2018/11/16
     */
    @RequestMapping(value = "/listDepartment", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listDepartment(@RequestBody PageParameter<DepartmentDTO> pageParameter){
        try{
            return  departmentService.listDepartment(pageParameter);
        }catch (Exception e){
            log.error("根据条件查询部门信息失败",e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
     *@Description: 查询单个部门信息
     *@Param: [departmentDO]
     *@return: ResultT
     *@Author: zhangxingbiao
     *@date: 2018/11/16
     */
    @RequestMapping(value = "/getDepartment", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO department = null;
        try {
            department = departmentService.getDepartment(departmentDTO);
            return ResultT.success(department);
        }catch (Exception e){
            log.error("根据主键查询部门信息失败",e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }

    }

    /**
     *@Description: 新增部门信息
     *@Param: [departmentDO]
     *@return: ResultT
     *@Author: zhangxingbiao
     *@date: 2018/11/16
     */
    @RequestMapping(value = "/insertDepartment", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertDepartment(@RequestBody DepartmentDTO departmentDTO){
        Integer integer = null;
        try {
            integer = departmentService.insertDepartment(departmentDTO);
            return ResultT.success();
        }catch (Exception e){
            log.error("添加部门信息失败",e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }

    }

    /**
     *@Description: 更新部门信息
     *@Param: [departmentDO]
     *@return: ResultT
     *@Author: zhangxingbiao
     *@date: 2018/11/16
     */
    @RequestMapping(value = "/updateDepartment", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateDepartment(@RequestBody DepartmentDTO departmentDTO){
        Integer integer = null;
        try {
            integer = departmentService.updateDepartment(departmentDTO);
            return  ResultT.success();
        }catch (Exception e){
            log.error("更新部门信息失败",e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }

    }

    /**
     *@Description: 删除部门信息
     *@Param: [departmentDO]
     *@return: ResultT
     *@Author: zhangxingbiao
     *@date: 2018/11/16
     */
    @RequestMapping(value = "/deleteDepartment", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteDepartment(@RequestBody DepartmentDTO departmentDTO) {
        Integer integer = null;
        try {
            if (StringUtils.isNotEmpty(departmentDTO.getDeptUuid()) || departmentDTO.getUuids().size()>0) {
                integer = departmentService.deleteDepartment(departmentDTO);
                return ResultT.success();
            }
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        } catch (Exception e) {
            log.error("删除部门信息失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    /**
    *@Description: 获取当前部门和所有子部门
    *@Param: [departmentDO]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangpengwei
    *@date: 2018/11/22
    */
    @RequestMapping(value = "/getALLDepartment", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getALLDepartment(@RequestBody DepartmentDTO departmentDTO) {
        List<DepartmentDTO> departmentDTOList = null;
        try {
            //判断接收到的对象中机构UUID不为空
            if (StringUtils.isNotEmpty(departmentDTO.getOrgUuid())) {
                //获取所有当前部门下的所有子部门
                departmentDTOList = departmentService.listDept(departmentDTO);
                if(departmentDTOList != null && departmentDTOList.size() > 0){
                    return ResultT.success(departmentDTOList);
                }
                return ResultT.failure(ResultCode.LIST_FAILURE);
            }
            return ResultT.failure(ResultCode.LIST_FAILURE);
        } catch (Exception e) {
            log.error("查询部门信息失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }
}
