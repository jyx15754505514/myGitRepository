package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.system.pojo.RolePermissionDO;
import com.ccicnavi.bims.system.pojo.RolePermissionDTO;

/**
 * @program: bims-backend
 * @description: 角色按钮api
 * @author: zqq
 * @create: 2018-11-22 11:33
 */
public interface RolePermissionService {

    /**
    *@Description: 新增角色按钮
    *@Param: rolePermissionDO
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/22
    */

    public Integer insertRolePermission(RolePermissionDTO rolePermissionDTO);
}
