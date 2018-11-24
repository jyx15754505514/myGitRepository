package com.ccicnavi.bims.product.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: bims-backend
 * @description: 最小服务项与检测指标关系实体
 * @author: LiJie
 * @create: 2018-11-22 14:42
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MinItemTestDO implements Serializable {

    /**最小服务项ID*/
    private String minItemUuid;

    /**检测指标ID*/
    private String testItemUuid;

    /**所属机构ID*/
    private String orgUuid;

    /**所属平台ID*/
    private String appSysUuid;




}
