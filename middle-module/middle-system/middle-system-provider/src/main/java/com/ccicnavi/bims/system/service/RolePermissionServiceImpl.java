package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.RolePermissionDao;
import com.ccicnavi.bims.system.pojo.RolePermissionDO;
import com.ccicnavi.bims.system.pojo.RolePermissionDTO;
import com.ccicnavi.bims.system.service.api.RolePermissionService;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlTran;
import org.n3r.eql.util.Closes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: 本人姓名
 * @create: 2018-11-22 11:35
 */
@Slf4j
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    private RolePermissionDao rolePermissionDao;
    @Override
    public Integer insertRolePermission(RolePermissionDTO rolePermissionDTO) {
        EqlTran tran = EqlUtils.getInstance("DEFAULT").newTran();
        Integer deletenum =0;
        Integer savenum = 0;
        try {
            tran.start();
            if(!StringUtils.isEmpty(rolePermissionDTO.getDeleteButUuid())){
                deletenum=rolePermissionDao.deleteRolePermission(rolePermissionDTO,tran);
            }else{
                deletenum=1;
            }
            if(!StringUtils.isEmpty(rolePermissionDTO.getSaveButUuid())){
                List<String> list = rolePermissionDTO.getSaveButUuid();
                for(String butuuid:list){
                    RolePermissionDO rolePermissionDO = new RolePermissionDO();
                    rolePermissionDO.setRoleUuid(rolePermissionDTO.getRoleUuid());
                    rolePermissionDO.setButUuid(butuuid);
                    rolePermissionDO.setAppSysUuid(rolePermissionDTO.getAppSysUuid());
                    rolePermissionDO.setProdCatalogUuid(rolePermissionDTO.getProdCatalogUuid());
                    savenum=rolePermissionDao.insertRolePermission(rolePermissionDO,tran);
                }
            }else{
                savenum=1;
            }
            if(savenum > 0 && deletenum>0){
                tran.commit();
                return savenum;
            }
        } catch (Exception e) {
            log.error("新增角色按钮失败",e);
            tran.rollback();
        } finally {
            Closes.closeQuietly(tran);
        }
        return savenum;
    }
}
