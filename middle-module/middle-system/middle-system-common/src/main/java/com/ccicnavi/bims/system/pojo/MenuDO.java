package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/* *
 * @Author MengZiJie
 * @Description 菜单管理
 * @Date 16:04 2018/11/15
 */
@Getter
@Setter
@ToString
public class MenuDO implements Serializable {

    /**
     * 主键uuid
     */
    private String menuUuid;
    /**
     * 父级菜单
     */
    private String parentUuid;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 请求地址
     */
    private String menuUrl;
    /**
     * 菜单图标
     */
    private String menuIcon;
    /**
     * 字体颜色
     */
    private String menuFontcolor;
    /**
     * 菜单层级
     */
    private Integer menuLevel;
    /**
     * 所有的父级菜单id
     */
    private String parentAllUuid;
    /**
     * 是Y否N启用
     */
    private String isEnabled;

    private String sortNum;
    /**
     * 备注
     */
    private String comments;
    /**
     * 删除标识（N正常Y删除）
     */
    private String isDeleted;
    /**
     * 产品线id
     */
    private String prodCatalogUuid;
    /**
     * 归属机构id
     */
    private String orgUuid;
    /**
     * 应用系统id
     */
    private String appSysUuid;
    /**
     * 预留字段1
     */
    private String extend1;
    /**
     * 预留字段2
     */
    private String extend2;
    /**
     * 预留字段3
     */
    private String extend3;

    private List<String> uuids;
}
