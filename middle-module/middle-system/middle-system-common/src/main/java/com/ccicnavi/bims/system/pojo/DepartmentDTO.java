package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *@program: bims-backend
 *@description: 部门信息表的DTO实体
 *@author: zhangxingbiao
 *@create: 2018-11-15 14:45
 */
@Getter
@Setter
@ToString
public class DepartmentDTO implements Serializable {

    /**
     * 部门主键集合
     */
    private List<String> uuids;
    /**
     * 所在级别
     */
    private Long levels;
    /**
     * 部门子集
     */
    private List<DepartmentDTO> deptChildList;
    /**
     * 主键
     */
    private String deptUuid;
    /**
     * 部门编号
     */
    private String deptCode;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 部门类别
     */
    private String deptType;
    /**
     * 上级部门名称
     */
    private String parentName;
    /**
     * 上级部门编号uuid
     */
    private String parentUuid;
    /**
     * 电话
     */
    private String deptTel;
    /**
     * 排序号
     */
    private Integer deptSort;
    /**
     * 负责人
     */
    private String manager;
    /**
     * 是否参加业务
     */
    private String isBusiness;
    /**
     * 启用标识
     */
    private String isEnabled;
    /**
     * 备注
     */
    private String comments;
    /**
     * 删除标识
     */
    private String isDeleted;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 创建人id
     */
    private String createdUuid;
    /**
     * 创建人
     */
    private String createdName;
    /**
     * 最后一次更新时间
     */
    private Date updatedTime;
    /**
     * 更新人uuid
     */
    private String updatedUuid;
    /**
     * 更新人
     */
    private String updatedName;
    /**
     * 归属机构id
     */
    private String orgUuid;
    /**
     * 应用系统id
     */
    private String appSysUuid;
    /**
     * 产品线id
     */
    private String prodCatalogUuid;
    /**
     * 预留字段1
     */
    private String extend1;
    /**
     * 预留字段2
     */
    private String extend2;
    /**
     * 预留字段3
     */
    private String extend3;

}