package com.ccicnavi.bims.resource.pojo;

import java.io.Serializable;
import java.util.Date;

public class StandardInfoDO implements Serializable {
    private String stdUuid;

    private String stdName;

    private String stdCode;

    private String stdReplCode;

    private Date implDate;

    private String isCnas;

    private String isFile;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private Date updatedTime;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;

    public String getStdUuid() {
        return stdUuid;
    }

    public void setStdUuid(String stdUuid) {
        this.stdUuid = stdUuid == null ? null : stdUuid.trim();
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName == null ? null : stdName.trim();
    }

    public String getStdCode() {
        return stdCode;
    }

    public void setStdCode(String stdCode) {
        this.stdCode = stdCode == null ? null : stdCode.trim();
    }

    public String getStdReplCode() {
        return stdReplCode;
    }

    public void setStdReplCode(String stdReplCode) {
        this.stdReplCode = stdReplCode == null ? null : stdReplCode.trim();
    }

    public Date getImplDate() {
        return implDate;
    }

    public void setImplDate(Date implDate) {
        this.implDate = implDate;
    }

    public String getIsCnas() {
        return isCnas;
    }

    public void setIsCnas(String isCnas) {
        this.isCnas = isCnas == null ? null : isCnas.trim();
    }

    public String getIsFile() {
        return isFile;
    }

    public void setIsFile(String isFile) {
        this.isFile = isFile == null ? null : isFile.trim();
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