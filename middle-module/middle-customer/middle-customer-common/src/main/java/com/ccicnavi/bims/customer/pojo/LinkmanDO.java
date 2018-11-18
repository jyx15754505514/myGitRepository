package com.ccicnavi.bims.customer.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户联系人
 */
@Setter
@Getter
@ToString
public class LinkmanDO implements Serializable {
    private String linkmanUuid;

    private String custUuid;

    private String linkmanName;

    private String gender;

    private String phone;

    private String email;

    private String fax;

    private String officePhone;

    private String addr;

    private String isDefault;

    private String statusUuid;

    private String dept;

    private String position;

    private String role;

    private String qq;

    private String weChat;

    private String typeOfService;

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

    private String [] uuids;//要删除的客户联系人主键
}
