package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.RoleDao;
import com.ccicnavi.bims.system.pojo.RoleDO;
import com.ccicnavi.bims.system.pojo.RoleDTO;
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
    public PageBean<RoleDO> listRole(PageParameter<RoleDO> pageParameter){
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<RoleDO> roleDOS = new Eql("DEFAULT").select("listRole").params(pageParameter.getParameter()).returnType(RoleDO.class).limit(page).execute();
        return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),roleDOS);
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
}
