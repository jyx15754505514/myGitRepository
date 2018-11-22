package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author heibin
 * @Description 证书结果
 * @Date 14:35 2018/11/20
 */
@Getter
@Setter
@ToString
public class OrderResultInfoDO implements Serializable {
    private String resultUuid;

    private String resultNo;

    private String certPaperNo;

    private String certEditerUuid;

    private Date certEditTime;

    private String certCheckerUuid;

    private Date certCheckTime;

    private String certSignerUuid;

    private Date certSignTime;

    private String isCertUpload;

    private String isPdf;

    private String isMergeReport;

    private String statusUuid;

    private Integer certPrintPage;

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
}
