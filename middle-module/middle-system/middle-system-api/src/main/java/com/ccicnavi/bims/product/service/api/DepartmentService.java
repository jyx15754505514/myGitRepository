package com.ccicnavi.bims.product.service.api;

import com.ccicnavi.bims.system.pojo.DepartmentDO;

import java.util.List;

public interface DepartmentService {
    /**
     * 查询部门信息
     * @param departmentDO
     * @return
     * @throws Exception
     */
    public List<DepartmentDO>listDepartment(DepartmentDO departmentDO)throws Exception;

    /**
     * 新增部门信息
     * @param departmentDO
     * @return
     * @throws Exception
     */
    public Integer insertDepartment(DepartmentDO departmentDO)throws Exception;

    /**
     * 更改部门信息
     * @param departmentDO
     * @return
     * @throws Exception
     */
    public Integer updateDepartment(DepartmentDO departmentDO)throws Exception;

    /**
     * 删除部门信息
     * @param departmentDO
     * @return
     * @throws Exception
     */
    public Integer deleteDepartment(DepartmentDO departmentDO)throws Exception;

    /**
     * 根据主键获取单个部门信息
     * @param departmentDO
     * @return
     * @throws Exception
     */
    public DepartmentDO getDepartment(DepartmentDO departmentDO)throws  Exception;
}
