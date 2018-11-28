package com.ccicnavi.bims.customer.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 分包方信息实体DO
 * @author: WangYingLing
 * @create: 2018-11-15 09:16
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubcontractorDO implements Serializable {
    /**
     * 分包方主键
     */
    private String subcontractorUuid;
    /**
     * 分包方代码
     */
    private String subcCode;
    /**
     * 统一社会信用代码
     */
    private String subcUscc;
    /**
     * 分包方类型
     */
    private String subcUnitType;
    /**
     * 单位名称
     */
    private String name;
    /**
     * 英文单位名称
     */
    private String enName;
    /**
     * 法人
     */
    private String legalRep;
    /**
     * 注册资本
     */
    private String regCapital;
    /**
     * 别名（简称）
     */
    private String subcShortName;
    /**
     * 分包方邮编
     */
    private String subcPostCode;
    /**
     * 分包方地址
     */
    private String subcUrl;
    /**
     * 传真
     */
    private String fax;
    /**
     * 电话
     */
    private String tel;
    /**
     * 手机
     */
    private String subcPhone;
    /**
     * 地址
     */
    private String addr;
    /**
     * 排序标识
     */
    private String rank;
    /**
     * 主要检测领域
     */
    private String detectionField;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
     * 更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedTime;
    /**
     * 更新人主键updated_uuid
     */
    private String updatedUuid;
    /**
     * 更新人名称
     */
    private String updatedName;
    /**
     * 产品线主键  prod_catalog_uuid
     */
    private String prodCatalogUuid;
    /**
     * 归属机构
     */
    private String orgUuid;
    /**
     * 应用系统id
     */
    private String appSysUuid;
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
