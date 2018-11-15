package com.ccicnavi.bims.resource.api;

import com.ccicnavi.bims.resource.pojo.OrganizationDO;

import java.util.List;

public interface OrganizationService {
    /**
     * 查询组织机构
     * @param organizationDO
     * @return
     */
    public List<OrganizationDO> listOrganizationDO(OrganizationDO organizationDO);

    /**
     * 根据主键查询组织机构
     * @param organizationDO
     * @return
     * @throws Exception
     */
    public OrganizationDO getOrganizationDO(OrganizationDO organizationDO);

    /**
     * 新增组织机构
     * @param organizationDO
     * @return
     * @throws Exception
     */
    public Integer insertOrganizationDO(OrganizationDO organizationDO);

    /**
     * 修改组织机构
     * @param organizationDO
     * @return
     * @throws Exception
     */
    public Integer updateOrganizationDO(OrganizationDO organizationDO);

    /**
     * 删除组织机构
     * @param organizationDO
     * @return
     * @throws Exception
     */
    public Integer deleteOrganizationDO(OrganizationDO organizationDO);


}
