package com.ccicnavi.bims.system.manager;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.pojo.UserDO;


/**
 * @ClassName: UserManager
 * @description: 登录用户业务管理层
 * @author: zhaotao
 * @create: 2018-11-19 10:50
 **/
public interface UserManager {

    /*
    * y用户登录
    * @Author zhaotao
    * @Date  2018/11/19 10:51
    * @Param [UserDO]
    * @return com.ccicnavi.bims.common.ResultT
    **/
    ResultT userLogin(UserDO UserDO);
}
