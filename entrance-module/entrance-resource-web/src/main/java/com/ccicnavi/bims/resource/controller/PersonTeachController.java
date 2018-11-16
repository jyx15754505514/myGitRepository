package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.resource.api.PersonTeachService;
import com.ccicnavi.bims.resource.pojo.PersonTeachDO;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/personTeach")
public class PersonTeachController {

    @Reference(timeout = 30000,url =  "dubbo://127.0.0.1:20882")
    PersonTeachService personTeachService;

    ResultT resultT = new ResultT();

    /*
    *@Param: [personTeachDO]
    *@description: 查询人员教育经历
    *@return: com.ccicnavi.bims.common.ResultT
    *@author: WangGengXiang
    *@create: 2018/11/16 10:31
    */
    @RequestMapping(value = "/list",method = RequestMethod.POST,produces =  "application/json;charset=UTF-8")
    public ResultT listPersonTeach(@RequestBody PersonTeachDO personTeachDO){
        try {
            List<PersonTeachDO> personTeachDOS = personTeachService.listPersonTeach(personTeachDO);
            resultT.setData(personTeachDOS);
            resultT.success();
            return resultT;
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /*
    *@Param: [personTeachDO]
    *@description: 添加人员教育经历
    *@return: com.ccicnavi.bims.common.ResultT
    *@author: WangGengXiang
    *@create: 2018/11/16 11:20
    */
    @RequestMapping(value = "/add",method =  RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public  ResultT insertPeronsTeach(@RequestBody PersonTeachDO personTeachDO){
        try {
            Integer num  = personTeachService.insertPersonTeach(personTeachDO);
            resultT.setData(num);
            resultT.success();
            return resultT;
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /*
    *@Param: [personTeachDO]
    *@description: 更新用户教育信息
    *@return: com.ccicnavi.bims.common.ResultT
    *@author: WangGengXiang
    *@create: 2018/11/16 11:28
    */
    @RequestMapping(value = "/update",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT updatePersonTeach(@RequestBody PersonTeachDO personTeachDO){
        try {
            Integer num  = personTeachService.updatePersonTeach(personTeachDO);
            resultT.setData(num);
            resultT.success();
            return  resultT;
        } catch (Exception e) {
            e.printStackTrace();
            return  resultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /*
    *@Param: [personTeachDO]
    *@description: 删除用户信息
    *@return: com.ccicnavi.bims.common.ResultT
    *@author: WangGengXiang
    *@create: 2018/11/16 11:31
    */
    @RequestMapping(value =  "/delete",method =  RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public  ResultT deletePersonTeach(@RequestBody PersonTeachDO personTeachDO){
        try {
            Integer num  = personTeachService.insertPersonTeach(personTeachDO);
            resultT.setData(num);
            resultT.success();
            return  resultT;
        } catch (Exception e) {
            e.printStackTrace();
            return  resultT.failure(ResultCode.DELETE_FAILURE);
        }
    }




}
