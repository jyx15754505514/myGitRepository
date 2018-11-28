package com.ccicnavi.bims.product.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品分类DTO(产品分类与产品分类组织机构关系表)
 * @author: LiJie
 * @create: 2018-11-20 23:32
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO implements Serializable {

    /**产品分类主键*/
    private String productCategoryUuid;

    /**产品类别ID*/
    private String productCategoryTypeUuid;

    /**主父节点分类ID*/
    private String parentCategoryUuid;

    /**所有父级产品分类的ID*/
    private String parentAllCategoryUuid;

    /**产品分类名称*/
    private String categoryName;

    /**产品分类编码*/
    private String categoryCode;

    /**排序号*/
    private String seqNum;

    /**描述*/
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

    private String prodCatalogUuid;

    private String orgUuid;

    private String appSysUuid;

    /**
     * 以下是产品分类与组织机构关系表字段：
     */
    /**产品分类与组织机构关系表所属组织机构UUID*/
    private String organizationUuid;

    /**要删除的产品分类主键数组*/
    private String [] uuids;

    /**公共所属组织机构*/
    private String publicOrgUuid;

    /**
     * 商品信息
     */
    private List<GoodsDO> goodsDOList;

    /**
     * 产品分类主键list
     */
    private List<String> productCategoryUuidList;




}
