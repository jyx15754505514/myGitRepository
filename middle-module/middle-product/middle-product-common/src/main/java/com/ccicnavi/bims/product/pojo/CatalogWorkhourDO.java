package com.ccicnavi.bims.product.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 产品线工时工资DO
 * @author: LiJie
 * @create: 2018-11-19 18:13
 */
@Setter
@Getter
@ToString
public class CatalogWorkhourDO implements Serializable {

    /**组织机构*/
    private String organizationUuid;

    /**产品线ID*/
    private String prodCatalogUuid;

    private String salaryWorkhour;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedUuid;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;
}
