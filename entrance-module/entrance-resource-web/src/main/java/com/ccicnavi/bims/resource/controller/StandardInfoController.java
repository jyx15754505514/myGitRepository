package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.StandardInfoService;
import com.ccicnavi.bims.resource.pojo.StandardInfoDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: bims-backend
 * @description: （标准）增删改查
 * @author: zhangpengwei
 * @create: 2018-11-15 21:25
 */

@RestController
@RequestMapping("/standard")
public class StandardInfoController {
    private final static Logger log = LoggerFactory.getLogger(SealController.class);

    @Reference(timeout = 30000)
    private StandardInfoService standardInfoService;

    /**
    *@Description: 描述
    *@Param: [parameter]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangpengwei
    *@date: 2018/11/16
    */
    @RequestMapping(value = "/listStandard", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listStandard(@RequestBody PageParameter parameter){
        PageBean<StandardInfoDO> standardInfoDOList = null;
        try {
            standardInfoDOList = standardInfoService.listStandardInfo(parameter);
            if(standardInfoDOList != null) {
                return ResultT.success(standardInfoDOList);
            }
        } catch (Exception e) {
            log.error("查询标准失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /**
    *@Description: 新增（标准）
    *@Param: [standardInfoDO]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangpengwei
    *@date: 2018/11/16
    */
    @RequestMapping(value = "/insertStandard", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertStandard(@RequestBody StandardInfoDO standardInfoDO ){
        Integer num = 0;
        try {
            num = standardInfoService.insertStandardInfo(standardInfoDO);
            if(num != null) {
                return ResultT.success(num);
            }
        } catch (Exception e) {
            log.error("添加标准失败", e);
        }
        return ResultT.failure(ResultCode.ADD_FAILURE);
    }

    /**
    *@Description: 更新（标准）
    *@Param: [standardInfoDO]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangpengwei
    *@date: 2018/11/16
    */
    @RequestMapping(value = "/updateStandard", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateStandard(@RequestBody StandardInfoDO standardInfoDO ){
        Integer num = 0;
        try {
            num = standardInfoService.updateStandardInfo(standardInfoDO);
            if(num != null) {
                return ResultT.success(num);
            }
        } catch (Exception e) {
            log.error("更新标准失败", e);
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

    /**
    *@Description: 删除（标准）
    *@Param: [standardInfoDO]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangpengwei
    *@date: 2018/11/16
    */
    @RequestMapping(value = "/deleteStandard", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteStandard(@RequestBody StandardInfoDO standardInfoDO ){
        Integer num = 0;
        try {
            num = standardInfoService.deleteStandardInfo(standardInfoDO);
            if(num != null) {
                return ResultT.success(num);
            }
        } catch (Exception e) {
            log.error("删除标准失败", e);
        }
        return ResultT.failure(ResultCode.DELETE_FAILURE);
    }

    /**
    *@Description: 根据主键或者名称获取（标准）
    *@Param: [standardInfoDO]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangpengwei
    *@date: 2018/11/16
    */
    @RequestMapping(value = "/getStandard", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getStandard(@RequestBody StandardInfoDO standardInfoDO ){
        StandardInfoDO standardInfo = null;
        try {
            standardInfo = standardInfoService.getStandardInfo(standardInfoDO);
            if(standardInfo != null) {
                return ResultT.success(standardInfo);
            }
        } catch (Exception e) {
            log.error("获取标准失败", e);
        }
        return ResultT.failure(ResultCode.GET_FAILURE);
    }
}
