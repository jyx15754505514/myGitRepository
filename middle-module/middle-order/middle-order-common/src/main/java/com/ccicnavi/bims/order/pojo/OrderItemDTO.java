package com.ccicnavi.bims.order.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * @Author MengZiJie
 * @Description 委托单服务项DTO
 * @Date 9:30 2018/11/20
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemDTO implements Serializable {
    /**
     *主键id
     */
    private String orderItemUuid;
    /**
     *委托单id
     */
    private String orderUuid;
    /**
     *服务单编号
     */
    private String orderItemNo;
    /**
     *服务项名称
     */
    private String minItemName;
    /**
     *服务项id
     */
    private String minItemUuid;
    /**
     *服务项分类
     */
    private String minItemType;
    /**
     *参考金额（基准费用）
     */
    private Integer refAmount;
    /**
     *应收金额
     */
    private Integer receivableAmount;
    /**
     *应收折扣
     */
    private Integer refDiscount;
    /**
     *折扣价
     */
    private Integer refDiscountPrice;
    /**
     *参考工时
     */
    private String refWorkhour;
    /**
     *币种
     */
    private String currencyType;
    /**
     *等值外币
     */
    private Integer currencyAmount;
    /**
     *是Y否N分包，默认N
     */
    private String isSubpkg;
    /**
     *是Y否N分包管理，默认Y
     */
    private String isSubpkgMgr;
    /**
     *派单人id
     */
    private String assignUserUuid;
    /**
     *派单时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date assignTime;
    /**
     *派单说明
     */
    private String assignComments;
    /**
     *接收任务机构id
     */
    private String receOrgUuid;
    /**
     *接收任务的机构名称
     */
    private String receOrgName;
    /**
     *接收任务的人id
     */
    private String receUserUuid;
    /**
     *接收到任务的时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date receUserTime;
    /**
     *使用标准id
     */
    private String useStdUuid;
    /**
     *使用标准名称
     */
    private String useStdName;
    /**
     *状态id
     */
    private String statusUuid;
    /**
     *状态名称
     */
    private String statusName;
    /**
     *是Y否N退回，默认N
     */
    private String isBack;
    /**
     *退回原因
     */
    private String backReason;
    /**
     *是Y否N退检
     */
    private String isCancel;
    /**
     *退检原因
     */
    private String cancelReason;
    /**
     *是Y否N加急，默认N
     */
    private String isUrgent;
    /**
     *计划开工日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date planStartworkDate;
    /**
     *计划完工日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date planFinishworkDate;
    /**
     *计划开工说明
     */
    private String planStartworkComments;
    /**
     *实际开工日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date realStartworkDate;
    /**
     *实际完工日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date realFinisthworkDate;
    /**
     *实际完工说明
     */
    private String realFinishworkComments;
    /**
     *完工数量标记1/5
     */
    private String finishQtyLbl;
    /**
     *备注
     */
    private String comments;
    /**
     *删除标识（N正常Y删除）
     */
    private String isDeleted;
    /**
     *创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;
    /**
     *创建人id
     */
    private String createdUuid;
    /**
     *创建人
     */
    private String createdName;
    /**
     *最后一次更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedTime;
    /**
     *更新人uuid
     */
    private String updatedUuid;
    /**
     *更新人
     */
    private String updatedName;
    /**
     *预留字段1
     */
    private String extend1;
    /**
     *预留字段2
     */
    private String extend2;
    /**
     *预留字段3
     */
    private String extend3;
    /**
     *子项
     */
    private List<OrderItemSubDO> orderItemSubDO;
    /**
     *成本
     */
    private List<OrderItemCostDO> orderItemCostDO;
    /**
     *flag
     */
    private String flag;
    /**
     * 主键uuids
     */
    private List<String> orderItemUuids;




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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date planInspectDate;
    /**
     * 计划检验地
     */
    private String planInspectAddr;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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

}
