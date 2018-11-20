package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/19 22:52
 * @Description:
 */
@Getter
@Setter
@ToString
public class DictValueDO implements Serializable {
    private String dictValueUuid;

    private String dictValueName;

    private String dictValueCode;

    private String dictParentUuid;

    private String sortNum;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;

    private String prodCatalogUuid;

    private String extend1;

    private String extend2;

    private String extend3;
}
