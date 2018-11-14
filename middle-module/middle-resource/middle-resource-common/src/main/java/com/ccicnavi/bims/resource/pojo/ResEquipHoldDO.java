package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备保管信息
 */
@Getter
@Setter
@ToString
public class ResEquipHoldDO implements Serializable {
    private String equipHoldUuid;

    private String equipUuid;

    private Date useDate;

    private String assetsCode;

    private String useDeptUuid;

    private String useDeptName;

    private Date purchaseDate;

    private Integer purchasePrice;

    private Integer purchaseCount;

    private String agencyUuid;

    private String agencyName;

    private String deptUuid;

    private String deptName;

    private String mgrUuid;

    private String mgrName;

    private String locationAddr;

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
