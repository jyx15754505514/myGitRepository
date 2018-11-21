package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
/* *
 * @Author MengZiJie
 * @Description 委托单DTO
 * @Date 9:23 2018/11/20
 */
@Getter
@Setter
@ToString
public class OrderInfoDTO implements Serializable {

    private String orderUuid;//委托单

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

    private Date acceptDate;

    private String acceptOrgUuid;

    private String acceptOrgName;

    private String statusUuid;

    private String statusName;

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

    private String currentStatus;//委托单当前状态

    private String nextStatus;//委托单下一状态

    private List<String> orderUuids;//委托单id集合

    private String shippingTypeId;//运输单信息

    private String vesselName;

    private String blNo;

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

    private String consignerName;

    private String consigneeName;

    private String provideCertUuid;

    private String provideCertName;

    private String isOpenCert;

    List<OrderItemDTO> orderItemDTO;//服务项
}
