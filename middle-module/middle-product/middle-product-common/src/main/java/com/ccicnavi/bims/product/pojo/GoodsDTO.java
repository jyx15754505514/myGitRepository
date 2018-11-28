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

    /**
     * 主键
     */
    private String goodsUuid;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品名称英文
     */
    private String goodsNameEn;
    /**
     * 商品分类
     */
    private String productCategoryUuid;
    /**
     * 计量单位
     */
    private String goodsUnitUuid;
    /**
     * 规格
     */
    private String goodsSpec;
    /**
     * 备注
     */
    private String comments;
    /**
     * 删除标识（N正常Y删除）
     */
    private String isDeleted;


    /**
     * 商品id集合
     */
    private List<String> goodsUuidList;

    /**
     * 产品线id
     */
    private String prodCatalogUuid;

    /**
     * 归属机构id
     */
    private String orgUuid;

    /**
     * 公共所属机构
     */
    private String publicOrgUuid;

    /**
     * 应用系统id
     */
    private String appSysUuid;

    /**
     * 所属分类ID
     */
    private List<String> productCategoryUuidList;
}
