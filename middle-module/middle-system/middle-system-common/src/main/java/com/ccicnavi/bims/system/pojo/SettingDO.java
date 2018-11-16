package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *@program: bims-backend
 *@description: 系统设置的DO实体
 *@author: zhangxingbiao
 *@create: 2018-11-15 14:45
 */
@Getter
@Setter
@ToString
public class SettingDO implements Serializable{
    private String settingUuid;

    private String loginTitle;

    private String loginFileUuid;

    private String mainTitle;

    private String mainFileUuid;

    private String mainWindowStyle;

    private String initialPassword;

    private String isForce;

    private String startPasswordLength;

    private String endPasswordLength;

    private String passwordStrength;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;

    private String prodCatalogUuid;

    private String extend1;

    private String extend2;

    private String extend3;

    private List<String> uuids;


}