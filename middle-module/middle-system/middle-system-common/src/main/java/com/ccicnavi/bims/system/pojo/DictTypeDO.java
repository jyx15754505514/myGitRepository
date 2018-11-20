package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/19 22:52
 * @Description:
 */
@Getter
@Setter
@ToString
public class DictTypeDO implements Serializable {
    private String dictTypeUuid;

    private String dictTypeName;

    private String dictTypeCode;

    private String sortNum;

    private String comments;

    private String isDeleted;

    private String orgUuid;

    private String appSysUuid;

    private String prodCatalogUuid;

    private String extend1;

    private String extend2;

    private String extend3;
}
