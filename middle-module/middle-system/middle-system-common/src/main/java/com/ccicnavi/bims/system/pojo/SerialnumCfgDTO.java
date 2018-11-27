package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/20 17:25
 * @Description:
 */
@Getter
@Setter
@ToString
public class SerialnumCfgDTO implements Serializable {
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
     *周期
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
    /**
     * 规则列表
     */
    private List<SerialnumCfgItemDO> items;//规则项
}
