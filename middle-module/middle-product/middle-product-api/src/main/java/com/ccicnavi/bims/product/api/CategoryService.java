package com.ccicnavi.bims.product.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.CategoryDO;
import com.ccicnavi.bims.product.pojo.CategoryDTO;
import com.ccicnavi.bims.product.pojo.CategoryOrgDTO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品分类接口定义
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
public interface CategoryService {

    /**查询全部产品分类信息*/
    List<CategoryDO> listCategory(CategoryDO category);

    /**新增产品分类信息*/
    int saveCategory(CategoryDO category);

    /**删除产品分类信息*/
    int removeCategory(CategoryDTO categoryDTO);

    /**修改产品分类信息*/
    int updateCategory(CategoryDO category);

    /**根据主键返回对应产品分类信息*/
    CategoryDO getCategory(CategoryDO Category);

    /**分页查询产品分类信息*/
    PageBean<CategoryDO> listCategoryPage(PageParameter<CategoryDO> pageParameter);

    /**根据所属公司与所属业务线查询出对应的一级分类信息*/
    List<CategoryDO> listCategoryFirstByOrgAndProd(CategoryDTO categoryDTO);

    /**根据父级分类ID查询其字类分类信息*/
    List<CategoryDO> listCategoryByParentUuid(CategoryDTO categoryDTO);

    /**根据所属机构和产品线ID查询出其下的产品分类信息*/
    List<CategoryDO> listCategoryByOrgAndProd(CategoryDTO categoryDTO);

    /**根据所属机构和产品线ID查询出其下的产品分类信息(子公司)*/
    List<CategoryDO> listCategorySubByOrgAndProd(CategoryDTO categoryDTO);

    /**查询组织机构对应的产品分类信息UUID*/
    List<String> listCategoryOrgByOrgUuid(CategoryOrgDTO categoryOrgDTO);

    /**根据多个产品分类ID查询其下的子级分类信息(包括子级)*/
    List<CategoryDO> listCategoryByParentAllUuids(CategoryOrgDTO categoryOrgDTO);

}
