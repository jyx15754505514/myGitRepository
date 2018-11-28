package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.CategoryDO;
import com.ccicnavi.bims.product.pojo.CategoryDTO;
import com.ccicnavi.bims.product.pojo.CategoryOrgDTO;

import java.util.List;


public interface CategoryDao {

    List<CategoryDO> listCategory(CategoryDTO categoryDTO) throws Exception;

    int saveCategory(CategoryDO category) throws Exception;

    int removeCategory(CategoryDTO categoryDTO) throws Exception;

    int updateCategory(CategoryDO category) throws Exception;

    CategoryDO getCategory(CategoryDTO categoryDTO) throws Exception;

    PageBean<CategoryDO> listCategoryPage(PageParameter<CategoryDTO> pageParameter) throws Exception;

    List<CategoryDO> listCategoryFirstByOrgAndProd(CategoryDTO categoryDTO) throws Exception;

    List<CategoryDO> listCategoryByParentUuid(CategoryDTO categoryDTO) throws Exception;

    List<CategoryDO> listCategoryByOrgAndProd(CategoryDTO categoryDTO) throws Exception;

    List<CategoryDO> listCategorySubByOrgAndProd(CategoryDTO categoryDTO) throws Exception;

    /**
     * 根据所属机构和产品线ID查询出其下的产品分类的UUID
     * @param categoryOrgDTO
     * @return
     * @throws Exception
     */
    List<String> listCategoryOrgByOrgUuid(CategoryOrgDTO categoryOrgDTO) throws Exception;


    /***
     * 根据多个产品分类的ID查询出其下的子级产品分类信息
     * @param categoryOrgDTO
     * @return
     * @throws Exception
     */
    List<CategoryDO> listCategoryByParentAllUuids(CategoryOrgDTO categoryOrgDTO) throws Exception;

    /**
     * 根据商品分类ID查询出所有的上级分类ID
     * @param categoryDTO
     * @return
     * @throws Exception
     */
    List<CategoryDO> listParentCategoryByUuid(CategoryDTO categoryDTO) throws Exception;
}
