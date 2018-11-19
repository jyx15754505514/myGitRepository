package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: bims-backend
 * @description: 用户-角色关联实体
 * @author: zhangpengwei
 * @create: 2018-11-19 14:32
 */
@Getter
@Setter
@ToString
public class RoleUserDO {

    private String roleUuid;

    private String orgUuid;

    private String appSysUuid;

}
