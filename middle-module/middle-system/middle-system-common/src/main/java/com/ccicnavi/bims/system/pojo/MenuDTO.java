package com.ccicnavi.bims.system.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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

    private List<String> prodCatalogList;

    private String roleUuid;
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
    private List<String> roleUuids;
    private String[] menuUuids;

    private List<MenuDTO> menuDTO;

    private List<MenuDO> menuDOList;

    private List<String> menuUuidList;
    /**
     * 所有按钮
     */
    private List<MenuButtonDTO> menuButtonDOList;
    /**
     * 所选按钮
     */
    private List<MenuButtonDTO> selectdMenuButtonDOList;
}
