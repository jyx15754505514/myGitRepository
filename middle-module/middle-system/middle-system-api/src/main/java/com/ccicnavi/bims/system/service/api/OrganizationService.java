package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.system.pojo.OrganizationDO;

import java.util.List;

public interface OrganizationService {
    /**
     * 查询组织机构
     * @param organizationDO
     */
    public List<OrganizationDO> listOrganizationDO(OrganizationDO organizationDO);

    /**
     * 根据主键查询组织机构
     * @param organizationDO
     * @return
     */
    public OrganizationDO getOrganizationDO(OrganizationDO organizationDO);

    /**
     * 新增组织机构
     * @param organizationDO
     * @return
     */
    public Integer insertOrganizationDO(OrganizationDO organizationDO);

    /**
     * 修改组织机构
     * @param organizationDO
     * @return
     */
    public Integer updateOrganizationDO(OrganizationDO organizationDO);

    /**
     * 删除组织机构
     * @param organizationDO
     * @return
     */
    public Integer deleteOrganizationDO(OrganizationDO organizationDO);


}
