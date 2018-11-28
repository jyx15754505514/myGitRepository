package com.ccicnavi.bims.system.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleUserDTO implements Serializable {

    private String roleUuid;

    private String userUuid;

    private String orgUuid;

    private List<String> saveUserUuids;
    private List<String> deleteUserUuids;
}
