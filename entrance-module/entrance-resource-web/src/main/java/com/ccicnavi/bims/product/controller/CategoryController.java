package com.ccicnavi.bims.product.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.CategoryOrgService;
import com.ccicnavi.bims.product.api.CategoryService;
import com.ccicnavi.bims.product.pojo.CategoryDO;
import com.ccicnavi.bims.product.pojo.CategoryDTO;
import com.ccicnavi.bims.product.pojo.CategoryOrgDO;
import com.ccicnavi.bims.product.pojo.CategoryOrgDTO;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class CategoryController {


    @Reference(timeout = 30000)
    CategoryService categoryService;
    @Reference(timeout = 30000)
    CategoryOrgService categoryOrgService;

    /**
     * 查询全部产品分类信息()
     *
     * @return
     */
    @RequestMapping(value = "/listAllCategory", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listAllCategory( @RequestBody CategoryDO category) {
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
     *
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
     * 根据所属公司机构和业务线查询出一级产品分类
     *
     * @return
     */
    @RequestMapping(value = "/listCategoryFirstByOrgAndProd", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listCategoryFirstByOrgAndProd(@RequestBody CategoryDTO categoryDTO) {
        try {
            List<CategoryDO> CustInvoiceList = categoryService.listCategoryFirstByOrgAndProd(categoryDTO);
            return ResultT.success(CustInvoiceList);
        } catch (Exception e) {
            log.error(" 根据所属公司机构和业务线查询出一级产品分类~", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
     * 根据父级ID查询出子级产品分类
     *
     * @return
     */
    @RequestMapping(value = "/listCategoryByParentUuid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listCategoryByParentUuid(@RequestBody CategoryDTO categoryDTO) {
        try {
            List<CategoryDO> CustInvoiceList = categoryService.listCategoryByParentUuid(categoryDTO);
            return ResultT.success(CustInvoiceList);
        } catch (Exception e) {
            log.error("根据父级ID查询出子级产品分类~", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }


    /**
     * 根据主键查询对应产品分类信息
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
            log.error("根据主键查询产品分类失败", e);
        }
        return ResultT.failure(ResultCode.GET_FAILURE);
    }


    /**
     * 保存产品分类信息
     *
     * @param categoryDO
     * @return
     */
    @RequestMapping(value = "/saveCategory", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT saveCategory(@RequestBody CategoryDO categoryDO) {
        try {
            Integer count = categoryService.saveCategory(categoryDO);
            if (count > 0) {
                return ResultT.success("新增产品分类成功");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("新增产品分类失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
     * 修改产品分类信息
     *
     * @param categoryDO
     * @return
     */
    @RequestMapping(value = "/updateCategory", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateCustomer(@RequestBody CategoryDO categoryDO) {
        try {
            Integer count = categoryService.updateCategory(categoryDO);
            if (count > 0) {
                return ResultT.success("修改产品分类成功");
            } else {
                return ResultT.failure(ResultCode.UPDATE_FAILURE);
            }
        } catch (Exception e) {
            log.error("修改产品分类失败", e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }


    /**
     * 删除产品分类信息
     *
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
                    return ResultT.success("删除产品分类成功");
                } else {
                    return ResultT.failure(ResultCode.DELETE_FAILURE);
                }
            }
        } catch (Exception e) {
            log.error("删除产品分类信息失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    /**
     * @return com.ccicnavi.bims.common.ResultT
     * @Author guojinxu
     * @Description 查询产品类别与组织机构关系
     * @Date 2018/11/22 15:27
     * @Param [categoryOrgDO]
     **/
    @RequestMapping(value = "/listCategoryOrgDO", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listCategoryOrgDO(@RequestBody CategoryOrgDO categoryOrgDO) {
        try {
            List<CategoryOrgDO> categoryOrgDOList = categoryOrgService.listCategoryOrgDO(categoryOrgDO);
            return ResultT.success(categoryOrgDOList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.GET_FAILURE);
        }
    }

    /**
     * @return com.ccicnavi.bims.common.ResultT
     * @Author guojinxu
     * @Description 更新产品类别与组织机构关系
     * @Date 2018/11/22 15:29
     * @Param [categoryOrgDTO]
     **/
    @RequestMapping(value = "/updateCategoryOrgDO", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateCategoryOrgDO(@RequestBody CategoryOrgDTO categoryOrgDTO) {
        try {
            int num = categoryOrgService.updateCategoryOrgDO(categoryOrgDTO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.RENEW_FAILURE);
        }
    }


    /**
     * 根据所属公司机构和业务线查询出所有子级产品分类信息(省公司)
     *
     * @return
     */
    @RequestMapping(value = "/listCategoryByOrgAndProd", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listCategoryByOrgAndProd(@RequestBody CategoryDTO categoryDTO) {
        try {
            List<CategoryDO> CustInvoiceList = categoryService.listCategoryByOrgAndProd(categoryDTO);
            return ResultT.success(CustInvoiceList);
        } catch (Exception e) {
            log.error("根据所属公司机构和业务线查询出所有子级产品分类信息(省公司)~", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
     * 根据所属公司机构和业务线查询出所有子级产品分类信息(子公司)
     *
     * @return
     */
    @RequestMapping(value = "/listCategorySubByOrgAndProd", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listCategorySubByOrgAndProd(@RequestBody CategoryDTO categoryDTO) {
        try {
            List<CategoryDO> CustInvoiceList = categoryService.listCategorySubByOrgAndProd(categoryDTO);
            return ResultT.success(CustInvoiceList);
        } catch (Exception e) {
            log.error("根据所属公司机构和业务线查询出所有子级产品分类信息(子公司)~", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
     * 根据组织机构对应的产品分类(支持多个)查询其下的具体产品分类信息
     */
    @RequestMapping(value = "/listCategoryByParentAllUuids", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listCategoryByParentAllUuids(@RequestBody CategoryOrgDTO categoryOrgDTO) {
        try {
            List<CategoryDO> CustInvoiceList = categoryService.listCategoryByParentAllUuids(categoryOrgDTO);
            return ResultT.success(CustInvoiceList);
        } catch (Exception e) {
            log.error("根据组织机构对应的产品分类(支持多个)查询其下的具体产品分类信息~", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }


}
