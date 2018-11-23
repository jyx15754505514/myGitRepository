package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.DepartmentDTO;
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
     * @Description: 查询部门信息(条件查询)
     * @Param: [departmentDTO]
     * @return: List<DepartmentDTO>
     * @Author: zhangxingbiao
     * @date: 2018/11/15
     */
    public PageBean<DepartmentDTO> listDepartment(PageParameter<DepartmentDTO> pageParameter) throws Exception;

    /**
     * @Description: 新增部门信息
     * @Param: [departmentDTO]
     * @return: Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/15
     */
    public Integer insertDepartment(DepartmentDTO departmentDTO) throws Exception;

    /**
     * @Description: 更新部门信息
     * @Param: [departmentDTO]
     * @return: Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/15
     */
    public Integer updateDepartment(DepartmentDTO departmentDTO) throws Exception;

    /**
     * @Description: 删除部门信息
     * @Param: [departmentDTO]
     * @return: Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/15
     */
    public Integer deleteDepartment(DepartmentDTO departmentDTO) throws Exception;

    /**
     * @Description: 根据主键获取单个部门信息
     * @Param: [departmentDTO]
     * @return: DepartmentDTO
     * @Author: zhangxingbiao
     * @date: 2018/11/15
     */
    public DepartmentDTO getDepartment(DepartmentDTO departmentDTO) throws Exception;

    /**
    *@Description: 根据用户的UUID查询所有的部门信息
    *@Param: [userDO]
    *@return: java.util.List<com.ccicnavi.bims.system.pojo.UserDeptDO>
    *@Author: zhangpengwei
    *@date: 2018/11/19
    */
    public List<DepartmentDTO> listDeptByUser(UserDTO userDTO) throws Exception;

    /**
     * @Description: 根据部门类型查询部门信息
     * @Param: [departmentDTO]
     * @return: java.util.List<com.ccicnavi.bims.system.pojo.DepartmentDTO>
     * @Author: zhangpengwei
     * @date: 2018/11/20
     */
    public List<DepartmentDTO> listDeptByDeptType(DepartmentDTO departmentDTO) throws Exception;

    /**
     *@Description: 根据公司查询部门信息(orgUuid和parentUuid）
     *@Param: [departmentDTO]
     *@return: java.util.List<com.ccicnavi.bims.system.pojo.DepartmentDTO>
     *@Author: zhangpengwei
     *@date: 2018/11/21
     */
    public List<DepartmentDTO> listDept(DepartmentDTO departmentDTO) throws Exception ;

}
