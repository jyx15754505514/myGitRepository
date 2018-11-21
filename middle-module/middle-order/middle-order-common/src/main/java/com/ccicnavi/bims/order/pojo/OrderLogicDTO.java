package com.ccicnavi.bims.order.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/* *
 * @Author MengZiJie
 * @Description 委托单逻辑信息
 * @Date 17:10 2018/11/21
 */
@Getter
@Setter
@ToString
public class OrderLogicDTO implements Serializable {

    private String orderUuid;

    private String statusUuid;

    private String statusName;

    private String isDeleted;

    private Date updatedTime;

    private String updatedUuid;

    private String updatedName;

    private String prodCatalogUuid;

    private String orgUuid;

    private String appSysUuid;

    List<String> orderUuids;

}
