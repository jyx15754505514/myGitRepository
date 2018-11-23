package com.ccicnavi.bims.product.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: bims-backend
 * @description: 最小服务项与标准的关系实体
 * @author: LiJie
 * @create: 2018-11-22 14:40
 */
@Setter
@Getter
@ToString
public class MinItemStdDO implements Serializable {

    /**最小服务项ID*/
    private String minItemUuid;

    /**标准ID*/
    private String stdUuid;

    /**所属机构ID*/
    private String orgUuid;

    /**所属平台ID*/
    private String appSysUuid;


}
