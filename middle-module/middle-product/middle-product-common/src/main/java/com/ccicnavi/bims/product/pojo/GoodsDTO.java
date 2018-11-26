package com.ccicnavi.bims.product.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 商品信息删除
 * @author: guojinxu
 * @create: 2018/11/26 10:51
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodsDTO implements Serializable {

    /**商品id集合 以，号隔开*/
    private List<String> goodsUuidList;
}
