package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/* *
 * @Author MengZiJie
 * @Description 菜单管理
 * @Date 16:04 2018/11/15
 */
@Getter
@Setter
@ToString
public class MenuDO implements Serializable {

    private String menuUuid;

    private String parentUuid;

    private String menuName;

    private String menuUrl;

    private String menuIcon;

    private String menuFontcolor;

    private Integer menuLevel;

    private String parentAllUuid;

    private String isEnabled;

    private String sortNum;

    private String isDeleted;

    private String appSysUuid;

    private String businessLine;

    private String extend1;

    private String extend2;

    private String extend3;
}
