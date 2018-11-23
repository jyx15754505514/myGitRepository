package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: 本人姓名
 * @create: 2018-11-22 11:24
 */
@Getter
@Setter
@ToString
public class RolePermissionDO implements Serializable {
    private String roleUuid;
    private String butUuid;
    private String appSysUuid;
    private String prodCatalogUuid;
}
