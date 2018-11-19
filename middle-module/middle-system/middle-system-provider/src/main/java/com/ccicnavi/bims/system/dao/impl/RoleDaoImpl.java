package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.RoleDao;
import com.ccicnavi.bims.system.pojo.RoleDO;
import com.ccicnavi.bims.system.pojo.RoleDTO;
import com.ccicnavi.bims.system.pojo.RoleUserDO;
import com.ccicnavi.bims.system.pojo.UserDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleDaoImpl implements RoleDao {

    /**
     * 分页查询角色信息
     * @param pageParameter
     * @return
     */
    @Override
    public PageBean<RoleDO> listRole(PageParameter<RoleDO> pageParameter) {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<RoleDO> roleDOS = new Eql("DEFAULT").select("listRole").params(pageParameter.getParameter()).returnType(RoleDO.class).limit(page).execute();
        if(roleDOS != null){
            return new PageBean<>(page.getTotalRows(), page.getTotalPages(), page.getCurrentPage(), page.getPageRows(), page.getStartIndex(), roleDOS);
        }else{
            return null;
        }
    }

    @Override
    public Integer insertRole(RoleDO role){
        return new Eql("DEFAULT").insert("insertRole").params(role).returnType(Integer.class).execute();
    }

    @Override
    public Integer updateRole(RoleDO role){
        return new Eql("DEFAULT").insert("updateRole").params(role).returnType(Integer.class).execute();
    }

    @Override
    public Integer deleteRole(RoleDTO role){
        return new Eql("DEFAULT").insert("deleteRole").params(role).returnType(Integer.class).execute();
    }

    @Override
    public RoleDO getRole(RoleDO role){
        return new Eql("DEFAULT").selectFirst("getRole").params(role).returnType(RoleDO.class).execute();
    }

    /**
    *@Description: 根据用户UUID获取所有角色UUID
    *@Param: [userDO]
    *@return: java.util.List<com.ccicnavi.bims.system.pojo.RoleUserDO>
    *@Author: zhangpengwei
    *@date: 2018/11/19
    */
    @Override
    public List<RoleUserDO> listRoleByUser(UserDO userDO){
        List<RoleUserDO> roleDOList = null;
        try {
            roleDOList =  new Eql("DEFAULT").selectFirst("listRoleByUser").params(userDO).returnType(RoleDO.class).execute();
            return roleDOList;
        } catch (Exception e) {
            return roleDOList;
        }
    }
}
