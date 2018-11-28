package com.ccicnavi.bims.order.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author songyateng 
 * @Description 工作单
 * @Date 15:14 2018/11/21
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderWorksheetDO implements Serializable {
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
    private Date assignTime;
    /**
     * 分配说明
     */
    private String assignComments;
    /**
     * 计划开始日期
     */
    private Date planStartDate;
    /**
     * 计划完成日期
     */
    private Date planEndDate;
    /**
     * 实施部门id
     */
    private String implDeptUuid;
    /**
     * 实施负责人id
     */
    private String implMgrUuid;
    /**
     * 实施开始日期
     */
    private Date implStartDate;
    /**
     * 实施完成日期
     */
    private Date implEndDate;
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
