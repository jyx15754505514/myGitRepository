package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.system.dao.RolePermissionDao;
import com.ccicnavi.bims.system.pojo.RolePermissionDO;
import com.ccicnavi.bims.system.pojo.RolePermissionDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 角色按钮dao实现类
 * @author: zqq
 * @create: 2018-11-22 11:29
 */
@Service
public class RolePermissionDaoImpl  implements RolePermissionDao {
    @Override
    public List<RolePermissionDTO> selectRolePermission(RolePermissionDTO rolePermissionDTO) {
        return new Eql().select("selectRolePermission").params(rolePermissionDTO).returnType(RolePermissionDTO.class).execute();
    }

    @Override
    public Integer insertRolePermission(RolePermissionDO rolePermissionDO, EqlTran tran) {
        Eql eql = new Eql();
        if(tran !=null){
            eql.useTran(tran);
        }
        return eql.insert("insertRolePermission").params(rolePermissionDO).returnType(Integer.class).execute();
    }

    @Override
    public Integer deleteRolePermission(RolePermissionDTO rolePermissionDTO, EqlTran tran) {
        Eql eql = new Eql();
        if(tran !=null){
            eql.useTran(tran);
        }
        return eql.delete("deleteRolePermission").params(rolePermissionDTO).returnType(Integer.class).execute();
    }
}
