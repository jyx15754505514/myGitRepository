package com.ccicnavi.bims.system.pojo;

import java.io.Serializable;

public class Notworkday implements Serializable{
    private String notworkdayUuid;

    private String year;

    private String month;

    private String day;

    private String startAm;

    private String endAm;

    private String startPm;

    private String endPm;

    private String comments;

    private String isDeleted;

    private String orgUuid;

    private String appSysUuid;

    private String businessLine;

    private String extend1;

    private String extend2;

    private String extend3;

    public String getNotworkdayUuid() {
        return notworkdayUuid;
    }

    public void setNotworkdayUuid(String notworkdayUuid) {
        this.notworkdayUuid = notworkdayUuid == null ? null : notworkdayUuid.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public String getStartAm() {
        return startAm;
    }

    public void setStartAm(String startAm) {
        this.startAm = startAm == null ? null : startAm.trim();
    }

    public String getEndAm() {
        return endAm;
    }

    public void setEndAm(String endAm) {
        this.endAm = endAm == null ? null : endAm.trim();
    }

    public String getStartPm() {
        return startPm;
    }

    public void setStartPm(String startPm) {
        this.startPm = startPm == null ? null : startPm.trim();
    }

    public String getEndPm() {
        return endPm;
    }

    public void setEndPm(String endPm) {
        this.endPm = endPm == null ? null : endPm.trim();
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