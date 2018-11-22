package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
/**
 * @Author MengZiJie
 * @Description 委托单服务项子项
 * @Date 9:37 2018/11/20
 */
@Getter
@Setter
@ToString
public class OrderItemSubDO implements Serializable {

    private String subItemUuid; //子项主键

    private String itemUuid; //服务项主键

    private String subItemNo;

    private String itemName;

    private String productTestItemUuid; //产品主键
}
