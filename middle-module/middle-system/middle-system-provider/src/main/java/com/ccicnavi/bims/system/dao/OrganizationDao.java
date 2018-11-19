package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.OrganizationDO;

import java.util.List;

public interface OrganizationDao {

    /**
     * 查询职称信息
     * @param organizationDO
     * @return
     */
    public PageBean<OrganizationDO> listOrganization(PageParameter<OrganizationDO> pageParameter) throws Exception;

    /**
     * 根据主键查询职称信息
     * @param organizationDO
     * @return
     */
    public OrganizationDO getOrganization(OrganizationDO organizationDO) throws Exception;

    /**
     * 新增职称信息
     * @param organizationDO
     * @return
     */
    public Integer insertOrganization(OrganizationDO organizationDO) throws Exception;

    /**
     * 修改职称信息
     * @param organizationDO
     * @return
     */
    public Integer updateOrganization(OrganizationDO organizationDO) throws Exception;

    /**
     * 删除职称信息
     * @param  organizationDO
     * @return
     */
    public Integer deleteOrganization(OrganizationDO organizationDO) throws Exception;
}
