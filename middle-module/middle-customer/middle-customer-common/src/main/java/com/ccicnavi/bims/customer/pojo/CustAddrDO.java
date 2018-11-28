package com.ccicnavi.bims.customer.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 客户地址
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustAddrDO implements Serializable {
    /**
     * 客户地址主键
     */
    private String addrUuid;
    /**
     * 所属客户主键
     */
    private String custUuid;
    /**
     * 客户地址
     */
    private String custAddr;
    /**
     * 地址区域
     */
    private String custRegion;
    /**
     * 英文地址
     */
    private String custAddrEn;
    /**
     * 地址类型
     */
    private String addrType;
    /**
     * 备注信息
     */
    private String comments;
    /**
     * 删除标识（ N正常、Y删除）
     */
    private String isDeleted;
    /**
     * 创建日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;
    /**
     * 创建人uuid
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
     * 更新人名称
     */
    private String updatedName;
    /**
     * 更新人uuid
     */
    private String updatedUuid;
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

    /**
     * 要删除的客户地址主键
     */
    private List<String> uuids;
}
