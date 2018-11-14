package com.ccicnavi.bims.customer.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 客户跟踪POJO
 */
@Setter
@Getter
@ToString
public class CustTailDO {

    private String tailUuid;

    private String custUuid;

    private String personUuid;

    private String personName;

    private String statusUuid;

    private String performance;

    private String visitType;

    private String linkmanPurpose;

    private String idea;

    private Date nextLinkTime;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String extend1;

    private String extend2;

    private String extend3;

}
