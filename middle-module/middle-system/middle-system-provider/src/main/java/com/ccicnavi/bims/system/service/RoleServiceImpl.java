package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.RoleDO;
import com.ccicnavi.bims.system.pojo.RoleDTO;
import com.ccicnavi.bims.system.service.api.RoleService;
import com.ccicnavi.bims.system.dao.RoleDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public PageBean<RoleDO> listRole(PageParameter<RoleDO> pageParameter){
        try {
             return roleDao.listRole(pageParameter);
        } catch (Exception e) {
            log.error("查询失败",e);
        }
        return new PageBean<RoleDO>(0,0,0,0,0,new ArrayList<RoleDO>());
    }

    @Override
    public Integer insertRole(RoleDO role){
        try {
            return roleDao.insertRole(role);
        } catch (Exception e) {
            log.error("新增失败",e);
            return 0;
        }
    }

    @Override
    public Integer updateRole(RoleDO role){
        try {
            return roleDao.updateRole(role);
        } catch (Exception e) {
            log.error("修改失败",e);
            return 0;
        }
    }

    @Override
    public Integer deleteRole(RoleDTO role){
        if(!StringUtils.isEmpty(role.getUuids()) && role.getUuids() != ""){
            String[] split = StringUtils.split(role.getUuids(), ",");
            List<String> resultList= new ArrayList<>(Arrays.asList(split));
            role.setRoleUuids(resultList);
        }
        try {
            return roleDao.deleteRole(role);
        } catch (Exception e) {
            log.error("删除失败",e);
            return 0;
        }
    }

    @Override
    public RoleDO getRole(RoleDO role){
        try {
            return roleDao.getRole(role);
        } catch (Exception e) {
            log.error("删除失败",e);
            return new RoleDO();
        }
    }






}
