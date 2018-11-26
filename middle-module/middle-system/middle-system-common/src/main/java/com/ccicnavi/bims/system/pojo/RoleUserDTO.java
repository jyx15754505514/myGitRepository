package com.ccicnavi.bims.system.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 用户-角色关联实体
 * @author: zhangpengwei
 * @create: 2018-11-19 14:32
 */
@Getter
@Setter
@ToString
public class RoleUserDTO implements Serializable {

    private String roleUuid;

    private String userUuid;

    private String orgUuid;

    private List<String> saveUserUuids;
    private List<String> deleteUserUuids;
}
