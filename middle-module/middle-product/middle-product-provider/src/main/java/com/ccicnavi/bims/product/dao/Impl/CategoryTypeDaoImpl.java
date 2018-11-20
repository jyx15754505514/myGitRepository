package com.ccicnavi.bims.product.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.dao.CategoryTypeDao;
import com.ccicnavi.bims.product.pojo.CategoryTypeDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品类别的分类(product_category_type)DaoImpl
 * @author: WangYingLing
 * @create: 2018-11-20 10:37
 */
@Service
public class CategoryTypeDaoImpl implements CategoryTypeDao {

    @Override
    public List<CategoryTypeDO> lsitCategoryTypeDO() {
        return new Eql().select("lsitCategoryTypeDO").returnType(CategoryTypeDO.class).execute();
    }

    @Override
    public int saveCategoryTypeDO(CategoryTypeDO categoryTypeDO) {
        return new Eql().insert("saveCategoryTypeDO").params(categoryTypeDO).returnType(int.class).execute();
    }

    @Override
    public int removeCategoryTypeDO(CategoryTypeDO categoryTypeDO) {
        return new Eql().update("removeCategoryTypeDO").params(categoryTypeDO).returnType(int.class).execute();
    }

    @Override
    public int updateCategoryTypeDO(CategoryTypeDO categoryTypeDO) {
        return new Eql().update("updateCategoryTypeDO").params(categoryTypeDO).returnType(int.class).execute();
    }

    @Override
    public CategoryTypeDO getCategoryTypeDO(CategoryTypeDO categoryTypeDO) {
        return new Eql().selectFirst("getCategoryTypeDO").params(categoryTypeDO).returnType(CategoryTypeDO.class).execute();
    }

    @Override
    public PageBean<CategoryTypeDO> listCategoryTypePage(PageParameter<CategoryTypeDO> pageParameter) {
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<CategoryTypeDO> categoryTypeList = new Eql().select("lsitCategoryTypeDO").params(pageParameter.getParameter()).returnType(CategoryTypeDO.class).limit(page).execute();
        if(categoryTypeList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),categoryTypeList);//封装分页
        }else {
            return null;
        }
    }
}
