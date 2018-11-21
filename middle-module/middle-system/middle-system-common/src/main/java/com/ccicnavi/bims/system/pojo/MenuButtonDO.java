package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: 本人姓名
 * @create: 2018-11-20 10:48
 */
@Setter
@Getter
@ToString
public class MenuButtonDO implements Serializable {

    private java.lang.String btnUuid;//主键uuid

    private java.lang.String menuUuid;//菜单uuid

    private java.lang.String btnName;//按钮名称

    private java.lang.String btnUrl;//按钮路径

    private java.lang.String btnIcon;//按钮图标

    private java.lang.String btnFontcolor;//按钮颜色

    private java.lang.String isEnabled;//是否显示(Y是N否)

    private java.lang.String sortNum;//排序号

    private java.lang.String isDeleted;//删除标识（N正常Y删除）

    private java.lang.String prodCatalogUuid;//产品线id

    private java.lang.String orgUuid;//归属机构id

    private java.lang.String appSysUuid;//应用系统id

    private java.lang.String extend1;//预留字段1

    private java.lang.String extend2;//预留字段2

    private java.lang.String extend3;//预留字段3

    private List<String> uuids;
}
