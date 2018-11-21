package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/20 10:23
 * @Description:
 */
@Getter
@Setter
@ToString
public class SerialnumCfgDO {
    private String sncUuid;

    private String sncName;

    private String sncInitValue;

    private Integer sncLength;

    private Integer sncStep;

    private String sncPeriod;

    private String isHop;

    private String delimiter;

    private String isDelimAfterFirst;

    private String isDelimBeforeLast;

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
