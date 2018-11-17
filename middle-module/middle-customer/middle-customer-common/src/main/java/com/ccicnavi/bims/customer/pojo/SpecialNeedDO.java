package com.ccicnavi.bims.customer.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 客户特殊需求信息实体DO
 * @author: WangYingLing
 * @create: 2018-11-15 09:16
 */


@Getter
@Setter
@ToString

public class SpecialNeedDO implements Serializable {

    private String needUuid;

    private String custUuid;

    private String needType;

    private String needContent;

    private String deptUuid;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String extend1;

    private String extend2;

    private String extend3;

}
