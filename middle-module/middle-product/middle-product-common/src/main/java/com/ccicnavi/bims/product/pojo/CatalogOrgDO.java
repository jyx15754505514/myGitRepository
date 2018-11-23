package com.ccicnavi.bims.product.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: bims-backend
 * @description: 产品线与组织机构关系DO
 * @author: WangYingLing
 * @create: 2018-11-21 20:13
 */
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatalogOrgDO implements Serializable {

    /**
     * 组织机构id
     */
    private String organizationUuid;

    /**
     * 产品线id
     */
    private String prodCatalogUuid;

    /**
     * 应用系统id
     */
    private String appSysUuid;


}
