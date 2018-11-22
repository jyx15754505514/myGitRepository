package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/20 10:25
 * @Description:
 */
@Getter
@Setter
@ToString
public class SerialnumCfgItemDO {
    private String sncdUuid;//项uuid

    private String sncUuid;//规则uuid

    private String sncdType;//规则项类型，DATE,TEXT,SYS,OLD,N

    private String sncdValue;//规则项值

    private Integer sncdOrderNum;//排序序号
}
