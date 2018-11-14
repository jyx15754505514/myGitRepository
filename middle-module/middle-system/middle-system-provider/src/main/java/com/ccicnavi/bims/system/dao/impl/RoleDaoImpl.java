package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.system.dao.RoleDao;
import com.ccicnavi.bims.system.pojo.RoleDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleDaoImpl implements RoleDao {

    @Override
    public List<RoleDO> listRole(RoleDO role) throws Exception {
        return new Eql().select("listRole").params(role).returnType(RoleDO.class).execute();
    }

    @Override
    public Integer insertRole(RoleDO role) throws Exception {
        return new Eql().insert("insertRole").params(role).returnType(Integer.class).execute();
    }

    @Override
    public Integer updateRole(RoleDO role) throws Exception {
        return new Eql().insert("updateRole").params(role).returnType(Integer.class).execute();
    }

    @Override
    public Integer deleteRole(RoleDO role) throws Exception {
        return new Eql().insert("deleteRole").params(role).returnType(Integer.class).execute();
    }

    @Override
    public RoleDO getRole(RoleDO role) throws Exception {
        return new Eql().selectFirst("getRole").params(role).returnType(RoleDO.class).execute();
    }
}
