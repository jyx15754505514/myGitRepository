package com.ccicnavi.bims.order.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 *@program: bims-backend
 *@description: 工作单与服务项的关系DO实体
 *@author: zhangxingbiao
 *@create: 2018-11-29 16:30
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderWorksheetMemberDO implements Serializable {
    /**
     * 主键
     */
    private String worksheetMemberUuid;
    /**
     * 工作单id
     */
    private String worksheetUuid;
    /**
     * 委托服务项目id
     */
    private String orderItemUuid;
    /**
     * 参与人id
     */
    private String userUuid;
    /**
     * 参与人姓名
     */
    private String userName;
    /**
     * 参与角色id
     */
    private String roleUuid;
    /**
     * 参与角色
     */
    private String roleName;
}
