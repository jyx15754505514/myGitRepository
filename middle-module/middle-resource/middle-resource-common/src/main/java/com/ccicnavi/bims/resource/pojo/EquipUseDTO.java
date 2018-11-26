package com.ccicnavi.bims.resource.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备领用归还信息DTO
 * @author: panyida
 * @create: 2018-11-16 20:57
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EquipUseDTO implements Serializable {
    /**
     * 领用记录主键uuid
     */
    private String equipUseUuid;
    /**
     * 器具uuid
     */
    private String equipUuid;
    /**
     * 领用日期
     */
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
     * 设备名称
     */
    private String equipName;
    /**
     * 设备英文名称
     */
    private String equipNameEn;
    /**
     * 规格
     */
    private String equipSpec;
    /**
     * 出厂编号
     */
    private String factoryNo;
    /**
     * 生产厂家
     */
    private String manufacture;
    /**
     * 使用部门uuid
     */
    private String useDeptUuid;
    /**
     * 领用记录主键uuid集合
     */
    private List<String> equipUseUuids;
}
