package com.ccicnavi.bims.system.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.resource.api.PersonService;
import com.ccicnavi.bims.resource.pojo.PersonDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.util.List;

@Controller
@RequestMapping("person")
public class PersonController {

    @Reference(version = "1.0.0", timeout = 10000,url = "dubbo://127.0.0.1:20881")
    PersonService personService;

    ResultT resultT = new ResultT();

    @RequestMapping(value = "/list",method =  RequestMethod.GET)
    public ResultT listPerson(@RequestBody PersonDO personDO) {
        try {
            List<PersonDO> personDOS = personService.listPerson(personDO);
            resultT.setData(personDOS);
            resultT.success();
        } catch (Exception e) {
            e.printStackTrace();
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
