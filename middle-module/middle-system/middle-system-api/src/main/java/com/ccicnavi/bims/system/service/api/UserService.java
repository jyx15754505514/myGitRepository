package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.sso.common.pojo.SSOUser;
import com.ccicnavi.bims.system.pojo.UserDTO;

/**
 *@program: bims-backend
 *@description: 登录用户的api接口
 *@author: zhangxingbiao
 *@create: 2018-11-15 14:45
 */
public interface UserService {
    /**
     * 查询登录用户
     * @param pageParameter
     * @return List<UserDO>
     */
    public ResultT listUser(PageParameter<UserDTO> pageParameter);

    /**
     * 新增登录用户
     * @param UserDO
     * @return Integer
     */
    public Integer insertUser(UserDTO UserDO);

    /**
     * 更改登录用户
     * @param UserDO
     * @return Integer
     */
    public Integer updateUser(UserDTO UserDO);

    /**
     * 删除登录用户
     * @param UserDO
     * @return Integer
     */
    public Integer deleteUser(UserDTO UserDO);

    /**
     * 根据主键获取单个登录用户信息
     * @param UserDO
     * @return UserDO
     */
    public  UserDTO getUser(UserDTO UserDO);


    /**
     *@Description: 根据角色查询用户
     *@Param: userDTO
     *@return: UserDTO
     *@Author: 本人姓名
     *@date: 2018/11/22
     */
    public UserDTO selectByRoleUser(UserDTO userDTO);


    /**
     *@Description: 更改启用禁用状态
     *@Param: [userDO]
     *@return: java.lang.Integer
     *@Author: zhangxingbiao
     *@date: 2018/11/22
     */
    Integer updateIsEnabled(UserDTO userDTO);

    /**
     *@Description: 根据用户id分配角色
     *@Param: [userDO]
     *@return: java.lang.Integer
     *@Author: zhangxingbiao
     *@date: 2018/11/22
     */
    Integer addUserRole(UserDTO userDTO);

    /**
    *@Description: 恢复初始密码
    *@Param: [userDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/23
    */
    public Integer initialPassword(UserDTO userDTO);

    /**
     *@Description: 用户登录
     *@Param: [userDO]
     *@return: java.lang.Integer
     *@Author: zhangxingbiao
     *@date: 2018/11/22
     */
    SSOUser login(UserDTO userDTO);
}
