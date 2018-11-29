package com.ccicnavi.bims.order.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
/**
 * @Author MengZiJie
 * @Description 运输单
 * @Date 21:19 2018/11/20
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderInspectionDO implements Serializable {
    /**
     * 委托单id
     */
    private String orderUuid;
    /**
     * 运输方式id
     */
    private String shippingTypeId;
    /**
     * 船名
     */
    private String vesselName;
    /**
     * 提单号
     */
    private String blNo;
    /**
     * 航次
     */
    private String voyageName;
    /**
     * 起运港
     */
    private String dispathPortId;
    /**
     * 目的港
     */
    private String destPortId;
    /**
     * 装货港
     */
    private String loadingPortId;
    /**
     * 卸货港
     */
    private String dischargePortId;
    /**
     * 贸易性质
     */
    private String tradeNatureId;
    /**
     * 海关证书号
     */
    private String customsCertNo;
    /**
     * 海关报关号
     */
    private String customsDeclNo;
    /**
     * 报验人
     */
    private String inspectionPerson;
    /**
     * 重量
     */
    private String weight;
    /**
     * 重量单位
     */
    private String weightUnit;
    /**
     * 发货人
     */
    private String consignerName;
    /**
     * 收货人
     */
    private String consigneeName;
    /**
     * 提供单证id，以逗号区分
     */
    private String provideCertUuid;
    /**
     * 提供单证的名称，以逗号区分
     */
    private String provideCertName;
    /**
     * 删除标识（N正常Y删除）
     */
    private String isDeleted;
    /**
     * 是Y否N出证，默认N
     */
    private String isOpenCert;
    /**
     * 备注
     */
    private String comments;
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
    /**
     * 货值
     */
    private Integer goodsValue;
    /**
     * 货值币种
     */
    private String goodsCurrency;
    /**
     * 批重量
     */
    private Integer weightBatch;
    /**
     * 批重量单位
     */
    private String weightBatchUnit;

}
