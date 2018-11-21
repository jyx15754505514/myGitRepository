package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.CategoryDO;
import com.ccicnavi.bims.product.pojo.CategoryDTO;

import java.util.List;


public interface CategoryDao {

    List<CategoryDO> listCategory(CategoryDO category) throws Exception;

    int saveCategory(CategoryDO category) throws Exception;

    int removeCategory(CategoryDO category) throws Exception;

    int updateCategory(CategoryDO category) throws Exception;

    CategoryDO getCategory(CategoryDO category) throws Exception;

    PageBean<CategoryDO> listCategoryPage(PageParameter<CategoryDO> pageParameter) throws Exception;

    List<CategoryDO> listCategoryFirstByOrgAndProd(CategoryDTO categoryDTO) throws Exception;

    List<CategoryDO> listCategoryByParentUuid(CategoryDO category) throws Exception;
}
