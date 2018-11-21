package com.ccicnavi.bims.product.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 产品类别DO
 * @author: LiJie
 * @create: 2018-11-19 17:24
 */
@Setter
@Getter
@ToString
public class CategoryDO implements Serializable {

    private String productCategoryUuid;//主键

    private String productCategoryTypeUuid;//产品类别ID

    private String parentCategoryUuid;//主父节点分类ID

    private String parentAllCategoryUuid;//所有分类的ID

    private String categoryName;//类别名称

    private String categoryCode;//类别编码

    private String seqNum;//排序号

    private String longDescription;

    private String isEnabled;//是否可用(Y/N)

    private String comments;//备注

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedUuid;

    private String updatedName;

    private String prodCatalogUuid;//产品线ID

    private String orgUuid;

    private String appSysUuid;//应用系统ID

    private String extend1;

    private String extend2;

    private String extend3;





}