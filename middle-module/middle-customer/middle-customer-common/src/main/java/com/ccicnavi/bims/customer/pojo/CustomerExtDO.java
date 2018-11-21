package com.ccicnavi.bims.customer.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 客户注册信息实体DO
 * @author: LiJie
 * @create: 2018-11-15 09:16
 */
@Setter
@Getter
@ToString
public class CustomerExtDO implements Serializable {

    private String custUuid;

    private String legalRep;

    private String regCapital;

    private Date regDate;

    private String regNo;

    private String businessScope;

    private String bankName;

    private String bankAccount;

    private String payUnitName;

    private String payUnitAddr;

    private String payUnitTel;

    private String taxNo;

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
}
