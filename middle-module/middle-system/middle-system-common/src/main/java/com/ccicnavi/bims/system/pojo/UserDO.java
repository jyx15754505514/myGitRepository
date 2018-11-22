package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @program: bims-backend
 * @description: 用户登录DO实体类
 * @author: zhaotao
 * @create: 2018-11-14 23:33
 **/
@Getter
@Setter
@ToString
public class UserDO implements Serializable {

    private List<RoleUserDO> roleList;

    private List<MenuDTO> menuList;

    private List<DepartmentDO> deptList;

    private String userUuid;

    private String nickName;

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