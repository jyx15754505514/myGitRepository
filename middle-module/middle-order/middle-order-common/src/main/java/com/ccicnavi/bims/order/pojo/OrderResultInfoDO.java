package com.ccicnavi.bims.order.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author heibin
 * @Description 证书结果
 * @Date 14:35 2018/11/20
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResultInfoDO implements Serializable {
    /**
     * 主键
     */
    private String resultUuid;
    /**
     * 结果报告编号/证书编号
     */
    private String resultNo;
    /**
     * 空白证书编号
     */
    private String certPaperNo;
    /**
     * 证书编制人员id
     */
    private String certEditerUuid;
    /**
     * 证书编制时间
     */
    private Date certEditTime;
    /**
     * 证书核检人员id
     */
    private String certCheckerUuid;
    /**
     * 证书核检时间
     */
    private Date certCheckTime;
    /**
     * 证书签发人员id
     */
    private String certSignerUuid;
    /**
     * 证书签发时间
     */
    private Date certSignTime;
    /**
     * 结果报告/证书是否上传
     */
    private String isCertUpload;
    /**
     * 结果报告/证书是否有pdf文件
     */
    private String isPdf;
    /**
     * 是否联合报告
     */
    private String isMergeReport;
    /**
     * 状态（待编制R_STATUS_1、待审核R_STATUS_2、待签发R_STATUS_3待打印R_STATUS_4）
     */
    private String statusUuid;
    /**
     * 设置证书打印页数
     */
    private Integer certPrintPage;
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
}
