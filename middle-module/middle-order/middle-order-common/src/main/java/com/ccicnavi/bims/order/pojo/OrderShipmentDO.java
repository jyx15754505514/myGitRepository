package com.ccicnavi.bims.order.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 标准样品库DO
 * @author: panyida
 * @create: 2018-11-19 15:41
 **/
@Getter
@Setter
@ToString
public class OrderShipmentDO implements Serializable {
    private String orderUuid;

    private String shippingTypeId;

    private String shipName;

    private String voyageName;

    private String dispathPortId;

    private String destPortId;

    private String loadingPortId;

    private String dischargePortId;

    private String tradeNatureId;

    private String customsCertNo;

    private String customsDeclNo;

    private String inspectionPerson;

    private String weight;

    private String weightUnit;

    private List<String> orderUuidList;
}
