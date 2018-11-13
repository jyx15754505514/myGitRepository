package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class SealDO implements Serializable{
    private String selUuid;

    private String selName;

    private String selEngName;

    private String selCertName;

    private String selEnmUuid;

    private String selCount;

    private String selBatchNo;

    private String selStartNumber;

    private String selEndNumber;

    private String selPerson;

    private String selKeeper;

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