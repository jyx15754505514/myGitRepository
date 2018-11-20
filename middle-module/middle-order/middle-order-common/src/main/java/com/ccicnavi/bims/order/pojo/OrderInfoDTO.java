package com.ccicnavi.bims.order.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/* *
 * @Author MengZiJie
 * @Description 委托单DTO
 * @Date 9:23 2018/11/20
 */
public class OrderInfoDTO implements Serializable {

    private String orderUuid;//委托单基本信息

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

    private String shippingTypeId;//运输方式

    private String shipName;

    private String voyageName;

    private String dispathPortId;

    private String destPortId;

    private String loadingPortId;

    private String dischargePortId;

    private String tradeNatureId;

    private String customsCertNo;

    private String customsDeclNo;

    private String inspectionPerson;

    private String weight;

    private String weightUnit;

    List<OrderItemDTO> orderItemDTO;//服务项
}
