package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author songyateng
 * @Description 成本单DO
 * @Date 14:19 2018/11/22
 */
@Getter
@Setter
@ToString
public class OrderItemCostDo implements Serializable {

    private String itemCostUuid;

    private String orderItemUuid;

    private String costTypeId;

    private String costTypeName;

    private Integer costFee;

    private String applyUserUuid;

    private Date applyDate;

    private String comments;

    private String extend1;

    private String extend2;

    private String extend3;

}
