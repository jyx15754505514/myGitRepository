package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@ToString
/**
 * @program: bims-backend
 * @description: 模板实体类
 * @author: zhaotao
 * @create: 2018-11-14 23:33
 **/
public class TemplateDO implements Serializable {
    private String templateUuid;

    private String dictTypeUuid;

    private String templateName;

    private String templateFileUuid;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String businessLine;

    private String orgUuid;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;


}