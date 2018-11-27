package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.OrganizationDTO;
import com.ccicnavi.bims.system.pojo.UserDTO;

import java.util.List;

/**
 *@program: bims-backend
 *@description: 组织机构信息的api接口
 *@author: zhangxingbiao
 *@create: 2018-11-15 14:45
 */
public interface OrganizationService {
    /**
     * 查询组织机构
     * @param pageParameter
     */
    public ResultT listOrganization(PageParameter<OrganizationDTO> pageParameter);

    /**
     * 根据主键查询组织机构
     * @param organizationDTO
     * @return
     */
    public OrganizationDTO getOrganization(OrganizationDTO organizationDTO);

    /**
     * 新增组织机构
     * @param organizationDTO
     * @return
     */
    public Integer insertOrganization(OrganizationDTO organizationDTO);

    /**
     * 修改组织机构
     * @param organizationDTO
     * @return
     */
    public Integer updateOrganization(OrganizationDTO organizationDTO);

    /**
     * 删除组织机构
     * @param organizationDTO
     * @return
     */
    public Integer deleteOrganization(OrganizationDTO organizationDTO);

    /**
     *@Description: 根据用户查询省公司
     *@Param: [organizationDTO]
     *@return: java.util.List<com.ccicnavi.bims.system.pojo.OrganizationDO>
     *@Author: zhangpengwei
     *@date: 2018/11/20
     */
    public OrganizationDTO getOrgByUser(OrganizationDTO organizationDTO);

    /**
     *@Description: 根据当前用户的orgUuid获取所有的当前机构和子机构
     *@Param: [userDO]
     *@return: com.ccicnavi.bims.system.pojo.OrganizationDO
     *@Author: zhangpengwei
     *@date: 2018/11/22
     */
    public List<OrganizationDTO> listOrgByUser(OrganizationDTO organizationDTO);

    /**
     *@Description: 根据当前机构查询下级机构（包括公司和部门：只查一级）
     *@Param: [organizationDTO]
     *@return: java.util.List<com.ccicnavi.bims.system.pojo.OrganizationDTO>
     *@Author: zhangpengwei
     *@date: 2018/11/26
     */
    //public List<OrganizationDTO> listOrgByOrg(OrganizationDTO organizationDTO);
    public ResultT listOrgByOrg(PageParameter<OrganizationDTO> pageParameter);

    /**
     *@Description: 禁用/启用机构和子机构（包括公司和部门）
     *@Param: [organizationDTO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/26
     */
    public Integer updateOrgByEnable(OrganizationDTO organizationDTO);
}
