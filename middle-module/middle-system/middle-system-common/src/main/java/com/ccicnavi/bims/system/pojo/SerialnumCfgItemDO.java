package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/20 10:25
 * @Description:
 */
@Getter
@Setter
@ToString
public class SerialnumCfgItemDO implements Serializable {
    /**
     * 项uuid
     * */
    private String sncdUuid;
    /**
     * 规则uuid
     * */
    private String sncUuid;
    /**
     * 规则项类型，DATE,TEXT,SYS,OLD,N
     * */
    private String sncdType;
    /**
     * 规则项值
     * */
    private String sncdValue;
    /**
     * 排序序号
     * */
    private Integer sncdOrderNum;
}
