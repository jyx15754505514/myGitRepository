package com.ccicnavi.bims.order.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;

/**
 * @Author heibin
 * @Description 委托样品类型
 * @Date 20:30 2018/11/21
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderSampleTypeDO implements Serializable {
    /**
     * 委托单样品主键
     */
    private String orderSplUuid;
    /**
     * 委托单主键
     */
    private String orderUuid;
    /**
     * 样品类型id（意图）
     */
    private String splPurposeType;
    /**
     * 样品数量（意图）
     */
    private Integer splPurposeQty;
}
