package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.product.service.api.RoleService;
import com.ccicnavi.bims.system.dao.RoleDao;

@Service
public class RoleServiceImpl implements RoleService {

    @Reference
    RoleDao roleDao;

    @Override
    public int insertRole() {
        return roleDao.insertRole();
    }
}
