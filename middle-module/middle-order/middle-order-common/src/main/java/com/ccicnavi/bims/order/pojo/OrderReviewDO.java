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
    /**
     * 评审主键
     */
    private String orderReviewUuid;
    /**
     * 委托单主键
     */
    private String orderUuid;
    /**
     * 评审人uuid
     */
    private String reviewUserUuid;
    /**
     * 评审意见
     */
    private String reviewSuggest;
    /**
     * 评审日期
     */
    private Date reviewDate;
    /**
     * 评审通过
     */
    private String isPass;
    /**
     * 扩展字段1
     */
    private String extend1;
    /**
     * 扩展字段2
     */
    private String extend2;
    /**
     * 扩展字段3
     */
    private String extend3;

}
