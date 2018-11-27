package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.OrganizationDTO;
import com.ccicnavi.bims.system.service.api.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 组织机构信息的Controller层
 * @author: zhangpengwei
 * @create: 2018-11-22 11:53
 */

@RestController
@RequestMapping(value = "/org")
public class OrganizationController {

    private final static Logger log = LoggerFactory.getLogger(OrganizationController.class);

    @Reference
    //(timeout = 60000, url = "dubbo://127.0.0.1:20881")
    OrganizationService organizationService;

    @Reference
    //(timeout = 60000, url = "dubbo://127.0.0.1:20880")
    IdWorkerService idWorkerService;

    /**
     * @Description: 查询组织结构信息(条件查询)
     * @Param: [pageParameter]
     * @return: com.ccicnavi.bims.common.ResultT
     * @Author: zhangpengwei
     * @date: 2018/11/25
     */
    @RequestMapping(value = "/listOrg", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listOrg(@RequestBody PageParameter<OrganizationDTO> pageParameter) {
        try {
            return organizationService.listOrganization(pageParameter);
        } catch (Exception e) {
            log.error("根据条件查询组织结构信息失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
     * @Description: 新增组织机构信息
     * @Param: [organizationDTO]
     * @return: com.ccicnavi.bims.common.ResultT
     * @Author: zhangpengwei
     * @date: 2018/11/23
     */
    @RequestMapping(value = "/insertOrg", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertOrg(@RequestBody OrganizationDTO organizationDTO) {
        Integer integer = null;
        try {
            String organizationUuid = idWorkerService.getId(new Date());
            organizationDTO.setOrganizationUuid(organizationUuid);
            //organizationDTO.setOrgAllParentUuid();
            organizationDTO.setOrgUuid(organizationUuid);
            integer = organizationService.insertOrganization(organizationDTO);
            if (integer > 0) {
                return ResultT.success();
            }
            return ResultT.failure(ResultCode.ADD_FAILURE);
        } catch (Exception e) {
            log.error("添加组织机构信息失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
     * @Description: 修改组织机构信息
     * @Param: [organizationDTO]
     * @return: com.ccicnavi.bims.common.ResultT
     * @Author: zhangpengwei
     * @date: 2018/11/23
     */
    @RequestMapping(value = "/updateOrg", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateOrg(@RequestBody OrganizationDTO organizationDTO) {
        Integer integer = null;
        try {
            integer = organizationService.updateOrganization(organizationDTO);
            if (integer != null && integer != 0) {
                return ResultT.success();
            }
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        } catch (Exception e) {
            log.error("更新组织机构信息失败", e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /**
     * @Description: 删除组织机构信息
     * @Param: [organizationDTO]
     * @return: com.ccicnavi.bims.common.ResultT
     * @Author: zhangpengwei
     * @date: 2018/11/23
     */
    @RequestMapping(value = "/deleteOrg", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteOrg(@RequestBody OrganizationDTO organizationDTO) {
        Integer integer = null;
        try {
            if (StringUtils.isNotEmpty(organizationDTO.getOrgUuid()) || organizationDTO.getUuids().size() > 0) {
                integer = organizationService.deleteOrganization(organizationDTO);
                if (integer != null && integer != 0) {
                    return ResultT.success();
                }
            }
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        } catch (Exception e) {
            log.error("删除组织机构信息失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    /**
     * @Description: 根据主键UUID获取组织机构信息
     * @Param: [organizationDTO]
     * @return: com.ccicnavi.bims.common.ResultT
     * @Author: zhangpengwei
     * @date: 2018/11/25
     */
    @RequestMapping(value = "/getOrg", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getOrg(@RequestBody OrganizationDTO organizationDTO) {
        OrganizationDTO organization = new OrganizationDTO();
        try {
            organization = organizationService.getOrganization(organizationDTO);
            if (organization != null) {
                return ResultT.success(organization);
            }
            return ResultT.failure(ResultCode.GET_FAILURE);
        } catch (Exception e) {
            log.error("根据主键查询部门信息失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    /**
     *@Description: 根据用户查询省公司Uuid
     *@Param: [organizationDTO]
     *@return: com.ccicnavi.bims.common.ResultT
     *@Author: zhangpengwei
     *@date: 2018/11/26
     */
    @RequestMapping(value = "/getOrgByUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getOrgByUser(@RequestBody OrganizationDTO organizationDTO) {
        if(StringUtils.isEmpty(organizationDTO.getOrgUuid())){
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
        try {
            OrganizationDTO organization = new OrganizationDTO();
            organization = organizationService.getOrgByUser(organizationDTO);
            //if (organization != null) {
            return ResultT.success(organization);
            //}
            //return ResultT.failure(ResultCode.GET_FAILURE);
        } catch (Exception e) {
            log.error("根据主键查询部门信息失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    /**
     * @Description: 获取当前用户下的所有当前机构和子机构
     * @Param: [organizationDO]
     * @return: com.ccicnavi.bims.common.ResultT
     * @Author: zhangpengwei
     * @date: 2018/11/22
     */
    @RequestMapping(value = "/listOrgByUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listOrgByUser(@RequestBody OrganizationDTO organizationDTO) {
        //判断接收到的对象中机构UUID不为空
        if (StringUtils.isEmpty(organizationDTO.getOrgUuid())) {
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
        try {
            //获取所有当前机构下的所有子机构
            List<OrganizationDTO> organizationDTOList = organizationService.listOrgByUser(organizationDTO);
            return ResultT.success(organizationDTOList);
        } catch (Exception e) {
            log.error("查询组织机构信息失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
     *@Description: 根据当前机构查询下级机构（包括公司和部门：只查一级）
     *@Param: [organizationDTO]
     *@return: com.ccicnavi.bims.common.ResultT
     *@Author: zhangpengwei
     *@date: 2018/11/26
     */
    @RequestMapping(value = "/listOrgByOrg", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    public ResultT listOrgByOrg(@RequestBody OrganizationDTO organizationDTO){
//        //判断接收到的对象中机构UUID不为空
//        if (StringUtils.isEmpty(organizationDTO.getOrgUuid())) {
//            return ResultT.failure(ResultCode.LIST_FAILURE);
//        }
//        try {
//            //获取所有当前机构下的所有子机构
//            List<OrganizationDTO> organizationDTOList = organizationService.listOrgByOrg(organizationDTO);
//            return ResultT.success(organizationDTOList);
//        } catch (Exception e) {
//            log.error("查询组织机构信息失败", e);
//            return ResultT.failure(ResultCode.LIST_FAILURE);
//        }
//    }
    public ResultT listOrgByOrg(@RequestBody PageParameter<OrganizationDTO> pageParameter) {
        try {
            return organizationService.listOrgByOrg(pageParameter);
        } catch (Exception e) {
            log.error("根据条件查询组织结构信息失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
     *@Description: 禁用/启用机构和子机构（包括公司和部门）
     *@Param: [organizationDTO]
     *@return: com.ccicnavi.bims.common.ResultT
     *@Author: zhangpengwei
     *@date: 2018/11/26
     */
    @RequestMapping(value = "/updateOrgByEnable", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateOrgByEnable(@RequestBody OrganizationDTO organizationDTO) {
        Integer integer = null;
        try {
            if (StringUtils.isNotEmpty(organizationDTO.getOrgUuid())) {
                integer = organizationService.updateOrgByEnable(organizationDTO);
                if (integer != null && integer != 0) {
                    return ResultT.success();
                }
            }
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        } catch (Exception e) {
            log.error("删除组织机构信息失败", e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }
}
