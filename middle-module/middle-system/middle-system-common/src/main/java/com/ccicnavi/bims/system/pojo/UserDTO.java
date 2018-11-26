package com.ccicnavi.bims.system.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @program: bims-backend
 * @description: 用户DTO实体类
 * @author: zhaotao
 * @create: 2018-11-14 23:33
 **/
@Getter
@Setter
@ToString
public class UserDTO implements Serializable {

    /**
     * 添加角色的主键集合
     */
    private List<String> addRoleList;
    /**
     * 删除角色的主键集合
     */
    private List<String> deleteRoleList;
    /**
     * 已授权用户集合
     */
    private List<UserDO> authUserList;
    /**
     * 未授权用户集合
     */
    private List<UserDO> unauthUserList;
    /**
     * 用户拥有的角色集合
     */
    private List<RoleDO> roleDOList;
    /**
     * 用户拥有的角色集合,多公司名称
     */
    private List<RoleDTO> roleDTOList;
    /**
     * 用户拥有的权限集合
     */
    private List<MenuDTO> menuList;
    /**
     * 用户所在的部门集合
     */
    private List<DepartmentDO> deptList;
    /**
     * 角色主键
     */
    private String roleUuid;
    /**
     * 批量操作uuids
     */
    private List<String> uuids;
    /**
     * orgUuid集合
     */
    private List<String> orgList;
    /**
     * userUuid集合
     */
    private List<String> userList;
    /**
     * 用户主键
     */
    private String userUuid;
    /**
     * 用户盐值
     */
    private String salt;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户登录名
     */
    private String loginName;
    /**
     * 用户邮箱
     */
    private String loginEmail;
    /**
     * 用户登录手机号
     */
    private String loginPhone;
    /**
     * 用户登录密码
     */
    private String currentPassword;
    /**
     * 用户密码提示
     */
    private String passwordHints;
    /**
     * 用户是否强制修改密码
     */
    private String isChangePassword;
    /**
     * 用户类型
     */
    private String loginUsertype;
    /**
     * 用户禁用时间
     */
    private Date disabledTime;
    /**
     * 用户禁用原因
     */
    private String disabledReason;
    /**
     * 用户登录失败次数
     */
    private Integer failedLogins;
    /**
     * 用户登录方式
     */
    private String loginMethod;
    /**
     * 用户最后登录时区
     */
    private String lastTimeZone;
    /**
     * 用户最近所在地
     */
    private String lastLocal;
    /**
     * 用户最后登录IP
     */
    private String lastLoginIp;
    /**
     * 用户最后登录时间
     */
    private Date lastLoginTime;
    /**
     * 用户绑定登录IP
     */
    private String bindLoginIp;
    /**
     * 用户是否启用
     */
    private String isEnabled;
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
     * 创建人
     */
    private String createdUuid;
    /**
     * 创建人姓名
     */
    private String createdName;
    /**
     * 最后更新时间
     */
    private Date updatedTime;
    /**
     * 最后更新人
     */
    private String updatedName;
    /**
     * 用户所在公司
     */
    private String orgUuid;
    /**
     * 应用系统
     */
    private String appSysUuid;
    /**
     * 产品线ID
     */
    private String prodCatalogUuid;

    /**
     * 用户姓名姓名
     */
    private String realName;

    private String extend1;

    private String extend2;

    private String extend3;


}