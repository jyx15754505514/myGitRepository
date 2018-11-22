package com.ccicnavi.bims.system.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.RoleUserDao;
import com.ccicnavi.bims.system.dao.UserDao;
import com.ccicnavi.bims.system.pojo.RoleDO;
import com.ccicnavi.bims.system.pojo.UserDO;
import com.ccicnavi.bims.system.pojo.UserDTO;
import com.ccicnavi.bims.system.service.api.RoleService;
import com.ccicnavi.bims.system.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.n3r.eql.util.Closes;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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

    @Autowired
    private RoleUserDao roleUserDao;

    /**
    *@Description: 查询登录用户信息
    *@Param: [UserDO]
    *@return: List<UserDO>
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    @Override
    public ResultT listUser(PageParameter<UserDTO> pageParameter){
        try{
            PageBean<UserDTO> pageBean = userDao.listUser(pageParameter);
            if (pageBean != null){
                List<UserDTO> userList = pageBean.getProducts();
                if(userList != null && userList.size() > 0) {
                    for (UserDTO user : userList) {
                        List<RoleDO> roleUserList = roleService.listRoleByUser(user);
                        user.setRoleDOList(roleUserList);
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
    public Integer insertUser(UserDTO userDTO){
        EqlTran tran = new Eql("DEFAULT").newTran();
        Integer saveUser = null;
        Integer insertRole = null;
        try{
            tran.start();
            //新增用户表信息
            saveUser = userDao.insertUser(userDTO, tran);
            List<String> roleList = userDTO.getAddRoleList();
            //判断角色是否为空
            if(roleList != null && roleList.size() > 0){
                for(String roleUuid : roleList){
                    userDTO.setRoleUuid(roleUuid);
                    //新增用户角色中间表
                    insertRole = roleUserDao.insertRoleUsers(userDTO, tran);
                }
            }
            if(saveUser != null && saveUser > 0 && insertRole != null && insertRole > 0) {
                tran.commit();
            }else {
                new RuntimeException("新建用户失败");
            }
        }catch (Exception e){
            log.error("新建用户失败", e);
            tran.rollback();
        }finally {
            Closes.closeQuietly(tran);
        }
        return saveUser;

    }

    /**
     *@Description: 更改登录用户信息
     *@Param: [userDTO]
     *@return: java.lang.Integer
     *@Author: zhangxingbiao
     *@date: 2018/11/21
     */
    @Override
    public Integer updateUser(UserDTO userDTO){
        EqlTran tran = new Eql("DEFAULT").newTran();
        Integer updateUser = 0;
        Integer deleteRoleUser = 0;
        Integer insertRole = 0;
        try {
            tran.start();
            //更新用户表信息
            updateUser = userDao.updateUser(userDTO, tran);
            //删除角色的集合不为空就根据用户uuid删除中间表角色信息
            List<String> deleteRoleList = userDTO.getDeleteRoleList();
            if(deleteRoleList != null && deleteRoleList.size() > 0){
                deleteRoleUser = roleUserDao.deleteRoleUsers(userDTO, tran);
            }
            //添加角色的集合不为空就根据用户uuid添加用户和角色信息
            List<String> addRoleList = userDTO.getAddRoleList();
            if(addRoleList != null && addRoleList.size() > 0){
                for(String roleUuid : addRoleList){
                    userDTO.setRoleUuid(roleUuid);
                    //新增用户角色中间表
                    insertRole = roleUserDao.insertRoleUsers(userDTO, tran);
                }
            }
            if(deleteRoleUser != null && insertRole != null) {
                tran.commit();
            }

        } catch (Exception e) {
            log.error("更新登录用户信息失败",e);
            tran.rollback();
        }finally {
            Closes.closeQuietly(tran);
        }
        return updateUser;
    }

    /**
    *@Description: 删除登录用户信息
    *@Param: UserDO
    *@return: UserDO
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    @Override
    public Integer deleteUser(UserDTO userDTO){
        EqlTran tran = new Eql("DEFAULT").newTran();
        Integer deleteUser = 0;
        Integer deleteRoleUser = 0;
        try {
            tran.start();
            deleteUser = userDao.deleteUser(userDTO, null);
            deleteRoleUser = roleUserDao.deleteRoleUsers(userDTO, null);
            if(deleteUser != null && deleteRoleUser != null){
                tran.commit();
            }
        } catch (Exception e) {
            log.error("删除登录用户信息失败",e);
            tran.rollback();
            return null;
        }
        return deleteUser;
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
            userDTO.setRoleDOList(roleUserList);
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


    /**
     *@Description: 更改启用禁用状态
     *@Param: [userDO]
     *@return: java.lang.Integer
     *@Author: zhangxingbiao
     *@date: 2018/11/22
     */
    @Override
    public Integer updateIsEnabled(UserDTO userDTO) {
        try {
            return userDao.updateIsEnabled(userDTO);
        } catch (Exception e) {
            log.error("更改启用禁用状态失败",e);
            return null;

        }
    }
}
