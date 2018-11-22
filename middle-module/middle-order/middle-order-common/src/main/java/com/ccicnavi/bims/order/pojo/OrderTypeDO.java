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

    private String orderTypeId;

    private String parentTypeId;

    private String hasTable;

    private String typeName;
}
