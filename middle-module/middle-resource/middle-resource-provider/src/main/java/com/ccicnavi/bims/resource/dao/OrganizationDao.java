package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.resource.pojo.OrganizationDO;

import java.util.List;

public interface OrganizationDao {

    /**
     * 查询职称信息
     * @param organizationDO
     * @return
     */
    public List<OrganizationDO> listOrganizationDO(OrganizationDO organizationDO) throws Exception;

    /**
     * 根据主键查询职称信息
     * @param organizationDO
     * @return
     */
    public OrganizationDO getOrganizationDO(OrganizationDO organizationDO) throws Exception;

    /**
     * 新增职称信息
     * @param organizationDO
     * @return
     */
    public Integer insertOrganizationDO(OrganizationDO organizationDO) throws Exception;

    /**
     * 修改职称信息
     * @param organizationDO
     * @return
     */
    public Integer updateOrganizationDO(OrganizationDO organizationDO) throws Exception;

    /**
     * 删除职称信息
     * @param  organizationDO
     * @return
     */
    public Integer deleteOrganizationDO(OrganizationDO organizationDO) throws Exception;
}
