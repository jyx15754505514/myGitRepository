package com.ccicnavi.bims.order.pojo;/* *
 * @Author heibin
 * @Description
 * @Date
 * @Param
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Getter
@Setter
@ToString
public class OrderWorksheetCostDo implements Serializable {

    private String worksheetCostUuid;

    private String worksheetUuid;

    private String orderItemUuid;

    private String costTypeId;

    private String costTypeName;

    private Integer costFee;

    private String comments;

    private String extend1;

    private String extend2;

    private String extend3;
}
