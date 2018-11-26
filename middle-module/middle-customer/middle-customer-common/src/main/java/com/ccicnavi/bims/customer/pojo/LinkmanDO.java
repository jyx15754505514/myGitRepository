package com.ccicnavi.bims.customer.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
  * @author songyateng
  * @description 客户联系人DO
  * @date 2018/11/26 18:01
  */
@Setter
@Getter
@ToString
public class LinkmanDO implements Serializable {
    /**
     * 键UUID
     */
    private String linkmanUuid;
    /**
     * 所属客户UUID
     */
    private String custUuid;
    /**
     *姓名
     */
    private String linkmanName;
    /**
     *性别(F女M男)
     */
    private String gender;
    /**
     *手机
     */
    private String phone;
    /**
     *邮箱
     */
    private String email;
    /**
     *传真
     */
    private String fax;
    /**
     *办公电话
     */
    private String officePhone;
    /**
     *地址
     */
    private String addr;
    /**
     *是否是常用联系人（Y：是 N：否）
     */
    private String isDefault;
    /**
     *是否是常用联系人（Y：是 N：否）
     */
    private String statusUuid;
    /**
     *联系人部门
     */
    private String dept;
    /**
     *联系人职位
     */
    private String position;
    /**
     *联系人角色
     */
    private String role;
    /**
     *联系人QQ
     */
    private String qq;
    /**
     *联系人微信
     */
    private String weChat;
    /**
     *服务种类
     */
    private String typeOfService;
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
    /**
     *要删除的客户联系人主键
     */
    private List<String> uuids;
}
