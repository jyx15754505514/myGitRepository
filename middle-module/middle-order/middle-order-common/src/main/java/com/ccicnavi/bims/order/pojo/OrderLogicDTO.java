package com.ccicnavi.bims.order.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * @Author MengZiJie
 * @Description 委托单逻辑信息
 * @Date 17:10 2018/11/21
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderLogicDTO implements Serializable {
    /**
     * 委托单主键
     */
    private String orderUuid;
    /**
     * 委托单主键List
     */
    private List<String> orderUuids;
    /**
     * 状态
     */
    private String statusUuid;
    /**
     * 状态名称
     */
    private String statusName;
    /**
     * 是否删除
     */
    private String isDeleted;
    /**
     * 更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedTime;
    /**
     * 更新人UUID
     */
    private String updatedUuid;
    /**
     * 更新人名称
     */
    private String updatedName;
    /**
     * 所属产品线
     */
    private String prodCatalogUuid;
    /**
     * 所属公司UUID
     */
    private String orgUuid;
    /**
     * 所属平台UUID
     */
    private String appSysUuid;



}
