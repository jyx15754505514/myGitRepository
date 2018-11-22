package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.product.pojo.CategoryOrgDO;
import org.n3r.eql.EqlTran;

import java.util.List;

/**
 * @description: 产品类别与组织机构关系
 * @author: guojinxu
 * @create: 2018/11/21 10:00
 */
public interface CategoryOrgDao {

    List<CategoryOrgDO> listCategoryOrgDO(CategoryOrgDO categoryOrgDO)throws Exception;

    int saveCategoryOrgDO(CategoryOrgDO categoryOrgDO, EqlTran eqlTran)throws Exception;

    int removeCategoryOrgDO(CategoryOrgDO categoryOrgDO, EqlTran eqlTran)throws Exception;

}
