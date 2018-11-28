package com.ccicnavi.bims.system.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDTO implements Serializable {
    private String roleUuid;

    private String uuids;

    private String userUuid;

    private String orgName;

    private List<String> roleUuids;

    private String parentRoleUuid;

    private String roleName;

    private String roleCode;

    private String isSystem;

    private String isEnabled;

    private String comments;

    private String isDeleted;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;

    private String createdUuid;

    private String createdName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedTime;

    private String updatedName;

    private String updatedUuid;

    private String orgUuid;

    private String appSysUuid;

    private String prodCatalogUuid;

    private String extend1;

    private String extend2;

    private String extend3;
}
