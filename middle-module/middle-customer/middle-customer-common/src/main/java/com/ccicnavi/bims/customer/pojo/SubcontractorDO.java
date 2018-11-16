package com.ccicnavi.bims.customer.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 分包方信息实体DO
 * @author: WangYingLing
 * @create: 2018-11-15 09:16
 */

@Getter
@Setter
@ToString
public class SubcontractorDO implements Serializable {

    private String subcontractorUuid;

    private String subcCode;

    private String name;

    private String enName;

    private String subcShortName;

    private String subcPostCode;

    private String subcUrl;

    private String fax;

    private String tel;

    private String subcPhone;

    private String addr;

    private String rank;

    private String detectionField;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String businessLine;

    private String orgUuid;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;

}
