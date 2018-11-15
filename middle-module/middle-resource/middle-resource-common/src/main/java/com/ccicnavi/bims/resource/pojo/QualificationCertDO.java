package com.ccicnavi.bims.resource.pojo;


import lombok.ToString;

import java.util.Date;

@ToString
public class QualificationCertDO {
    private String cationUuid;

    private String personUuid;

    private String cationCertUuid;

    private String cationCertName;

    private String cationAreasUuid;

    private String cationLevl;

    private String cationCertNo;

    private String cationCompany;

    private Date issueDate;

    private Date updateDate;

    private String registerNumber;

    private String registerCompany;

    private Date registerDate;

    private String isFile;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private Date updatedTime;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;

    private String businessLine;

    private String extend1;

    private String extend2;

    private String extend3;

    public QualificationCertDO(String cationUuid, String personUuid, String cationCertUuid, String cationCertName, String cationAreasUuid, String cationLevl, String cationCertNo, String cationCompany, Date issueDate, Date updateDate, String registerNumber, String registerCompany, Date registerDate, String isFile, String isDeleted, Date createdTime, String createdUuid, Date updatedTime, String updatedName, String orgUuid, String appSysUuid, String businessLine, String extend1, String extend2, String extend3) {
        this.cationUuid = cationUuid;
        this.personUuid = personUuid;
        this.cationCertUuid = cationCertUuid;
        this.cationCertName = cationCertName;
        this.cationAreasUuid = cationAreasUuid;
        this.cationLevl = cationLevl;
        this.cationCertNo = cationCertNo;
        this.cationCompany = cationCompany;
        this.issueDate = issueDate;
        this.updateDate = updateDate;
        this.registerNumber = registerNumber;
        this.registerCompany = registerCompany;
        this.registerDate = registerDate;
        this.isFile = isFile;
        this.isDeleted = isDeleted;
        this.createdTime = createdTime;
        this.createdUuid = createdUuid;
        this.updatedTime = updatedTime;
        this.updatedName = updatedName;
        this.orgUuid = orgUuid;
        this.appSysUuid = appSysUuid;
        this.businessLine = businessLine;
        this.extend1 = extend1;
        this.extend2 = extend2;
        this.extend3 = extend3;
    }

    public QualificationCertDO() {

    }

    public void setCationUuid(String cationUuid) {
        this.cationUuid = cationUuid;
    }

    public void setPersonUuid(String personUuid) {
        this.personUuid = personUuid;
    }

    public void setCationCertUuid(String cationCertUuid) {
        this.cationCertUuid = cationCertUuid;
    }

    public void setCationCertName(String cationCertName) {
        this.cationCertName = cationCertName;
    }

    public void setCationAreasUuid(String cationAreasUuid) {
        this.cationAreasUuid = cationAreasUuid;
    }

    public void setCationLevl(String cationLevl) {
        this.cationLevl = cationLevl;
    }

    public void setCationCertNo(String cationCertNo) {
        this.cationCertNo = cationCertNo;
    }

    public void setCationCompany(String cationCompany) {
        this.cationCompany = cationCompany;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public void setRegisterCompany(String registerCompany) {
        this.registerCompany = registerCompany;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public void setIsFile(String isFile) {
        this.isFile = isFile;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public void setCreatedUuid(String createdUuid) {
        this.createdUuid = createdUuid;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public void setUpdatedName(String updatedName) {
        this.updatedName = updatedName;
    }

    public void setOrgUuid(String orgUuid) {
        this.orgUuid = orgUuid;
    }

    public void setAppSysUuid(String appSysUuid) {
        this.appSysUuid = appSysUuid;
    }

    public void setBusinessLine(String businessLine) {
        this.businessLine = businessLine;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3;
    }

    public String getCationUuid() {
        return cationUuid;
    }

    public String getPersonUuid() {
        return personUuid;
    }

    public String getCationCertUuid() {
        return cationCertUuid;
    }

    public String getCationCertName() {
        return cationCertName;
    }

    public String getCationAreasUuid() {
        return cationAreasUuid;
    }

    public String getCationLevl() {
        return cationLevl;
    }

    public String getCationCertNo() {
        return cationCertNo;
    }

    public String getCationCompany() {
        return cationCompany;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public String getRegisterCompany() {
        return registerCompany;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public String getIsFile() {
        return isFile;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public String getCreatedUuid() {
        return createdUuid;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public String getUpdatedName() {
        return updatedName;
    }

    public String getOrgUuid() {
        return orgUuid;
    }

    public String getAppSysUuid() {
        return appSysUuid;
    }

    public String getBusinessLine() {
        return businessLine;
    }

    public String getExtend1() {
        return extend1;
    }

    public String getExtend2() {
        return extend2;
    }

    public String getExtend3() {
        return extend3;
    }
}