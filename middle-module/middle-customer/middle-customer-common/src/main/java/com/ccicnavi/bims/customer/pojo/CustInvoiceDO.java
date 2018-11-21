package com.ccicnavi.bims.customer.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 客户发票
 */
@Setter
@Getter
@ToString
public class CustInvoiceDO implements Serializable {
    private String invoiceUuid;

    private String custUuid;

    private String invoiceTitle;

    private String invoiceType;

    private String taxpayerCode;

    private String bankName;

    private String bankAccount;

    private Integer money;

    private String isTaxpayer;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String updatedUuid;
    private String extend1;

    private String extend2;

    private String extend3;

    private List<String> uuids;//要删除的客户发票主键
}
