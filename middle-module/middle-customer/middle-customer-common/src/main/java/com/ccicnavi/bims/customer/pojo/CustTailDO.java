package com.ccicnavi.bims.customer.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
  * @author songyateng
  * @description 客户跟踪实体
  * @date 2018/11/26 17:56
  */
@Setter
@Getter
@ToString
public class CustTailDO implements Serializable {
    /**
     * 主键UUID
     */
    private String tailUuid;
    /**
     *客户唯一标识符
     */
    private String custUuid;
    /**
     *跟踪人UUID
     */
    private String personUuid;
    /**
     *跟踪人姓名
     */
    private String personName;
    /**
     *联系人UUID
     */
    private String linkmanUuid;
    /**
     *联系人姓名
     */
    private String linkmanName;
    /**
     *跟进状态（枚举）
     */
    private String statusUuid;
    /**
     *绩效系数（枚举）
     */
    private String performance;
    /**
     *访问方式
     */
    private String visitType;
    /**
     *联系目的
     */
    private String linkmanPurpose;
    /**
     *反馈意见
     */
    private String idea;
    /**
     *下次联系时间
     */
    private Date nextLinkTime;
    /**
     *备注
     */
    private String comments;
    /**
     *删除标识（N正常Y删除）
     */
    private String isDeleted;
    /**
     *创建时间
     */
    private Date createdTime;
    /**
     *创建人id
     */
    private String createdUuid;
    /**
     *创建人
     */
    private String createdName;
    /**
     *最后一次更新时间
     */
    private Date updatedTime;
    /**
     *更新人
     */
    private String updatedName;
    /**
     *更新人uuid
     */
    private String updatedUuid;
    /**
     *预留字段1
     */
    private String extend1;
    /**
     *预留字段2
     */
    private String extend2;
    /**
     *预留字段3
     */
    private String extend3;
    /**
     *要删除的客户跟踪人主键
     */
    private List<String> uuids;

}
