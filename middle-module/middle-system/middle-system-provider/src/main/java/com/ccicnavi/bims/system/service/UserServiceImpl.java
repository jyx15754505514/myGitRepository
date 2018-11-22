package com.ccicnavi.bims.system.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.UserDao;
import com.ccicnavi.bims.system.pojo.RoleDO;
import com.ccicnavi.bims.system.pojo.UserDO;
import com.ccicnavi.bims.system.pojo.UserDTO;
import com.ccicnavi.bims.system.service.api.RoleService;
import com.ccicnavi.bims.system.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *@program: bims-backend
 *@description: 登录用户api实现类
 *@author: zhaotao
 *@create: 2018-11-15 14:45
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService;

    /**
    *@Description: 查询登录用户信息
    *@Param: [UserDO]
    *@return: List<UserDO>
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    @Override
    public ResultT listUser(PageParameter<UserDO> pageParameter){
        try{
            PageBean<UserDTO> pageBean = userDao.listUser(pageParameter);
            if (pageBean != null){
                List<UserDTO> userList = pageBean.getProducts();
                if(userList != null && userList.size() > 0) {
                    for (UserDTO user : userList) {
                        List<RoleDO> roleUserList = roleService.listRoleByUser(user);
                        user.setRoleList(roleUserList);
                    }
                }
                 return ResultT.success(pageBean);
            }
        }catch (Exception e){
            log.error("查询登录用户信息失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }


    /**
    *@Description: 新增登录用户信息
    *@Param: [UserDO]
    *@return: Integer
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    @Override
    public Integer insertUser(UserDO userDO){
        try {
            return userDao.insertUser(userDO, null);
        }catch (Exception e){
            log.error("新增登录用户信息失败",e);
            return null;
        }
    }

    /**
    *@Description: 更新登录用户信息
    *@Param: UserDO
    *@return: UserDO
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    @Override
    public Integer updateUser(UserDO userDO){
        try {
            return userDao.updateUser(userDO, null);
        } catch (Exception e) {
            log.error("更新登录用户信息失败",e);
            return null;

        }
    }

    /**
    *@Description: 删除登录用户信息
    *@Param: UserDO
    *@return: UserDO
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    @Override
    public Integer deleteUser(UserDO userDO){
        try {
            return userDao.deleteUser(userDO, null);
        } catch (Exception e) {
            log.error("删除登录用户信息失败",e);
            return null;
        }
    }

    /**
    *@Description: 根据主键获取登录用户信息
    *@Param: [UserDO]
    *@return: UserDO
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    @Override
    public UserDTO getUser(UserDTO userDTO){
        try {
            userDTO = userDao.getUser(userDTO);
            List<RoleDO> roleUserList = roleService.listRoleByUser(userDTO);
            userDTO.setRoleList(roleUserList);
            return userDTO;
        } catch (Exception e) {
            log.error("根据主键获取登录用户信息失败",e);
            return null;
        }
    }

    @Override
    public UserDTO selectByRoleUser(UserDTO userDTO) {
        //授权用户
        try {
            UserDTO userDto =new UserDTO();
            List<UserDO> authUserList = userDao.listauthUserList(userDTO);
            List<UserDO> unauthUserList =userDao.selectunauthUserList(userDTO);
            userDto.setAuthUserList(authUserList);
            userDto.setUnauthUserList(unauthUserList);
            return userDto;
        } catch (Exception e) {
            log.error("根据角色查询用户信息失败",e);
            return null;
        }
    }
}
