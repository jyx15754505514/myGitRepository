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
    private String sncdUuid;

    private String sncUuid;

    private String sncdType;

    private String sncdValue;

    private Integer sncdOrderNum;
}
