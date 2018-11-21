package com.ccicnavi.bims.order.pojo;/* *
 * @Author heibin
 * @Description
 * @Date
 * @Param
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author songyateng 
 * @Description //TODO
 * @Date 15:14 2018/11/21
 * @Param 
 * @Return 
 */

@Getter
@Setter
@ToString
public class OrderWorksheetDO implements Serializable {

    private String worksheetUuid;//主键

    private String assignUserUuid;//工作单分配人id

    private Date assignTime;//分配时间

    private String assignComments;//分配说明

    private Date planStartDate;//计划开始日期

    private Date planEndDate;//计划完成日期

    private String implDeptUuid;//实施部门id

    private String implMgrUuid;//实施负责人id

    private Date implStartDate;//实施开始日期

    private Date implEndDate;//实施完成日期

    private String comments;//备注

    private String isDeleted;//删除标识（N正常Y删除）

    private Date createdTime;//创建时间

    private String createdUuid;//创建人id

    private String createdName;//创建人

    private Date updatedTime;//最后一次更新时间

    private String updatedUuid;//更新人uuid

    private String updatedName;//更新人

    private String orgUuid;//归属机构id

    private String appSysUuid;//应用系统id

    private String extend1;//预留字段1

    private String extend2;//预留字段2

    private String extend3;//预留字段3


}
