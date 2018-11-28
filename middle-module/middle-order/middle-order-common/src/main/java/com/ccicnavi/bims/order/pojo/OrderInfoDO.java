package com.ccicnavi.bims.order.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 订单主信息DO
 * @author: panyida
 * @create: 2018-11-19 15:26
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderInfoDO implements Serializable {
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
     * 预留字段1
     */
    private String extend1;
    /**
     * 预留字段2
     */
    private String extend2;
    /**
     * 预留字段3
     */
    private String extend3;

}
