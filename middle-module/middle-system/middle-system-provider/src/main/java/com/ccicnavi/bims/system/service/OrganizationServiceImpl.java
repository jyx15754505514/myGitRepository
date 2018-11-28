package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.DepartmentDao;
import com.ccicnavi.bims.system.dao.OrganizationDao;
import com.ccicnavi.bims.system.pojo.DepartmentDTO;
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

    /**
     *@Description: 查询组织结构信息(条件查询)
     *@Param: [pageParameter]
     *@return: com.ccicnavi.bims.common.ResultT
     *@Author: zhangpengwei
     *@date: 2018/11/25
     */
    @Override
//    public ResultT listOrganization(PageParameter<OrganizationDTO> pageParameter) {
//        try {
//            PageBean<OrganizationDTO> pageBean = organizationDao.listOrganization(pageParameter);
//            if (pageBean != null) {
//                return ResultT.success(pageBean);
//            }
//        } catch (Exception e) {
//            log.error("组织机构列表获取失败" + e);
//        }
//        return ResultT.failure(ResultCode.LIST_FAILURE);
//    }
    public List<OrganizationDTO> listOrganization(OrganizationDTO organizationDTO) {
        try {
            List<OrganizationDTO> orgList = new ArrayList<OrganizationDTO>();
            List<String> uuids = new ArrayList<String>();
            orgList = organizationDao.listOrgByUser(organizationDTO);
            // 递归调用
            if(orgList != null && orgList.size() > 0 ){
                //递归调用，获取树形部门结构
                listOrganiztionUuid(organizationDTO, orgList, uuids);
                //System.out.println("uuids:::::"+uuids);
                //OrganizationDTO orgDTO = new OrganizationDTO();
                organizationDTO.setOrganizationUuid(null);
                organizationDTO.setUuids(uuids);
                return organizationDao.listOrganization(organizationDTO);
            }else{
                return null;
            }
        } catch (Exception e) {
            log.error("查询组织机构信息失败", e);
            return null;
        }
    }

    /**
     *@Description: 新增组织机构信息
     *@Param: [organizationDTO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/25
     */
    @Override
    public Integer insertOrganization(OrganizationDTO organizationDTO) {
        try {
            return organizationDao.insertOrganization(organizationDTO);
        } catch (Exception e) {
            log.error("组织机构对象新增失败" + e);
            return null;
        }
    }

    /**
     *@Description: 修改组织机构信息
     *@Param: [organizationDTO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/25
     */
    @Override
    public Integer updateOrganization(OrganizationDTO organizationDTO) {
        try {
            return organizationDao.updateOrganization(organizationDTO);
        } catch (Exception e) {
            log.error("组织机构对象修改失败" + e);
            return null;
        }
    }

    /**
     *@Description: 删除组织机构信息
     *@Param: [organizationDTO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/25
     */
    @Override
    public Integer deleteOrganization(OrganizationDTO organizationDTO) {
        try {
            List<OrganizationDTO> orgList = new ArrayList<OrganizationDTO>();
            List<String> uuids = new ArrayList<String>();
            orgList = organizationDao.listOrgByUser(organizationDTO);
            //删除 递归调用
            if(orgList != null && orgList.size() > 0 ){
                //递归调用，获取树形部门结构
                listOrganiztionUuid(organizationDTO, orgList, uuids);
                System.out.println("uuids:::::"+uuids);
                //OrganizationDTO orgDTO = new OrganizationDTO();
                organizationDTO.setOrganizationUuid(null);
                organizationDTO.setUuids(uuids);
                return organizationDao.deleteOrganization(organizationDTO);
            }else{
                return null;
            }
        } catch (Exception e) {
            log.error("组织机构对象删除失败" + e);
            return null;
        }
    }

    /**
     *@Description: 根据主键UUID获取组织机构信息
     *@Param: [organizationDTO]
     *@return: com.ccicnavi.bims.system.pojo.OrganizationDTO
     *@Author: zhangpengwei
     *@date: 2018/11/25
     */
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
     *@Param: [organizationDTO]
     *@return: java.util.List<com.ccicnavi.bims.system.pojo.OrganizationDO>
     *@Author: zhangpengwei
     *@date: 2018/11/20
     */
    @Override
    public OrganizationDTO getOrgByUser(OrganizationDTO organizationDTO) {
        try {
            String organizationUuid = organizationDTO.getOrgUuid();
            organizationDTO.setOrganizationUuid(organizationUuid);
            return organizationDao.getOrgByUser(organizationDTO);
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
    public List<OrganizationDTO> listOrgByUser(OrganizationDTO organizationDTO) {
        List<OrganizationDTO> orgList = new ArrayList<OrganizationDTO>();
        try {
            //通过OrganizationDO中orgUuid  获取当前用户所在的公司
            orgList = organizationDao.listOrgByUser(organizationDTO);
            if(orgList != null && orgList.size() > 0 ){
                //递归调用，获取树形部门结构
                listChildOrg(organizationDTO, orgList);
            }
            return orgList;
        } catch (Exception e) {
            log.error("查询组织机构信息失败", e);
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
            childList = organizationDao.listOrgByUser(organizationDTO);

            if (childList != null && childList.size() > 0) {
                org.setChildren(childList);
                listChildOrg(organizationDTO, childList);
            }
        }
    }

    /**
     *@Description: 根据当前机构查询下级机构（包括公司和部门：只查一级）
     *@Param: [organizationDTO]
     *@return: java.util.List<com.ccicnavi.bims.system.pojo.OrganizationDTO>
     *@Author: zhangpengwei
     *@date: 2018/11/26
     */
//    @Override
//    public List<OrganizationDTO> listOrgByOrg(OrganizationDTO organizationDTO){
//        List<OrganizationDTO> orgList = new ArrayList<OrganizationDTO>();
//        try {
//            orgList = organizationDao.listOrgByOrg(organizationDTO);
//            return orgList;
//        } catch (Exception e) {
//            log.error("查询组织机构信息失败", e);
//            return null;
//        }
//    }
    @Override
    public ResultT listOrgByOrg(PageParameter<OrganizationDTO> pageParameter) {
        try {
            PageBean<OrganizationDTO> pageBean = organizationDao.listOrgByOrg(pageParameter);
            if (pageBean != null) {
                return ResultT.success(pageBean);
            }
        } catch (Exception e) {
            log.error("组织机构列表获取失败" + e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /**
     *@Description: 禁用/启用机构和子机构（包括公司和部门）
     *@Param: [organizationDTO]
     *@return: java.lang.Integer
     *@Author: zhangpengwei
     *@date: 2018/11/26
     */
    @Override
    public Integer updateOrgByEnable(OrganizationDTO organizationDTO){
        try {
            //String orgAllParentUuid = organizationDTO.getOrgUuid();
            //organizationDTO.setOrgAllParentUuid(orgAllParentUuid);

            List<OrganizationDTO> orgList = new ArrayList<OrganizationDTO>();
            List<String> uuids = new ArrayList<String>();
            orgList = organizationDao.listOrgByUser(organizationDTO);
            //禁用/启用 递归调用
            if(orgList != null && orgList.size() > 0 ){
                //递归调用，获取树形部门结构
                listOrganiztionUuid(organizationDTO, orgList, uuids);
                System.out.println("uuids:::::"+uuids);
                organizationDTO.setOrganizationUuid(null);
                organizationDTO.setUuids(uuids);
                return organizationDao.updateOrgByEnable(organizationDTO);
            }else{
                return null;
            }
        } catch (Exception e) {
            log.error("组织机构删除失败" + e);
            return null;
        }
    }

    /**
     *@Description: 删除、禁用/启用 递归调用
     *@Param: [departmentDO, deptList]
     *@return: void
     *@Author: zhangpengwei
     *@date: 2018/11/21
     */
    private void listOrganiztionUuid(OrganizationDTO organizationDTO, List<OrganizationDTO> orgList, List<String> uuids) throws Exception {
        List<OrganizationDTO> childList = new ArrayList<OrganizationDTO>();
        for(OrganizationDTO org : orgList) {
            //机构主键UUID作为父级UUID传入查询子机构
            String organizationUuid = org.getOrganizationUuid();
            organizationDTO.setOrgParentUuid(organizationUuid);
            organizationDTO.setOrgUuid(null);
            organizationDTO.setUuids(null);
            uuids.add(org.getOrganizationUuid());

            childList = organizationDao.listOrgByUser(organizationDTO);

            if (childList != null && childList.size() > 0) {
                org.setChildren(childList);
                listOrganiztionUuid(organizationDTO, childList, uuids);
            }
        }
    }
}
