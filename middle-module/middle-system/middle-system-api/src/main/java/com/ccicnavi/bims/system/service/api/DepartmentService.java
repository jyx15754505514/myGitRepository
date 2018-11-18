package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.DepartmentDO;

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
    public ResultT listDepartment(PageParameter<DepartmentDO> pageParameter);

    /**
     * 新增部门信息
     * @param departmentDO
     * @return
     */
    public Integer insertDepartment(DepartmentDO departmentDO);

    /**
     * 更改部门信息
     * @param departmentDO
     * @return
     */
    public Integer updateDepartment(DepartmentDO departmentDO);

    /**
     * 删除部门信息
     * @param departmentDO
     * @return
     */
    public Integer deleteDepartment(DepartmentDO departmentDO);

    /**
     * 根据主键获取单个部门信息
     * @param departmentDO
     * @return
     */
    public DepartmentDO getDepartment(DepartmentDO departmentDO);
}
