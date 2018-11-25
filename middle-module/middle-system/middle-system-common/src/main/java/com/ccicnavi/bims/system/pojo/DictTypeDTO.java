package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**


/**
 *@program: bims-backend
 *@description: 数据字典DTO
 *@author: zhangxingbiao
 *@create: 2018-11-20 11:45
 */
@Setter
@Getter
@ToString
public class DictTypeDTO implements Serializable {
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
     * 主键uuid
     */
    private String dictValueUuid;
    /**
     * 字典数值名称
     */
    private String dictValueName;
    /**
     * 字典数值编码
     */
    private String dictValueCode;
    /**
     * 父节点uuid
     */
    private String dictParentUuid;
    /**
     * 备注
     */
    private String comments;
    /**
     * 删除标识
     */
    private String isDeleted;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 创建人id
     */
    private String createdUuid;
    /**
     * 创建人
     */
    private String createdName;
    /**
     * 最后一次更新时间
     */
    private Date updatedTime;
    /**
     * 更新人uuid
     */
    private String updatedUuid;
    /**
     * 更新人
     */
    private String updatedName;
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
    /**
     * 字典数值集合
     */
    private List<DictValueDO> valueList;
    /**
     * 字典类型集合
     */
    private List<String> typeList;
    /**
     * 字典类型主键集合
     */
    private List<String> uuids;

}
