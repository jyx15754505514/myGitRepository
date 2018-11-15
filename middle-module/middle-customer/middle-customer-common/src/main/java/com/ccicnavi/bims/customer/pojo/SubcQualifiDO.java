package com.ccicnavi.bims.customer.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 分包方资质信息
 */

@Getter
@Setter
@ToString
public class SubcQualifiDO {

    private String subcQualifiUuid;

    private String subcUuid;

    private String qualifiRange;

    private String qualifiEnmUuid;

    private String qualifiDescribe;

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
