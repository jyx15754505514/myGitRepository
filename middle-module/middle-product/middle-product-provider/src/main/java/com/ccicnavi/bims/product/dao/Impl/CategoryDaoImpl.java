package com.ccicnavi.bims.product.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.dao.CategoryDao;
import com.ccicnavi.bims.product.pojo.CategoryDO;
import com.ccicnavi.bims.product.pojo.CategoryDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品分类数据库交互
 * @author: LiJie
 * @create: 2018-11-19 19:36
 */
@Service
public class CategoryDaoImpl implements CategoryDao {

    @Override
    public List<CategoryDO> listCategory(CategoryDO category) {
        return new Eql().select("listCategory").params(category).returnType(CategoryDO.class).execute();
    }

    @Override
    public int saveCategory(CategoryDO category) {
        return new Eql().insert("insertCategory").params(category).returnType(int.class).execute();
    }

    @Override
    public int removeCategory(CategoryDTO categoryDTO) {
        return new Eql().update("deleteCategory").params(categoryDTO).returnType(int.class).execute();
    }

    @Override
    public int updateCategory(CategoryDO category) {
        return new Eql().update("updateCategory").params(category).returnType(int.class).execute();
    }

    @Override
    public CategoryDO getCategory(CategoryDO category) {
        return new Eql().selectFirst("getCategory").params(category).returnType(CategoryDO.class).execute();
    }

    @Override
    public PageBean<CategoryDO> listCategoryPage(PageParameter<CategoryDO> pageParameter) {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<CategoryDO> categoryList = new Eql().select("listCategory").params(pageParameter.getParameter()).returnType(CategoryDO.class).limit(page).execute();
        if (categoryList != null) {
            return new PageBean<>(page.getTotalRows(), page.getTotalPages(), page.getCurrentPage(), page.getPageRows(), page.getStartIndex(), categoryList);//封装分页
        } else {
            return null;
        }
    }

    /**
     * 根据所属公司与所属产品线查询其下的一级分类信息
     *
     * @return
     */
    @Override
    public List<CategoryDO> listCategoryFirstByOrgAndProd(CategoryDTO categoryDTO) {
        return new Eql().select("listCategoryFirstByOrgAndProd").params(categoryDTO).returnType(CategoryDO.class).execute();
    }

    /**
     * 根据父级ID查询其子类产品分类信息
     *
     * @param categoryDTO
     * @return
     * @throws Exception
     */
    @Override
    public List<CategoryDO> listCategoryByParentUuid(CategoryDTO categoryDTO) {
        return new Eql().select("listCategoryByParentUuid").params(categoryDTO).returnType(CategoryDO.class).execute();
    }

    /***
     * 根据所属机构和产品线ID查询出其下的所有子级分类信息(省公司、包括子级分类)
     * @param categoryDTO
     * @return
     * @throws Exception
     */
    @Override
    public List<CategoryDO> listCategoryByOrgAndProd(CategoryDTO categoryDTO) {
        return new Eql().select("listCategoryByOrgAndProd").params(categoryDTO).returnType(CategoryDO.class).execute();
    }

    /***
     * 根据所属机构和产品线ID查询出其下的所有子级分类信息(子公司、包括子级分类)
     * @param categoryDTO
     * @return
     * @throws Exception
     */
    @Override
    public List<CategoryDO> listCategorySubByOrgAndProd(CategoryDTO categoryDTO){
        return new Eql().select("listCategorySubByOrgAndProd").params(categoryDTO).returnType(CategoryDO.class).execute();
    }

}
