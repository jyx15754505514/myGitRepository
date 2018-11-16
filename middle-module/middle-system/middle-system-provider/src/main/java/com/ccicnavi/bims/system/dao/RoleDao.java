package com.ccicnavi.bims.system.dao;


import com.ccicnavi.bims.system.pojo.RoleDO;
import org.n3r.eql.EqlTran;

import java.util.List;

public interface RoleDao {

    /**
     * 查询角色信息
     * @param role
     * @return List<role>
     * @throws Exception
     */
    public List<RoleDO> listRole(RoleDO role) throws Exception;

    /**
     * 新增角色
     * @param role
     * @return Integer
     * @throws Exception
     */
    public Integer insertRole(RoleDO role)throws  Exception;

    /**
     * 更新角色信息
     * @param role
     * @return Integer
     * @throws Exception
     */
    public Integer updateRole(RoleDO role)throws Exception;

    /**
     * 删除角色信息
     * @param role
     * @return Integer
     * @throws Exception
     */
    public Integer deleteRole(RoleDO role)throws Exception;

    /**
     * 根据主键查询非工作日信息
     * @param role
     * @return role
     * @throws Exception
     */
    public RoleDO getRole(RoleDO role)throws Exception;

}
