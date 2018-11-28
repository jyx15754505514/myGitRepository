package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.ConstantCode;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.RemindDO;
import com.ccicnavi.bims.system.pojo.RemindDTO;
import com.ccicnavi.bims.system.service.api.RemindService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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
@Slf4j
public class RemindController {


    @Reference
    private RemindService remindServic;
    @Reference
    IdWorkerService idWorkerService;
    /**
    *@Description: 查询提醒设置
    *@Param: PageParameter
    *@return: PageBean<RemindDO>
    *@Author: zqq
    *@date: 2018/11/15
    */

    @RequestMapping(value = "/listRemind", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listRemind(@RequestBody PageParameter<RemindDTO>  PageParameter){

        try {
            PageBean<RemindDTO> pageBean = remindServic.listRemind(PageParameter);
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

    @RequestMapping(value = "/saveRemind", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertRemind(@RequestBody RemindDTO remind){

        try {
            if(StringUtils.isEmpty(remind.getRemindUuid())){
                String uuid =idWorkerService.getId(new Date());
                remind.setRemindUuid(uuid);
                Integer num = remindServic.insertRemind(remind);
            }else{
                Integer num =remindServic.updateRemind(remind);
            }
            return ResultT.success("保存提醒设置成功");
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
    public ResultT updateRemind(@RequestBody RemindDTO Remind){
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
    public ResultT deleteRemind(@RequestBody RemindDTO Remind){
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
    public ResultT getRemind(@RequestBody RemindDTO remind){
        try {
            RemindDTO remindDTO= remindServic.getRemind(remind);
            return ResultT.success(remindDTO);
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
    public ResultT lisrRemindOrg(@RequestBody PageParameter<RemindDTO>  PageParameter){
        try {
            PageBean<RemindDTO> pageBean = remindServic.listRemindOrg(PageParameter);
            return ResultT.success(pageBean);
        } catch (Exception e) {
            log.error("查询提醒设置失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
    *@Description: 查询提醒设置
    *@Param: remindDTO
    *@return: List<RemindDTO>
    *@Author: zqq
    *@date: 2018/11/28
    */

    @RequestMapping(value = "/listRemindList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listRemindList(@RequestBody RemindDTO  remindDTO){

        try {
            remindDTO.setDictParentUuid(ConstantCode.DICT_PARENT_UUID);
            List<RemindDTO> list = remindServic.listRemindList(remindDTO);
            return ResultT.success(list);
        } catch (Exception e) {
            log.error("根据条件查询提醒设置失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }

    }
}
