package com.ccicnavi.bims.product.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.CategoryTypeService;
import com.ccicnavi.bims.product.pojo.CategoryDO;
import com.ccicnavi.bims.product.pojo.CategoryTypeDO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品类别的分类(categoryType)Controller
 * @author: WangYingLing
 * @create: 2018-11-21 17:54
 */
@RestController
@RequestMapping(value = "/categoryType")
public class CategoryTypeController {

    @Reference(timeout = 30000,url = "dubbo://127.0.0.1:20884")
    CategoryTypeService categoryTypeService;

    @RequestMapping(value = "/list",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listCategoryTypeDO(@RequestBody CategoryTypeDO categoryTypeDO){
        try {
            List<CategoryTypeDO> categoryTypeDOList=categoryTypeService.listCategoryTypeDO(categoryTypeDO);
            return ResultT.success(categoryTypeDOList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT saveCategoryTypeDO(@RequestBody CategoryTypeDO categoryTypeDO){
        try {
            Integer num=categoryTypeService.saveCategoryTypeDO(categoryTypeDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    @RequestMapping(value = "/remove",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT removeCategoryTypeDO(@RequestBody CategoryTypeDO categoryTypeDO){
        try {
            Integer num=categoryTypeService.removeCategoryTypeDO(categoryTypeDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT updateCategoryTypeDO(@RequestBody CategoryTypeDO categoryTypeDO){
        try {
            Integer num=categoryTypeService.updateCategoryTypeDO(categoryTypeDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    @RequestMapping(value = "/get",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getCategoryTypeDO(@RequestBody CategoryTypeDO categoryTypeDO){
        try {
            CategoryTypeDO categoryTypeDOResult=categoryTypeService.getCategoryTypeDO(categoryTypeDO);
            return ResultT.success(categoryTypeDOResult);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    @RequestMapping(value = "/listPage",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listCategoryTypePage(@RequestBody PageParameter<CategoryTypeDO> pageParameter){
        try {
            PageBean<CategoryTypeDO> pageBean=categoryTypeService.listCategoryTypePage(pageParameter);
            return ResultT.success(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

}
