package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author MengZiJie
 * @Description 设备信息DTO
 * @Data 2018/11/23 11:08
 */
@Getter
@Setter
@ToString
public class EquipDTO implements Serializable {

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

    private Date updatedTime;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;

    private String prodCatalogPuid;

    private Integer expireDay;//到期提醒天数

    private List<String> equipUuids;//设备uuids

    private List<EquipTestDO> equipTestDTO;//检定记录

    private List<EquipUseDO> equipUseDO;//领用记录
}
