package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: bims-backend
 * @description: 委托单最小服务项子项（最小颗粒度）DO
 * @author: heibin
 * @create: 2018-11-20 9:36
 **/
@Getter
@Setter
@ToString
public class OrderItemSubDO {
    private String subItemUuid;

    private String itemUuid;

    private String subItemNo;

    private String itemName;

    private String productTestItemUuid;

}
