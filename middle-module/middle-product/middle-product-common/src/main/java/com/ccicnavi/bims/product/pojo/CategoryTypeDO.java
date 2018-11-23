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

    /**
     * 主键
     */
    private String productCategoryTypeUuid;

    /**
     * 父类型id
     */
    private String parentTypeUuid;

    /**
     * 是否有子表
     */
    private String hasTable;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 备注
     */
    private String comments;

    /**
     * 删除标识（N正常Y删除）
     */
    private String isDeleted;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 创建人id
     */
    private String createdUuid;

    /**
     * 创建人
     */
    private String createdName;

    /**
     * 最后一次更新时间
     */
    private Date updatedTime;

    /**
     * 更新人uuid
     */
    private String updatedUuid;

    /**
     * 更新人
     */
    private String updatedName;

    /**
     * 产品线id
     */
    private String prodCatalogUuid;

    /**
     * 归属机构id
     */
    private String orgUuid;

    /**
     * 应用系统id
     */
    private String appSysUuid;

    /**
     * 预留字段1
     */
    private String extend1;

    /**
     * 预留字段2
     */
    private String extend2;

    /**
     * 预留字段3
     */
    private String extend3;
}
