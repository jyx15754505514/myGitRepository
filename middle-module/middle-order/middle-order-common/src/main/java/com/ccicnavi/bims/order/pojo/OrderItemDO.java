package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 委托服务项目DO
 * @author: panyida
 * @create: 2018-11-19 15:39
 **/
@Getter
@Setter
@ToString
public class OrderItemDO implements Serializable {
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

}
