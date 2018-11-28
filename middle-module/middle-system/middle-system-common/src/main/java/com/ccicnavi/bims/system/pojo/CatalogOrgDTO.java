package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description: 产品线与组织机构关系
 * @author: guojinxu
 * @create: 2018/11/21 22:05
 */
@Getter
@Setter
@ToString
public class CatalogOrgDTO implements Serializable {
    /**
     * 组织机构id
     */
    private String organizationUuid;

    /**
     * 组织机构名称
     */
    private String orgName;

    /**
     *产品线id
     */
    private String prodCatalogUuid;

    /**
    * 产品线名称
    **/
    private String catalogName;

    /**
     *应用系统id
     */
    private String appSysUuid;

    /**
     *机构编号集合
     */
    private String orgUuidList;

    /**
     *产品线编号集合
     */
    private String catalogUuidList;

}
