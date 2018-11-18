package com.ccicnavi.bims.system.dao;


import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.RoleDO;
import com.ccicnavi.bims.system.pojo.RoleDTO;


public interface RoleDao {

    /**
     * 查询角色信息
     *
     * @param pageParameter
     * @return List<role>
     * @throws Exception
     */
    public PageBean<RoleDO> listRole(PageParameter<RoleDO> pageParameter)throws  Exception;

    /**
     * 新增角色
     *
     * @param role
     * @return Integer
     * @throws Exception
     */
    public Integer insertRole(RoleDO role)throws  Exception;

    /**
     * 更新角色信息
     *
     * @param role
     * @return Integer
     * @throws Exception
     */
    public Integer updateRole(RoleDO role)throws  Exception;

    /**
     * 删除角色信息
     *
     * @param role
     * @return Integer
     * @throws Exception
     */
    public Integer deleteRole(RoleDTO role)throws  Exception;

    /**
     * 根据主键查询角色信息
     *
     * @param role
     * @return role
     * @throws Exception
     */
    public RoleDO getRole(RoleDO role)throws  Exception;
}
