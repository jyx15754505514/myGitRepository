package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.OrganizationDO;
import com.ccicnavi.bims.system.pojo.OrganizationDTO;
import com.ccicnavi.bims.system.pojo.UserDO;
import com.ccicnavi.bims.system.pojo.UserDTO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 组织机构信息
 * @author: zhangpengwei
 * @create: 2018-11-15 14:45
 */
public interface OrganizationDao {

    /**
     * 查询职称信息
     * @param pageParameter
     * @return
     */
    public PageBean<OrganizationDTO> listOrganization(PageParameter<OrganizationDTO> pageParameter) throws Exception;

    /**
     * 根据主键查询职称信息
     * @param organizationDTO
     * @return
     */
    public OrganizationDTO getOrganization(OrganizationDTO organizationDTO) throws Exception;

    /**
     * 新增职称信息
     * @param organizationDTO
     * @return
     */
    public Integer insertOrganization(OrganizationDTO organizationDTO) throws Exception;

    /**
     *@Description: 修改职称信息
     *@Param: [organizationDTO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/23
     */
    public Integer updateOrganization(OrganizationDTO organizationDTO) throws Exception;

    /**
     *@Description: 删除职称信息
     *@Param: [organizationDTO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/23
     */
    public Integer deleteOrganization(OrganizationDTO organizationDTO) throws Exception;

    /**
     *@Description: 根据用户查询省公司
     *@Param: [userDTO]
     *@return: com.ccicnavi.bims.system.pojo.OrganizationDTO
     *@Author: zhangpengwei
     *@date: 2018/11/23
     */
    public OrganizationDTO getOrgByUser(UserDTO userDTO) throws Exception;

    /**
     *@Description: 根据当前用户的orgUuid获取所有的当前机构和子机构
     *@Param: [organizationDTO]
     *@return: java.util.List<com.ccicnavi.bims.system.pojo.OrganizationDTO>
     *@Author: zhangpengwei
     *@date: 2018/11/23
     */
    public List<OrganizationDTO> listOrgByOrg(OrganizationDTO organizationDTO) throws Exception;
}
