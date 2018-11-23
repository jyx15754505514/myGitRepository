package com.ccicnavi.bims.resource.pojo;
import lombok.Data;

import java.util.Date;
import  java.io.Serializable;


@Data
public class PersonWorkDO  implements  Serializable {

    private String personUuid;

    private String workUuid;

    private String personType;

    private String deptUuid;

    private String position;

    private Date joinJobTime;

    private Date regularTime;

    private Date joinAppTime;

    private Date joinOrgTime;

    private Date postTime;

    private String postName;

    private String email;

    private String fax;

    private String officePhone;

    private String workAddr;

    private String isUploadFile;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedUuid;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;

    private String prodCatalogUuid;

    private String extend1;

    private String extend2;

    private String extend3;
}