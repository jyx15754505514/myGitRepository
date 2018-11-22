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

    private String sampleUuid;

    private String orderUuid;

    private String sampleCode;

    private String sampleName;

    private String sampleSpec;

    private String sampleType;

    private String samplePlace;

    private String sampleUnit;

    private String sendPerson;

    private Date sendTime;

    private String receivePerson;

    private Date receiveTime;

    private String receiptPerson;

    private Date receiptTime;

    private String receiptType;

    private String disposer;

    private Date disposerTime;

    private String disposerMethod;

    private String sampleFile;

    private String comments;

    private String isDeleted;

    private Date createdTime;

    private String createdUuid;

    private String createdName;

    private Date updatedTime;

    private String updatedUuid;

    private String updatedName;

    private String prodCatalogUuid;

    private String orgUuid;

    private String appSysUuid;

    private String extend1;

    private String extend2;

    private String extend3;
}
