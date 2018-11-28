package com.ccicnavi.bims.product.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: LiJie
 * @create: 2018-11-28 22:14
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestItemDTO {

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
     * 公共所属机构ID
     */
    private String publicOrgUuid;

    /**
     * 应用系统id
     */
    private String appSysUuid;

}
