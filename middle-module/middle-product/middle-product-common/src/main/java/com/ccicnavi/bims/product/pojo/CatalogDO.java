package com.ccicnavi.bims.product.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 产品线信息DO(prod_catalog)
 * @author: WangYingLing
 * @create: 2018-11-19 22:46
 */

@Getter
@Setter
@ToString
public class CatalogDO implements Serializable {

    /**
     * 主键
     */
    private String prodCatalogUuid;

    /**
     * 产品线名称
     */
    private String catalogName;

    /**
     * 产品线编码
     */
    private String catalogCode;

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
