package com.ccicnavi.bims.system.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class OrganizationDO implements Serializable{

    private String organizationUuid;

    private String orgParentUuid;

    private String orgName;

    private String orgShortName;

    private String orgCode;

    private String orgType;

    private String orgTel;

    private String orgTelExt;

    private String orgFax;

    private String orgUrl;

    private String orgAddr;

    private String isEnabled;

    private String sortNum;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;

    private String businessLine;

    private String extend1;

    private String extend2;

    private String extend3;

}
