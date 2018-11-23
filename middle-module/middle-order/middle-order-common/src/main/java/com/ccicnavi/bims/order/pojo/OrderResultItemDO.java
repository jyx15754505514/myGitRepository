package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author heibin
 * @Description 委托服务项-证书关系
 * @Date 20:14 2018/11/20
 */
@Getter
@Setter
@ToString
public class OrderResultItemDO  implements Serializable {
    /**
     * 主键
     */
    private String resultItemUuid;
    /**
     * 结果报告ID
     */
    private String resultUuid;
    /**
     * 委托单ID
     */
    private String orderUuid;
    /**
     * 委托服务项ID
     */
    private String orderItemUuid;
}
