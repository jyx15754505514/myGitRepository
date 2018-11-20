package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/* *
 * @Author MengZiJie
 * @Description 委托单服务项DTO
 * @Date 9:30 2018/11/20
 */
@Getter
@Setter
@ToString
public class OrderItemDTO implements Serializable {

    private String orderItemUuid;

    private String minItemName;

    private String minItemUuid;

    private String minItemType;

    private Integer receivableAmount;

    private Integer refAmount;

    private String refWorkhour;

    private String isSubpkg;

    private String isSubpkgMgr;

    private String acceptOrgUuid;

    private String acceptOrgName;

    private String useStdUuid;

    private String useStdName;

    List<OrderItemSubDO> orderItemSubDO;
}
