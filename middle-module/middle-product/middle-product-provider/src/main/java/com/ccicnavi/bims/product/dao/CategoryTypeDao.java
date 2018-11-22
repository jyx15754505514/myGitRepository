package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.CategoryTypeDO;

import java.util.List;

public interface CategoryTypeDao {

    List<CategoryTypeDO> lsitCategoryType();

    int saveCategoryType(CategoryTypeDO categoryTypeDO);

    int removeCategoryType(CategoryTypeDO categoryTypeDO) throws Exception;

    int updateCategoryType(CategoryTypeDO categoryTypeDO);

    CategoryTypeDO getCategoryType(CategoryTypeDO categoryTypeDO);

    PageBean<CategoryTypeDO> listCategoryTypePage(PageParameter<CategoryTypeDO> pageParameter);

}
