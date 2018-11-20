package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/20 10:03
 * @Description:
 */
@Getter
@Setter
@ToString
public class OrderReviewDO implements Serializable {
    private String orderUuid;//委托单uuid

    private String reviewUserUuid; //评审人uuid

    private String reviewSuggest;//评审人意见

    private Date reviewDate;//评审日期

    private String isPass;//评审通过

    private String extend1;

    private String extend2;

    private String extend3;

}
