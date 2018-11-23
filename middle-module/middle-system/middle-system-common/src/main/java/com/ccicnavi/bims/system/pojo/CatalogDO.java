package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 产品线信息DO(prod_catalog)
 * @author: WangYingLing
 * @create: 2018-11-19 22:46
 */

@Getter
@Setter
@ToString
public class CatalogDO implements Serializable {
    /**
     * 产品线uuid
     */
    private String prodCatalogUuid;
    /**
     * 产品线名称
     */
    private String catalogName;
    /**
     * 产品线编号
     */
    private String catalogCode;
    /**
     * 备注
     */
    private String comments;
    /**
     * 是否删除
     */
    private String isDeleted;
    /**
     *创建时间
     */
    private Date createdTime;

    private String createdUuid;
    /**
     *创建人
     */
    private String createdName;
    /**
     *更新时间
     */
    private Date updatedTime;

    private String updatedUuid;
    /**
     *修改人
     */
    private String updatedName;
    /**
     *所属机构
     */
    private String orgUuid;
    /**
     *系统编号
     */
    private String appSysUuid;
    /**
     *扩展字段
     */
    private String extend1;
    /**
     *扩展字段
     */
    private String extend2;
    /**
     *扩展字段
     */
    private String extend3;
}
