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
    /**
     * 工作单明细主键
     */
    private String worksheetItemUuid;
    /**
     *工作单主键
     */
    private String worksheetUuid;
    /**
     * 委托服务项主键
     */
    private String orderItemUuid;
    /**
     * 最小颗粒度主键
     */
    private String itemSubUuid;
}
