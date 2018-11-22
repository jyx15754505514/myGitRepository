package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.DepartmentDO;
import com.ccicnavi.bims.system.pojo.UserDO;
import com.ccicnavi.bims.system.pojo.UserDTO;
import com.ccicnavi.bims.system.pojo.UserDeptDO;

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

    /*
    * 根据用户的UUID查询所有的部门信息
    * @Author zhaotao
    * @Date  2018/11/19 11:20
    * @Param [userDO]
    * @return java.util.List<com.ccicnavi.bims.system.pojo.DepartmentDO>
    **/
    List<DepartmentDO> listDeptByUser(UserDTO userDTO);
}
