package com.ccicnavi.bims.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.CategoryTypeService;
import com.ccicnavi.bims.product.dao.CategoryTypeDao;
import com.ccicnavi.bims.product.pojo.CategoryTypeDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品类别的分类ServiceImpl
 * @author: WangYingLing
 * @create: 2018-11-20 10:34
 */

@Service
@Slf4j
public class CategoryTypeServiceImpl implements CategoryTypeService {

    @Autowired
    CategoryTypeDao categoryTypeDao;

    @Override
    public List<CategoryTypeDO> listCategoryTypeDO(CategoryTypeDO categoryTypeDO) {
        try {
            return categoryTypeDao.lsitCategoryTypeDO();
        } catch (Exception e) {
            log.error("查询产品类别的分类信息失败",e);
            return null;
        }
    }

    @Override
    public int saveCategoryTypeDO(CategoryTypeDO categoryTypeDO) {
        try {
            return categoryTypeDao.saveCategoryTypeDO(categoryTypeDO);
        } catch (Exception e) {
            log.error("新增产品类别的分类信息失败",e);
            return 0;
        }
    }

    @Override
    public int removeCategoryTypeDO(CategoryTypeDO categoryTypeDO) {
        try {
            return categoryTypeDao.removeCategoryTypeDO(categoryTypeDO);
        } catch (Exception e) {
            log.error("删除产品类别的分类信息失败",e);
            return 0;
        }
    }

    @Override
    public int updateCategoryTypeDO(CategoryTypeDO categoryTypeDO) {
        try {
            return categoryTypeDao.updateCategoryTypeDO(categoryTypeDO);
        } catch (Exception e) {
            log.error("修改产品类别的分类信息失败",e);
            return 0;
        }
    }

    @Override
    public CategoryTypeDO getCategoryTypeDO(CategoryTypeDO categoryTypeDO) {
        try {
            return categoryTypeDao.getCategoryTypeDO(categoryTypeDO);
        } catch (Exception e) {
            log.error("获取产品类别的分类信息失败",e);
            return null;
        }
    }

    @Override
    public PageBean<CategoryTypeDO> listCategoryTypePage(PageParameter<CategoryTypeDO> pageParameter) {
        try {
            return categoryTypeDao.listCategoryTypePage(pageParameter);
        } catch (Exception e) {
            log.error("分页查询产品类别的分类信息失败",e);
            return null;
        }
    }
}
