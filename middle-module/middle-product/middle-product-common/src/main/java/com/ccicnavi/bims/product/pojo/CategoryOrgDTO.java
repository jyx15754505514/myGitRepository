package com.ccicnavi.bims.product.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description:
 * @author: guojinxu
 * @create: 2018/11/21 22:39
 */
@Getter
@Setter
@ToString
public class CategoryOrgDTO {
    private String productCategoryUuid;//产品类别id

    private String organizationUuid;//组织机构id

    private String prodCatalogUuid;//产品线id

    private String appSysUuid;//应用系统id

    private String categoryUuidList;

    private String orgUuidList;

    private String catalogUuidList;
}
