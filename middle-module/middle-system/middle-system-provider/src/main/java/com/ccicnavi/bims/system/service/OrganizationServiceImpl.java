package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.DepartmentDao;
import com.ccicnavi.bims.system.dao.OrganizationDao;
import com.ccicnavi.bims.system.pojo.OrganizationDTO;
import com.ccicnavi.bims.system.pojo.UserDTO;
import com.ccicnavi.bims.system.service.api.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 组织机构信息的api实现类
 * @author: zhangpengwei
 * @create: 2018-11-15 14:45
 */
@Service
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationDao organizationDao;

    @Autowired
    DepartmentDao departmentDao;


    @Override
    public PageBean<OrganizationDTO> listOrganization(PageParameter<OrganizationDTO> pageParameter) {
        try {
            return organizationDao.listOrganization(pageParameter);
        } catch (Exception e) {
            log.error("组织机构列表获取失败" + e);
            return new PageBean<OrganizationDTO>(0,0,0,0,0,new ArrayList<OrganizationDTO>());
        }

    }


    @Override
    public Integer insertOrganization(OrganizationDTO organizationDTO) {
        try {
            return organizationDao.insertOrganization(organizationDTO);
        } catch (Exception e) {
            log.error("组织机构对象新增失败" + e);
            return null;
        }
    }

    @Override
    public Integer updateOrganization(OrganizationDTO organizationDTO) {
        try {
            return organizationDao.updateOrganization(organizationDTO);
        } catch (Exception e) {
            log.error("组织机构对象修改失败" + e);
            return null;
        }
    }

    @Override
    public Integer deleteOrganization(OrganizationDTO organizationDTO) {
        try {
            return organizationDao.deleteOrganization(organizationDTO);
        } catch (Exception e) {
            log.error("组织机构对象删除失败" + e);
            return null;
        }
    }

    @Override
    public OrganizationDTO getOrganization(OrganizationDTO organizationDTO) {
        try {
            return organizationDao.getOrganization(organizationDTO);
        } catch (Exception e) {
            log.error("组织机构对象获取失败" + e);
            return null;
        }
    }

    /**
    *@Description: 根据用户查询省公司
    *@Param: [userDO]
    *@return: java.util.List<com.ccicnavi.bims.system.pojo.OrganizationDO>
    *@Author: zhangpengwei
    *@date: 2018/11/20
    */
    @Override
    public OrganizationDTO getOrgByUser(UserDTO userDTO) {
        try {
            return organizationDao.getOrgByUser(userDTO);
        } catch (Exception e) {
            log.error("省公司获取失败",e);
            return null;
        }
    }

    /**
    *@Description: 根据当前用户的orgUuid获取所有的当前机构和子机构
    *@Param: [userDO]
    *@return: com.ccicnavi.bims.system.pojo.OrganizationDO
    *@Author: zhangpengwei
    *@date: 2018/11/22
    */
    @Override
    public List<OrganizationDTO> listOrgByOrg(OrganizationDTO organizationDTO) {
        List<OrganizationDTO> orgList = new ArrayList<OrganizationDTO>();
        try {
            //通过OrganizationDO中orgUuid  获取当前用户所在的公司
            //String parentUuid = organizationDO.getOrgUuid();
            //organizationDO.setOrgParentUuid(parentUuid);
            orgList = organizationDao.listOrgByOrg(organizationDTO);
            if(orgList != null && orgList.size() > 0 ){
                //递归调用，获取树形部门结构
                listChildOrg(organizationDTO, orgList);
            }
            return orgList;
        } catch (Exception e) {
            log.error("查询部门信息失败", e);
            return null;
        }
    }

    /**
     *@Description: 递归调用
     *@Param: [departmentDO, deptList]
     *@return: void
     *@Author: zhangpengwei
     *@date: 2018/11/21
     */
    private void listChildOrg(OrganizationDTO organizationDTO, List<OrganizationDTO> orgList) throws Exception {
        List<OrganizationDTO> childList = new ArrayList<OrganizationDTO>();
        for(OrganizationDTO org : orgList) {
            //机构主键UUID作为父级UUID传入查询子机构
            String organizationUuid = org.getOrganizationUuid();
            organizationDTO.setOrgParentUuid(organizationUuid);
            organizationDTO.setOrgUuid(null);
            childList = organizationDao.listOrgByOrg(organizationDTO);
            if (childList != null || childList.size() > 0) {
                org.setOrgChildList(childList);
                listChildOrg(organizationDTO, childList);
            }
        }
    }
}
