package com.ccicnavi.bims.customer.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/23 15:20
 * @Description: 分包方银行信息
 */
public class SubBankDO implements Serializable {
    /**
     * 分包方银行主键
     */
    private String subcBankUuid;
    /**
     * 分包方主键
     */
    private String subcUuid;
    /**
     * 分包方名称
     */
    private String subcCustomer;
    /**
     * 分包方状态
     */
    private String subcStatus;
    /**
     * 分包方银行账号
     */
    private String subcBankAccount;
    /**
     * 开户行地址
     */
    private String subcBankAddr;
    /**
     * 开户行编号
     */
    private String subcBankCode;
    /**
     * 备注信息
     */
    private String comments;
    /**
     * 是否删除
     */
    private String isDeleted;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 创建人UUID
     */
    private String createdUuid;
    /**
     * 创建人名称
     */
    private String createdName;
    /**
     * 更新时间
     */
    private Date updatedTime;
    /**
     * 更新UUID
     */
    private String updatedUuid;
    /**
     * 更新名称
     */
    private String updatedName;
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
