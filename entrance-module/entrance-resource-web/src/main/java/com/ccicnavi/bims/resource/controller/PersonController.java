package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.PersonService;
import com.ccicnavi.bims.resource.pojo.PersonDO;
import com.ccicnavi.bims.resource.pojo.PersonDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

//    private final static Logger log = LoggerFactory.getLogger(PersonDO.class);

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20882")
    PersonService personService;

    /*
     *@program: [personDO]
     *@description: 查询人员信息
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/16 9:29
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listPerson(@RequestBody PersonDO personDO) {
        try {
            List<PersonDO> personDOS = personService.listPerson(personDO);
            return ResultT.success(personDOS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }


    /*
     *@program: [personDO]
     *@description: 添加人员
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/16 9:30
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT inserPerson(@RequestBody PersonDO personDO) {
        try {
            Integer num = personService.insertPerson(personDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }

    }

    /*
     *@program: [personDO]
     *@description: 更新人员
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/16 9:30
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updatePerson(@RequestBody PersonDO personDO) {
        try {
            Integer num = personService.updatePerson(personDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /*
     *@program: [personDO]
     *@description: 删除人员
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/16 9:30
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deletePerson(@RequestBody PersonDO personDO) {
        try {
            Integer num = personService.deletePerson(personDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    /*
     *@Param: [pageParameter]
     *@description: 根据条件 查询人员分页数据
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/16 15:46
     */
    @RequestMapping(value = "/listPage", method = RequestMethod.POST, produces = "application/json;charset:UTF-8")
    public ResultT getPagePerson(@RequestBody PageParameter<PersonDO> pageParameter) {
        try {
            PageBean<PersonDO> pagePerson = personService.getPagePerson(pageParameter);
            return ResultT.success(pagePerson);
        } catch (Exception e) {
            return  ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

}
