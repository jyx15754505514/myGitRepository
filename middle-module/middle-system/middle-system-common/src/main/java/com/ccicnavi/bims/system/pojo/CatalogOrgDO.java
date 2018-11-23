package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: 本人姓名
 * @create: 2018-11-21 20:13
 */
@Getter
@Setter
@ToString
public class CatalogOrgDO implements Serializable {
    /**
     *机构uuid
     */
    private String organizationUuid;
    /**
     *产品线uuid
     */
    private String prodCatalogUuid;
    /**
     *系统编号
     */
    private String appSysUuid;


}
