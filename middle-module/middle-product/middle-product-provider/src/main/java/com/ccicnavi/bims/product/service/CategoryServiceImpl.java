package com.ccicnavi.bims.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.CategoryService;
import com.ccicnavi.bims.product.dao.CategoryDao;
import com.ccicnavi.bims.product.pojo.CategoryDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品类别接口实现
 * @author: LiJie
 * @create: 2018-11-19 18:22
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;


    @Override
    public List<CategoryDO> listCategory(CategoryDO category) {
        try {
            return categoryDao.listCategory();
        } catch (Exception e) {
            log.error("查询产品分类失败~",e);
            return null;
        }
    }

    @Override
    public int saveCategory(CategoryDO category) {
        try {
            return categoryDao.saveCategory(category);
        } catch (Exception e) {
            log.error("保存产品分类失败~",e);
            return 0;
        }
    }

    @Override
    public int removeCategory(CategoryDO category) {
        try {
            return categoryDao.removeCategory(category);
        } catch (Exception e) {
            log.error("删除产品分类失败~",e);
            return 0;
        }
    }

    @Override
    public int updateCategory(CategoryDO category) {
        try {
            return categoryDao.updateCategory(category);
        } catch (Exception e) {
            log.error("修改产品分类失败~",e);
            return 0;
        }
    }

    @Override
    public CategoryDO getCategory(CategoryDO category) {
        try {
            return categoryDao.getCategory(category);
        } catch (Exception e) {
            log.error("根据主键获取产品分类信息失败~",e);
            return null;
        }
    }

    @Override
    public PageBean<CategoryDO> listCategoryPage(PageParameter<CategoryDO> pageParameter) {
        try {
            return categoryDao.listCategoryPage(pageParameter);
        } catch (Exception e) {
            log.error("分页查询产品分类信息失败~",e);
            return null;
        }
    }
}
