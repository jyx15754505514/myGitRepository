package com.ccicnavi.bims.resource.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class PersonSkillDO implements Serializable{

    private List<String> uuids;

    private String skillUuid;

    private String skillJob;

    private String personUuid;

    private String skillLevl;

    private Date getDate;

    private String approvalNumber;

    private Date appointStartDate;

    private Date appointEndDate;

    private String appointNumber;

    private String isFile;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private Date updatedTime;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;

    private String businessLine;

    private String extend1;

    private String extend2;

    private String extend3;

}
