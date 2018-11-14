package com.ccicnavi.bims.customer.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户DO实体
 */
@Setter
@Getter
@ToString
public class CustomerDO implements Serializable {

    private String custUuid;

    private String custParentUuid;

    private String custName;

    private String custNameEn;

    private String custShortName;

    private String custCode;

    private String custUscc;

    private String custAddr;

    private String custRegion;

    private String custScale;

    private String custAddrEn;

    private String custPostCode;

    private String custFax;

    private String custPhone;

    private String custUrl;

    private String custTrade;

    private Date cooperationStartDate;

    private String isSediment;

    private String custSource;

    private String recommendDept;

    private String recommendUser;

    private String recommendComm;

    private String followDept;

    private String serveType;

    private String specialRequire;

    private String marketMgrName;

    private String custIndustryType;

    private String custCreditRating;

    private String mainLinkmanUuid;

    private String mainLinkmanName;

    private String custLevel;

    private String finCycle;

    private String statusUuid;

    private String custUnitType;

    private String custCompetitor;

    private String mainProduct;

    private String comments;

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
