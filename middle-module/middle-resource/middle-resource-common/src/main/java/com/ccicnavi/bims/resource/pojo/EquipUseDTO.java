package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 设备领用归还信息DTO
 * @author: panyida
 * @create: 2018-11-16 20:57
 **/
@Getter
@Setter
@ToString
public class EquipUseDTO implements Serializable {
    private String equipUseUuid;

    private String equipUuid;

    private Date useDate;

    private String usePerson;

    private String useDept;

    private Date backDate;

    private String prodCatalogPuid;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;

    private String equipName;

    private String equipNameEn;

    private String equipSpec;

    private String factoryNo;

    private String manufacture;

    private String useDeptUuid;
}
