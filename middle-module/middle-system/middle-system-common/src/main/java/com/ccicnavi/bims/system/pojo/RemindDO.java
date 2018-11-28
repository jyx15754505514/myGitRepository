package com.ccicnavi.bims.system.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 提醒设置DO
 * @author: zqq
 * @create: 2018-11-15 09:17
 */
@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RemindDO implements Serializable {


    /**
     * 主键
     */
    private String remindUuid;
    /**
     * 提醒内容
     */
    private String remindContent;
    /**
     * 提醒类别（数据字典）
     */
    private String remindType;
    /**
     * 数值
     */
    private String num;
    /**
     * 单位（年YEAR/月MONTH/日DAY）
     */
    private String unit;
    /**
     * 提醒形式（追加APPEND；提前BEFORE）
     */
    private String warnType;
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
     * 最后一次更新人
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
     * 产品线类型
     */
    private String prodCatalogUuid;
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
