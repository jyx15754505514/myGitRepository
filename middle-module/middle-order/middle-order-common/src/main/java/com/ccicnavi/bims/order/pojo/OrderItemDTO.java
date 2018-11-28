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
@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
public class OrderItemDTO implements Serializable {
    /**
     *主键
     */
    private String orderItemUuid;
    /**
     * 委托单id
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
     *应收金额
     */
    private Integer receivableAmount;
    /**
     *参考金额
     */
    private Integer refAmount;
    /**
     *参考工时
     */
    private String refWorkhour;
    /**
     *应收折扣
     */
    private Integer refDiscount;
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
}
