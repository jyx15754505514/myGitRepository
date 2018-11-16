package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.pojo.LogDO;
import com.ccicnavi.bims.system.service.api.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/* *
 * @Author MengZiJie
 * @Description 日志管理
 * @Date 9:16 2018/11/16
 */
@RestController
@RequestMapping("/log")
public class LogController {

    private final static Logger log = LoggerFactory.getLogger(LogController.class);

    @Reference(timeout = 30000,url = "dubbo://127.0.0.1:20881")
    LogService logService;

    /* *
     * @Author MengZiJie
     * @Description 查询日志
     * @Date 9:14 2018/11/16
     * @Param [logDO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/listLog",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listLog(@RequestBody LogDO logDO){
        ResultT resultT = new ResultT();
        List<LogDO> logDOS = null;
        try {
            logDOS = logService.listLog(logDO);
            return ResultT.success(logDOS);
        } catch (Exception e) {
            log.error("查询日志失败",e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

}
