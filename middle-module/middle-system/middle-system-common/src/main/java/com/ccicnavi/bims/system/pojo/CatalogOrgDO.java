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

    private String organizationUuid;

    private String prodCatalogUuid;

    private String appSysUuid;


}
