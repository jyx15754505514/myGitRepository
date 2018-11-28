package com.ccicnavi.bims.system.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/* *
 * @Author MengZiJie
 * @Description 地区
 * @Date 15:27 2018/11/14
 */
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AreaDO implements Serializable {

    private String areaUuid;

    private String areaParentUuid;

    private String areaName;

    private String areaEnName;

    private String areaCode;

    private String isDeleted;

}
