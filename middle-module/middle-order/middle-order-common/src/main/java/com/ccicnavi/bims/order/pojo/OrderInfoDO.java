package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;

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

    private String productCategoryUuid;

    private String orderNo;

    private String orderName;

    private Date orderDate;

    private String orderCrmNo;

    private String orderAreaId;

    private String crmUuid;

    private String crmName;

    private String crmLinkman;

    private String crmTelphone;

    private String crmEmail;

    private String crmContractNo;

    private String crmEmerName;

    private String crmEmerTelphone;

    private String orderItemName;

    private String orderItemType;

    private String orderItemSpec;

    private Integer orderItemQty;

    private String orderItemQtyUnit;

    private String useStdUuid;

    private String useStdName;

    private String useStdComment;

    private Integer totalFee;

    private Date firstFeeDate;

    private String isInternal;

    private String sourceOrgUuid;

    private String sourceOrgName;

    private Date planInspectDate;

    private Date planInspectAddr;

    private String comments;

    private String currencyType;

    private String conclusionType;

    private String certLangUuid;

    private Integer certQty;

    private Integer certCopyQty;

    private Date acceptDate;

    private String acceptOrgUuid;

    private String acceptOrgName;

    private String statusUuid;

    private String statusName;

    private String lblSubpkg;

    private String lblExec;

    private String lblCrmCapc;

    private String isReview;

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
