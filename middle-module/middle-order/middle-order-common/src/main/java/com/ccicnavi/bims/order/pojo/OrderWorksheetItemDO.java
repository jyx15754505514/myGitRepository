package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
/**
 * @Author songyateng
 * @Description 工作单与服务项实体
 * @Date 17:40 2018/11/21
 */
@Getter
@Setter
@ToString
public class OrderWorksheetItemDO implements Serializable {

    private String worksheetUuid;

    private String orderItemUuid;//委托服务项目id
}
