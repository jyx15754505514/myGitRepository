package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
/**
 * 证书纸
 * @Date 2018/11/13 17 54
 * @Auther mzj
 */
@Getter
@Setter
@ToString
public class CertPaperDO {
    private String paperUuid;

    private String paperStartNum;

    private String paperEndNum;

    private String stromPerson;

    private String stromTime;

    private String leadUnit;

    private String leadDept;

    private String paperStatus;

    private String stromNum;

    private String residualNum;

    private String currentCode;

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
