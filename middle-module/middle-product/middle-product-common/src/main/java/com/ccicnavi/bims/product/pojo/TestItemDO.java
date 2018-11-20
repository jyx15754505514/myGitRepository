package com.ccicnavi.bims.product.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 检测指标DO(product_test_item)
 * @author: wangynigling
 * @create: 2018-11-19 17:02
 */
@Getter
@Setter
@ToString
public class TestItemDO implements Serializable {

    private String itemUuid;

    private String itemName;

    private String itemNameEn;

    private String itemUomUuid;

    private String itemCode;

    private Integer itemPrice;

    private String itemWorkhour;

    private String useStdUuid;

    private String useStdName;

    private String itemNameAlias;

    private String comments;

    private String prodCatalogUuid;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedUuid;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;

}
