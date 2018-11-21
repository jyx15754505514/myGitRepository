package com.ccicnavi.bims.product.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 产品类别的分类信息DO(product_category_type)
 * @author: WangYingLing
 * @create: 2018-11-20 10:26
 */
@Getter
@Setter
@ToString
public class CategoryTypeDO implements Serializable {

    private String productCategoryTypeUuid;

    private String parentTypeUuid;

    private String hasTable;

    private String typeName;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedUuid;

    private String updatedName;

    private String prodCatalogUuid;

    private String orgUuid;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;
}
