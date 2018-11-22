package com.ccicnavi.bims.product.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description: 产品类别与组织机构关系
 * @author: guojinxu
 * @create: 2018/11/21 9:27
 */
@Getter
@Setter
@ToString
public class CategoryOrgDO implements Serializable {

    private String productCategoryUuid;//产品类别id

    private String organizationUuid;//组织机构id

    private String prodCatalogUuid;//产品线id

    private String appSysUuid;//应用系统id
}
