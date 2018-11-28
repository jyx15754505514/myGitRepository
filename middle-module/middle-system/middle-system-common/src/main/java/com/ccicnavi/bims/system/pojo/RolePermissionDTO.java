package com.ccicnavi.bims.system.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: 本人姓名
 * @create: 2018-11-22 11:24
 */
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RolePermissionDTO implements Serializable {
    private String roleUuid;
    private String butUuid;
    private String appSysUuid;
    private String prodCatalogUuid;
    private List<String> saveButUuids;
    private List<String> deleteButUuids;
}
