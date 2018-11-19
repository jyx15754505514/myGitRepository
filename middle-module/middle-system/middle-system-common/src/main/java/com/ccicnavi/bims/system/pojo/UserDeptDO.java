package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: bims-backend
 * @description: 用户-部门关联实体
 * @author: zhangpengwei
 * @create: 2018-11-19 15:16
 */
@Getter
@Setter
@ToString
public class UserDeptDO implements Serializable {

    private String userUuid;

    private String deptUuid;

    private String orgUuid;

}

