package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/*
 * 证书纸管理-分发记录
 * @Date 2018/11/23 20 44
 * @Auther heibin
 */
@Getter
@Setter
@ToString
public class CertAwayDO implements Serializable {
    private String awayUuid;

    private String paperUuid;

    private String startNum;

    private String endNum;

    private String targetType;

    private String targetName;

    private String awayNum;

    private Date awayDate;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private String prodCatalogUuid;

    private String orgUuid;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;
}
