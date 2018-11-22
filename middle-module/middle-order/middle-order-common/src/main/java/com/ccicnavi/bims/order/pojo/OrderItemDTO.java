package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * @Author MengZiJie
 * @Description 委托单服务项DTO
 * @Date 9:30 2018/11/20
 */
@Getter
@Setter
@ToString
public class OrderItemDTO implements Serializable {

    private String orderItemUuid;

    private String orderUuid;

    private String orderItemNo;

    private String minItemName;

    private String minItemUuid;

    private String minItemType;

    private Integer receivableAmount;

    private Integer refAmount;

    private String refWorkhour;

    private String isSubpkg;

    private String isSubpkgMgr;

    private String receOrgUuid;

    private String receOrgName;

    private String receUserUuid;

    private Date receUserTime;

    private String useStdUuid;

    private String useStdName;

    private String statusUuid;

    private String statusName;

    private String isBack;

    private String backReason;

    private String isCancel;

    private String cancelReason;

    private String isUrgent;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedUuid;

    private String updatedName;

    private List<OrderItemSubDO> orderItemSubDO;//子项

    private List<OrderItemCostDO> orderItemCostDo;//成本

    private String flag;
}
