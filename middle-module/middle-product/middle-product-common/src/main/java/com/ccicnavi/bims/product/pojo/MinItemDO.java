package com.ccicnavi.bims.product.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 最小服务项DO
 * @author: LiJie
 * @create: 2018-11-19 17:24
 */
@Setter
@Getter
@ToString
public class MinItemDO implements Serializable {
    private String minItemUuid;//最小服务项ID

    private String minItemName;//服务项名称

    private String minItemCode;//服务项编码

    private String goodsCategoryUuid;//所属产品分类ID

    private String serviceCategoryUuid;//所属服务分类ID

    private Integer goodsPrice;

    private Integer servicePrice;

    private String useStdUuid;//使用标准ID

    private String useStdName;//使用标准名称

    private String stdWorkhour;//标准工时

    private String comments;  //备注

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedUuid;

    private Date updatedName;

    private String prodCatalogUuid;//产品线ID

    private String orgUuid;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;



}