package com.ccicnavi.bims.product.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 检测指标DO(product_test_item)
 * @author: wangynigling
 * @create: 2018-11-19 17:02
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestItemDO implements Serializable {

    /**
     * 主键
     */
    private String itemUuid;

    /**
     * 指标名称
     */
    private String itemName;

    /**
     * 指标名称英文
     */
    private String itemNameEn;

    /**
     * 计量单位id
     */
    private String itemUomUuid;

    /**
     * 指标编码
     */
    private String itemCode;

    /**
     * 单价
     */
    private Integer itemPrice;

    /**
     * 标准工时
     */
    private String itemWorkhour;

    /**
     * 使用方法id
     */
    private String useStdUuid;

    /**
     * 使用标准名称
     */
    private String useStdName;

    /**
     * 名称别名
     */
    private String itemNameAlias;

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

    /**产品线id
     *
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
