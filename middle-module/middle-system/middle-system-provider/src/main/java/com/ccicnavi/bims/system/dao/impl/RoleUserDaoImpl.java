package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.system.dao.RoleUserDao;
import com.ccicnavi.bims.system.pojo.RoleUserDO;
import com.ccicnavi.bims.system.pojo.RoleUserDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

/**
 * @program: bims-backend
 * @description: 角色用户dao实现类
 * @author: zqq
 * @create: 2018-11-22 14:02
 */
@Service
public class RoleUserDaoImpl implements RoleUserDao {
    @Override
    public Integer insertRoleUser(RoleUserDO roleUserDO, EqlTran tran) {
        Eql eql = new Eql();
        if(tran !=null){
            eql.useTran(tran);
        }
        return eql.insert("insertRoleUser").params(roleUserDO).returnType(Integer.class).execute();
    }

    @Override
    public Integer deleteRoleUser(RoleUserDTO roleUserDTO, EqlTran tran) {
        Eql eql = new Eql();
        if(tran !=null){
            eql.useTran(tran);
        }
        return eql.delete("deleteRoleUser").params(roleUserDTO).returnType(Integer.class).execute();
    }
}
