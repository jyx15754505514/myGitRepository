package com.ccicnavi.bims.product.dao.Impl;

import com.ccicnavi.bims.product.dao.CategoryOrgDao;
import com.ccicnavi.bims.product.pojo.CategoryOrgDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 产品类别与组织机构关系
 * @author: guojinxu
 * @create: 2018/11/21 10:14
 */
@Service
public class CategoryOrgDaoImpl implements CategoryOrgDao {
    @Override
    public List<CategoryOrgDO> listCategoryOrgDO(CategoryOrgDO categoryOrgDO) {
        return new Eql().select("listCategoryOrgDO").params(categoryOrgDO).returnType(CategoryOrgDO.class).execute();
    }

    @Override
    public int saveCategoryOrgDO(CategoryOrgDO categoryOrgDO, EqlTran eqlTran){
        return new Eql().useTran(eqlTran).insert("saveCategoryOrgDO").params(categoryOrgDO).returnType(int.class).execute();
    }

    @Override
    public int removeCategoryOrgDO(CategoryOrgDO categoryOrgDO, EqlTran eqlTran){
        return new Eql().useTran(eqlTran).delete("removeCategoryOrgDO").params(categoryOrgDO).returnType(int.class).execute();
    }

}
