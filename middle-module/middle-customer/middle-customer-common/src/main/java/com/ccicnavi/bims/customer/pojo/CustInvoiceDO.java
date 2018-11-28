package com.ccicnavi.bims.customer.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
  * @author songyateng
  * @description 客户发票
  * @date 2018/11/26 10:00
  */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustInvoiceDO implements Serializable {
    /**
     * 发票主键
     */
    private String invoiceUuid;
    /**
     * 客户主键
     */
    private String custUuid;
    /**
     * 发票抬头
     */
    private String invoiceTitle;
    /**
     * 发票类型
     */
    private String invoiceType;
    /**
     * 纳税人识别号
     */
    private String taxpayerCode;
    /**
     * 开户行
     */
    private String bankName;
    /**
     * 银行账号
     */
    private String bankAccount;
    /**
     * 金额
     */
    private Integer money;
    /**
     * 是否一般纳税人（N都Y是）
     */
    private String isTaxpayer;
    /**
     * 备注
     */
    private String comments;
    /**
     * 删除标识（N正常Y删除）
     */
    private String isDeleted;
    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;
    /**
     * 创建人
     */
    private String createdUuid;
    /**
     * 创建人名称
     */
    private String createdName;
    /**
     * 更新日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedTime;
    /**
     * 更新人名称
     */
    private String updatedName;
    /**
     * 更新人UUID
     */
    private String updatedUuid;
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
    /**
     * 要删除的客户发票主键
     */
    private List<String> uuids;
}
