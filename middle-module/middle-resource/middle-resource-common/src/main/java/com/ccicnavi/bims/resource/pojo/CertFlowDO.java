package com.ccicnavi.bims.resource.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


import java.io.Serializable;
import java.util.Date;

/**
 * 证书纸管理-证书流水
 * @Date 2018/11/25 21:13
 * @Auther heibin
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CertFlowDO implements Serializable {
    /**
     * 证书流水uuid
     */
    private String  flowUuid;
    /**
     * 流水号
     */
    private String  flowNum;
    /**
     * 空证状态（N正常Y作废）
     */
    private String  emptyCardStatus;
    /**
     * 作废原因
     */
    private String  reason;
    /**
     * 证书号
     */
    private String  certNum;
    /**
     * 证书状态
     */
    private String  certStatus;
    /**
     * 领用单位
     */
    private String  leadUnit;
    /**
     * 领用部门
     */
    private String  leadDept;
    /**
     * 作废人id
     */
    private String  cancelUuid;
    /**
     * 作废人
     */
    private String  cancelName;
    /**
     * 作废日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date cancelDate;
    /**
     * 备注
     */
    private String  comments;
    /**
     * 删除标识（N正常Y删除）
     */
    private String  isDeleted;
    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;
    /**
     * 创建人id
     */
    private String  createdUuid;
    /**
     * 创建人
     */
    private String  createdName;
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
