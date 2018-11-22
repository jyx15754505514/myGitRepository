package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 菜单集合与按钮集合dto
 * @author: zqq
 * @create: 2018-11-20 09:48
 */
@Setter
@Getter
@ToString
public class MenuButtonDTO implements Serializable {

    private List<MenuDO> menuList;

    private List<MenuButtonDO> MenuButtonList;

}
