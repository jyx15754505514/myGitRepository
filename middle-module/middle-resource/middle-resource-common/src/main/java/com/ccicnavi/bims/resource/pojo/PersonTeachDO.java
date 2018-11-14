package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class PersonTeachDO {
    private String teachUuid;

    private String personUuid;

    private Date startTime;

    private Date endTime;

    private String school;

    private String major;

    private String studentType;

    private String schoolSystem;

    private String education;

    private String degree;

    private String hotDegree;

    private String witness;

    private String graduation;

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
