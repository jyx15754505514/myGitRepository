package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/* *
 * @Author heibin
 * @Description 委托样品类型
 * @Date 20:30 2018/11/21
 */
@Getter
@Setter
@ToString
public class OrderSampleTypeDO implements Serializable {
    private String orderSplUuid;

    private String orderUuid;

    private String splPurposeType;

    private Integer splPurposeQty;
}
