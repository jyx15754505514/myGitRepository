package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.system.dao.RoleUserDao;
import com.ccicnavi.bims.system.pojo.RoleUserDO;
import com.ccicnavi.bims.system.pojo.RoleUserDTO;
import com.ccicnavi.bims.system.dao.RoleUserDao;
import com.ccicnavi.bims.system.pojo.RoleUserDO;
import com.ccicnavi.bims.system.pojo.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
import java.util.List;



/**
 *@program: bims-backend
 *@description: 角色用户的dao层实现
 *@author: zhangxingbiao
 *@create: 2018-11-21 22:01
 */
@Service
@Slf4j
public class RoleUserDaoImpl implements RoleUserDao {
    /**
    *@Description: 新增用户角色信息
    *@Param: [userDTO, tran]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/22
    */

    @Override
    public Integer insertRoleUser(UserDTO userDTO, EqlTran tran) {
        Eql eql = new Eql("DEFAULT");
        if(tran != null) {
            eql.useTran(tran);
        }
        return new Eql("DEFAULT").insert("insertRoleUser").params(userDTO).returnType(Integer.class).execute();
    }

    @Override
    public Integer insertRoleUser(RoleUserDO roleUserDO, EqlTran tran) {
        Eql eql = new Eql("DEFAULT");
        if(tran != null) {
            eql.useTran(tran);
        }
        return new Eql("DEFAULT").insert("insertRoleUser").params(roleUserDO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 更新用户角色信息
    *@Param: [userDTO, tran]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/22
    */

    @Override
    public Integer updateRoleUser(UserDTO userDTO, EqlTran tran) {
        Eql eql = new Eql("DEFAULT");
        if (tran != null) {
            eql.useTran(tran);
        }
        return new Eql("DEFAULT").update("updateRoleUser").params(userDTO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 删除用户角色
    *@Param: [userDTO, tran]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/22
    */

    @Override
    public Integer deleteRoleUser(UserDTO userDTO, EqlTran tran) {
        Eql eql = new Eql("DEFAULT");
        if (tran != null) {
            eql.useTran(tran);
        }
        return new Eql("DEFAULT").delete("deleteRoleUser").params(userDTO).returnType(Integer.class).execute();
    }

    @Override
    public Integer deleteRoleUser(RoleUserDTO roleUserDTO, EqlTran tran) {
        Eql eql = new Eql("DEFAULT");
        if (tran != null) {
            eql.useTran(tran);
        }
        return new Eql("DEFAULT").delete("deleteRoleUser").params(roleUserDTO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 查询用户角色
    *@Param: [userDTO, tran]
    *@return: com.ccicnavi.bims.system.pojo.UserDTO
    *@Author: zhangxingbiao
    *@date: 2018/11/22
    */

    @Override
    public List<RoleUserDO> listRoleUser(UserDTO userDTO, EqlTran tran) {
        Eql eql = new Eql("DEFAULT");
        if (tran != null) {
            eql.useTran(tran);
        }
        return new Eql("DEFAULT").select("listRoleUser").params(userDTO).returnType(RoleUserDO.class).execute();
    }
}
