package com.ccicnavi.bims.sso.common.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Role {
    private String roleUuid;

    private String parentRoleUuid;

    private String organization_uuid;   //组织结构id

    private String org_name;    //组织结构名称

    private String roleName;   //角色名称

    private String roleCode;    //角色编号

    private String isSystem;    //是Y否N内置角色

    private String isEnabled;    //是Y否N启用

    private String comments;    //备注

    private String isDeleted;    //删除标识（N正常Y删除）

    private Date createdTime;    //创建时间

    private String createdUuid;    //创建人id

    private String createdName;    //创建人

    private Date updatedTime;    //最后一次更新时间

    private String updatedName;    //更新人

    private String orgUuid;    //更新人uuid

    private String appSysUuid;    //应用系统id

    private String businessLine;

    private String extend1;

    private String extend2;

    private String extend3;
}
