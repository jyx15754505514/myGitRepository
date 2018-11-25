package com.ccicnavi.bims.product.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description: 产品类别与组织机构关系
 * @author: guojinxu
 * @create: 2018/11/21 9:27
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryOrgDO implements Serializable {

    /**产品类别id*/
    private String productCategoryUuid;//产品类别id

    /**组织机构id*/
    private String organizationUuid;//组织机构id

    /**产品线id*/
    private String prodCatalogUuid;//产品线id

    /**应用系统id*/
    private String appSysUuid;//应用系统id
}
