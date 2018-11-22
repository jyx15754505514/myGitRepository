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

    private String minItemUuid;

    private String stdUuid;

    private String orgUuid;

    private String appSysUuid;


}
