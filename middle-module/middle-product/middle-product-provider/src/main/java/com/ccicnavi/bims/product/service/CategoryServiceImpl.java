package com.ccicnavi.bims.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.CategoryService;
import com.ccicnavi.bims.product.dao.CategoryDao;
import com.ccicnavi.bims.product.pojo.CategoryDO;
import com.ccicnavi.bims.product.pojo.CategoryDTO;
import com.ccicnavi.bims.product.pojo.CategoryOrgDTO;
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
            log.error("查询产品分类失败~", e);
            return null;
        }
    }

    @Override
    public int saveCategory(CategoryDO category) {
        try {
            return categoryDao.saveCategory(category);
        } catch (Exception e) {
            log.error("保存产品分类失败~", e);
            return 0;
        }
    }

    @Override
    public int removeCategory(CategoryDTO categoryDTO) {
        try {
            if (!StringUtils.isEmpty(categoryDTO.getProductCategoryUuid())) {
                categoryDTO.setUuids(categoryDTO.getProductCategoryUuid().split(","));
                return categoryDao.removeCategory(categoryDTO);
            }
        } catch (Exception e) {
            log.error("删除产品分类失败~", e);
        }
        return 0;
    }

    @Override
    public int updateCategory(CategoryDO category) {
        try {
            return categoryDao.updateCategory(category);
        } catch (Exception e) {
            log.error("修改产品分类失败~", e);
            return 0;
        }
    }

    @Override
    public CategoryDO getCategory(CategoryDO category) {
        try {
            return categoryDao.getCategory(category);
        } catch (Exception e) {
            log.error("根据主键获取产品分类信息失败~", e);
            return null;
        }
    }

    @Override
    public PageBean<CategoryDO> listCategoryPage(PageParameter<CategoryDO> pageParameter) {
        try {
            return categoryDao.listCategoryPage(pageParameter);
        } catch (Exception e) {
            log.error("分页查询产品分类信息失败~", e);
            return null;
        }
    }

    /**
     * 根据所属公司机构和产品线查询出其下的一级分类信息(支持筛选服务种类)
     *
     * @return
     */
    @Override
    public List<CategoryDO> listCategoryFirstByOrgAndProd(CategoryDTO categoryDTO) {
        try {
            return categoryDao.listCategoryFirstByOrgAndProd(categoryDTO);
        } catch (Exception e) {
            log.error("根据所属公司机构和产品线查询出其下的一级分类信息失败~", e);
            return null;
        }
    }

    /**
     * 根据父级分类ID查询其子级分类信息
     *
     * @return
     */
    @Override
    public List<CategoryDO> listCategoryByParentUuid(CategoryDTO categoryDTO) {
        try {
            return categoryDao.listCategoryByParentUuid(categoryDTO);
        } catch (Exception e) {
            log.error("根据父级分类ID查询其子级分类信息失败~", e);
            return null;
        }
    }

    /**
     * 根据所属机构和产品线ID查询出其下的所有产品分类信息(省公司、包括其子级分类信息)
     *
     * @param categoryDTO
     * @return
     */
    @Override
    public List<CategoryDO> listCategoryByOrgAndProd(CategoryDTO categoryDTO) {
        try {
            return categoryDao.listCategoryByOrgAndProd(categoryDTO);
        } catch (Exception e) {
            log.error("根据所属机构和产品线ID查询出其下的所有产品分类信息失败~", e);
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
            log.error("根据所属机构和产品线ID查询出其下的所有产品分类信息(子公司)~", e);
            return null;
        }
    }

    /**
     * 根据组织机构查询其下的产品分类信息得出产品分类UUID
     *
     * @param categoryOrgDTO
     * @return
     */
    @Override
    public List<String> listCategoryOrgByOrgUuid(CategoryOrgDTO categoryOrgDTO) {
        try {
            return categoryDao.listCategoryOrgByOrgUuid(categoryOrgDTO);
        } catch (Exception e) {
            log.error("根据所属机构和产品线ID查询出其下的所有产品分类信息UUID~", e);
            return null;
        }
    }

    /**
     * 根据多个产品分类的ID查询其下的子级产品分类信息
     *
     * @param categoryOrgDTO
     * @return
     */
    @Override
    public List<CategoryDO> listCategoryByParentAllUuids(CategoryOrgDTO categoryOrgDTO) {
        try {
            //1.根据组织机构和产品线查询出其下对应的产品分类的UUID
            List<String> strList = categoryDao.listCategoryOrgByOrgUuid(categoryOrgDTO);
            //2.组合多个产品分类特殊字符、用以模糊查询该产品分类下的子级产品分类信息
            if (!StringUtils.isEmpty(strList) && strList.size() > 0) {
                String categoryUuidList = "";
                for (int i = 0; i < strList.size(); i++) {
                    categoryUuidList += strList.get(i) + "|";
                }
                categoryUuidList = categoryUuidList.substring(0, categoryUuidList.length() - 1);//截取掉最后一位特殊字符
                categoryOrgDTO.setCategoryUuidList(categoryUuidList);//设置查询到该公司所有所属的产品分类的UUID
                return categoryDao.listCategoryByParentAllUuids(categoryOrgDTO);
            }
        } catch (Exception e) {
            log.error("根据多个产品分类的ID查询其下的子级产品分类信息~", e);
        }
        return null;
    }


}
