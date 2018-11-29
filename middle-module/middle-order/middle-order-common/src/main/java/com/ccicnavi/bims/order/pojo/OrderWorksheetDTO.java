package com.ccicnavi.bims.order.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *@program: bims-backend
 *@description: 工作单DTO
 *@author: zhangxingbiao
 *@create: 2018-11-29 16:27
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderWorksheetDTO implements Serializable{
    /**
     * 工作单主键集合
     */
    private List<String> uuids;
    /**
     * 主键
     */
    private String worksheetUuid;
    /**
     * 工作单分配人id
     */
    private String assignUserUuid;
    /**
     * 分配时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date assignTime;
    /**
     * 分配说明
     */
    private String assignComments;
    /**
     * 计划开始日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date planStartDate;
    /**
     * 计划完成日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date planEndDate;
    /**
     * 实施部门id
     */
    private String implDeptUuid;
    /**
     * 实施部门名称
     */
    private String implDeptName;
    /**
     * 实施负责人id
     */
    private String implMgrUuid;
    /**
     * 实施负责人名称
     */
    private String implMgrName;
    /**
     * 实施开始日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date implStartDate;
    /**
     * 实施完成日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date implEndDate;
    /**
     * 核验人
     */
    private String checkMgrUuid;
    /**
     * 核验时间
     */
    private Date checkMgrTime;
    /**
     * 状态id
     */
    private String statusUuid;
    /**
     * 状态name
     */
    private String statusName;
    /**
     * 工作单类型
     */
    private String worksheetType;
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
     * 更新人名称
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
}
