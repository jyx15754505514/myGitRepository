package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.system.pojo.RoleUserDO;
import com.ccicnavi.bims.system.pojo.RoleUserDTO;
import org.n3r.eql.EqlTran;

/**
 * @program: bims-backend
 * @description: 角色用户dao
 * @author: zqq
 * @create: 2018-11-22 13:59
 */
public interface RoleUserDao {
    public Integer insertRoleUser(RoleUserDO roleUserDO, EqlTran tran);
    public Integer deleteRoleUser(RoleUserDTO roleUserDTO, EqlTran tran);
}
