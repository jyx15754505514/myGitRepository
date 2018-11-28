package com.ccicnavi.bims.product.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 商品VO
 * @author: LiJie
 * @create: 2018-11-28 16:27
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodsVO {

    /**商品集合*/
    private GoodsDO goodsDO;

    /**对应的产品分类*/
    private List<CategoryDO> categoryDOList;

}
