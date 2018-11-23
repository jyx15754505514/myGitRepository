package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description: 产品线与组织机构关系
 * @author: guojinxu
 * @create: 2018/11/21 22:05
 */
@Getter
@Setter
@ToString
public class CatalogOrgDTO {

    private String organizationUuid;//组织机构id

    private String prodCatalogUuid;//产品线id

    private String appSysUuid;//应用系统id

    private String orgUuidList;

    private String catalogUuidList;

}
