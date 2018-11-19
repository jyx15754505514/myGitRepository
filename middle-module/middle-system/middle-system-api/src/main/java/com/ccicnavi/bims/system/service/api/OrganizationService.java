package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.OrganizationDO;

import java.util.List;

public interface OrganizationService {
    /**
     * 查询组织机构
     * @param organizationDO
     */
    public PageBean<OrganizationDO> listOrganization(PageParameter<OrganizationDO> pageParameter);

    /**
     * 根据主键查询组织机构
     * @param organizationDO
     * @return
     */
    public OrganizationDO getOrganization(OrganizationDO organizationDO);

    /**
     * 新增组织机构
     * @param organizationDO
     * @return
     */
    public Integer insertOrganization(OrganizationDO organizationDO);

    /**
     * 修改组织机构
     * @param organizationDO
     * @return
     */
    public Integer updateOrganization(OrganizationDO organizationDO);

    /**
     * 删除组织机构
     * @param organizationDO
     * @return
     */
    public Integer deleteOrganization(OrganizationDO organizationDO);


}
