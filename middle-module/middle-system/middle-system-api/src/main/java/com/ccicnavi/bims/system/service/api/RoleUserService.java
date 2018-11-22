package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.system.pojo.RoleUserDO;
import com.ccicnavi.bims.system.pojo.RoleUserDTO;

/**
 * @program: bims-backend
 * @description: 角色用户api
 * @author: zqq
 * @create: 2018-11-22 14:04
 */
public interface RoleUserService {
    public Integer insertRoleUser(RoleUserDTO roleUserDTO);
}
