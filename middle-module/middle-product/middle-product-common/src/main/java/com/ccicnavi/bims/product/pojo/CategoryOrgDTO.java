package com.ccicnavi.bims.product.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: guojinxu
 * @create: 2018/11/21 22:39
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryOrgDTO implements Serializable {

    /**产品类别id*/
    private String productCategoryUuid;

    /**组织机构id*/
    private String organizationUuid;

    /**产品线id*/
    private String prodCatalogUuid;

    /**应用系统id*/
    private String appSysUuid;

    /**产品类别id 集合*/
    private String categoryUuidList;

    /**组织机构id 集合*/
    private String orgUuidList;

    /**产品线id 集合*/
    private String catalogUuidList;

    /**
     * 设置公共所属机构
     */
    private String publicOrgUuid;
}
