package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.LogDO;
import com.ccicnavi.bims.system.pojo.LogDTO;
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
    public ResultT listLog(@RequestBody PageParameter<LogDTO> pageParameter){
        ResultT resultT = new ResultT();
        PageBean<LogDTO> logDOS = null;
        try {
            logDOS = logService.listLog(pageParameter);
            return ResultT.success(logDOS);
        } catch (Exception e) {
            log.error("查询日志失败",e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }


   /* *
    * @Author MengZiJie
    * @Description 获取日志失败
    * @Date 14:06 2018/11/16
    * @Param [logDO]
    * @Return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value = "/getLog",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getLog(@RequestBody LogDO logDO){
        ResultT resultT = new ResultT();
        LogDO logDOS = null;
        try {
            logDOS = logService.getLog(logDO);
            return ResultT.success(logDOS);
        } catch (Exception e) {
            log.error("获取日志失败",e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    /* *
     * @Author MengZiJie
     * @Description 新增日志
     * @Date 14:07 2018/11/16
     * @Param [logDO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/insertLog",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertLog(@RequestBody LogDO logDO){
        ResultT resultT = new ResultT();
        Integer logDOS = null;
        try {
            logDOS = logService.insertLog(logDO);
            return ResultT.success();
        } catch (Exception e) {
            log.error("新增日志失败",e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /* *
     * @Author MengZiJie
     * @Description 更新日志
     * @Date 14:09 2018/11/16
     * @Param [logDO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/updateLog",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateLog(@RequestBody LogDO logDO){
        ResultT resultT = new ResultT();
        Integer logDOS = null;
        try {
            logDOS = logService.updateLog(logDO);
            return ResultT.success();
        } catch (Exception e) {
            log.error("更新日志失败",e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /* *
     * @Author MengZiJie
     * @Description 删除日志
     * @Date 14:10 2018/11/16
     * @Param [logDO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/deleteLog",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteLog(@RequestBody LogDO logDO){
        ResultT resultT = new ResultT();
        Integer logDOS = null;
        try {
            logDOS = logService.deleteLog(logDO);
            return ResultT.success();
        } catch (Exception e) {
            log.error("删除日志失败",e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

}
