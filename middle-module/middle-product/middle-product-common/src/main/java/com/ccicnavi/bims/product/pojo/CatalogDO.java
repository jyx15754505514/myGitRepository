package com.ccicnavi.bims.product.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: 本人姓名
 * @create: 2018-11-19 22:46
 */

@Getter
@Setter
@ToString
public class CatalogDO {

    private String prodCatalogUuid;

    private String catalogName;

    private String catalogCode;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedName;

    private String orgUuid;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;

}
