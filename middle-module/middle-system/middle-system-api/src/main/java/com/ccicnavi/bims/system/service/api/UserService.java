package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.UserDO;
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
    public ResultT listUser(PageParameter<UserDO> pageParameter);

    /**
     * 新增登录用户
     * @param UserDO
     * @return Integer
     */
    public Integer insertUser(UserDO UserDO);

    /**
     * 更改登录用户
     * @param UserDO
     * @return Integer
     */
    public Integer updateUser(UserDO UserDO);

    /**
     * 删除登录用户
     * @param UserDO
     * @return Integer
     */
    public Integer deleteUser(UserDO UserDO);

    /**
     * 根据主键获取单个登录用户信息
     * @param UserDO
     * @return UserDO
     */
    public  UserDO getUser(UserDO UserDO);

    /**
     *@Description: 根据角色查询用户
     *@Param: userDTO
     *@return: UserDTO
     *@Author: 本人姓名
     *@date: 2018/11/22
     */

    public UserDTO selectByRoleUser(UserDTO userDTO);
}
