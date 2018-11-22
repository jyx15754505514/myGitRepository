package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/20 17:25
 * @Description:
 */
@Getter
@Setter
@ToString
public class SerialnumCfgDTO {
    private String sncUuid;//规则uuid

    private String sncName;//规则名称

    private String sncInitValue;//序号初始值

    private Integer sncLength;//序号长度

    private Integer sncStep;//步长

    private String sncPeriod;//周期

    private String isHop;//

    private String delimiter;

    private String isDelimAfterFirst;

    private String isDelimBeforeLast;

    private String sortNum;//排序编号

    private String comments;

    private String isDeleted;

    private String orgUuid;

    private String appSysUuid;

    private String prodCatalogUuid;

    private String extend1;

    private String extend2;

    private String extend3;

    private List<SerialnumCfgItemDO> items;//规则项
}
