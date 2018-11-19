package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.api.LinkmanService;
import com.ccicnavi.bims.customer.pojo.LinkmanDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户联系人资源调度
 * @author: LiJie
 * @create: 2018-11-17 10:33
 */
@RestController
@RequestMapping("/linkman")
public class LinkmanController {

    private final static Logger log = LoggerFactory.getLogger(LinkmanController.class);

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20883")
    LinkmanService linkmanService;

   /**
   *@Description: 查询客户联系人信息(不分页)
   *@Param: linkmanDO
   *@return: List<LinkmanDO>
   *@Author: zqq
   *@date: 2018/11/19
   */

    @RequestMapping(value = "/listAllLinkman", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listAllLinkman(@RequestBody LinkmanDO linkmanDO) {
        try {
            List<LinkmanDO> LinkmanList = linkmanService.listLinkman(linkmanDO);
            return ResultT.success(LinkmanList);
        } catch (Exception e) {
            log.error("查询客户联系人信息失败", e);
            return ResultT.failure(ResultCode.RESULE_DATA_NONE);
        }
    }

    /**
    *@Description: 查询客户联系人信息(分页)
    *@Param: pageParameter
    *@return: PageBean<LinkmanDO>
    *@Author: zqq
    *@date: 2018/11/19
    */

    @RequestMapping(value = "/listLinkman", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listLinkman(@RequestBody PageParameter<LinkmanDO> pageParameter) {
        try {
            PageBean<LinkmanDO> LinkmanList = linkmanService.listLinkmanPage(pageParameter);
            if (LinkmanList != null) {
                return ResultT.success(LinkmanList);
            }
        } catch (Exception e) {
            log.error("根据条件查询客户联系人失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /**
    *@Description: 根据主键查询客户联系人信息
    *@Param: linkmanDO
    *@return: LinkmanDO
    *@Author: zqq
    *@date: 2018/11/19
    */

    @RequestMapping(value = "/getLinkman", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getLinkman(@RequestBody LinkmanDO linkmanDO) {
        if(StringUtils.isEmpty(linkmanDO.getLinkmanUuid())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            LinkmanDO linkman = linkmanService.getLinkman(linkmanDO);
            if (linkman != null) {
                return ResultT.success(linkman);
            }
        } catch (Exception e) {
            log.error("根据主键查询客户失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }


    /**
    *@Description: 新增客户联系人信息
    *@Param: linkmanDO
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/19
    */
    
    @RequestMapping(value = "/saveLinkman", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT saveLinkman(@RequestBody LinkmanDO linkmanDO) {
        try {
            Integer count = linkmanService.saveLinkman(linkmanDO);
            if (count > 0) {
                return ResultT.success("新增客户联系人成功");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("新增客户联系人失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
    *@Description: 修改客户联系人信息
    *@Param: linkmanDO
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/19
    */

    @RequestMapping(value = "/updateLinkman", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateLinkman(@RequestBody LinkmanDO linkmanDO) {
        try {
            if(!StringUtils.isEmpty(linkmanDO.getLinkmanUuid())){
                Integer count = linkmanService.updateLinkman(linkmanDO);
                if (count > 0) {
                    return ResultT.success("修改客户联系人成功");
                } else {
                    return ResultT.failure(ResultCode.UPDATE_FAILURE);
                }
            }else{
                return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            }
        } catch (Exception e) {
            log.error("修改客户联系人失败", e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /**
    *@Description: 删除客户联系人信息
    *@Param: linkmanDO
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/19
    */

    @RequestMapping(value = "/removeLinkman", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT removeLinkman(@RequestBody LinkmanDO linkmanDO) {
        if(StringUtils.isEmpty(linkmanDO.getUuids())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            Integer count = linkmanService.removeLinkman(linkmanDO);
            if (count > 0) {
                return ResultT.success("删除客户联系人成功");
            } else {
                return ResultT.failure(ResultCode.DELETE_FAILURE);
            }
        } catch (Exception e) {
            log.error("删除客户联系人失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }


}
