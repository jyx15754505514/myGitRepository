package com.ccicnavi.bims.resource.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


import java.io.Serializable;
import java.util.Date;

/**
 * 证书纸管理-分发记录
 * @Date 2018/11/23 20 44
 * @Auther heibin
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CertAwayDO implements Serializable {
    /**
     * 分发记录uuid
     */
    private String awayUuid;
    /**
     * 证书纸uuid
     */
    private String paperUuid;
    /**
     * 分发流水起始号
     */
    private String startNum;
    /**
     * 分发流水截止号
     */
    private String endNum;
    /**
     * 分发对象
     */
    private String targetType;
    /**
     * 对象名称
     */
    private String targetName;
    /**
     * 分发数量
     */
    private String awayNum;
    /**
     * 分发日期
     */
    private Date awayDate;
    /**
     * 备注
     */
    private String comments;
    /**
     * 作废标识（N正常Y删除）
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
