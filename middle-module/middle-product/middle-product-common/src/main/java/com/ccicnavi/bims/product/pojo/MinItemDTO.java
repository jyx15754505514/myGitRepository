package com.ccicnavi.bims.product.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 最小服务项DTO
 * @author: LiJie
 * @create: 2018-11-21 17:15
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MinItemDTO implements Serializable {

    /**
     * 最小服务项ID
     */
    private String minItemUuid;

    /**
     * 服务项名称
     */
    private String minItemName;

    /**
     * 服务项编码
     */
    private String minItemCode;

    /**
     * 所属商品分类ID
     */
    private String goodsCategoryUuid;

    /**
     * 所属服务分类ID
     */
    private String serviceCategoryUuid;

    /**
     * 商品价
     */
    private Integer goodsPrice;

    /**
     * 服务价
     */
    private Integer servicePrice;

    /**
     * 使用标准ID
     */
    private String useStdUuid;

    /**
     * 使用标准名称
     */
    private String useStdName;

    /**
     * 标准工时
     */
    private String stdWorkhour;

    /**
     * 备注
     */
    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedUuid;

    private Date updatedName;

    /**
     * 产品线ID
     */
    private String prodCatalogUuid;

    /**
     * 所属机构ID
     */
    private String orgUuid;

    /**
     * 公共所属机构
     */
    private String publicOrgUuid;

    /**
     * 所属平台ID
     */
    private String appSysUuid;


    /**
     * 需要删除的主键
     */
    private String[] uuids;


}
