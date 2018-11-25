package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/*
 * 证书纸管理-证书流水
 * @Date 2018/11/25 21:13
 * @Auther heibin
 */
@Getter
@Setter
@ToString
public class CertFlowDO {
    private String  flowUuid;

    private String  flowNum;

    private String  emptyCardStatus;

    private String  reason;

    private String  certNum;

    private String  certStatus;

    private String  leadUnit;

    private String  leadDept;

    private String  cancelUuid;

    private String  cancelName;

    private Date cancelDate;

    private String  comments;

    private String  isDeleted;

    private Date createdTime;

    private String  createdUuid;

    private String  createdName;

    private String prodCatalogUuid;

    private String orgUuid;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;




}
