package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 设备检定信息DO
 * @author: panyida
 * @create: 2018-11-14 11:30
 **/
@Getter
@Setter
@ToString
public class EquipTestDO implements Serializable {
    private String equipTestUuid;

    private String equipUuid;

    private String certNo;

    private Date testDate;

    private String testCycle;

    private String isLongTerm;

    private Date testValidDate;

    private String testResult;

    private String testType;

    private Integer testFee;

    private String feeDesc;

    private String standardDesc;

    private String onlineCertUrl;

    private String prodCatalogPuid;

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
