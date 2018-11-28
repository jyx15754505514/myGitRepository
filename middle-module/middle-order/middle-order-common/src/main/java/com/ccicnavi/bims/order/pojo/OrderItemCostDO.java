package com.ccicnavi.bims.order.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
/**
 * @Author songyateng
 * @Description 成本单DO
 * @Date 14:19 2018/11/22
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemCostDO implements Serializable {
    /**
     * 主键
     */
    private String itemCostUuid;
    /**
     * 最小服务项id
     */
    private String orderItemUuid;
    /**
     * 成本类型id
     */
    private String costTypeUuid;
    /**
     * 成本名称
     */
    private String costTypeName;
    /**
     * 成本费用
     */
    private Integer costFee;
    /**
     * 申请人
     */
    private String applyUserUuid;
    /**
     * 申请日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date applyDate;
    /**
     * 备注
     */
    private String comments;
    /**
     * 预留字段1
     */
    private String extend1;
    /**
     * 预留字段2
     */
    private String extend2;
    /**
     * 预留字段3
     */
    private String extend3;

}
