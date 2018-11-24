package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 设备领用归还信息DO
 * @author: panyida
 * @create: 2018-11-15 19:32
 **/
@Getter
@Setter
@ToString
public class EquipUseDO implements Serializable {

    private String equipUseUuid;

    private String equipUuid;

    private Date useDate;

    private String usePerson;

    private String useDept;

    private Date backDate;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedUuid;

    private String updatedName;

    private String prodCatalogUuid;

    private String orgUuid;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;
}
