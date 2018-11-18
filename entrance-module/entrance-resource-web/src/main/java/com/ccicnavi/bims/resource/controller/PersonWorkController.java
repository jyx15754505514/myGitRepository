package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.PersonWorkService;
import com.ccicnavi.bims.resource.pojo.PersonWorkDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/personwork")
public class PersonWorkController {

    private final static Logger log = LoggerFactory.getLogger(PersonWorkController.class);

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20882")
    PersonWorkService personWorkService;

    /**@description: 查询人员工作信息
    *@author: ChaiYanShun
    *@create: 2018/11/16 16:09
    *@Param [personWorkDO]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value="/listPersonWork", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listPersonWork(@RequestBody PersonWorkDO personWorkDO) {
        try {
            List<PersonWorkDO> personWorkDOList = personWorkService.listPersonWorkDO(personWorkDO);
            return ResultT.success(personWorkDOList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

      /**@description: 新增人员工作信息
      *@author: ChaiYanShun
      *@create: 2018/11/16 16:09
      *@Param [personWorkDO]
      *@return com.ccicnavi.bims.common.ResultT
      */
      @RequestMapping(value="/insertPersonWork", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
      public ResultT insertPersonWork(@RequestBody PersonWorkDO personWorkDO){
          try {
             Integer num = personWorkService.insertPersonWorkDO(personWorkDO);
              if(num != null && num != 0) {
                  return ResultT.success();
              }
          } catch (Exception e) {
              log.debug("新增人员工作信息失败", e);
          }
          return ResultT.failure(ResultCode.ADD_FAILURE);
      }

    /**@description: 修改人员工作信息
    *@author: ChaiYanShun
    *@create: 2018/11/16 16:12
    *@Param [personWorkDO]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value="/updatePersonWork", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT updatePersonWork(@RequestBody PersonWorkDO personWorkDO){
        try {
            Integer num = personWorkService.updatePersonWorkDO(personWorkDO);
            if(num != null && num != 0) {
                return ResultT.success();
            }
        } catch (Exception e) {
            log.debug("修改人员工作信息失败", e);
        }
        return  ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

    /**@description: 删除人员工作信息
    *@author: ChaiYanShun
    *@create: 2018/11/16 16:12
    *@Param [personWorkDO]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value="/deletePersonWork", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT deletePersonWork(@RequestBody PersonWorkDO personWorkDO){
        try {
            Integer num = personWorkService.deletePersonWorkDO(personWorkDO);
            if(num != null && num != 0) {
                return ResultT.success();
            }
        } catch (Exception e) {
            log.debug("删除人员工作信息失败", e);
        }
        return ResultT.failure(ResultCode.DELETE_FAILURE);
    }

    /**@description: 根据主键查询人员工作信息
    *@author: ChaiYanShun
    *@create: 2018/11/16 16:12
    *@Param [personWorkDO]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value="/getPersonWork", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getPersonWork(@RequestBody PersonWorkDO personWorkDO){
        try {
            PersonWorkDO resultBean = personWorkService.getPersonWorkDO(personWorkDO);
            if(resultBean != null) {
                return ResultT.success(resultBean);
            }
        } catch (Exception e) {
            log.debug("根据主键查询人员工作信息失败", e);
        }
        return ResultT.failure(ResultCode.GET_FAILURE);
    }

    /**@description: 分页查询人员工作信息
    *@author: ChaiYanShun
    *@create: 2018/11/16 17:39
    *@Param [pageParameter]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value="/getPersonWorkPage", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getPersonWorkPage(@RequestBody PageParameter<PersonWorkDO> pageParameter){
        try {
            PageBean<PersonWorkDO> personWorkPage = personWorkService.getPersonWorkPage(pageParameter);
            return ResultT.success(personWorkPage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }

    }
}
