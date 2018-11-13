package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.product.service.api.RoleService;
import com.ccicnavi.bims.system.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public int insertRole() {
        return roleDao.insertRole();
    }
}
