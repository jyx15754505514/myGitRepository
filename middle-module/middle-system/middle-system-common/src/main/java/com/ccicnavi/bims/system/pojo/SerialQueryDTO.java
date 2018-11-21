package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/21 11:55
 * @Description:
 */
@Getter
@Setter
@ToString
public class SerialQueryDTO {
    private String orgUuid;

    private String appSysUuid;

    private String prodCatalogUuid;

    private String busUuid;

    private String sncUuid;
}
