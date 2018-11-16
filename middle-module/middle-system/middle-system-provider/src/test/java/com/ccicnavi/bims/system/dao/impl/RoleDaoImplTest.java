package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.system.pojo.RoleDO;
import org.junit.Test;

import java.util.List;


class RoleDaoImplTest {

    @Test
    void listRole() {
        RoleDaoImpl roleDao = new RoleDaoImpl();
        RoleDO roleDO = new RoleDO();
        roleDO.setOrgUuid("CCIC");
        roleDO.setAppSysUuid("CCIC");
        roleDO.setBusinessLine("CQC");
        roleDO.setRoleUuid("111");
    }

    @Test
    void insertRole() {
    }

    @Test
    void updateRole() {
    }

    @Test
    void deleteRole() {
    }

    @Test
    void getRole() {
        RoleDaoImpl roleDao = new RoleDaoImpl();
        RoleDO roleDO = new RoleDO();
        roleDO.setOrgUuid("CCIC");
        roleDO.setAppSysUuid("CCIC");
        roleDO.setBusinessLine("CQC");
        roleDO.setRoleUuid("111");
        RoleDO role = roleDao.getRole(roleDO);
        System.out.println(role);

    }
}