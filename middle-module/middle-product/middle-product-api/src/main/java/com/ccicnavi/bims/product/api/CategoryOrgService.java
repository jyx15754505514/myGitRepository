package com.ccicnavi.bims.product.api;

import com.ccicnavi.bims.product.pojo.CategoryOrgDO;
import com.ccicnavi.bims.product.pojo.CategoryOrgDTO;

import java.util.List;

/**
 * @description: 产品类别与组织机构关系
 * @author: guojinxu
 * @create: 2018/11/21 9:39
 */
public interface CategoryOrgService {

    /**查询产品类别与组织机构关系*/
    List<CategoryOrgDO> listCategoryOrgDO(CategoryOrgDO categoryOrgDO)throws Exception;

    /**更新产品类别与组织机构关系*/
    int updateCategoryOrgDO(CategoryOrgDTO categoryOrgDTO)throws Exception;

}
