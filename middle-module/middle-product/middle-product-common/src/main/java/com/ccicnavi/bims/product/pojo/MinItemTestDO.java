package com.ccicnavi.bims.product.pojo;

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
@Setter
@Getter
@ToString
public class MinItemTestDO implements Serializable {

    private String minItemUuid;

    private String testItemUuid;

    private String orgUuid;

    private String appSysUuid;




}
