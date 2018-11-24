package com.ccicnavi.bims.product.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.TestItemService;
import com.ccicnavi.bims.product.pojo.TestItemDO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 检测指标(testItem)Controller
 * @author: WangYingLing
 * @create: 2018-11-21 16:21
 */
@RestController
@RequestMapping(value = "/testItem")
public class TestItemController {

    @Reference(timeout = 30000)
    TestItemService testItemService;

    @RequestMapping(value = "/listTestItem",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listTestItem(@RequestBody TestItemDO testItemDO){
        try {
            List<TestItemDO> testItemDOList=testItemService.listTestItem(testItemDO);
            return ResultT.success(testItemDOList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    @RequestMapping(value = "/saveTestItem",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT saveTestItem(@RequestBody TestItemDO testItemDO){
        try {
            Integer num=testItemService.saveTestItem(testItemDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/removeTestItem",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT removeTestItem(@RequestBody TestItemDO testItemDO){
        try {
            Integer num=testItemService.removeTestItem(testItemDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/updateTestItem",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT updateTestItem(@RequestBody TestItemDO testItemDO){
        try {
            Integer num=testItemService.updateTestItem(testItemDO);
            return ResultT.success(testItemDO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    @RequestMapping(value = "/getTestItem",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getTestItem(@RequestBody TestItemDO testItemDO){
        try {
            TestItemDO testItemDOResult=testItemService.getTestItem(testItemDO);
            return ResultT.success(testItemDOResult);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/listTestItemPage",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listTestItemPage(@RequestBody PageParameter<TestItemDO> pageParameter){
        try {
            PageBean<TestItemDO> testItemDOPageBean=testItemService.listTestItemPage(pageParameter);
            return ResultT.success(testItemDOPageBean);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

}
