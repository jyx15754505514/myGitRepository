package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.CategoryTypeDO;

import java.util.List;

public interface CategoryTypeDao {

    List<CategoryTypeDO> lsitCategoryTypeDO();

    int saveCategoryTypeDO(CategoryTypeDO categoryTypeDO);

    int removeCategoryTypeDO(CategoryTypeDO categoryTypeDO) throws Exception;

    int updateCategoryTypeDO(CategoryTypeDO categoryTypeDO);

    CategoryTypeDO getCategoryTypeDO(CategoryTypeDO categoryTypeDO);

    PageBean<CategoryTypeDO> listCategoryTypePage(PageParameter<CategoryTypeDO> pageParameter);

}
