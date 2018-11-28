package com.ccicnavi.bims.product.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: LiJie
 * @create: 2018-11-28 23:04
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryTypeDTO implements Serializable {

    /**
     * 主键
     */
    private String productCategoryTypeUuid;

    /**
     * 父类型id
     */
    private String parentTypeUuid;

    /**
     * 是否有子表
     */
    private String hasTable;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 备注
     */
    private String comments;

    /**
     * 删除标识（N正常Y删除）
     */
    private String isDeleted;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
     * 产品线id
     */
    private String prodCatalogUuid;

    /**
     * 归属机构id
     */
    private String orgUuid;

    /**
     * 公共所属机构ID
     */
    private String publicOrgUuid;

    /**
     * 应用系统id
     */
    private String appSysUuid;
}
