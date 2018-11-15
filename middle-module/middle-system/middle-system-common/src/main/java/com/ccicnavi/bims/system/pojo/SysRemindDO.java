package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
public class SysRemindDO {

    private List<String> uuids;

    private String remindUuid;//主键

    private String remindContent;//提醒内容

    private String remindType;//提醒类别（数据字典）

    private String num;//数值

    private String unit;//单位（年YEAR/月MONTH/日DAY）

    private String warnType;//提醒形式（追加APPEND；提前BEFORE）

    private String comments;//备注

    private String isDeleted;//删除标识（N正常Y删除）

    private Date createdTime;//创建时间

    private String createdUuid;//创建人id

    private String createdName;//创建人

    private Date updatedTime;//最后一次更新时间

    private String updatedName;//最后一次更新人

    private String orgUuid;//归属机构id

    private String appSysUuid;//应用系统id

    private String businessLine;//产品线类型

    private String extend1;//预留字段1

    private String extend2;//预留字段2

    private String extend3;//预留字段3

}
