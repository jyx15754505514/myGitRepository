package com.ccicnavi.bims.system.service;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.PasswdService;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.sso.common.pojo.SSOUser;
import com.ccicnavi.bims.system.dao.RoleUserDao;
import com.ccicnavi.bims.system.dao.SettingDao;
import com.ccicnavi.bims.system.dao.UserDao;
import com.ccicnavi.bims.system.pojo.RoleDTO;
import com.ccicnavi.bims.system.pojo.SettingDO;
import com.ccicnavi.bims.system.pojo.UserDO;
import com.ccicnavi.bims.system.pojo.UserDTO;
import com.ccicnavi.bims.system.service.api.RoleService;
import com.ccicnavi.bims.system.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.n3r.eql.util.Closes;
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

    @Autowired
    private RoleUserDao roleUserDao;

    @Autowired
    private SettingDao settingDao;

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20880")
    private PasswdService passwdService;

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
                        List<RoleDTO> roleDTOList = roleService.listRoleByUser(user);
                        user.setRoleDTOList(roleDTOList);
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
        Integer insertUser = 0;
        Integer insertRole = 0;
        Integer insertPerson = 0;
        try{
            tran.start();
            //新增用户表信息
            insertUser = userDao.insertUser(userDTO, tran);

            List<String> roleList = userDTO.getAddRoleList();
            //判断角色是否为空
            if(roleList != null && roleList.size() > 0){
                for(String roleUuid : roleList){
                    userDTO.setRoleUuid(roleUuid);
                    //新增用户角色中间表
                    insertRole += roleUserDao.insertRoleUsers(userDTO, tran);
                }
            }
            if(insertUser == 0 || insertRole != roleList.size()) {
                tran.rollback();
                log.debug("新建用户失败");
                return null;
            }
            tran.commit();
        }catch (Exception e){
            log.error("新建用户失败", e);
            tran.rollback();
        }finally {
            Closes.closeQuietly(tran);
        }
        return insertUser;

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
        }finally {
            Closes.closeQuietly(tran);
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
            List<RoleDTO> roleDTOList = roleService.listRoleByUser(userDTO);
            userDTO.setRoleDTOList(roleDTOList);
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
    /**
    *@Description: 根据用户分配角色
    *@Param: [userDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/23
    */

    @Override
    public Integer addUserRole(UserDTO userDTO) {
        EqlTran tran = new Eql("DEFAULT").newTran();
        Integer insertRole = null;
        Integer deleteRoleUser = null;
        try {
            tran.start();
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
            if((insertRole != null && insertRole != addRoleList.size()) || (deleteRoleUser != null && deleteRoleUser != deleteRoleList.size())) {
                tran.rollback();
                return null;
            }
            tran.commit();
        } catch (Exception e) {
            log.error("分配角色失败",e);
        }finally {
            Closes.closeQuietly(tran);
        }
        return insertRole;
    }

    @Override
    public SSOUser login(UserDTO userDTO) {
        try {
            SSOUser user = new SSOUser();
            user = userDao.login(userDTO);
            return user;
        } catch (Exception e) {
            log.error("根据主键获取登录用户信息失败",e);
            return null;
        }
    }

    /**
     *@Description: 恢复初始密码
     *@Param: [userDTO]
     *@return: java.lang.Integer
     *@Author: zhangxingbiao
     *@date: 2018/11/23
     */
    @Override
    public UserDTO initialPassword(UserDTO userDTO) {
        EqlTran tran = new Eql("DEFAULT").newTran();
        SettingDO settingDO = null;
        Integer updateUser = 0;
        try{
            tran.start();
            List<String> userList = userDTO.getUserList();
            for(String uuid : userList){
                userDTO.setUserUuid(uuid);
                UserDTO user = userDao.getUser(userDTO);
                String orguuid = user.getOrgUuid();
                userDTO.setOrgUuid(orguuid);
                settingDO = settingDao.getSetting(userDTO);
                //获取初始密码
                String initialpassword = settingDO.getInitialPassword();
                //获取盐值
                String salt = passwdService.getSalt();
                //密码加密
                String password = passwdService.getHash(initialpassword, salt);
                //将密码返回
                userDTO.setCurrentPassword(password);
                userDTO.setSalt(salt);
                //更改用户密码
                updateUser = userDao.updateUser(userDTO, tran);
            }
            if(userList != null && userList.size() > 0){
                tran.commit();
            }
        }catch (Exception e){
            log.error("恢复初始密码失败");
            tran.rollback();
            return null;
        }finally {
            Closes.closeQuietly(tran);
        }
        return userDTO;
    }
}
