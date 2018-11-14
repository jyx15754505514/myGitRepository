package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/* *
 * @Author MengZiJie
 * @Description 地区
 * @Date 15:27 2018/11/14
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
