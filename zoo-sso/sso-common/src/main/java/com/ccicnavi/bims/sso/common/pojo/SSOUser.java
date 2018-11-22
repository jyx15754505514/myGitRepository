package com.ccicnavi.bims.sso.common.pojo;

import com.ccicnavi.bims.system.pojo.DepartmentDTO;
import com.ccicnavi.bims.system.pojo.RoleDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class SSOUser implements Serializable {

    private List<RoleDTO> roleList;    //角色列表

    private List<String> btnUrlList;    //按钮绑定的url列表

    private List<DepartmentDTO> departmentList;//部门信息

    private String userUuid;    //用户ID

    private String nickName;    //用户昵称

    private String version;     //设置登录标识

    private int expireMinite;   //设置登录有效时间

    private long expireFreshTime;   //设置登录时间

    private String loginName;

    private String loginEmail;

    private String loginPhone;

    private String currentPassword;

    private String passwordHints;

    private String isChangePassword;

    private String loginUsertype;

    private Date disabledTime;

    private String disabledReason;

    private Integer failedLogins;

    private String loginMethod;

    private String lastTimeZone;

    private String lastLocal;

    private String lastLoginIp;

    private Date lastLoginTime;

    private String bindLoginIp;

    private String isEnabled;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;

    private String prodCatalogUuid;

    private String extend1;

    private String extend2;

    private String extend3;
}
