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
    private String resultItemUuid;

    private String resultUuid;

    private String orderUuid;

    private String orderItemUuid;
}
