package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class ResPersonWorkExpeDO {
    private String workExpeUuid;

    private String personUuid;

    private Date startWorkTime;

    private Date endWorkTime;

    private String witness;

    private String orgName;

    private String deptName;

    private String job;

    private String jobContent;

    private String isGrassWork;

    private String isExpatriateWork;

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