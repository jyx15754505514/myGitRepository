package com.ccicnavi.bims.system.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.RoleDao;
import com.ccicnavi.bims.system.dao.RoleUserDao;
import com.ccicnavi.bims.system.dao.UserDao;
import com.ccicnavi.bims.system.pojo.RoleUserDO;
import com.ccicnavi.bims.system.pojo.UserDO;
import com.ccicnavi.bims.system.pojo.UserDTO;
import com.ccicnavi.bims.system.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.n3r.eql.util.Closes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

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
    private RoleUserDao roleUserDao;

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
            PageBean<UserDO> pageBean = userDao.listUser(pageParameter);
            if (pageBean != null){
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
    *@Param: userDTO
    *@return: UserDO
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    @Override
    public Integer deleteUser(UserDTO userDTO){
        EqlTran tran = new Eql("DEFAULT").newTran();
        Integer deleteUser = null;
        Integer deleteRoleUser = null;
        try {
            //开始事务
            tran.start();
            //删除用户表信息
            deleteUser = userDao.deleteUser(userDTO, null);
            //查询用户与角色中间表信息
            List<RoleUserDO> roleUserList= roleUserDao.listRoleUser(userDTO, tran);
            //判断查出结果是否为空
            if(roleUserList != null && roleUserList.size()>0){
                //不为空就根据用户uuid删除中间表角色信息
                deleteRoleUser = roleUserDao.deleteRoleUser(userDTO, tran);
            }
            //删除用户相关部门信息
            //删除后是否要判断一下！！！！！！！！！！！！！！！！！！！！！！！
            //提交事务
            tran.commit();
        } catch (Exception e) {
            log.error("删除登录用户信息失败",e);
            //回滚事务
            tran.rollback();
        }finally {
            Closes.closeQuietly(tran);
            return deleteUser;
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
    public UserDO getUser(UserDO userDO){
        try {
            return userDao.getUser(userDO);
        } catch (Exception e) {
            log.error("根据主键获取登录用户信息失败",e);
            return null;
        }
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
        Integer updateUser = null;
        Integer deleteRoleUser = null;
        Integer insertRole = null;
        try {
            tran.start();
            //更新用户表信息
            updateUser = userDao.updateUser(userDTO, tran);
            //查询用户与角色中间表信息
            List<RoleUserDO> roleUserList= roleUserDao.listRoleUser(userDTO, tran);
            //判断查出结果是否为空
            if(roleUserList != null && roleUserList.size()>0){
                //不为空就根据用户uuid删除中间表角色信息
                deleteRoleUser = roleUserDao.deleteRoleUser(userDTO, tran);
            }
            if(deleteRoleUser != null){
                List<String> roleList = new ArrayList<String>();
                if(userDTO.getRoleList() != null && userDTO.getRoleList().size()>0){
                    //获取用户当前所有角色
                    roleList = userDTO.getRoleList();
                    for(String type :roleList){
                        UserDTO userdto = new UserDTO();
                        userdto.setUserUuid(userDTO.getUserUuid());
                        userdto.setRoleUuid(type);
                        userdto.setOrgUuid(userDTO.getOrgUuid());
                        //新增用户角色中间表
                        insertRole = roleUserDao.insertRoleUser(userdto,tran);
                    }
                }
            }
            if(updateUser>0 && insertRole>0) {
                tran.commit();
                return updateUser;
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
    *@Description: 保存登录用户信息
    *@Param: [userDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/22
    */
    @Override
    public Integer saveUser(UserDTO userDTO) {
        EqlTran tran = new Eql("DEFAULT").newTran();
        Integer saveUser = null;
        Integer insertRole = null;
        try{
            tran.start();
            //新增用户表信息
            saveUser = userDao.saveUser(userDTO, tran);
            List<String> roleList = new ArrayList<String>();
            //判断角色是否为空
            if(userDTO.getRoleList() != null && userDTO.getRoleList().size()>0){
                //获取用户当前所有角色
                roleList = userDTO.getRoleList();
                for(String type :roleList){
                    UserDTO userdto = new UserDTO();
                    userdto.setUserUuid(userDTO.getUserUuid());
                    userdto.setRoleUuid(type);
                    userdto.setOrgUuid(userDTO.getOrgUuid());
                    //新增用户角色中间表
                    insertRole = roleUserDao.insertRoleUser(userdto,tran);
                }
            }
            if(saveUser>0 && insertRole>0) {
                tran.commit();
                return saveUser;
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
