package com.ccicnavi.bims.product.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.CategoryTypeDO;
import com.ccicnavi.bims.product.pojo.CategoryTypeDTO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品类别的分类信息接口定义
 * @author: WangYingLing
 * @create: 2018-11-15 09:19
 */
public interface CategoryTypeService {

    /**
     * @description 查询全部产品类别的分类信息
     * @return List<CategoryTypeDO>
     */
    List<CategoryTypeDO> listCategoryType(CategoryTypeDO categoryTypeDO);

    /**
     * @description 新增产品类别的分类信息
     * @param categoryTypeDO
     * @return int
     */
    int saveCategoryType(CategoryTypeDO categoryTypeDO);

    /**
     * @description 删除产品类别的分类信息
     * @param categoryTypeDO
     * @return int
     */
    int removeCategoryType(CategoryTypeDO categoryTypeDO);

    /**
     * @description 修改产品类别的分类信息
     * @param categoryTypeDO
     * @return int
     */
    int updateCategoryType(CategoryTypeDO categoryTypeDO);

    /**
     * @description 根据主键获取产品类别的分类信息
     * @param categoryTypeDO
     * @return CategoryTypeDO
     */
    CategoryTypeDO getCategoryType(CategoryTypeDO categoryTypeDO);

    /**
     * @description 分页查询产品类别的分类信息
     * @param pageParameter
     * @return PageBean<CategoryTypeDO>
     */
    PageBean<CategoryTypeDO> listCategoryTypePage(PageParameter<CategoryTypeDTO> pageParameter);

}
