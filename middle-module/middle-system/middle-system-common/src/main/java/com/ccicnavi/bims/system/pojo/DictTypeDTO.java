package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**


/**
 *@program: bims-backend
 *@description: 数据字典DTO
 *@author: zhangxingbiao
 *@create: 2018-11-20 11:45
 */
@Setter
@Getter
@ToString
public class DictTypeDTO implements Serializable {


    private String dictParentUuid;

    private List<DictValueDO> valueList;

    private List<String> typeList;

}
