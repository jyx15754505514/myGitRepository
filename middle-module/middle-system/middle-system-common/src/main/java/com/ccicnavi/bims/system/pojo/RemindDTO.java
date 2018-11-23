package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 提醒设置dto
 * @author: zqq
 * @create: 2018-11-15 19:50
 */

@Setter
@Getter
@ToString
public class RemindDTO implements Serializable {

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

    /**
     * 机构名称
     */
    private String orgName;
    private List<String> uuids;
}
