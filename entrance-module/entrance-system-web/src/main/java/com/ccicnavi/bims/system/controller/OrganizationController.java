package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.pojo.OrganizationDTO;
import com.ccicnavi.bims.system.service.api.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @Reference(timeout = 60000,url = "dubbo://127.0.0.1:20881")
    OrganizationService organizationService;

    /**
    *@Description: 获取所有当前机构和子机构
    *@Param: [organizationDO]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangpengwei
    *@date: 2018/11/22
    */
    @RequestMapping(value = "/getAllOrg", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getALLDepartment(@RequestBody OrganizationDTO organizationDTO) {
        List<OrganizationDTO> organizationDTOList = new ArrayList<OrganizationDTO>();
        try {
            //判断接收到的对象中机构UUID不为空
            if (StringUtils.isNotEmpty(organizationDTO.getOrgUuid())) {
                //获取所有当前机构下的所有子机构
                organizationDTOList = organizationService.listOrgByOrg(organizationDTO);
                if(organizationDTOList != null && organizationDTOList.size() > 0){
                    return ResultT.success(organizationDTOList);
                }
                ResultT.failure(ResultCode.LIST_FAILURE);
            }
            return ResultT.failure(ResultCode.LIST_FAILURE);
        } catch (Exception e) {
            log.error("查询部门信息失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

}
