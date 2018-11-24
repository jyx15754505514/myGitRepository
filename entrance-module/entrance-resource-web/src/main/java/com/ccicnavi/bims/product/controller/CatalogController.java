package com.ccicnavi.bims.product.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.CatalogOrgService;
import com.ccicnavi.bims.product.api.CatalogService;
import com.ccicnavi.bims.product.pojo.CatalogDO;
import com.ccicnavi.bims.product.pojo.CatalogOrgDO;
import com.ccicnavi.bims.product.pojo.CatalogOrgDTO;
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

    @Reference(timeout = 30000)
    CatalogService catalogService;
    @Reference(timeout = 30000)
    CatalogOrgService catalogOrgService;


    /**
     * @description 查询全部产品线信息
     * @param catalogDO
     * @return com.ccicnavi.bims.common.ResultT
     * @author WangYingLing
     */
    @RequestMapping(value = "/listCatalog",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listCatalog(@RequestBody CatalogDO catalogDO){
        try {
            List<CatalogDO> catalogDOList=catalogService.listCatalog(catalogDO);
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
    @RequestMapping(value = "/saveCatalog",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT saveCatalog(@RequestBody CatalogDO catalogDO){
        try {
            Integer num=catalogService.saveCatalog(catalogDO);
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
    @RequestMapping(value = "/removeCatalog",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT removeCatalog(@RequestBody CatalogDO catalogDO){
        try {
            Integer num=catalogService.removeCatalog(catalogDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    /**
     * @description 修改产品线信息
     * @param catalogDO
     * @return com.ccicnavi.bims.common.ResultT
     * @author WangYingLing
     */
    @RequestMapping(value = "/updateCatalog",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT updateCatalog(@RequestBody CatalogDO catalogDO){
        try {
            Integer num=catalogService.updateCatalog(catalogDO);
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
    @RequestMapping(value = "/getCatalog",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getCatalog(@RequestBody CatalogDO catalogDO){
        try {
            CatalogDO catalogDOResult=catalogService.getCatalog(catalogDO);
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
    @RequestMapping(value = "/listCatalogPage",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listCatalogPage(@RequestBody PageParameter<CatalogDO> pageParameter){
        try {
            PageBean<CatalogDO> catalogDOPageBean=catalogService.listCatalogPage(pageParameter);
            return ResultT.success(catalogDOPageBean);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
     * @description 根据组织id查询产品线信息
     * @param catalogOrgDO
     * @return com.ccicnavi.bims.common.ResultT
     * @author WangYingLing
     */
    @RequestMapping(value = "/getCatalogByOrgUUid",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getCatalogByOrgUUid(@RequestBody CatalogOrgDO catalogOrgDO){
        try {
            List<CatalogDO> catalogDOList=catalogService.getCatalogByOrgUUid(catalogOrgDO);
            return ResultT.success(catalogDOList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    /**
     * @Author guojinxu
     * @Description 组织机构与产品线关系查询
     * @Date 2018/11/22 15:17
     * @Param [catalogOrgDO]
     * @return com.ccicnavi.bims.common.ResultT
     **/
    @RequestMapping(value = "/listCatalogOrgDO",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listCatalogOrgDO(@RequestBody CatalogOrgDO catalogOrgDO){
        try {
            List<CatalogOrgDO> catalogOrgDOList = catalogOrgService.listCatalogOrgDO(catalogOrgDO);
            return ResultT.success(catalogOrgDOList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    /**
     * @Author guojinxu
     * @Description 更新组织机构与产品线间的关系
     * @Date 2018/11/22 15:23
     * @Param [catalogOrgDTO]
     * @return com.ccicnavi.bims.common.ResultT
     **/
    @RequestMapping(value = "/updateCatalogOrgDO",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT updateCatalogOrgDO(@RequestBody CatalogOrgDTO catalogOrgDTO){
        try {
            int num = catalogOrgService.updateCatalogOrgDO(catalogOrgDTO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.RENEW_FAILURE);
        }
    }




}
