package com.ccicnavi.bims.customer.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 客户跟踪POJO
 */
@Setter
@Getter
@ToString
public class CustTailDO implements Serializable {

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

    private String updatedUuid;

    private String extend1;

    private String extend2;

    private String extend3;

    private List<String> uuids;//要删除的客户跟踪人主键

}
