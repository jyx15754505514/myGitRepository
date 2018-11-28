package com.ccicnavi.bims.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.CategoryTypeService;
import com.ccicnavi.bims.product.dao.CategoryTypeDao;
import com.ccicnavi.bims.product.pojo.CategoryTypeDO;
import com.ccicnavi.bims.product.pojo.CategoryTypeDTO;
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
    public List<CategoryTypeDO> listCategoryType(CategoryTypeDO categoryTypeDO) {
        try {
            return categoryTypeDao.listCategoryType(categoryTypeDO);
        } catch (Exception e) {
            log.error("查询产品类别的分类信息失败",e);
            return null;
        }
    }

    @Override
    public int saveCategoryType(CategoryTypeDO categoryTypeDO) {
        try {
            return categoryTypeDao.saveCategoryType(categoryTypeDO);
        } catch (Exception e) {
            log.error("新增产品类别的分类信息失败",e);
            return 0;
        }
    }

    @Override
    public int removeCategoryType(CategoryTypeDO categoryTypeDO) {
        try {
            return categoryTypeDao.removeCategoryType(categoryTypeDO);
        } catch (Exception e) {
            log.error("删除产品类别的分类信息失败",e);
            return 0;
        }
    }

    @Override
    public int updateCategoryType(CategoryTypeDO categoryTypeDO) {
        try {
            return categoryTypeDao.updateCategoryType(categoryTypeDO);
        } catch (Exception e) {
            log.error("修改产品类别的分类信息失败",e);
            return 0;
        }
    }

    @Override
    public CategoryTypeDO getCategoryType(CategoryTypeDO categoryTypeDO) {
        try {
            return categoryTypeDao.getCategoryType(categoryTypeDO);
        } catch (Exception e) {
            log.error("获取产品类别的分类信息失败",e);
            return null;
        }
    }

    @Override
    public PageBean<CategoryTypeDO> listCategoryTypePage(PageParameter<CategoryTypeDTO> pageParameter) {
        try {
            return categoryTypeDao.listCategoryTypePage(pageParameter);
        } catch (Exception e) {
            log.error("分页查询产品类别的分类信息失败",e);
            return null;
        }
    }
}
