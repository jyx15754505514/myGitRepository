package com.ccicnavi.bims.system.service.api;

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
     * @param organizationDTO
     */
    public PageBean<OrganizationDTO> listOrganization(PageParameter<OrganizationDTO> pageParameter);

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
    *@Param: [userDO]
    *@return: java.util.List<com.ccicnavi.bims.system.pojo.OrganizationDO>
    *@Author: zhangpengwei
    *@date: 2018/11/20
    */
    public OrganizationDTO getOrgByUser(UserDTO userDTO);

//    /**
//    *@Description: 根据传入的公司UUID或者部门UUID===启用/禁用===当前公司或者部门自身及其下级公司或部门
//    *@Param: [orgDeptDTO]
//    *@return: java.lang.Integer
//    *@Author: zhangpengwei
//    *@date: 2018/11/21
//    */
//    public Integer updateOrgEnable(OrganizationDTO organizationDTO);

    /**
    *@Description: 根据当前用户的orgUuid获取所有的当前机构和子机构
    *@Param: [userDO]
    *@return: com.ccicnavi.bims.system.pojo.OrganizationDO
    *@Author: zhangpengwei
    *@date: 2018/11/22
    */
    public List<OrganizationDTO> listOrgByOrg(OrganizationDTO organizationDTO);

}
