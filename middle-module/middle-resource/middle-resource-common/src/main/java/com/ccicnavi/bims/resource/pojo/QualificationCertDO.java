package com.ccicnavi.bims.resource.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class QualificationCertDO implements Serializable {

    private String cationUuid;

    private String personUuid;

    private String cationCertUuid;

    private String cationCertName;

    private String cationAreasUuid;

    private String cationLevl;

    private String cationCertNo;

    private String cationCompany;

    private Date issueDate;

    private Date updateDate;

    private String registerNumber;

    private String registerCompany;

    private Date registerDate;

    private String isFile;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private Date updatedUuid;

    private String updatedName;

    private String prodCatalogUuid;

    private String orgUuid;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;
}