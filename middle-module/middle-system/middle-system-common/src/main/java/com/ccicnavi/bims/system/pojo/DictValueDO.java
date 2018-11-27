package com.ccicnavi.bims.system.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/19 22:52
 * @Description:
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DictValueDO implements Serializable {
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

    private String extend1;

    private String extend2;

    private String extend3;

}
