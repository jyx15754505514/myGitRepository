package com.ccicnavi.bims.product.manager.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.Constants;
import com.ccicnavi.bims.product.api.CategoryService;
import com.ccicnavi.bims.product.api.GoodsService;
import com.ccicnavi.bims.product.manager.CategoryManager;
import com.ccicnavi.bims.product.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: LiJie
 * @create: 2018-11-28 11:36
 */
@Service
@Slf4j
public class CategoryManagerImpl implements CategoryManager {


//    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20884")
    @Reference
    GoodsService goodsService;
//    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20884")
    @Reference
    CategoryService categoryService;


    /**
     * 根据商品名称获取到所有的商品分类信息
     *
     * @param goodsDTO
     * @return
     */
    @Override
    public ResultT listCategoryByGoodName(GoodsDTO goodsDTO) {
        try {
            //1.首先根据名称模糊查询到对应的商品信息
            List<GoodsDO> goodsDOList = goodsService.listGoodsDO(goodsDTO);
            //封参
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setAppSysUuid(goodsDTO.getAppSysUuid());
            categoryDTO.setOrgUuid(goodsDTO.getOrgUuid());
            categoryDTO.setProdCatalogUuid(goodsDTO.getProdCatalogUuid());
            categoryDTO.setPublicOrgUuid(Constants.PUBLIC_ORGUUID);
            //2.不为null的话则根据它的商品的分类ID查询出所有的父级分类
            if (!StringUtils.isEmpty(goodsDOList)) {
                for (GoodsDO goodsDOs : goodsDOList) {//获取到所有的商品
                    String productCategoryUuid = goodsDOs.getProductCategoryUuid();//获取到对应的直属上级产品分类ID
                    categoryDTO.setProductCategoryUuid(productCategoryUuid);//设置产品分类ID
                    CategoryDO categoryDOS = categoryService.getCategory(categoryDTO);
                    if (!StringUtils.isEmpty(categoryDOS) && !StringUtils.isEmpty(categoryDOS.getParentAllCategoryUuid())) {
                        //获取到所有上级产品分类ID
                        categoryDTO.setProductCategoryUuidList(Arrays.asList(categoryDOS.getParentAllCategoryUuid().trim().split("-")));
                        categoryDTO.setOrderByDesc("Y");//降序方式、子级在前、默认升序
                        List<CategoryDO> allCategoryDO = categoryService.listCategory(categoryDTO);
                        String parentCategory = "-";
                        for (int i = 0; i < allCategoryDO.size(); i++) {
                            parentCategory += allCategoryDO.get(i).getCategoryName() + "-";
                        }
                        parentCategory = parentCategory.substring(0, parentCategory.length() - 1);//截取掉最后一位特殊字符
                        goodsDOs.setGoodsName(goodsDOs.getGoodsName() + parentCategory);//重新组装
                    }
                }
                return ResultT.success(goodsDOList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultT.failure(ResultCode.RESULE_DATA_NONE);
    }
}
