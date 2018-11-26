package com.ccicnavi.bims.resource.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备检定信息DTO
 * @author: panyida
 * @create: 2018-11-16 11:42
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EquipTestDTO implements Serializable {

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
     * 设备名称
     */
    private String equipName;
    /**
     * 设备英文名称
     */
    private String equipNameEn;
    /**
     * 规格
     */
    private String equipSpec;
    /**
     * 出厂编号
     */
    private String factoryNo;
    /**
     * 生产厂家
     */
    private String manufacture;
    /**
     * 使用部门uuid
     */
    private String useDeptUuid;
    /**
     * 检定记录主键集合
     */
    private List<String> equipTestUuids;
}
