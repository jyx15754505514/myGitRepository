package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.UserDO;
import com.ccicnavi.bims.system.pojo.UserDTO;
import org.n3r.eql.EqlTran;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 登录用户dao接口
 * @author: zhaotao
 * @create: 2018-11-14 23:33
 **/
public interface UserDao {

    /**
    *@Description: 查询登录用户信息
    *@Param: [UserDO]
    *@return: List<UserDO>
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    public PageBean<UserDO> listUser(PageParameter<UserDO> pageParameter);

    /**
    *@Description: 新增登录用户
    *@Param: [UserDO]
    *@return: Integer
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    public Integer insertUser(UserDO UserDO, EqlTran tran);

    /**
    *@Description: 更新登录用户信息
    *@Param: [UserDO]
    *@return: Integer
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    public Integer updateUser(UserDO UserDO, EqlTran tran);

    /**
    *@Description: 删除登录用户信息
    *@Param: [UserDO]
    *@return: Integer
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    public Integer deleteUser(UserDO UserDO, EqlTran tran);

    /**
    *@Description: 根据主键获取单个登录用户信息
    *@Param: [UserDO]
    *@return: UserDO
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    public  UserDO getUser(UserDO UserDO);
    /**
     *@Description: 查询授权用户
     *@Param: userDTO
     *@return:  List<UserDO>
     *@Author: zqq
     *@date: 2018/11/22
     */

    public List<UserDO> listauthUserList(UserDTO userDTO);

    /**
     *@Description: 查询未授权用户
     *@Param: userDTO
     *@return: List<UserDO>
     *@Author: zqq
     *@date: 2018/11/22
     */

    public List<UserDO> selectunauthUserList(UserDTO userDTO);
}
