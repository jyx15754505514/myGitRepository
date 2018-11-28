package com.ccicnavi.bims.resource.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 证书纸
 * @Date 2018/11/13 17 54
 * @Auther mzj
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CertPaperDTO  implements Serializable {
    /**
     * 证书纸uuid
     */
    private String paperUuid;
    /**
     * 流水起始号
     */
    private String paperStartNum;
    /**
     * 流水截止号
     */
    private String paperEndNum;
    /**
     * 入库人
     */
    private String stromPerson;
    /**
     * 入库时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date stromDate;
    /**
     * 领用单位
     */
    private String leadUnit;
    /**
     * 领用部门
     */
    private String leadDept;
    /**
     * 证书纸状态
     */
    private String paperStatus;
    /**
     * 入库数量
     */
    private String stromNum;
    /**
     * 剩余数量
     */
    private String residualNum;
    /**
     * 当前号
     */
    private String currentCode;
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
    /**
     * 备注
     */
    private String comments;
    /**
     * 产品线id
     */
    private String prodCatalogUuid;
    /**
     * 要删除的空证台账主键
     */
    private List<String> uuids;
}
