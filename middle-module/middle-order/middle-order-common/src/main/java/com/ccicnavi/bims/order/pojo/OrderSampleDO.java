package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;
/**
 * @Author MengZiJie
 * @Description 委托单-样品库
 * @Date 16:46 2018/11/20
 */
@Getter
@Setter
@ToString
public class OrderSampleDO implements Serializable {
    /**
     * 样品主键
     */
    private String sampleUuid;
    /**
     * 委托单主键
     */
    private String orderUuid;
    /**
     * 样品编号
     */
    private String sampleCode;
    /**
     * 样品名称
     */
    private String sampleName;
    /**
     * 规格型号
     */
    private String sampleSpec;
    /**
     * 样品分类
     */
    private String sampleType;
    /**
     * 存放位置
     */
    private String samplePlace;
    /**
     * 数量/单位
     */
    private String sampleUnit;
    /**
     * 送样人
     */
    private String sendPerson;
    /**
     * 送样日期
     */
    private Date sendTime;
    /**
     * 取样人
     */
    private String receivePerson;
    /**
     * 取样日期
     */
    private Date receiveTime;
    /**
     * 接样人
     */
    private String receiptPerson;
    /**
     * 接样时间
     */
    private Date receiptTime;
    /**
     * 接收时样品状态
     */
    private String receiptType;
    /**
     * 处置人
     */
    private String disposer;
    /**
     * 处置时间
     */
    private Date disposerTime;
    /**
     * 处置方法
     */
    private String disposerMethod;
    /**
     * 文件附件
     */
    private String sampleFile;
    /**
     * 备注
     */
    private String comments;
    /**
     * 是否删除标识
     */
    private String isDeleted;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 创建人Uuid
     */
    private String createdUuid;
    /**
     * 创建人名称
     */
    private String createdName;
    /**
     * 更新时间
     */
    private Date updatedTime;
    /**
     * 更新人Uuid
     */
    private String updatedUuid;
    /**
     * 更新人名称
     */
    private String updatedName;
    /**
     * 产品线Uuid
     */
    private String prodCatalogUuid;
    /**
     * 归属机构
     */
    private String orgUuid;
    /**
     * 应用系统Uuid
     */
    private String appSysUuid;
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
