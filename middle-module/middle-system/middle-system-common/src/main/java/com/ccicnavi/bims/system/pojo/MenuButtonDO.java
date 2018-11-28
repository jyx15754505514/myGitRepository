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
 * @create: 2018-11-20 10:48
 */
@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuButtonDO implements Serializable {
    /**
     * 主键uuid
     */
    private String btnUuid;
    /**
     * 菜单uuid
     */
    private String menuUuid;
    /**
     * 按钮名称
     */
    private String btnName;
    /**
     * 按钮路径
     */
    private String btnUrl;
    /**
     * 按钮图标
     */
    private String btnIcon;
    /**
     * 按钮颜色
     */
    private String btnFontcolor;
    /**
     * 是否显示(Y是N否)
     */
    private String isEnabled;
    /**
     * 排序号
     */
    private String sortNum;
    /**
     * 删除标识（N正常Y删除）
     */
    private String isDeleted;//

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
