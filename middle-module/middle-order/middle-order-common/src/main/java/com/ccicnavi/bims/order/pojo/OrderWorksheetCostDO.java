package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
/**
 * @Author songyateng
 * @Description 工作单与服务项实体
 * @Date 20:00 2018/11/21
 */
@Getter
@Setter
@ToString
public class OrderWorksheetCostDO implements Serializable {

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
