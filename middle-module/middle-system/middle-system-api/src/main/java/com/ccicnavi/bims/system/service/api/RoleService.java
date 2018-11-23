package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.*;

import java.util.List;

public interface RoleService {

    /**
     * 查询角色信息
     * @param pageParameter
     * @return PageBean<RoleDO>
     * @throws Exception
     */
    public PageBean<RoleDO> listRole(PageParameter<RoleDO> pageParameter);

    /**
     * 新增角色
     * @param role
     * @return Integer
     * @throws Exception
     */
    public Integer insertRole(RoleDO role);

    /**
     * 更新角色信息
     * @param role
     * @return Integer
     * @throws Exception
     */
    public Integer updateRole(RoleDO role);

    /**
     * 删除角色信息
     * @param role
     * @return Integer
     * @throws Exception
     */
    public Integer deleteRole(RoleDTO role);

    /**
     * 根据主键查询角色信息
     * @param role
     * @return role
     * @throws Exception
     */
    public RoleDO getRole(RoleDO role);

    /*
    * 根据用户UUID查询所有角色UUID
    * @Author zhaotao
    * @Date  2018/11/19 11:20
    * @Param [userDO]
    * @return java.util.List<java.lang.String>
    **/
    public List<RoleDTO> listRoleByUser(UserDTO userDO);
}
