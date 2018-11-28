package com.ccicnavi.bims.customer.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 客户注册信息实体DO
 * @author: LiJie
 * @create: 2018-11-15 09:16
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerExtDO implements Serializable {
    /**
     * 客户唯一标识符
     */
    private String custUuid;
    /**
     *法人
     */
    private String legalRep;
    /**
     *注册资本
     */
    private String regCapital;
    /**
     *注册日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date regDate;
    /**
     *注册号
     */
    private String regNo;
    /**
     *经验范围
     */
    private String businessScope;
    /**
     *开户行名称
     */
    private String bankName;
    /**
     *开户行账号
     */
    private String bankAccount;
    /**
     *付款单位名称
     */
    private String payUnitName;
    /**
     *付款单位地址
     */
    private String payUnitAddr;
    /**
     *付款单位电话
     */
    private String payUnitTel;
    /**
     *税号
     */
    private String taxNo;
    /**
     *备注
     */
    private String comments;
    /**
     *删除标识（N正常Y删除）
     */
    private String isDeleted;
    /**
     *创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;
    /**
     *创建人id
     */
    private String createdUuid;
    /**
     *创建人
     */
    private String createdName;
    /**
     *最后一次更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedTime;
    /**
     *更新人uuid
     */
    private String updatedName;
    /**
     *更新人
     */
    private String updatedUuid;
    /**
     *预留字段1
     */
    private String extend1;
    /**
     *预留字段2
     */
    private String extend2;
    /**
     *预留字段3
     */
    private String extend3;
}
