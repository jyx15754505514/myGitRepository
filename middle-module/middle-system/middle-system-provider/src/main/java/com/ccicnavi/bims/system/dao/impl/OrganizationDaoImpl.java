package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.OrganizationDao;
import com.ccicnavi.bims.system.pojo.OrganizationDO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationDaoImpl implements OrganizationDao {
    /**
     * 列表查询（标准）
     */
    @Override
    public List<OrganizationDO> listOrganizationDO(OrganizationDO organizationDO) throws  Exception{
        return EqlUtils.getInstance("DEFAULT").select("listOrganization").params(organizationDO).returnType(Integer.class).execute();
    }

    /**
     * 新增（标准）
     * @param organizationDO
     * @return
     * @
     */
    @Override
    public Integer insertOrganizationDO(OrganizationDO organizationDO) throws  Exception {
        return EqlUtils.getInstance("DEFAULT").insert("insertOrganization").params(organizationDO).returnType(Integer.class).execute();
    }

    /**
     * 更新（标准）
     * @param organizationDO
     * @return
     * @
     */
    @Override
    public Integer updateOrganizationDO(OrganizationDO organizationDO) throws  Exception {
        return EqlUtils.getInstance("DEFAULT").update("updateOrganization").params(organizationDO).returnType(Integer.class).execute();
    }

    /**
     * 删除（标准）
     * @param organizationDO
     * @return
     * @
     */
    @Override
    public Integer deleteOrganizationDO(OrganizationDO organizationDO) throws  Exception  {
        return EqlUtils.getInstance("DEFAULT").delete("deleteOrganization").params(organizationDO).returnType(Integer.class).execute();
    }

    /**
     * 根据主键或者名称获取（标准）
     * @param organizationDO
     * @return
     * @
     */
    @Override
    public OrganizationDO getOrganizationDO(OrganizationDO organizationDO) throws  Exception {
        return EqlUtils.getInstance("DEFAULT").selectFirst("getOrganization").params(organizationDO).returnType(OrganizationDO.class).execute();
    }


}
