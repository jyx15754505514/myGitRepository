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

    private String orderUuid; //委托单id

    private String productCategoryUuid;//产品分类id

    private String orderNo; //委托编号

    private String orderName; //委托名称

    private Date orderDate; //委托日期

    private String orderCrmNo;  //客户号

    private String orderAreaId; //区域id

    private String crmUuid; //客户id

    private String crmName; //客户名称

    private String crmLinkman; //联系人

    private String crmTelphone; //联系人电话

    private String crmEmail; //联系人邮箱

    private String crmContractNo; //合同编号

    private String crmEmerName; //紧急联系人

    private String orderItemName; //委托项目名称

    private String orderItemType; //委托项目类型

    private String orderItemSpec; //项目规格

    private Integer orderItemQty; //数量

    private String orderItemQtyUnit; //数量单位

    private String useStdUuid; //使用标准id

    private String useStdName; //使用标准名称

    private String useStdComment; //标准说明

    private Integer totalFee; //总费用

    private Date firstFeeDate; //首次计费日期

    private String isInternal; //是Y否N内部委托单

    private String sourceOrgUuid; //委托单来源机构id

    private String sourceOrgName; //委托单来源机构名称

    private Date planInspectDate; //计划检验时间

    private Date planInspectAddr; //计划检验地

    private String comments; //备注

    private String currencyType; //币种id

    private String conclusionType; //结论方式

    private String certLangUuid; //证书语种id

    private Date acceptDate; //受理日期

    private String statusUuid; //状态uuid

    private String statusName; //状态名称

    private String isDeleted; //删除标识（N正常Y删除）

    private Date createdTime; //创建时间

    private String createdUuid; //创建人id

    private String createdName; //创建人

    private Date updatedTime; //最后一次更新时间

    private String updatedUuid; //更新人uuid

    private String updatedName; //更新人

    private String prodCatalogUuid; //'产品线id

    private String orgUuid; //归属机构id

    private String appSysUuid; //应用系统id

    private String shippingTypeId; //运输单信息

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
