package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.PersonTeachService;
import com.ccicnavi.bims.resource.pojo.PersonTeachDO;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/personTeach")
public class PersonTeachController {

    @Reference(timeout = 30000)
    PersonTeachService personTeachService;

    /*
     *@Param: [personTeachDO]
     *@description: 查询人员教育经历
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/16 10:31
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listPersonTeach(@RequestBody PersonTeachDO personTeachDO) {
        try {
            List<PersonTeachDO> personTeachDOS = personTeachService.listPersonTeach(personTeachDO);
            return ResultT.success(personTeachDOS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /*
     *@Param: [personTeachDO]
     *@description: 添加人员教育经历
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/16 11:20
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertPeronsTeach(@RequestBody PersonTeachDO personTeachDO) {
        try {
            Integer num = personTeachService.insertPersonTeach(personTeachDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /*
     *@Param: [personTeachDO]
     *@description: 更新用户教育信息
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/16 11:28
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updatePersonTeach(@RequestBody PersonTeachDO personTeachDO) {
        try {
            Integer num = personTeachService.updatePersonTeach(personTeachDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /*
     *@Param: [personTeachDO]
     *@description: 删除人员信息
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/16 14:47
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deletePersonTeach(@RequestBody PersonTeachDO personTeachDO) {
        try {
            Integer num = personTeachService.deletePersonTeach(personTeachDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    /*
     *@Param: [pageParameter]
     *@description: 根据条件 查询人员教育经历分页数据
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/16 15:46
     */
    @RequestMapping(value = "/listPage", method = RequestMethod.POST, produces = "application/json;charset:UTF-8")
    public ResultT getPagePersonTeach(@RequestBody PageParameter<PersonTeachDO> pageParameter) {
        try {
            PageBean<PersonTeachDO> pagePerson = personTeachService.getPagePersonTeach(pageParameter);
            return ResultT.success(pagePerson);
        } catch (Exception e) {
            return  ResultT.failure(ResultCode.LIST_FAILURE);
        }

    }



}
