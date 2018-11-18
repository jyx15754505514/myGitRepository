package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.RemindDO;
import com.ccicnavi.bims.system.pojo.RemindDTO;
import com.ccicnavi.bims.system.service.api.RemindService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger log = LoggerFactory.getLogger(RemindController.class);
    @Reference(timeout = 3000,url = "dubbo://127.0.0.1:20881")
    private RemindService remindServic;

    /**
    *@Description: 查询提醒设置
    *@Param: PageParameter
    *@return: PageBean<RemindDO>
    *@Author: zqq
    *@date: 2018/11/15
    */

    @RequestMapping(value = "/listRemind", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listRemind(@RequestBody PageParameter<RemindDO>  PageParameter){

        try {
            PageBean<RemindDO> pageBean = remindServic.listRemind(PageParameter);
            return ResultT.success(pageBean);
        } catch (Exception e) {
            log.error("根据条件查询提醒设置失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
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
            log.error("新增提醒设置失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
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
            log.error("修改提醒设置失败", e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
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
            log.error("删除提醒设置失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
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
            log.error("根据主键查询提醒设置失败", e);
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }
    /**
    *@Description: 连表查询设置提醒
    *@Param: PageParameter
    *@return: PageBean<RemindDTO>
    *@Author: zqq
    *@date: 2018/11/16
    */

    @RequestMapping(value = "/lisrRemindOrg", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT lisrRemindOrg(@RequestBody PageParameter<RemindDO>  PageParameter){
        try {
            PageBean<RemindDTO> pageBean = remindServic.listRemindOrg(PageParameter);
            return ResultT.success(pageBean);
        } catch (Exception e) {
            log.error("查询提醒设置失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }
}
