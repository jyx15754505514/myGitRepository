package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.PersonCultExpeService;
import com.ccicnavi.bims.resource.pojo.PersonCultExpeDO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personCultExpe")
public class PersonCultExpeController {

    //private final static Logger log = LoggerFactory.getLogger(PersonCultExpeController.class);

    @Reference(timeout = 30000)
    PersonCultExpeService personCultExpeService;

    /*
    *@program: [personCultExpe]
    *@description: 查询人员培训经历
    *@return: com.ccicnavi.bims.common.ResultT
    *@author: XiaWei
    *@create: 2018/11/16 10:20
    */
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listPersonCultExpe(@RequestBody (required=false) PersonCultExpeDO personCultExpe) {
        try {
            List<PersonCultExpeDO> personCultExpes = personCultExpeService.listPersonCultExpe(personCultExpe);
            return ResultT.success(personCultExpes);
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /*
    *@program: [personCultExpe]
    *@description: 新增人员培训经历
    *@return: com.ccicnavi.bims.common.ResultT
    *@author: XiaWei
    *@create: 2018/11/16 10:21
    */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertPersonCultExpe(@RequestBody PersonCultExpeDO personCultExpe) {
        try {
            Integer num = personCultExpeService.insertPersonCultExpe(personCultExpe);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /*
    *@program: [personCultExpe]
    *@description: 更新人员培训经历
    *@return: com.ccicnavi.bims.common.ResultT
    *@author: XiaWei
    *@create: 2018/11/16 10:23
    */
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updatePersonCultExpe(@RequestBody PersonCultExpeDO personCultExpe) {
        try {
            Integer num = personCultExpeService.updatePersonCultExpe(personCultExpe);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /*
    *@program: [personCultExpe]
    *@description: 删除人员培训经历
    *@return: com.ccicnavi.bims.common.ResultT
    *@author: XiaWei
    *@create: 2018/11/16 10:23
    */
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deletePersonCultExpe(@RequestBody PersonCultExpeDO personCultExpe) {
        try {
            Integer num = personCultExpeService.deletePersonCultExpe(personCultExpe);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    /*
    *@program: [personCultExpe]
    *@description: 根据主键获取人员培训经历
    *@return: com.ccicnavi.bims.common.ResultT
    *@author: XiaWei
    *@create: 2018/11/16 18:11
    */
    @RequestMapping(value = "/getPersonCultExpe", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getPersonCultExpeDO(@RequestBody PersonCultExpeDO personCultExpe) {
        try {
            PersonCultExpeDO personCultExpeDO = personCultExpeService.getPersonCultExpe(personCultExpe);
            return ResultT.success(personCultExpeDO);
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    /*
    *@program: [pageParameter]
    *@description: 根据条件 查询人员培训经历分页数据
    *@return: com.ccicnavi.bims.common.ResultT
    *@author: XiaWei
    *@create: 2018/11/16 17:49
    */
    @RequestMapping(value = "/listPage", method = RequestMethod.POST, produces = "application/json;charset:UTF-8")
    public ResultT getPagePersonCultExpe(@RequestBody PageParameter<PersonCultExpeDO> pageParameter) {
        try {
            PageBean<PersonCultExpeDO> pagePersonCultExpe = personCultExpeService.getPagePersonCultExpe(pageParameter);
            return ResultT.success(pagePersonCultExpe);
        } catch (Exception e) {
            return  ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }
}
