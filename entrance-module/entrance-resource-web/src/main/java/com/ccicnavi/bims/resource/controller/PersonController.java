package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.resource.api.PersonService;
import com.ccicnavi.bims.resource.pojo.PersonDO;
import com.ccicnavi.bims.system.controller.NotworkdayController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("person")
public class PersonController {

    private final static Logger log = LoggerFactory.getLogger(NotworkdayController.class);

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20881")
    PersonService personService;

    ResultT resultT = new ResultT();

    @RequestMapping(value = "/list",method =  RequestMethod.GET)
    public ResultT listPerson(@RequestBody PersonDO personDO) {
        try {
            List<PersonDO> personDOS = personService.listPerson(personDO);
            resultT.success(personDOS);
        } catch (Exception e) {
            log.debug("根据条件查询人员失败", e);
            //请求失败返回并设置错误信息
            return ResultT.failure(ResultCode.NOTWORKDAY_LIST_NOTWORKDAY);
        }
        return resultT;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
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

    @PostMapping("/update")
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

    @PostMapping("/delete")
    public  ResultT deletePerson(@RequestBody PersonDO personDO){
        try {
            Integer num = personService.deletePerson(personDO);
            resultT.success();
            resultT.setData(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  resultT;
    }


}
