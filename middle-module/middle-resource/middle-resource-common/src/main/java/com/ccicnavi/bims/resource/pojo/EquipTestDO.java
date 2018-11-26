package com.ccicnavi.bims.resource.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 设备检定信息DO
 * @author: panyida
 * @create: 2018-11-14 11:30
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EquipTestDO implements Serializable {
    /**
     * 检定记录主键
     */
    private String equipTestUuid;
    /**
     * 设备id
     */
    private String equipUuid;
    /**
     * 证书号
     */
    private String certNo;
    /**
     * 检定日期
     */
    private Date testDate;
    /**
     * 检定周期
     */
    private String testCycle;
    /**
     * 是否长期有效
     */
    private String isLongTerm;
    /**
     * 检定有效日期
     */
    private Date testValidDate;
    /**
     * 检定结果（合格、不合格）
     */
    private String testResult;
    /**
     * 检测类型(数据字典)
     */
    private String testType;
    /**
     * 费用
     */
    private Integer testFee;
    /**
     * 费用说明
     */
    private String feeDesc;
    /**
     * 依据技术文件说明
     */
    private String standardDesc;
    /**
     * 证书在线url
     */
    private String onlineCertUrl;
    /**
     * 备注
     */
    private String comments;
    /**
     * 删除标识（N正常Y删除）
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
     * 拓展字段1
     */
    private String extend1;
    /**
     * 拓展字段2
     */
    private String extend2;
    /**
     * 拓展字段3
     */
    private String extend3;
}
