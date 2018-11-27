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
    public Integer insertRoleUsers(UserDTO userDTO, EqlTran tran) {
        Eql eql = new Eql("DEFAULT");
        if(tran != null) {
            eql.useTran(tran);
        }
        return eql.insert("insertRoleUser").params(userDTO).returnType(Integer.class).execute();
    }


    @Override
    public Integer insertRoleUser(RoleUserDTO roleUserDTO, EqlTran tran) {
        Eql eql = new Eql("DEFAULT");
        if(tran != null) {
            eql.useTran(tran);
        }
        return eql.insert("insertRoleUser").params(roleUserDTO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 更新用户角色信息
    *@Param: [userDTO, tran]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/22
    */
    public Integer updateRoleUser(UserDTO userDTO, EqlTran tran) {
        Eql eql = new Eql("DEFAULT");
        if (tran != null) {
            eql.useTran(tran);
        }
        return eql.update("updateRoleUser").params(userDTO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 根据角色删除信息
    *@Param: [userDTO, tran]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/22
    */
    @Override
    public Integer deleteRoleUserByRole(UserDTO userDTO, EqlTran tran) {
        Eql eql = new Eql("DEFAULT");
        if (tran != null) {
            eql.useTran(tran);
        }
        return eql.delete("deleteRoleUserByRole").params(userDTO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 根据用户删除信息
    *@Param: [userDTO, tran]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/22
    */
    @Override
    public Integer deleteRoleUserByUser(UserDTO userDTO, EqlTran tran) {
        Eql eql = new Eql("DEFAULT");
        if (tran != null) {
            eql.useTran(tran);
        }
        return eql.delete("deleteRoleUserByUser").params(userDTO).returnType(Integer.class).execute();
    }


    /**
    *@Description: 查询用户角色
    *@Param: [userDTO, tran]
    *@return: com.ccicnavi.bims.system.pojo.UserDTO
    *@Author: zhangxingbiao
    *@date: 2018/11/22
    */
    @Override
    public List<RoleUserDTO> listRoleUser(UserDTO userDTO) {
        return new Eql("DEFAULT").select("listRoleUser").params(userDTO).returnType(RoleUserDO.class).execute();
    }

}
