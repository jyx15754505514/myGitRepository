package com.ccicnavi.bims.order.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * @Author MengZiJie
 * @Description 委托单DTO
 * @Date 9:23 2018/11/20
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
public class OrderInfoDTO implements Serializable {
    /**
     *委托单主键
     */
    private String orderUuid;
    /**
     *产品分类id
     */
    private String productCategoryUuid;
    /**
     *委托编号
     */
    private String orderNo;
    /**
     *委托单名称
     */
    private String orderName;
    /**
     * 委托日期
     */
    private Date orderDate;
    /**
     * 委托区域id
     */
    private String orderAreaId;
    /**
     * 外部编号
     */
    private String crmExternalNo;
    /**
     * 客户id
     */
    private String crmUuid;
    /**
     * 客户名称
     */
    private String crmName;
    /**
     * 联系人
     */
    private String crmLinkman;
    /**
     * 联系人电话
     */
    private String crmTelphone;
    /**
     * 联系人邮箱
     */
    private String crmEmail;
    /**
     * 贸易合同编号
     */
    private String crmContractNo;
    /**
     * 联检方
     */
    private String thirdOrgName;
    /**
     * 联检方联系人
     */
    private String thirdOrgLinkman;
    /**
     * 联检方联系人电话
     */
    private String thirdOrgTelphone;
    /**
     * 委托项目名称
     */
    private String orderItemName;
    /**
     * 委托项目类型
     */
    private String orderItemType;
    /**
     * 项目规格
     */
    private String orderItemSpec;
    /**
     * 项目标识
     */
    private String orderItemSign;
    /**
     * 数量
     */
    private Integer orderItemQty;
    /**
     * 数量单位
     */
    private String orderItemQtyUnit;
    /**
     * 使用标准id
     */
    private String useStdUuid;
    /**
     * 使用标准名称
     */
    private String useStdName;
    /**
     * 标准说明
     */
    private String useStdComment;
    /**
     * 总费用
     */
    private Integer totalFee;
    /**
     * 首次计费日期
     */
    private Date firstFeeDate;
    /**
     * 是Y否N内部委托单
     */
    private String isInternal;
    /**
     * 委托人来源
     */
    private String orderCrmSource;
    /**
     * 委托单来源机构id
     */
    private String sourceOrgUuid;
    /**
     * 委托单来源机构名称
     */
    private String sourceOrgName;
    /**
     * 计划检验时间
     */
    private Date planInspectDate;
    /**
     * 计划检验地
     */
    private Date planInspectAddr;
    /**
     * 备注
     */
    private String comments;
    /**
     * 币种id
     */
    private String currencyType;
    /**
     * 结论方式
     */
    private String conclusionType;
    /**
     * 证书语种id
     */
    private String certLangUuid;
    /**
     * 证书正本数量
     */
    private Integer certQty;
    /**
     * 证书副本数量
     */
    private Integer certCopyQty;
    /**
     * 受理日期
     */
    private Date acceptDate;
    /**
     * 受理机构id
     */
    private String acceptOrgUuid;
    /**
     * 受理机构名称（公司名称）
     */
    private String acceptOrgName;
    /**
     * 状态uuid
     */
    private String statusUuid;
    /**
     * 状态名称
     */
    private String statusName;
    /**
     * 是Y否N分包标记，默认为N
     */
    private String lblSubpkg;
    /**
     * 是Y否N执行标记，默认为N
     */
    private String lblExec;
    /**
     * 委托方是Y否N具备专业能力，默认为N
     */
    private String lblCrmCapc;
    /**
     * 是Y否N需要评审，默认为N
     */
    private String isReview;
    /**
     * 删除标识（N正常Y删除）
     */
    private String isDeleted;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 创建人id
     */
    private String createdUuid;
    /**
     * 创建人
     */
    private String createdName;
    /**
     * 最后一次更新时间
     */
    private Date updatedTime;
    /**
     * 更新人uuid
     */
    private String updatedUuid;
    /**
     * 更新人
     */
    private String updatedName;
    /**
     * 产品线id
     */
    private String prodCatalogUuid;
    /**
     * 归属机构id
     */
    private String orgUuid;
    /**
     * 应用系统id
     */
    private String appSysUuid;
    /**
     * 委托单当前状态
     */
    private String currentStatus;
    /**
     * 委托单下一状态
     */
    private String nextStatus;
    /**
     * 委托单id集合
     */
    private List<String> orderUuids;
    /**
     * 运输方式id
     */
    private String shippingTypeId;
    /**
     * 船名
     */
    private String vesselName;
    /**
     * 提单号
     */
    private String blNo;
    /**
     * 航次
     */
    private String voyageName;
    /**
     * 起运港
     */
    private String dispathPortId;
    /**
     * 目的港
     */
    private String destPortId;
    /**
     *装货港
     */
    private String loadingPortId;
    /**
     *卸货港
     */
    private String dischargePortId;
    /**
     *贸易性质
     */
    private String tradeNatureId;
    /**
     *海关证书号
     */
    private String customsCertNo;
    /**
     *海关报关号
     */
    private String customsDeclNo;
    /**
     *报验人
     */
    private String inspectionPerson;
    /**
     *重量
     */
    private String weight;
    /**
     *重量单位
     */
    private String weightUnit;
    /**
     *发货人
     */
    private String consignerName;
    /**
     *收货人
     */
    private String consigneeName;
    /**
     *提供单证id，以逗号区分
     */
    private String provideCertUuid;
    /**
     *提供单证的名称，以逗号区分
     */
    private String provideCertName;
    /**
     *是Y否N出证，默认N
     */
    private String isOpenCert;
    /**
     *服务项
     */
    private List<OrderItemDTO> orderItemDTO;
    /**
     *委托样品类型
     */
    private List<OrderSampleTypeDO> orderSampleTypeDO;
    /**
     * 运输信息
     */
    private OrderInspectionDO orderInspectionDO;
}
