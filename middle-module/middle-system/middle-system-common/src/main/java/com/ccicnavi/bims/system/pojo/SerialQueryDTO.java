package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/21 11:55
 * @Description: 功能查询条件实体
 */
@Getter
@Setter
@ToString
public class SerialQueryDTO implements Serializable {
    /**
     *机构编号
     */
    private String orgUuid;
    /**
     *系统编号
     */
    private String appSysUuid;
    /**
     *产品线编号
     */
    private String prodCatalogUuid;
    /**
     *原业务编号
     */
    private String busUuid;
    /**
     *业务规则编号
     */
    private String sncUuid;
}
