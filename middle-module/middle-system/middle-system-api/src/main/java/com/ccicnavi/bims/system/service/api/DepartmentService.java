package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.system.pojo.DepartmentDO;

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
     * @param departmentDO
     * @return
     */
    public List<DepartmentDO>listDepartment(DepartmentDO departmentDO)throws Exception;

    /**
     * 新增部门信息
     * @param departmentDO
     * @return
     */
    public Integer insertDepartment(DepartmentDO departmentDO)throws Exception;

    /**
     * 更改部门信息
     * @param departmentDO
     * @return
     */
    public Integer updateDepartment(DepartmentDO departmentDO)throws Exception;

    /**
     * 删除部门信息
     * @param departmentDO
     * @return
     */
    public Integer deleteDepartment(DepartmentDO departmentDO)throws Exception;

    /**
     * 根据主键获取单个部门信息
     * @param departmentDO
     * @return
     */
    public DepartmentDO getDepartment(DepartmentDO departmentDO)throws Exception;
}
