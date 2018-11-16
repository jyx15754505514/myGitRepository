package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.resource.api.PersonService;
import com.ccicnavi.bims.resource.pojo.PersonDO;
import com.ccicnavi.bims.system.controller.NotworkdayController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final static Logger log = LoggerFactory.getLogger(NotworkdayController.class);

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20882")
    PersonService personService;

    ResultT resultT = new ResultT();

    /*
    *@program: [personDO]
    *@description: 该类的作用描述
    *@author: wanggengxiang
    *@create: 2018/11/16
    */
    @RequestMapping(value = "/list",method =  RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listPerson(@RequestBody PersonDO personDO) {
        try {
            List<PersonDO> personDOS = personService.listPerson(personDO);
            resultT.setData(personDOS);
            resultT.success();
        } catch (Exception e) {
            log.debug("根据条件查询人员失败", e);
            //请求失败返回并设置错误信息
            return ResultT.failure(ResultCode.RESULE_DATA_NONE);
        }
        return resultT;
    }

    @RequestMapping(value = "/add",method =  RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT inserPerson(@RequestBody PersonDO personDO) {
        try {
            Integer num = personService.insertPerson(personDO);
            resultT.setData(num);
            resultT.success();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultT;
    }

    @RequestMapping(value = "/update",method =  RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public  ResultT updatePerson(@RequestBody PersonDO personDO){
        try {
            Integer num = personService.updatePerson(personDO);
            resultT.setData(num);
            resultT.success();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultT;
    }

    @RequestMapping(value = "/delete",method =  RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public  ResultT deletePerson(@RequestBody PersonDO personDO){
        try {
            Integer num = personService.deletePerson(personDO);
            resultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  resultT;
    }


}
