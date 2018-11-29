package com.ccicnavi.bims.order.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
/**
 * @Author songyateng
 * @Description 工作单与服务项实体
 * @Date 17:40 2018/11/21
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderWorksheetItemDO implements Serializable {
    /**
     * 工作单明细主键
     */
    private String worksheetItemUuid;
    /**
     *工作单id
     */
    private String worksheetUuid;
    /**
     * 委托服务项目id
     */
    private String orderItemUuid;

}
