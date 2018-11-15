package com.ccicnavi.bims.resource.pojo;





import lombok.ToString;

import java.util.Date;


@ToString
public class PersonWorkDO {
    private String personUuid;

    private String workUuid;

    private String personType;

    private String deptUuid;

    private String position;

    private Date joinJobTime;

    private Date regularTime;

    private Date joinAppTime;

    private Date joinOrgTime;

    private Date postTime;

    private String postName;

    private String email;

    private String fax;

    private String officePhone;

    private String workAddr;

    private String isUploadFile;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String orgUuid;

    private String orgName;

    private String appSysUuid;

    private String businessLine;

    private String extend1;

    private String extend2;

    private String extend3;

    public PersonWorkDO(String personUuid, String workUuid, String personType, String deptUuid, String position, Date joinJobTime, Date regularTime, Date joinAppTime, Date joinOrgTime, Date postTime, String postName, String email, String fax, String officePhone, String workAddr, String isUploadFile, String comments, String isDeleted, Date createdTime, String createdUuid, String createdName, Date updatedTime, String updatedName, String orgUuid, String orgName, String appSysUuid, String businessLine, String extend1, String extend2, String extend3) {
        this.personUuid = personUuid;
        this.workUuid = workUuid;
        this.personType = personType;
        this.deptUuid = deptUuid;
        this.position = position;
        this.joinJobTime = joinJobTime;
        this.regularTime = regularTime;
        this.joinAppTime = joinAppTime;
        this.joinOrgTime = joinOrgTime;
        this.postTime = postTime;
        this.postName = postName;
        this.email = email;
        this.fax = fax;
        this.officePhone = officePhone;
        this.workAddr = workAddr;
        this.isUploadFile = isUploadFile;
        this.comments = comments;
        this.isDeleted = isDeleted;
        this.createdTime = createdTime;
        this.createdUuid = createdUuid;
        this.createdName = createdName;
        this.updatedTime = updatedTime;
        this.updatedName = updatedName;
        this.orgUuid = orgUuid;
        this.orgName = orgName;
        this.appSysUuid = appSysUuid;
        this.businessLine = businessLine;
        this.extend1 = extend1;
        this.extend2 = extend2;
        this.extend3 = extend3;
    }

    public PersonWorkDO() {
    }

    public void setPersonUuid(String personUuid) {
        this.personUuid = personUuid;
    }

    public void setWorkUuid(String workUuid) {
        this.workUuid = workUuid;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public void setDeptUuid(String deptUuid) {
        this.deptUuid = deptUuid;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setJoinJobTime(Date joinJobTime) {
        this.joinJobTime = joinJobTime;
    }

    public void setRegularTime(Date regularTime) {
        this.regularTime = regularTime;
    }

    public void setJoinAppTime(Date joinAppTime) {
        this.joinAppTime = joinAppTime;
    }

    public void setJoinOrgTime(Date joinOrgTime) {
        this.joinOrgTime = joinOrgTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public void setWorkAddr(String workAddr) {
        this.workAddr = workAddr;
    }

    public void setIsUploadFile(String isUploadFile) {
        this.isUploadFile = isUploadFile;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public void setCreatedName(String createdName) {
        this.createdName = createdName;
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

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

    public String getPersonUuid() {
        return personUuid;
    }

    public String getWorkUuid() {
        return workUuid;
    }

    public String getPersonType() {
        return personType;
    }

    public String getDeptUuid() {
        return deptUuid;
    }

    public String getPosition() {
        return position;
    }

    public Date getJoinJobTime() {
        return joinJobTime;
    }

    public Date getRegularTime() {
        return regularTime;
    }

    public Date getJoinAppTime() {
        return joinAppTime;
    }

    public Date getJoinOrgTime() {
        return joinOrgTime;
    }

    public Date getPostTime() {
        return postTime;
    }

    public String getPostName() {
        return postName;
    }

    public String getEmail() {
        return email;
    }

    public String getFax() {
        return fax;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public String getWorkAddr() {
        return workAddr;
    }

    public String getIsUploadFile() {
        return isUploadFile;
    }

    public String getComments() {
        return comments;
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

    public String getCreatedName() {
        return createdName;
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

    public String getOrgName() {
        return orgName;
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