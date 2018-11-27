package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.RolePermissionDao;
import com.ccicnavi.bims.system.dao.RoleUserDao;
import com.ccicnavi.bims.system.pojo.*;
import com.ccicnavi.bims.system.service.api.RoleService;
import com.ccicnavi.bims.system.dao.RoleDao;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;
    @Autowired
    private RolePermissionDao rolePermissionDao;
    @Autowired
    private RoleUserDao roleUserDao;
    @Reference(url = "dubbo://127.0.0.1:20880", timeout = 5000)
    IdWorkerService idWorkerService;
    @Override
    public PageBean<RoleDO> listRole(PageParameter<RoleDO> pageParameter){
        try {
             return roleDao.listRole(pageParameter);
        } catch (Exception e) {
            log.error("查询失败",e);
        }
        return null;
    }

    @Override
    public Integer insertRole(RoleDO role){
        try {
            String uuid = idWorkerService.getId(new Date());
            role.setRoleUuid(uuid);
            return roleDao.insertRole(role,null);
        } catch (Exception e) {
            log.error("新增失败",e);
            return 0;
        }
    }

    @Override
    public Integer updateRole(RoleDO role){
        try {
            return roleDao.updateRole(role,null);
        } catch (Exception e) {
            log.error("修改失败",e);
            return 0;
        }
    }

    @Override
    public Integer deleteRole(RoleDTO role){
        EqlTran tran = new Eql("DEFAULT").newTran();
        List<String> list = role.getRoleUuids();
        Integer rolenum=0;
        Integer roleusernum=0;
        Integer rolepernum=0;
        try {
            tran.start();
            rolenum = roleDao.deleteRole(role,tran);
            for(String roleuuid:list){
                UserDTO userDTO =new UserDTO();
                userDTO.setRoleUuid(roleuuid);
                userDTO.setOrgUuid(role.getOrgUuid());
                List<RoleUserDTO> roleuserlist= roleUserDao.listRoleUser(userDTO);
                if(roleuserlist !=null && roleuserlist.size()>0){
                    roleusernum = roleUserDao.deleteRoleUsers(userDTO,tran);
                }else{
                    roleusernum=1;
                }

                RolePermissionDTO rolePermissionDTO =new RolePermissionDTO();
                rolePermissionDTO.setRoleUuid(roleuuid);
                rolePermissionDTO.setProdCatalogUuid(role.getProdCatalogUuid());
                List<RolePermissionDTO>  roleperlist = rolePermissionDao.selectRolePermission(rolePermissionDTO);
                if(roleperlist !=null && roleperlist.size()>0){
                    rolepernum = rolePermissionDao.deleteRolePermission(rolePermissionDTO,tran);
                }else{
                    rolepernum=1;
                }
            }
            if(rolenum >0 && roleusernum>0 && rolepernum>0){
                tran.commit();
                return rolenum;
            }
        } catch (Exception e) {
            log.error("删除失败",e);
            tran.rollback();
            return 0;
        }finally {
            tran.close();
        }
        return 0;
    }

    @Override
    public RoleDTO getRole(RoleDTO role){
        try {
            return roleDao.getRole(role);
        } catch (Exception e) {
            log.error("根据主键获取失败",e);
            return new RoleDTO();
        }
    }


    /**
    *@Description: 根据用户UUID获取所有角色UUID
    *@Param: [userDO]
    *@return: com.ccicnavi.bims.system.pojo.RoleUserDO
    *@Author: zhangpengwei
    *@date: 2018/11/19
    */
    @Override
    public List<RoleDTO> listRoleByUser(UserDTO userDO){
        List<RoleDTO> roleDOList = null;
        try {
            roleDOList = roleDao.listRoleByUser(userDO);
            return roleDOList;
        } catch (Exception e) {
            log.error("查询用户角色UUID失败",e);
            return roleDOList;
        }
    }

}
