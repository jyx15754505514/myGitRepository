package com.ccicnavi.bims.resource.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 设备保管信息DO
 * @author: panyida
 * @create: 2018-11-14 11:30
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
public class EquipHoldDO implements Serializable {
    private String equipHoldUuid;

    private String equipUuid;

    private Date useDate;

    private String assetsCode;

    private String useDeptUuid;

    private String useDeptName;

    private Date purchaseDate;

    private Integer purchasePrice;

    private Integer purchaseCount;

    private String agencyUuid;

    private String agencyName;

    private String deptUuid;

    private String deptName;

    private String mgrUuid;

    private String mgrName;

    private String locationAddr;

    private String prodCatalogUuid;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;
}
