package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/19 22:52
 * @Description:
 */
@Getter
@Setter
@ToString
public class DictTypeDO implements Serializable {
    /**
     * 主键uuid
     */
    private String dictTypeUuid;
    /**
     * 字典类型名称
     */
    private String dictTypeName;
    /**
     * 字典类型编码
     */
    private String dictTypeCode;
    /**
     * 排序编号
     */
    private String sortNum;
    /**
     * 备注
     */
    private String comments;
    /**
     * 删除标识
     */
    private String isDeleted;
    /**
     * 归属机构id
     */
    private String orgUuid;
    /**
     * 应用系统id
     */
    private String appSysUuid;
    /**
     * 产品线id
     */
    private String prodCatalogUuid;

    private String extend1;

    private String extend2;

    private String extend3;
}
