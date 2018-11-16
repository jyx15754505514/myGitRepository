package com.ccicnavi.bims.system.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.pojo.SettingDO;
import com.ccicnavi.bims.system.service.api.SettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 系统设置的Controller层
 * @author: zhangxingbiao
 * @create: 2018-11-15 19:38
 */
@RestController
@RequestMapping(value = "/Set")
public class SettingController {

    private final static Logger log = LoggerFactory.getLogger(SettingController.class);

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20881")
    SettingService settingService;

    @RequestMapping(value = "/listSetting", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listSetting(@RequestBody SettingDO settingDO) {
        List<SettingDO> set = null;
        try {
            set = settingService.listSetting(settingDO);
            return ResultT.success(set);
        } catch (Exception e) {
            log.error("根据条件查询系统信息失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    @RequestMapping(value = "/getSetting", method = RequestMethod.POST)
    public ResultT getSetting(@RequestBody SettingDO settingDO) {
        SettingDO settingDO1 = null;
        try {
            settingDO1 = settingService.getSetting(settingDO);
            return ResultT.success(settingDO1);
        } catch (Exception e) {
            log.error("根据主键查询系统设置信息失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }

    }

    @RequestMapping(value = "/insertSetting", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertSetting(@RequestBody SettingDO settingDO) {
        Integer integer = null;
        try {
            integer = settingService.insertSetting(settingDO);
            return ResultT.success(settingDO);
        } catch (Exception e) {
            log.error("新增系统设置信息失败",e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }

    }

    @RequestMapping(value = "/updateSetting", method = RequestMethod.POST)
    public ResultT updateSetting(@RequestBody SettingDO settingDO) {
        Integer integer = null;
        try {
            integer = settingService.updateSetting(settingDO);
            return ResultT.success(settingDO);
        } catch (Exception e) {
            log.error("更新系统设置信息失败", e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }

    }

    @RequestMapping(value = "/deleteSetting", method = RequestMethod.POST)
    public ResultT deleteSetting(@RequestBody SettingDO settingDO) {
        Integer integer = null;
        try {
            integer = settingService.deleteSetting(settingDO);
            return ResultT.success(settingDO);
        } catch (Exception e) {
            log.error("删除系统设置信息失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }

    }
}
