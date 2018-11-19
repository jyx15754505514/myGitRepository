package com.ccicnavi.bims.order.service;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 订单主信息DO
 * @author: panyida
 * @create: 2018-11-19 15:26
 **/
@Getter
@Setter
@ToString
public class OrderInfoDO implements Serializable {
    private String orderUuid;

    private String prodCatalogUuid;

    private String productCategoryId;

    private String orderNo;

    private String orderName;

    private Date orderDate;

    private String orderCrmNo;

    private String orderAreaId;

    private String crmUuid;

    private String crmName;

    private String crmLinkman;

    private String crmContractNo;

    private String orderItemName;

    private String orderItemType;

    private String orderItemSpec;

    private Integer orderItemQty;

    private String orderItemQtyUnit;

    private String useStdName;

    private String useStdUuid;

    private Integer totalFee;

    private String statusUuid;

    private String isInternal;

    private String sourceOrgUuid;

    private String sourceOrgName;

    private Date planInspectDate;

    private Date planInspectAddr;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private List<String> orderUuidList;
}
