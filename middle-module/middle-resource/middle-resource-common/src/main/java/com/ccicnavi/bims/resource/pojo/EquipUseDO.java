package com.ccicnavi.bims.resource.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 设备领用归还信息DO
 * @author: panyida
 * @create: 2018-11-15 19:32
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class EquipUseDO implements Serializable {

    /**
     * 主键uuid
     */
    private String equipUseUuid;
    /**
     * 器具uuid
     */
    private String equipUuid;
    /**
     * 领用日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date useDate;
    /**
     * 领用人
     */
    private String usePerson;
    /**
     * 领用人部门
     */
    private String useDept;
    /**
     * 归还日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date backDate;
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
     * 创建人uuid
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
     * 应用系统id
     */
    private String appSysUuid;
    /**
     * 拓展字段1
     */
    private String extend1;
    /**
     * 拓展字段2
     */
    private String extend2;
    /**
     * 拓展字段3
     */
    private String extend3;
}
