package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.RoleUserDao;
import com.ccicnavi.bims.system.pojo.RoleUserDO;
import com.ccicnavi.bims.system.pojo.RoleUserDTO;
import com.ccicnavi.bims.system.service.api.RoleUserService;
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
 * @create: 2018-11-22 14:05
 */
@Service
@Slf4j
public class RoleUserServiceImpl implements RoleUserService {

    @Autowired
    private RoleUserDao roleUserDao;
    /**
    *@Description: 新增角色用户
    *@Param: roleUserDO
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/22
    */
    @Override
    public Integer insertRoleUser(RoleUserDTO roleUserDTO) {
        EqlTran tran = EqlUtils.getInstance("DEFAULT").newTran();
        Integer deletenum = 0;
        Integer savenum = 0;
        try {
            if(!StringUtils.isEmpty(roleUserDTO.getDeleteUserUuid())){
                deletenum = roleUserDao.deleteRoleUser(roleUserDTO, tran);
            }else{
                deletenum =1;
            }
            if(!StringUtils.isEmpty(roleUserDTO.getSaveUserUuid())){
                List<String> list = roleUserDTO.getSaveUserUuid();
                for(String useruuid:list){
                    RoleUserDO roleUserDO = new RoleUserDO();
                    roleUserDO.setRoleUuid(roleUserDTO.getRoleUuid());
                    roleUserDO.setUserUuid(useruuid);
                    roleUserDO.setOrgUuid(roleUserDTO.getOrgUuid());
                    savenum = roleUserDao.insertRoleUser(roleUserDO, tran);
                }
            }else{
                savenum=1;
            }
            if(savenum >0 && deletenum >0 ){
                tran.commit();
                return savenum;
            }
        } catch (Exception e) {
            log.error("新增角色用户失败",e);
            tran.rollback();
        } finally {
            Closes.closeQuietly(tran);
        }
        return savenum;
    }
}
