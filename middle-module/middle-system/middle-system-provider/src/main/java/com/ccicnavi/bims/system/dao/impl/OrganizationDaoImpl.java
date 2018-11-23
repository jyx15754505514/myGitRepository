package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.OrganizationDao;
import com.ccicnavi.bims.system.pojo.OrganizationDTO;
import com.ccicnavi.bims.system.pojo.UserDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 组织机构信息
 * @author: zhangpengwei
 * @create: 2018-11-15 14:45
 */
@Service
public class OrganizationDaoImpl implements OrganizationDao {
    /**
     * 列表查询（组织机构）
     */
    @Override
    public PageBean<OrganizationDTO> listOrganization(PageParameter<OrganizationDTO> pageParameter) throws Exception{
        EqlPage page = new EqlPage(pageParameter.getStartIndex(),pageParameter.getPageRows());
        List<OrganizationDTO> OrganizationDOs = new Eql("DEFAULT").select("listOrganization").params(pageParameter.getParameter()).returnType(OrganizationDTO.class).limit(page).execute();
        return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),OrganizationDOs);
    }

    /**
     * 新增（组织机构）
     * @param organizationDTO
     * @return
     * @
     */
    @Override
    public Integer insertOrganization(OrganizationDTO organizationDTO) throws  Exception {
        return new Eql().insert("insertOrganization").params(organizationDTO).returnType(Integer.class).execute();
    }

    /**
     * 更新（组织机构）
     * @param organizationDTO
     * @return
     * @
     */
    @Override
    public Integer updateOrganization(OrganizationDTO organizationDTO) throws  Exception {
        return new Eql().update("updateOrganization").params(organizationDTO).returnType(Integer.class).execute();
    }

    /**
     * 删除（组织机构）
     * @param organizationDTO
     * @return
     * @
     */
    @Override
    public Integer deleteOrganization(OrganizationDTO organizationDTO) throws  Exception  {
        return new Eql().delete("deleteOrganization").params(organizationDTO).returnType(Integer.class).execute();
    }

    /**
     * 根据主键或者名称获取（组织机构）
     * @param organizationDTO
     * @return
     * @
     */
    @Override
    public OrganizationDTO getOrganization(OrganizationDTO organizationDTO) throws  Exception {
        return new Eql().selectFirst("getOrganization").params(organizationDTO).returnType(OrganizationDTO.class).execute();
    }

    /**
    *@Description: 根据用户查询省公司
    *@Param: [userDO]
    *@return: com.ccicnavi.bims.system.pojo.OrganizationDO
    *@Author: zhangpengwei
    *@date: 2018/11/20
    */
    @Override
    public OrganizationDTO getOrgByUser(UserDTO userDTO) throws Exception {
        return new Eql().selectFirst("getOrgByUser").params(userDTO).returnType(OrganizationDTO.class).execute();
    }

    /**
    *@Description: 根据当前用户的orgUuid获取所有的当前机构和子机构
    *@Param: [organizationDO]
    *@return: java.util.List<com.ccicnavi.bims.system.pojo.OrganizationDTO>
    *@Author: zhangpengwei
    *@date: 2018/11/22
    */
    @Override
    public List<OrganizationDTO> listOrgByOrg(OrganizationDTO organizationDTO) throws Exception {
        return new Eql().select("listOrgByOrg").params(organizationDTO).returnType(OrganizationDTO.class).execute();
    }
}
