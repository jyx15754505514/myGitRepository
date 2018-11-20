package com.ccicnavi.bims.product.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.CategoryTypeDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品类别的分类信息接口定义
 * @author: WangYingLing
 * @create: 2018-11-15 09:19
 */
public interface CategoryTypeService {

    /**查询全部产品类别的分类信息*/
    List<CategoryTypeDO> listCategoryTypeDO();

    /**新增产品类别的分类信息*/
    int saveCategoryTypeDO(CategoryTypeDO categoryTypeDO);

    /**删除产品类别的分类信息*/
    int removeCategoryTypeDO(CategoryTypeDO categoryTypeDO);

    /**修改产品类别的分类信息*/
    int updateCategoryTypeDO(CategoryTypeDO categoryTypeDO);

    /**根据主键获取产品类别的分类信息*/
    CategoryTypeDO getCategoryTypeDO(CategoryTypeDO categoryTypeDO);

    /**分页查询产品类别的分类信息*/
    PageBean<CategoryTypeDO> listCategoryTypePage(PageParameter<CategoryTypeDO> pageParameter);

}
