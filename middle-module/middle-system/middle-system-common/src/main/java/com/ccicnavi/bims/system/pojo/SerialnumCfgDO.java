package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/20 10:23
 * @Description:
 */
@Getter
@Setter
@ToString
public class SerialnumCfgDO implements Serializable {
    /**
     * 规则uuid
     */
    private String sncUuid;
    /**
     * 规则名称
     */
    private String sncName;
    /**
     * 序号初始值
     */
    private String sncInitValue;
    /**
     *序号长度
     */
    private Integer sncLength;
    /**
     *序号长度
     */
    private Integer sncStep;
    /**
     *跳号周期
     */
    private String sncPeriod;
    /**
     *区分部门
     */
    private String disDept;
    /**
     * 排序编号
     */
    private String sortNum;
    /**
     * 备注
     */
    private String comments;
    /**
     * 是否删除
     */
    private String isDeleted;
    /**
     * 所属机构
     */
    private String orgUuid;
    /**
     * 归属系统
     */
    private String appSysUuid;
    /**
     * 所属产品线
     */
    private String prodCatalogUuid;
    /**
     * 扩展字段1
     */
    private String extend1;
    /**
     * 扩展字段2
     */
    private String extend2;
    /**
     * 扩展字段3
     */
    private String extend3;
}
