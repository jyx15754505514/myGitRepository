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
    /**
     * uuid主键
     */
    private String settingUuid;
    /**
     * 登录页面标题*/
    private String loginTitle;
    /**
     * 登录页面背景图*/
    private String loginFileUuid;
    /**
     * 主界面页面标题*/
    private String mainTitle;
    /**
     * 主界面页面背景图*/
    private String mainFileUuid;
    /**
     * 主界面窗口样式*/
    private String mainWindowStyle;
    /**
     * 初始密码*/
    private String initialPassword;
    /**
     * 是否强制修改密码（Y是N否）*/
    private String isForce;
    /**
     * 开始密码长度*/
    private String startPasswordLength;
    /**
     * 开始密码长度*/
    private String endPasswordLength;
    /**
     * 密码强度*/
    private String passwordStrength;
    /**
     * 备注*/
    private String comments;
    /**
     * 删除标识（N正常Y删除）*/
    private String isDeleted;
    /**
     * 创建时间*/
    private Date createdTime;
    /**
     * 创建人id*/
    private String createdUuid;
    /**
     * 创建人*/
    private String createdName;
    /**
     * 最后一次更新时间*/
    private Date updatedTime;
    /**
     * 更新人uuid*/
    private String updatedName;
    /**
     * 归属机构id*/
    private String orgUuid;
    /**
     * 应用系统id*/
    private String appSysUuid;
    /**
     * 产品线id*/
    private String prodCatalogUuid;
    /**
     * 预留字段*/
    private String extend1;
    /**
     * 预留字段*/
    private String extend2;
    /**
     * 预留字段*/
    private String extend3;
    /**
     * uuid集合*/
    private List<String> uuids;


}