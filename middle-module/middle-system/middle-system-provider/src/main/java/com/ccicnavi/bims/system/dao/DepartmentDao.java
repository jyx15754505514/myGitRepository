package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.DepartmentDO;
import com.ccicnavi.bims.system.pojo.DepartmentDTO;
import com.ccicnavi.bims.system.pojo.UserDTO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 部门信息dao接口
 * @author: zhangxingbiao
 * @create: 2018-11-14 23:33
 **/
public interface DepartmentDao {

   /**
    *@Description: 查询部门信息(条件查询)
    *@Param: [departmentDO]
    *@return: List<DepartmentDO>
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
   public PageBean<DepartmentDO> listDepartment(PageParameter<DepartmentDO> pageParameter);

    /**
    *@Description: 新增部门信息
    *@Param: [departmentDO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    public Integer insertDepartment(DepartmentDO departmentDO);

    /**
    *@Description: 更新部门信息
    *@Param: [departmentDO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    public Integer updateDepartment(DepartmentDO departmentDO);

    /**
    *@Description: 删除部门信息
    *@Param: [departmentDO]
    *@return: Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    public Integer deleteDepartment(DepartmentDO departmentDO);

    /**
    *@Description: 根据主键获取单个部门信息
    *@Param: [departmentDO]
    *@return: DepartmentDO
    *@Author: zhangxingbiao
    *@date: 2018/11/15
    */
    public DepartmentDO getDepartment(DepartmentDO departmentDO);

    /**
    *@Description: 根据用户的UUID查询所有的部门信息
    *@Param: [userDO]
    *@return: java.util.List<com.ccicnavi.bims.system.pojo.UserDeptDO>
    *@Author: zhangpengwei
    *@date: 2018/11/19
    */
    public List<DepartmentDTO> listDeptByUser(UserDTO userDTO) throws Exception;

}
