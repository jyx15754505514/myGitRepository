package com.ccicnavi.bims.resource.pojo;

import java.io.Serializable;
import java.util.Date;

public class SealDO implements Serializable{
    private String selUuid;

    private String selName;

    private String selEngName;

    private String selCertName;

    private String selEnmUuid;

    private String selCount;

    private String selBatchNo;

    private String selStartNumber;

    private String selEndNumber;

    private String selPerson;

    private String selKeeper;

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

    public String getSelUuid() {
        return selUuid;
    }

    public void setSelUuid(String selUuid) {
        this.selUuid = selUuid == null ? null : selUuid.trim();
    }

    public String getSelName() {
        return selName;
    }

    public void setSelName(String selName) {
        this.selName = selName == null ? null : selName.trim();
    }

    public String getSelEngName() {
        return selEngName;
    }

    public void setSelEngName(String selEngName) {
        this.selEngName = selEngName == null ? null : selEngName.trim();
    }

    public String getSelCertName() {
        return selCertName;
    }

    public void setSelCertName(String selCertName) {
        this.selCertName = selCertName == null ? null : selCertName.trim();
    }

    public String getSelEnmUuid() {
        return selEnmUuid;
    }

    public void setSelEnmUuid(String selEnmUuid) {
        this.selEnmUuid = selEnmUuid == null ? null : selEnmUuid.trim();
    }

    public String getSelCount() {
        return selCount;
    }

    public void setSelCount(String selCount) {
        this.selCount = selCount == null ? null : selCount.trim();
    }

    public String getSelBatchNo() {
        return selBatchNo;
    }

    public void setSelBatchNo(String selBatchNo) {
        this.selBatchNo = selBatchNo == null ? null : selBatchNo.trim();
    }

    public String getSelStartNumber() {
        return selStartNumber;
    }

    public void setSelStartNumber(String selStartNumber) {
        this.selStartNumber = selStartNumber == null ? null : selStartNumber.trim();
    }

    public String getSelEndNumber() {
        return selEndNumber;
    }

    public void setSelEndNumber(String selEndNumber) {
        this.selEndNumber = selEndNumber == null ? null : selEndNumber.trim();
    }

    public String getSelPerson() {
        return selPerson;
    }

    public void setSelPerson(String selPerson) {
        this.selPerson = selPerson == null ? null : selPerson.trim();
    }

    public String getSelKeeper() {
        return selKeeper;
    }

    public void setSelKeeper(String selKeeper) {
        this.selKeeper = selKeeper == null ? null : selKeeper.trim();
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

    public String getBusinessLine() {
        return businessLine;
    }

    public void setBusinessLine(String businessLine) {
        this.businessLine = businessLine == null ? null : businessLine.trim();
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