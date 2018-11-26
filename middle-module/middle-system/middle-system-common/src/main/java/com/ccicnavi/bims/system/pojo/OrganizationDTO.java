package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 组织机构DTO
 * @author: zhangpengwei
 * @create: 2018-11-21 22:09
 */
@Getter
@Setter
@ToString
public class OrganizationDTO implements Serializable{

    /**
     * 组织机构主键集合
     */
    private List<String> uuids;
    /**
     * 所在级别
     */
    private Long levels;
    /**
     * 组织机构子集
     */
    private List<OrganizationDTO> orgChildList;
    /**
     * 组织机构主键
     */
    private String organizationUuid;
    /**
     * 父节点
     */
    private String orgParentUuid;
    /**
     * 所有上级机构id
     */
    private String orgAllParentUuid;
    /**
     * 组织机构名称
     */
    private String orgName;
    /**
     * 简称
     */
    private String orgShortName;
    /**
     * EHR公司编码
     */
    private String  ehrCode;
    /**
     * 公司代码
     */
    private String orgCode;
    /**
     *
     */
    private String orgType;
    /**
     * 省公司UUID
     */
    private String topOrgUuid;
    /**
     * 电话
     */
    private String orgTel;
    /**
     * 分机号
     */
    private String orgTelExt;
    /**
     * 传真
     */
    private String orgFax;
    /**
     * 网址
     */
    private String orgUrl;
    /**
     * 地址
     */
    private String orgAddr;
    /**
     * 所在省份id
     */
    private String areaProvinceUuid;
    /**
     * 所在城市id
     */
    private String areaCityUuid;
    /**
     * 启用标识
     */
    private String isEnabled;
    /**
     * 排序编号
     */
    private String sortNum;
    /**
     * 是Y否N虚拟组织
     */
    private String isVirtual;
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
    private String updateUuid;
    /**
     * 更新人
     */
    private String updatedName;
    /**
     * 产品线id
     */
    private String prodCatalogUuid;
    /**
     * 归属机构id
     */
    private String orgUuid;
    /**
     * 应用系统id
     */
    private String appSysUuid;
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
