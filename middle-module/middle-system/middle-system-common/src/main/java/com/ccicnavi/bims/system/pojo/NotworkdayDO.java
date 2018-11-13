package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString
public class NotworkdayDO implements Serializable{
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


}