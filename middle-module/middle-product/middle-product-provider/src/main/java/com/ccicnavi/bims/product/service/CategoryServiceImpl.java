package com.ccicnavi.bims.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.CategoryService;
import com.ccicnavi.bims.product.dao.CategoryDao;
import com.ccicnavi.bims.product.pojo.CategoryDO;
import com.ccicnavi.bims.product.pojo.CategoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

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
            return categoryDao.listCategory(category);
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
    public int removeCategory(CategoryDTO categoryDTO) {
        try {
            if(!StringUtils.isEmpty(categoryDTO.getProductCategoryUuid())){
                categoryDTO.setUuids(categoryDTO.getProductCategoryUuid().split(","));
                return categoryDao.removeCategory(categoryDTO);
            }
        } catch (Exception e) {
            log.error("删除产品分类失败~",e);
        }
            return 0;
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

    /**
     * 根据所属公司机构和产品线查询出其下的一级分类信息(支持筛选服务种类)
     * @return
     */
    @Override
    public List<CategoryDO> listCategoryFirstByOrgAndProd(CategoryDTO categoryDTO) {
        try {
            return categoryDao.listCategoryFirstByOrgAndProd(categoryDTO);
        } catch (Exception e) {
            log.error("根据所属公司机构和产品线查询出其下的一级分类信息失败~",e);
            return null;
        }
    }

    /**
     * 根据父级分类ID查询其子级分类信息
     * @return
     */
    @Override
    public List<CategoryDO> listCategoryByParentUuid(CategoryDTO categoryDTO) {
        try {
            return categoryDao.listCategoryByParentUuid(categoryDTO);
        } catch (Exception e) {
            log.error("根据父级分类ID查询其子级分类信息失败~",e);
            return null;
        }
    }

    /**
     * 根据所属机构和产品线ID查询出其下的所有产品分类信息(省公司、包括其子级分类信息)
     * @param categoryDTO
     * @return
     */
    @Override
    public List<CategoryDO> listCategoryByOrgAndProd(CategoryDTO categoryDTO) {
        try {
            return categoryDao.listCategoryByOrgAndProd(categoryDTO);
        } catch (Exception e) {
            log.error("根据所属机构和产品线ID查询出其下的所有产品分类信息失败~",e);
            return null;
        }
    }

    /***
     * 根据所属机构和产品线ID查询出其下的所有产品分类信息(子公司、包括其子级分类信息)
     * @param categoryDTO
     * @return
     */
    @Override
    public List<CategoryDO> listCategorySubByOrgAndProd(CategoryDTO categoryDTO) {
        try {
            return categoryDao.listCategorySubByOrgAndProd(categoryDTO);
        } catch (Exception e) {
            log.error("根据所属机构和产品线ID查询出其下的所有产品分类信息(子公司)~",e);
            return null;
        }
    }


}
