package com.ccicnavi.bims.resource.pojo;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 设备信息DO
 * @author: panyida
 * @create: 2018-11-14 11:30
 **/
@Getter
@Setter
@ToString
public class EquipDO implements Serializable {
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

    private String equipPlanUuid;

    private String equipOrderUuid;

    private String appointUuid;

    private String certNo;

    private Date testDate;

    private Date useDate;

    private String useDeptUuid;

    private String isVerify;

    private String testCycle;

    private String isLongTerm;

    private Date testValidDate;

    private String testResult;

    private Date purchaseDate;

    private Integer purchasePrice;

    private Integer purchaseCount;

    private String isRent;

    private String isLocalTest;

    private String isSelfTest;

    private String agencyUuid;

    private String agencyName;

    private String testType;

    private Integer testFee;

    private Integer repairFee;

    private String feeDesc;

    private String locationAddr;

    private String deptUuid;

    private String mgrUuid;

    private String partsDesc;

    private String standardDesc;

    private String rowType;

    private String isFile;

    private String isCertFile;

    private String onlineCertUrl;

    private String sourceCfmName;

    private Date sourceCfmDate;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedUuid;

    private String updatedName;

    private String prodCatalogUuid;

    private String orgUuid;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;
}
