package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.PersonWorkExpeService;
import com.ccicnavi.bims.resource.pojo.PersonWorkExpeDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/personworkexpe")
public class PersonWorkExpeController {

    private final static Logger log = LoggerFactory.getLogger(PersonWorkExpeController.class);

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20882")
    PersonWorkExpeService personWorkExpeService;

    /**
    *@description: 查询人员工作经历
    *@author: ChaiYanShun
    *@create: 2018/11/16 14:55
    *@Param PersonWorkExpeDO
    *@return ResultT
    */
    @RequestMapping(value="/listPersonWorkExpe", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listPersonWorkExpe(@RequestBody PersonWorkExpeDO personWorkExpeDO){
        try {
            List<PersonWorkExpeDO> personWorkExpeList = personWorkExpeService.listPersonWorkExpeDO(personWorkExpeDO);
            return ResultT.success(personWorkExpeList);
        } catch (Exception e) {
            log.debug("查询人员工作经历失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
    *@description: 新增人员工作经历
    *@author: ChaiYanShun
    *@create: 2018/11/16 14:58
    *@Param
    *@return
    */
    @RequestMapping(value="/insertPersonWorkExpe", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT insertPersonWorkExpe(@RequestBody PersonWorkExpeDO personWorkExpeDO){
        try {
            Integer num = personWorkExpeService.insertPersonWorkExpeDO(personWorkExpeDO);
            if(num != null && num != 0) {
                return ResultT.success();
            }
        } catch (Exception e) {
            log.debug("新增人员工作经历失败", e);
        }
        return ResultT.failure(ResultCode.ADD_FAILURE);
    }

    /**
    *@description: 修改人员工作经历
    *@author: ChaiYanShun
    *@create: 2018/11/16 15:01
    *@Param
    *@return
    */
    @RequestMapping(value="/updatePersonWorkExpe", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT updatePersonWorkExpe(@RequestBody PersonWorkExpeDO personWorkExpeDO){
        try {
            Integer num = personWorkExpeService.updatePersonWorkExpeDO(personWorkExpeDO);
            if(num != null && num != 0) {
                return ResultT.success();
            }
        } catch (Exception e) {
            log.debug("修改人员工作经历失败", e);
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

    /**
    *@description: 删除人员工作经历
    *@author: ChaiYanShun
    *@create: 2018/11/16 15:05
    *@Param
    *@return
    */
    @RequestMapping(value="/deletePersonWorkExpe", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT deletePersonWorkExpe(@RequestBody PersonWorkExpeDO personWorkExpeDO){
        try {
            Integer num = personWorkExpeService.deletePersonWorkExpeDO(personWorkExpeDO);
            if(num != null && num != 0) {
                return ResultT.success();
            }
        } catch (Exception e) {
            log.debug("删除人员工作经历失败", e);
        }
        return ResultT.failure(ResultCode.DELETE_FAILURE);
    }

    /**
    *@description: 根据主键查询人员工作经历
    *@author: ChaiYanShun
    *@create: 2018/11/16 15:11
    *@Param
    *@return
    */
    @RequestMapping(value="/getPersonWorkExpe", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getPersonWorkExpe(@RequestBody PersonWorkExpeDO personWorkExpeDO){
        try {
            PersonWorkExpeDO resultBean = personWorkExpeService.getPersonWorkExpeDO(personWorkExpeDO);
            if(resultBean != null) {
                return ResultT.success(resultBean);
            }
        } catch (Exception e) {
            log.debug("根据主键查询人员工作经历失败", e);
        }
        return ResultT.failure(ResultCode.GET_FAILURE);
    }

    /**@description: 分页查询人员工作经历
    *@author: ChaiYanShun
    *@create: 2018/11/16 20:20
    *@Param [pageParameter]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value="/getPersonWorkExpePage", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getPersonWorkExpePage(@RequestBody PageParameter<PersonWorkExpeDO> pageParameter){
        try {
            PageBean<PersonWorkExpeDO> personWorkExpePage = personWorkExpeService.getPersonWorkExpePage(pageParameter);
            return ResultT.success(personWorkExpePage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }
}
