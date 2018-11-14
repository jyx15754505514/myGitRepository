package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@ToString
public class ResEquipDO implements Serializable {
    private String equipUuid;

    private String equipName;

    private String equipNameEn;

    private String controlCode;

    private String equipModel;

    private String equipSpec;

    private String factoryNo;

    private String manufacture;

    private String factoryLevel;

    private String measureRange;

    private String accuracyLevel;

    private String equipAbc;

    private String statusUuid;

    private String partsDesc;

    private String testerName;

    private String businessLine;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;
}
