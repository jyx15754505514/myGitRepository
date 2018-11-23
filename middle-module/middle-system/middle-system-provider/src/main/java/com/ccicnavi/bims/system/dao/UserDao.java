package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.sso.common.pojo.SSOUser;
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
    public PageBean<UserDTO> listUser(PageParameter<UserDTO> pageParameter);

    /**
    *@Description: 新增登录用户
    *@Param: [UserDO]
    *@return: Integer
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    public Integer insertUser(UserDTO userDTO, EqlTran tran);

    /**
    *@Description: 更新登录用户信息
    *@Param: [UserDO]
    *@return: Integer
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    public Integer updateUser(UserDTO userDTO, EqlTran tran);

    /**
    *@Description: 删除登录用户信息
    *@Param: [UserDO]
    *@return: Integer
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    public Integer deleteUser(UserDTO userDTO, EqlTran tran);

    /**
    *@Description: 根据主键获取单个登录用户信息
    *@Param: [UserDO]
    *@return: UserDO
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    public  UserDTO getUser(UserDTO userDTO);

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

    /**
     *@Description: 保存登录用户信息
     *@Param: [personDTO, tran]
     *@return: java.lang.Integer
     *@Author: zhangxingbiao
     *@date: 2018/11/21
     */
    public Integer saveUser(UserDTO userDTO, EqlTran tran);

    /**
     *@Description: 更改启用禁用状态
     *@Param: [userDO, tran]
     *@return: java.lang.Integer
     *@Author: zhangxingbiao
     *@date: 2018/11/22
     */
    public Integer updateIsEnabled(UserDTO userDTO);

    /*
    * 用户登录查询用户信息
    * @Author zhaotao
    * @Date  2018/11/23 16:44
    * @Param [userDTO]
    * @return com.ccicnavi.bims.sso.common.pojo.SSOUser
    **/
    SSOUser login(UserDTO userDTO);
}
