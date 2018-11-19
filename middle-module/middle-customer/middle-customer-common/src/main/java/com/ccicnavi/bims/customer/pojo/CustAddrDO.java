package com.ccicnavi.bims.customer.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.io.Serializable;
import java.util.Date;

/**
 * 客户地址
 */
@Setter
@Getter
@ToString
public class CustAddrDO implements Serializable {

    private String addrUuid;

    private String custUuid;

    private String custAddr;

    private String custRegion;

    private String custAddrEn;

    private String addrType;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String prodCatalogUuid;

    private String orgUuid;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;

    private String [] uuids;//要删除的客户地址主键
}
