package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.SealService;
import com.ccicnavi.bims.resource.pojo.SealDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: bims-backend
 * @description: （封识）增删改查
 * @author: zhangpengwei
 * @create: 2018-11-15 21:55
 */
@RestController
@RequestMapping("/seal")
@Slf4j
public class SealController {

    @Reference(timeout = 30000)
    private SealService sealService;


    /*
    *@Description: 查询封识
    *@Param: [parameter]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangpengwei
    *@date: 2018/11/16
    */
    @RequestMapping(value = "/listSeal", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listSeal(@RequestBody PageParameter parameter){
        PageBean<SealDO> sealDOList = null;
        try {
            sealDOList = sealService.listSeal(parameter);
            if(sealDOList != null){
                return ResultT.success(sealDOList);
            }
        } catch (Exception e) {
            log.error("查询封识失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /*
    *@Description: 添加封识
    *@Param: [sealDO]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangpengwei
    *@date: 2018/11/16
    */
    @RequestMapping(value = "/insertSeal", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertSeal(@RequestBody SealDO sealDO ){
        Integer num = 0;
        try {
            num = sealService.insertSeal(sealDO);
            if(num != null){
                return ResultT.success(ResultCode.SUCCESS);
            }
        } catch (Exception e) {
            log.error("添加封识失败", e);
        }
        return ResultT.failure(ResultCode.ADD_FAILURE);
    }

    /*
    *@Description: 修改封识
    *@Param: [sealDO]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangpengwei
    *@date: 2018/11/16
    */
    @RequestMapping(value = "/updateSeal", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateSeal(@RequestBody SealDO sealDO ){
        Integer num = 0;
        try {
            num = sealService.updateSeal(sealDO);
            if(num != null){
                return ResultT.success(ResultCode.SUCCESS);
            }
        } catch (Exception e) {
            log.error("修改封识失败", e);
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

    /*
    *@Description: 删除封识
    *@Param: [sealDO]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangpengwei
    *@date: 2018/11/16
    */
    @RequestMapping(value = "/deleteSeal", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteSeal(@RequestBody SealDO sealDO ){
        Integer num = 0;
        try {
            num = sealService.deleteSeal(sealDO);
            if(num != null){
                return ResultT.success(ResultCode.SUCCESS);
            }
        } catch (Exception e) {
            log.error("删除封识失败", e);
        }
        return ResultT.failure(ResultCode.DELETE_FAILURE);
    }

    /*
    *@Description: 获取封识
    *@Param: [sealDO]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangpengwei
    *@date: 2018/11/16
    */
    @RequestMapping(value = "/getSeal", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getSeal(@RequestBody SealDO sealDO ){
        SealDO seal = null;
        try {
            seal = sealService.getSeal(sealDO);
            if(seal != null){
                return ResultT.success(seal);
            }
        } catch (Exception e) {
            log.error("获取封识失败", e);
        }
        return ResultT.failure(ResultCode.GET_FAILURE);
    }
}