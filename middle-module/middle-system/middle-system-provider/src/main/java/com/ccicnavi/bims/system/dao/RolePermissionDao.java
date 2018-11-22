package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.system.pojo.RolePermissionDO;
import com.ccicnavi.bims.system.pojo.RolePermissionDTO;
import org.n3r.eql.EqlTran;

/**
 * @program: bims-backend
 * @description: 角色按钮
 * @author: zqq
 * @create: 2018-11-22 11:26
 */
public interface RolePermissionDao {
    public Integer insertRolePermission(RolePermissionDO rolePermissionDO, EqlTran tran);
    public Integer deleteRolePermission(RolePermissionDTO rolePermissionDTO, EqlTran tran);
}
