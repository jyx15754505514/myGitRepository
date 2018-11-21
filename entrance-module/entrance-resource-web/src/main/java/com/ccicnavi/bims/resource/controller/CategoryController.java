package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.CategoryService;
import com.ccicnavi.bims.product.pojo.CategoryDO;
import com.ccicnavi.bims.product.pojo.CategoryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品分类管理
 * @author: LiJie
 * @create: 2018-11-21 11:29
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final static Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20884")
    CategoryService categoryService;

    /**
     * 查询全部产品分类信息()
     *
     * @return
     */
    @RequestMapping(value = "/listAllCategory", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listAllCategory(@RequestBody CategoryDO category) {
        try {
            List<CategoryDO> CustInvoiceList = categoryService.listCategory(category);
            return ResultT.success(CustInvoiceList);
        } catch (Exception e) {
            log.error("查询产品分类信息失败~", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }


    /**
     * 查询全部产品分类信息()
     * @return
     */
    @RequestMapping(value = "/listCategoryPage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listCategoryPage(@RequestBody PageParameter<CategoryDO> pageParameter) {
        try {
            PageBean<CategoryDO> categoryList = categoryService.listCategoryPage(pageParameter);
            return ResultT.success(categoryList);
        } catch (Exception e) {
            log.error("分页查询产品分类信息失败~", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }



    /**
     * 根据所属公司机构和业务线查询出一级产业分类
     *
     * @return
     */
    @RequestMapping(value = "/listCategoryFirstByOrgAndProd", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listCategoryFirstByOrgAndProd(@RequestBody CategoryDTO categoryDTO) {
        try {
            List<CategoryDO> CustInvoiceList = categoryService.listCategoryFirstByOrgAndProd(categoryDTO);
            return ResultT.success(CustInvoiceList);
        } catch (Exception e) {
            log.error(" 根据所属公司机构和业务线查询出一级产业分类~", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
     * 根据父级ID查询出子级产业分类
     *
     * @return
     */
    @RequestMapping(value = "/listCategoryByParentUuid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listCategoryByParentUuid(@RequestBody CategoryDTO categoryDTO) {
        try {
            List<CategoryDO> CustInvoiceList = categoryService.listCategoryByParentUuid(categoryDTO);
            return ResultT.success(CustInvoiceList);
        } catch (Exception e) {
            log.error("根据父级ID查询出子级产业分类~", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }


    /**
     * 根据主键查询对应产业分类信息
     *
     * @param categoryDO
     * @return
     */
    @RequestMapping(value = "/getCategory", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getCategory(@RequestBody CategoryDO categoryDO) {
        if (StringUtils.isEmpty(categoryDO.getProductCategoryUuid())) {
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            CategoryDO customer = categoryService.getCategory(categoryDO);
            if (customer != null) {
                return ResultT.success(customer);
            }
        } catch (Exception e) {
            log.error("根据主键查询产业分类失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }


    /**
     * 保存产业分类信息
     *
     * @param categoryDO
     * @return
     */
    @RequestMapping(value = "/saveCategory", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT saveCategory(@RequestBody CategoryDO categoryDO) {
        try {
            Integer count = categoryService.saveCategory(categoryDO);
            if (count > 0) {
                return ResultT.success("新增产业分类成功");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("新增产业分类失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
     * 修改产业分类信息
     *
     * @param categoryDO
     * @return
     */
    @RequestMapping(value = "/updateCategory", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateCustomer(@RequestBody CategoryDO categoryDO) {
        try {
            Integer count = categoryService.updateCategory(categoryDO);
            if (count > 0) {
                return ResultT.success("修改产业分类成功");
            } else {
                return ResultT.failure(ResultCode.UPDATE_FAILURE);
            }
        } catch (Exception e) {
            log.error("修改产业分类失败", e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }


    /**
     * 删除产业分类信息
     * @return
     */
    @RequestMapping(value = "/removeCategory", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT removeCategory(@RequestBody CategoryDTO categoryDTO) {
        try {
            if (StringUtils.isEmpty(categoryDTO.getProductCategoryUuid())) {
                return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            } else {
                Integer count = categoryService.removeCategory(categoryDTO);
                if (count > 0) {
                    return ResultT.success("删除产业分类成功");
                } else {
                    return ResultT.failure(ResultCode.DELETE_FAILURE);
                }
            }
        } catch (Exception e) {
            log.error("删除产业分类信息失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }


}
