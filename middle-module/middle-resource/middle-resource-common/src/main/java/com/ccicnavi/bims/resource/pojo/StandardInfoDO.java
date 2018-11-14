package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@ToString
public class StandardInfoDO implements Serializable {
    private String stdUuid;

    private String stdName;

    private String stdCode;

    private String stdReplCode;

    private Date implDate;

    private String isCnas;

    private String isFile;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private Date updatedTime;

    private String updatedName;

    private String businessLine;

    private String orgUuid;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;

}