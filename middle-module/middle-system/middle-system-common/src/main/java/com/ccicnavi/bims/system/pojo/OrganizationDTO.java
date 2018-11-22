package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: zhangpengwei
 * @create: 2018-11-21 22:09
 */
@Getter
@Setter
@ToString
public class OrganizationDTO implements Serializable{

    private List<String> uuids;                 //部门主键集合

    private Long levels;                        //所在级别

    private List<OrganizationDTO> orgChildList; //子集

    private String organizationUuid;

    private String orgParentUuid;

    private String orgName;

    private String orgShortName;

    private String orgCode;

    private String orgType;

    private String orgTel;

    private String orgTelExt;

    private String orgFax;

    private String orgUrl;

    private String orgAddr;

    private String isEnabled;

    private String sortNum;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;

    private String businessLine;

    private String extend1;

    private String extend2;

    private String extend3;
}
