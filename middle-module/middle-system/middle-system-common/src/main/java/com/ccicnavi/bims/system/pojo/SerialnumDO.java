package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/20 10:21
 * @Description:
 */
@Getter
@Setter
@ToString
public class SerialnumDO implements Serializable {
    /**
     * 实例uuid
     */
    private String snUuid;
    /**
     *编码规则uuid
     */
    private String sncUuid;
    /**
     *部门编号
     */
    private String snDeptCode;
    /**
     *原业务编号
     */
    private String busUuid;
    /**
     *当前序号
     */
    private String seqId;
    /**
     *周期
     */
    private String seqYmd;
    /**
     *排序号
     */
    private String sortNum;
    /**
     *备注
     */
    private String comments;
    /**
     *是否可用
     */
    private String isDeleted;
    /**
     *创建时间
     */
    private Date createdTime;

    private String createdUuid;
    /**
     *创建人
     */
    private String createdName;
    /**
     *更新时间
     */
    private Date updatedTime;
    /**
     *更新人
     */
    private String updatedName;
    /**
     *机构编号
     */
    private String orgUuid;
    /**
     *业务系统编号
     */
    private String appSysUuid;
    /**
     *产品线编号
     */
    private String prodCatalogUuid;
    /**
     *扩展字段
     */
    private String extend1;
    /**
     *扩展字段
     */
    private String extend2;
    /**
     *扩展字段
     */
    private String extend3;
}
