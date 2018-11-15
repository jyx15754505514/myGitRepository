package com.ccicnavi.bims.resource.pojo;





import lombok.ToString;

import java.util.Date;

@ToString
public class PersonWorkExpeDO {
    private String workExpeUuid;

    private String personUuid;

    private Date startWorkTime;

    private Date endWorkTime;

    private String witness;

    private String orgName;

    private String deptName;

    private String job;

    private String jobContent;

    private String isGrassWork;

    private String isExpatriateWork;

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

    public PersonWorkExpeDO(String workExpeUuid, String personUuid, Date startWorkTime, Date endWorkTime, String witness, String orgName, String deptName, String job, String jobContent, String isGrassWork, String isExpatriateWork, String comments, String isDeleted, Date createdTime, String createdUuid, String createdName, Date updatedTime, String updatedName, String orgUuid, String appSysUuid, String businessLine, String extend1, String extend2, String extend3) {
        this.workExpeUuid = workExpeUuid;
        this.personUuid = personUuid;
        this.startWorkTime = startWorkTime;
        this.endWorkTime = endWorkTime;
        this.witness = witness;
        this.orgName = orgName;
        this.deptName = deptName;
        this.job = job;
        this.jobContent = jobContent;
        this.isGrassWork = isGrassWork;
        this.isExpatriateWork = isExpatriateWork;
        this.comments = comments;
        this.isDeleted = isDeleted;
        this.createdTime = createdTime;
        this.createdUuid = createdUuid;
        this.createdName = createdName;
        this.updatedTime = updatedTime;
        this.updatedName = updatedName;
        this.orgUuid = orgUuid;
        this.appSysUuid = appSysUuid;
        this.businessLine = businessLine;
        this.extend1 = extend1;
        this.extend2 = extend2;
        this.extend3 = extend3;
    }

    public PersonWorkExpeDO() {
    }

    public void setWorkExpeUuid(String workExpeUuid) {
        this.workExpeUuid = workExpeUuid;
    }

    public void setPersonUuid(String personUuid) {
        this.personUuid = personUuid;
    }

    public void setStartWorkTime(Date startWorkTime) {
        this.startWorkTime = startWorkTime;
    }

    public void setEndWorkTime(Date endWorkTime) {
        this.endWorkTime = endWorkTime;
    }

    public void setWitness(String witness) {
        this.witness = witness;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public void setIsGrassWork(String isGrassWork) {
        this.isGrassWork = isGrassWork;
    }

    public void setIsExpatriateWork(String isExpatriateWork) {
        this.isExpatriateWork = isExpatriateWork;
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

    public String getWorkExpeUuid() {
        return workExpeUuid;
    }

    public String getPersonUuid() {
        return personUuid;
    }

    public Date getStartWorkTime() {
        return startWorkTime;
    }

    public Date getEndWorkTime() {
        return endWorkTime;
    }

    public String getWitness() {
        return witness;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getJob() {
        return job;
    }

    public String getJobContent() {
        return jobContent;
    }

    public String getIsGrassWork() {
        return isGrassWork;
    }

    public String getIsExpatriateWork() {
        return isExpatriateWork;
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