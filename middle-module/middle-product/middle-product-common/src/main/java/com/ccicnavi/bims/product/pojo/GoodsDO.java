package com.ccicnavi.bims.product.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 商品信息
 * @author: guojinxu
 * @create: 2018/11/22 15:43
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodsDO implements Serializable {
    /**主键*/
    private String goodsUuid;
    /**商品名称*/
    private String goodsName;
    /**商品名称英文*/
    private String goodsNameEn;
    /**商品分类*/
    private String productCategoryUuid;
    /**计量单位*/
    private String goodsUnitUuid;
    /**规格*/
    private String goodsSpec;
    /**备注*/
    private String comments;
    /**删除标识（N正常Y删除）*/
    private String isDeleted;
    /**创建时间*/
    private Date createdTime;
    /**创建人id*/
    private String createdUuid;
    /**创建人*/
    private String createdName;
    /**最后一次更新时间*/
    private Date updatedTime;
    /**更新人uuid*/
    private String updatedUuid;
    /**更新人*/
    private String updatedName;
    /**产品线id*/
    private String prodCatalogUuid;
    /**归属机构id*/
    private String orgUuid;
    /**应用系统id*/
    private String appSysUuid;
    /**预留字段1*/
    private String extend1;
    /**预留字段2*/
    private String extend2;
    /**预留字段3*/
    private String extend3;
}
