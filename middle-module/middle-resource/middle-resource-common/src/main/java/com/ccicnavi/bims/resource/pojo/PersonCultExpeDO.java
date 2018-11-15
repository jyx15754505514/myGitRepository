package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class PersonCultExpeDO implements Serializable {
    private String cultExpeUuid;

    private String personUuid;

    private Date startTime;

    private Date endTime;

    private String cultName;

    private String cultOrg;

    private String qualificationCert;

    private String cultType;

    private String isSign;

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
