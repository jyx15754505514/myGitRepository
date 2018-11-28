package com.ccicnavi.bims.sso.common.pojo;

import com.ccicnavi.bims.system.pojo.CatalogOrgDTO;
import com.ccicnavi.bims.system.pojo.DepartmentDTO;
import com.ccicnavi.bims.system.pojo.MenuDTO;
import com.ccicnavi.bims.system.pojo.RoleDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SSOUser implements Serializable {

    /**
    * 当前登录人所在公司对应的产品线
    **/
    private List<CatalogOrgDTO> prodCatalogList;

    private List<MenuDTO> menuList;

    private List<RoleDTO> roleList;    //角色列表

    private List<String> btnUrlList;    //按钮绑定的url列表

    /*
    * 部门名称
    **/
    private String  deptName;

    /*
     * 部门主键
     **/
    private String  deptUuid;

    /*
     * 部门编号
     **/
    private String  deptCode;

    /*
     * 部门是否删除
     **/
    private String  deptIsDeleted;

    /*
     * 部门是否启用
     **/
    private String  deptIsEnabled;

    private String jsessionID;    //jsessionID

    private String userUuid;    //用户ID

    private String nickName;    //用户昵称

    private String version;     //设置e登录标识

    private int expireMinite;   //设置登录有效时间

    private long expireFreshTime;   //设置登录时间

    private String loginName;

    private String salt;

    private String loginEmail;

    private String loginPhone;

    private String currentPassword;

    private String passwordHints;

    private String isChangePassword;

    private String loginUsertype;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date disabledTime;

    private String disabledReason;

    private Integer failedLogins;

    private String loginMethod;

    private String lastTimeZone;

    private String lastLocal;

    private String lastLoginIp;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastLoginTime;

    private String bindLoginIp;

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

    private String orgUuid;

    private String orgName;

    private String orgIsEnabled;

    private String orgIsDeleted;

    private String orgCode;

    private String appSysUuid;

    private String prodCatalogUuid;

    private String realName;

    private String extend2;

    private String extend3;
}
