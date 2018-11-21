package com.ccicnavi.bims.resource.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.CatalogService;
import com.ccicnavi.bims.product.pojo.CatalogDO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品线信息(Catalog)Controller
 * @author: WangYingLing
 * @create: 2018-11-21 12:02
 */
@RestController
@RequestMapping(value = "/catalog")
public class CatalogController {

    @Reference(timeout = 30000,url = "dubbo://127.0.0.1:20884")
    CatalogService catalogService;

    /**
     * @description 查询全部产品线信息
     * @param catalogDO
     * @return com.ccicnavi.bims.common.ResultT
     * @author WangYingLing
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listCatalogDO(@RequestBody CatalogDO catalogDO){
        try {
            List<CatalogDO> catalogDOList=catalogService.listCatalogDO(catalogDO);
            return ResultT.success(catalogDOList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
     * @description 新增产品线信息
     * @param catalogDO
     * @return com.ccicnavi.bims.common.ResultT
     * @author WangYingLing
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT saveCatalogDO(@RequestBody CatalogDO catalogDO){
        try {
            Integer num=catalogService.saveCatalogDO(catalogDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
     * @description 删除产品线信息
     * @param catalogDO
     * @return com.ccicnavi.bims.common.ResultT
     * @author WangYingLing
     */
    @RequestMapping(value = "/remove",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT removeCatalogDO(@RequestBody CatalogDO catalogDO){
        try {
            Integer num=catalogService.removeCatalogDO(catalogDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    /**
     * @description 查询修改产品线信息
     * @param catalogDO
     * @return com.ccicnavi.bims.common.ResultT
     * @author WangYingLing
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT updateCatalogDO(@RequestBody CatalogDO catalogDO){
        try {
            Integer num=catalogService.updateCatalogDO(catalogDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /**
     * @description 根据主键获取产品线信息
     * @param catalogDO
     * @return com.ccicnavi.bims.common.ResultT
     * @author WangYingLing
     */
    @RequestMapping(value = "/get",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getCatalogDO(@RequestBody CatalogDO catalogDO){
        try {
            CatalogDO catalogDOResult=catalogService.getCatalogDO(catalogDO);
            return ResultT.success(catalogDOResult);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    /**
     * @description 分页查询产品线信息
     * @param pageParameter
     * @return com.ccicnavi.bims.common.ResultT
     * @author WangYingLing
     */
    @RequestMapping(value = "/listPage",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listCatalogPage(@RequestBody PageParameter<CatalogDO> pageParameter){
        try {
            PageBean<CatalogDO> catalogDOPageBean=catalogService.listCatalogPage(pageParameter);
            return ResultT.success(catalogDOPageBean);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }



}
