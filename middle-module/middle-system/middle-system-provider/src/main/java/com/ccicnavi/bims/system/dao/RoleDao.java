package com.ccicnavi.bims.system.dao;


import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.*;

import java.util.List;


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

    /**
    *@Description: 根据用户UUID获取所有角色UUID
    *@Param: [UserDO]
    *@return: com.ccicnavi.bims.system.pojo.RoleUserDO
    *@Author: zhangpengwei
    *@date: 2018/11/19
    */
    public List<RoleDO> listRoleByUser(UserDTO userDO) throws  Exception;
}
