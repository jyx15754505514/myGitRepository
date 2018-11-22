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

    @Reference(timeout = 30000,url = "dubbo://127.0.0.1:20884")
    TestItemService testItemService;

    @RequestMapping(value = "/list",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listTestItemDo(@RequestBody TestItemDO testItemDO){
        try {
            List<TestItemDO> testItemDOList=testItemService.listTestItemDo(testItemDO);
            return ResultT.success(testItemDOList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT saveTestItemDo(@RequestBody TestItemDO testItemDO){
        try {
            Integer num=testItemService.saveTestItemDo(testItemDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/remove",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT removeTestItemDo(@RequestBody TestItemDO testItemDO){
        try {
            Integer num=testItemService.removeTestItemDo(testItemDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT updateTestItemDo(@RequestBody TestItemDO testItemDO){
        try {
            Integer num=testItemService.updateTestItemDo(testItemDO);
            return ResultT.success(testItemDO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    @RequestMapping(value = "/get",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getTestItemDo(@RequestBody TestItemDO testItemDO){
        try {
            TestItemDO testItemDOResult=testItemService.getTestItemDo(testItemDO);
            return ResultT.success(testItemDOResult);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/listPage",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
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
