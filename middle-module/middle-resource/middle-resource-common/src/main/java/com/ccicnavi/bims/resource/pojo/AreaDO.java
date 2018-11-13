package com.ccicnavi.bims.resource.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 地区
 * @Date 2018/11/13 17 53
 * @Auther mzj
 */
@Getter
@Setter
@ToString
public class AreaDO {
    private String areaUuid;

    private String areaParentUuid;

    private String areaName;

    private String areaEnName;

    private String areaCode;

    private String areaPost;

    private String sortNum;

    private String comments;

    private String isDeleted;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;
}
