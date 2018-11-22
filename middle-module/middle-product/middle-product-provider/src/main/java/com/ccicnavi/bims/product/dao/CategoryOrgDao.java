package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.product.pojo.CategoryOrgDO;

import java.util.List;

/**
 * @description: 产品类别与组织机构关系
 * @author: guojinxu
 * @create: 2018/11/21 10:00
 */
public interface CategoryOrgDao {

    List<CategoryOrgDO> listCategoryOrgDO(CategoryOrgDO categoryOrgDO)throws Exception;

    int saveCategoryOrgDO(CategoryOrgDO categoryOrgDO)throws Exception;

    int removeCategoryOrgDO(CategoryOrgDO categoryOrgDO)throws Exception;

}
