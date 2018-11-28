package com.ccicnavi.bims.product.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: bims-backend
 * @description: 最小服务项与检测指标关系表DTO
 * @author: LiJie
 * @create: 2018-11-28 22:04
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MinItemTestDTO implements Serializable {

    /**
     * 最小服务项ID
     */
    private String minItemUuid;

    /**
     * 检测指标ID
     */
    private String testItemUuid;

    /**
     * 所属机构ID
     */
    private String orgUuid;

    /**
     * 公共所属机构
     */
    private String publicOrgUuid;

    /**
     * 所属平台ID
     */
    private String appSysUuid;
}
