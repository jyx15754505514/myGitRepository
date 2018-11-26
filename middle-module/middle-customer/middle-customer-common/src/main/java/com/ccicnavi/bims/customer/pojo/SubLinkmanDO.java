package com.ccicnavi.bims.customer.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/23 14:38
 * @Description: 分包方联系人
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubLinkmanDO implements Serializable {
    /**
     * 联系人主键
     */
    private String linkmanUuid;
    /**
     *分包方主键
     */
    private String subcUuid;
    /**
     * 联系人名称
     */
    private String linkmanName;
    /**
     *性别
     */
    private String gender;
    /**
     * 手机
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 传真
     */
    private String fax;
    /**
     * 办公电话
     */
    private String officePhone;
    /**
     * 地址
     */
    private String addr;
    /**
     *  是否常用联系人
     */
    private String isDefault;
    /**
     * 状态
     */
    private String statusUuid;
    /**
     * 联系人部门
     */
    private String dept;
    /**
     * 联系人职位
     */
    private String position;
    /**
     * 联系人角色
     */
    private String role;
    /**
     * 联系人QQ
     */
    private String qq;
    /**
     * 联系人微信
     */
    private String weChat;
    /**
     * 服务种类
     */
    private String typeOfService;
    /**
     * 备注
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
     * 创建人主键
     */
    private String createdUuid;
    /**
     * 创建人名称
     */
    private String createdName;
    /**
     * 更新日期
     */
    private Date updatedTime;
    /**
     * 更新人名称
     */
    private String updatedName;
    /**
     * 更新人主键
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
}
