package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.pojo.RemindDO;
import com.ccicnavi.bims.system.service.api.RemindService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ccicnavi.bims.common.ResultCode.*;

/**
 * @program: bims-backend
 * @description: 设置提醒controller
 * @author: zqq
 * @create: 2018-11-15 15:34
 */

@RestController
@RequestMapping("/remind")
public class RemindController {

    @Reference(timeout = 3000,url = "dubbo://127.0.0.1:20881")
    private RemindService remindServic;

    /**
    *@Description: 查询提醒设置
    *@Param: sysRemind
    *@return: List<SysRemindDO>
    *@Author: zqq
    *@date: 2018/11/15
    */

    @RequestMapping(value = "/listRemind", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listRemind(@RequestBody RemindDO Remind){

        try {
            List<RemindDO> list = remindServic.listRemind(Remind);
            return ResultT.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.RENIND_LIST_RENINDLIST);
        }
    }
    /**
    *@Description: 新增提醒设置
    *@Param: sysRemind
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/15
    */

    @RequestMapping(value = "/insertRemind", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertRemind(@RequestBody RemindDO Remind){

        try {
            Integer num = remindServic.insertRemind(Remind);
            return ResultT.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.RENIND_LIST_RENINDINSERT);
        }
    }
    /**
    *@Description: 修改提醒设置
    *@Param: sysRemind
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/15
    */

    @RequestMapping(value = "/updateRemind", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateRemind(@RequestBody RemindDO Remind){
        try {
            Integer num = remindServic.updateRemind(Remind);
            return ResultT.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.RENIND_LIST_RENINDUPDATE);
        }
    }
    /**
    *@Description: 删除提醒设置
    *@Param: sysRemind
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/15
    */

    @RequestMapping(value = "/deleteRemind", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteRemind(@RequestBody RemindDO Remind){
        try {
            Integer num = remindServic.deleteRemind(Remind);
            return ResultT.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.RENIND_LIST_RENINDDELETE);
        }
    }
    /**
    *@Description: 根据主键查询提醒设置
    *@Param: sysRemind
    *@return: SysRemindDO
    *@Author: zqq
    *@date: 2018/11/15
    */

    @RequestMapping(value = "/getRemind", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getRemind(@RequestBody RemindDO remind){
        try {
            RemindDO remindDO= remindServic.getRemind(remind);
            return ResultT.success(remindDO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.RENIND_LIST_RENINDGET);
        }
    }
}
