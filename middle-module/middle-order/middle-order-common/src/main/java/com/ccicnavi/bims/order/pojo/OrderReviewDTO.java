package com.ccicnavi.bims.order.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/29 16:26
 * @Description:
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderReviewDTO {
    /**
     * 服务项信息
     */
    private List<OrderItemDTO> orderItemDTOList;
    /**
     * 评审信息
     */
    private List<OrderReviewDO> orderReviewDOList;

    /**
     *委托编号
     */
    private String orderNo;
    /**
     *委托单主键
     */
    private String orderUuid;
    /**
     *委托单名称
     */
    private String orderName;
    /**
     *委托日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String orderDate;

    /**
     *客户名称
     */
    private String crmName;
    /**
     *联系人
     */
    private String crmLinkman;
    /**
     *联系人电话
     */
    private String crmTelphone;
}
