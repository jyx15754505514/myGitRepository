package com.ccicnavi.bims.system.pojo;

import java.io.Serializable;
import java.util.Date;

public class Setting implements Serializable{
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

    private String businessLine;

    private String extend1;

    private String extend2;

    private String extend3;

    public String getSettingUuid() {
        return settingUuid;
    }

    public void setSettingUuid(String settingUuid) {
        this.settingUuid = settingUuid == null ? null : settingUuid.trim();
    }

    public String getLoginTitle() {
        return loginTitle;
    }

    public void setLoginTitle(String loginTitle) {
        this.loginTitle = loginTitle == null ? null : loginTitle.trim();
    }

    public String getLoginFileUuid() {
        return loginFileUuid;
    }

    public void setLoginFileUuid(String loginFileUuid) {
        this.loginFileUuid = loginFileUuid == null ? null : loginFileUuid.trim();
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle == null ? null : mainTitle.trim();
    }

    public String getMainFileUuid() {
        return mainFileUuid;
    }

    public void setMainFileUuid(String mainFileUuid) {
        this.mainFileUuid = mainFileUuid == null ? null : mainFileUuid.trim();
    }

    public String getMainWindowStyle() {
        return mainWindowStyle;
    }

    public void setMainWindowStyle(String mainWindowStyle) {
        this.mainWindowStyle = mainWindowStyle == null ? null : mainWindowStyle.trim();
    }

    public String getInitialPassword() {
        return initialPassword;
    }

    public void setInitialPassword(String initialPassword) {
        this.initialPassword = initialPassword == null ? null : initialPassword.trim();
    }

    public String getIsForce() {
        return isForce;
    }

    public void setIsForce(String isForce) {
        this.isForce = isForce == null ? null : isForce.trim();
    }

    public String getStartPasswordLength() {
        return startPasswordLength;
    }

    public void setStartPasswordLength(String startPasswordLength) {
        this.startPasswordLength = startPasswordLength == null ? null : startPasswordLength.trim();
    }

    public String getEndPasswordLength() {
        return endPasswordLength;
    }

    public void setEndPasswordLength(String endPasswordLength) {
        this.endPasswordLength = endPasswordLength == null ? null : endPasswordLength.trim();
    }

    public String getPasswordStrength() {
        return passwordStrength;
    }

    public void setPasswordStrength(String passwordStrength) {
        this.passwordStrength = passwordStrength == null ? null : passwordStrength.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedUuid() {
        return createdUuid;
    }

    public void setCreatedUuid(String createdUuid) {
        this.createdUuid = createdUuid == null ? null : createdUuid.trim();
    }

    public String getCreatedName() {
        return createdName;
    }

    public void setCreatedName(String createdName) {
        this.createdName = createdName == null ? null : createdName.trim();
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedName() {
        return updatedName;
    }

    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName == null ? null : updatedName.trim();
    }

    public String getOrgUuid() {
        return orgUuid;
    }

    public void setOrgUuid(String orgUuid) {
        this.orgUuid = orgUuid == null ? null : orgUuid.trim();
    }

    public String getAppSysUuid() {
        return appSysUuid;
    }

    public void setAppSysUuid(String appSysUuid) {
        this.appSysUuid = appSysUuid == null ? null : appSysUuid.trim();
    }

    public String getBusinessLine() {
        return businessLine;
    }

    public void setBusinessLine(String businessLine) {
        this.businessLine = businessLine == null ? null : businessLine.trim();
    }

    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1 == null ? null : extend1.trim();
    }

    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2 == null ? null : extend2.trim();
    }

    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3 == null ? null : extend3.trim();
    }
}