package com.ccicnavi.bims.product.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 产品分类DTO(产品分类与产品分类组织机构关系表)
 * @author: LiJie
 * @create: 2018-11-20 23:32
 */
@Setter
@Getter
@ToString
public class CategoryDTO implements Serializable {

    private String productCategoryUuid;

    private String productCategoryTypeUuid;

    private String parentCategoryUuid;

    private String parentAllCategoryUuid;

    private String categoryName;

    private String categoryCode;

    private String seqNum;

    private String longDescription;

    private String isEnabled;

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

    /**
     * 以下是产品分类与组织机构关系表字段：
     */
    /**产品分类与组织机构关系表所属组织机构UUID*/
    private String organizationUuid;


    /**要删除的产品分类主键数组*/
    private String [] uuids;




}
