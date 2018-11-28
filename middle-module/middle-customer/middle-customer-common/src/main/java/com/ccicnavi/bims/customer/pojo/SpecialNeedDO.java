package com.ccicnavi.bims.customer.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: bims-backend
 * @description: 客户特殊需求信息实体DO
 * @author: WangYingLing
 * @create: 2018-11-15 09:16
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpecialNeedDO implements Serializable {
    /**
     *主键UUID
     */
    private String needUuid;
    /**
     *客户唯一标识符
     */
    private String custUuid;
    /**
     *需求类型
     */
    private String needType;
    /**
     *需求类型
     */
    private String needContent;
    /**
     *部门
     */
    private String deptUuid;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedTime;
    /**
     *最后一次更新人
     */
    private String updatedName;
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

}
