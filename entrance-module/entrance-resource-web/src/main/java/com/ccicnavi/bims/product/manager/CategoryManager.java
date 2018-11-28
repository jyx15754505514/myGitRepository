package com.ccicnavi.bims.product.manager;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.product.pojo.GoodsDO;

/**
 * @program: bims-backend
 * @description: 产品分类业务接口定义
 * @author: LiJie
 * @create: 2018-11-28 11:36
 */
public interface CategoryManager {

    /**
     * 根据商品名称获取到所有的商品分类信息
     * @param goodsDO
     * @return
     */
    ResultT listCategoryByGoodName(GoodsDO goodsDO);

}
