package com.ccicnavi.bims.order.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
/**
 * @Author MengZiJie
 * @Description 委托单服务项子项
 * @Date 9:37 2018/11/20
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemSubDO implements Serializable {
    /**
     * 主键
     */
    private String subItemUuid;
    /**
     * 服务项目id
     */
    private String itemUuid;
    /**
     * 服务项子项编号
     */
    private String subItemNo;
    /**
     * 子项名称
     */
    private String itemName;
    /**
     * 子项名称id
     */
    private String productTestItemUuid;
}
