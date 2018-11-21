package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

/* *
 * @Author MengZiJie
 * @Description 运输单
 * @Date 21:19 2018/11/20
 */
@Getter
@Setter
@ToString
public class OrderInspectionDO implements Serializable {

    private String orderUuid;

    private String shippingTypeId;

    private String vesselName;

    private String blNo;

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

    private String consignerName;

    private String consigneeName;

    private String provideCertUuid;

    private String provideCertName;

    private String isOpenCert;

    private String comments;

    private String extend1;

    private String extend2;

    private String extend3;
}
