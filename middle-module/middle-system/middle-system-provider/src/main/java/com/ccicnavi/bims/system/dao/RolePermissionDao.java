package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.system.pojo.RolePermissionDO;
import com.ccicnavi.bims.system.pojo.RolePermissionDTO;
import org.n3r.eql.EqlTran;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 角色按钮
 * @author: zqq
 * @create: 2018-11-22 11:26
 */
public interface RolePermissionDao {
    /**
    *@Description: 根据按钮查询
    *@Param: RolePermissionDTO
    *@return: List<RolePermissionDTO>
    *@Author: zqq
    *@date: 2018/11/22
    */

    public List<RolePermissionDTO> selectRolePermission(RolePermissionDTO rolePermissionDTO);

    /**
    *@Description: 新增角色按钮
    *@Param: RolePermissionDO
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/22
    */

    public Integer insertRolePermission(RolePermissionDTO rolePermissionDTO, EqlTran tran);

    /**
    *@Description: 删除角色按钮
    *@Param: RolePermissionDTO
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/22
    */

    public Integer deleteRolePermission(RolePermissionDTO rolePermissionDTO, EqlTran tran);
}
