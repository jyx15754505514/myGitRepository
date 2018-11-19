package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@ToString
/**
 * @program: bims-backend
 * @description: 非工作日DO实体类
 * @author: zhaotao
 * @create: 2018-11-14 23:33
 **/
public class NotworkdayDO implements Serializable{

    private List<String> uuids;

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

    private String prodCatalogUuid;

    private String extend1;

    private String extend2;

    private String extend3;


}