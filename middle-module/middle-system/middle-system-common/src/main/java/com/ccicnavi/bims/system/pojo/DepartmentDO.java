package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString
public class DepartmentDO implements Serializable {
    private String deptUuid;

    private String deptCode;

    private String deptName;

    private String deptType;

    private String parentName;

    private String parentUuid;

    private String deptTel;

    private Integer deptSort;

    private String manager;

    private String business;

    private String isEnabled;

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

    private List<String> uuids;


}