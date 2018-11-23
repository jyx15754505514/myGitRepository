package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.DepartmentDTO;
import com.ccicnavi.bims.system.pojo.UserDTO;

import java.util.List;

/**
 *@program: bims-backend
 *@description: 部门信息的api接口
 *@author: zhangxingbiao
 *@create: 2018-11-15 14:45
 */
public interface DepartmentService {
    /**
     * 查询部门信息
     * @param pageParameter
     * @return
     */
    public ResultT listDepartment(PageParameter<DepartmentDTO> pageParameter);

    /**
     * 新增部门信息
     * @param departmentDTO
     * @return
     */
    public Integer insertDepartment(DepartmentDTO departmentDTO);

    /**
     * 更改部门信息
     * @param departmentDTO
     * @return
     */
    public Integer updateDepartment(DepartmentDTO departmentDTO);

    /**
     * 删除部门信息
     * @param departmentDTO
     * @return
     */
    public Integer deleteDepartment(DepartmentDTO departmentDTO);

    /**
     * 根据主键获取单个部门信息
     * @param departmentDTO
     * @return
     */
    public DepartmentDTO getDepartment(DepartmentDTO departmentDTO);

    /*
    * 根据用户的UUID查询所有的部门信息
    * @Author zhaotao
    * @Date  2018/11/19 11:20
    * @Param [userDTO]
    * @return java.util.List<com.ccicnavi.bims.system.pojo.DepartmentDTO>
    **/
    List<DepartmentDTO> listDeptByUser(UserDTO userDTO);

    /**
    *@Description: 根据部门类型查询部门信息
    *@Param: [departmentDTO]
    *@return: java.util.List<com.ccicnavi.bims.system.pojo.DepartmentDTO>
    *@Author: zhangpengwei
    *@date: 2018/11/20
    */
    public List<DepartmentDTO> listDeptByDeptType(DepartmentDTO departmentDTO);

    /**
    *@Description: 根据公司查询部门信息（orgUuid和parentUuid）
    *@Param: [departmentDTO]
    *@return: java.util.List<com.ccicnavi.bims.system.pojo.DepartmentDTO>
    *@Author: zhangpengwei
    *@date: 2018/11/21
    */
    public List<DepartmentDTO> listDept(DepartmentDTO departmentDTO);
}
