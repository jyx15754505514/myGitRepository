package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.pojo.RoleDO;
import com.ccicnavi.bims.system.service.api.RoleService;
import com.ccicnavi.bims.system.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<RoleDO> listRole(RoleDO role) throws Exception {
        return roleDao.listRole(role);
    }

    @Override
    public Integer insertRole(RoleDO role) throws Exception {
        return roleDao.insertRole(role);
    }

    @Override
    public Integer updateRole(RoleDO role) throws Exception {
        return roleDao.updateRole(role);
    }

    @Override
    public Integer deleteRole(RoleDO role) throws Exception {
        return roleDao.deleteRole(role);
    }

    @Override
    public RoleDO getRole(RoleDO role) throws Exception {
        return roleDao.getRole(role);
    }
}
