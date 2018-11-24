package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
/**
 * @Author songyateng
 * @Description 订单类型DO
 * @Date 17:15 2018/11/22
 * @Param
 * @Return
 */
@Getter
@Setter
@ToString
public class OrderTypeDO implements Serializable {
    /**
     * 主键
     */
    private String orderTypeId;
    /**
     *订单类型ID
     */
    private String parentTypeId;
    /**
     *是Y否N有子表，默认N
     */
    private String hasTable;
    /**
     * 类型名称
     */
    private String typeName;
}
