package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.CategoryDO;

import java.util.List;


public interface CategoryDao {

    List<CategoryDO> listCategory() throws Exception;

    int saveCategory(CategoryDO category) throws Exception;

    int removeCategory(CategoryDO category) throws Exception;

    int updateCategory(CategoryDO category) throws Exception;

    CategoryDO getCategory(CategoryDO category) throws Exception;

    PageBean<CategoryDO> listCategoryPage(PageParameter<CategoryDO> pageParameter) throws Exception;
}
