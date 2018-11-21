package com.ccicnavi.bims.product.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 产品分类DO
 * @author: LiJie
 * @create: 2018-11-19 17:24
 */
@Setter
@Getter
@ToString
public class CategoryDO implements Serializable {

    /**产品分类主键*/
    private String productCategoryUuid;

    /**产品类别ID*/
    private String productCategoryTypeUuid;

    /**主父节点分类ID*/
    private String parentCategoryUuid;

    /**所有分类的ID*/
    private String parentAllCategoryUuid;

    /**类别名称*/
    private String categoryName;

    /**类别编码*/
    private String categoryCode;

    /**排序号*/
    private String seqNum;

    private String longDescription;

    /**是否可用(Y/N)*/
    private String isEnabled;

    /**备注*/
    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedUuid;

    private String updatedName;

    /**产品线ID*/
    private String prodCatalogUuid;

    private String orgUuid;

    /**应用系统ID*/
    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;





}