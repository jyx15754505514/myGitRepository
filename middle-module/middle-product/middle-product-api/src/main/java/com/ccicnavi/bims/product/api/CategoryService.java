package com.ccicnavi.bims.product.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.CategoryDO;

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
    int removeCategory(CategoryDO category);

    /**修改产品分类信息*/
    int updateCategory(CategoryDO category);

    /**根据主键返回对应产品分类信息*/
    CategoryDO getCategory(CategoryDO Category);

    /**分页查询产品分类信息*/
    PageBean<CategoryDO> listCategoryPage(PageParameter<CategoryDO> pageParameter);

    /**根据所属公司与所属业务线查询出对应的一级分类信息*/
    List<CategoryDO> listCategoryFirstByOrgAndProd(CategoryDO category);

    /**根据父级分类ID查询其字类分类信息*/
    List<CategoryDO> listCategoryByParentUuid(CategoryDO category);





}
