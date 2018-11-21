package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 菜单dto
 * @author: zqq
 * @create: 2018-11-20 09:48
 */
@Setter
@Getter
@ToString
public class MenuDTO implements Serializable {
    private java.lang.String menuUuid;//

    private java.lang.String parentUuid;//父级菜单

    private java.lang.String menuName;//菜单名称

    private java.lang.String menuUrl;//请求地址

    private java.lang.String menuIcon;//菜单图标

    private java.lang.String menuFontcolor;//字体颜色

    private Integer menuLevel;//菜单层级

    private java.lang.String parentAllUuid;//所有的父级菜单id

    private java.lang.String isEnabled;//是Y否N启用

    private java.lang.String sortNum;//

    private java.lang.String comments;//备注

    private java.lang.String isDeleted;//删除标识（N正常Y删除）

    private java.lang.String prodCatalogUuid;//产品线id

    private java.lang.String orgUuid;//归属机构id

    private java.lang.String appSysUuid;//应用系统id

    private List<String> roleUuids;

    private List<MenuButtonDO> menuButtonDOList;
}
