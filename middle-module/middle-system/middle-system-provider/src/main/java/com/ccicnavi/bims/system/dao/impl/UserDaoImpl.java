package com.ccicnavi.bims.system.dao.impl;


import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.sso.common.pojo.SSOUser;
import com.ccicnavi.bims.system.dao.UserDao;
import com.ccicnavi.bims.system.pojo.UserDO;
import com.ccicnavi.bims.system.pojo.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 登录用户dao实现类
 * @author: zhaotao
 * @create: 2018-11-14 23:33
 **/

@Service
@Slf4j
public class UserDaoImpl implements UserDao {

    /**
    *@Description: 查询登录用户信息
    *@Param: [UserDO]
    *@return: List<UserDO>
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    @Override
    public PageBean<UserDTO> listUser(PageParameter<UserDTO> pageParameter){
        EqlPage eqlPage = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        List<UserDTO> UserDOListList = new Eql("DEFAULT").select("listUser").params(pageParameter.getParameter()).limit(eqlPage).returnType(UserDTO.class).execute();
        if(UserDOListList != null) {
            return  new PageBean<UserDTO>(eqlPage.getTotalRows(),eqlPage.getTotalPages(), eqlPage.getCurrentPage(), eqlPage.getPageRows(), eqlPage.getStartIndex(), UserDOListList);
        }else {
            return null;
        }
    }

    /**
    *@Description: 新增登录用户信息
    *@Param: [UserDO]
    *@return: Integer
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    @Override
    public Integer insertUser(UserDTO userDTO, EqlTran tran) {
        Eql eql = new Eql("DEFAULT");
        if(tran != null) {
            eql.useTran(tran);
        }
        return eql.delete("insertUser").params(userDTO).returnType(Integer.class).execute();
    }


    /**
    *@Description: 保存登录用户信息
    *@Param: [personDTO, tran]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/21
    */
    @Override
    public Integer saveUser(UserDTO userDTO, EqlTran tran) {
        Eql eql = new Eql("DEFAULT");
        if(tran != null){
            eql.useTran(tran);
        }
        return eql.insert("insertUser").params(userDTO).returnType(Integer.class).execute();
    }


    /**
    *@Description: 更新登录用户信息
    *@Param: [UserDO]
    *@return: Integer
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    @Override
    public Integer updateUser(UserDTO userDTO, EqlTran tran){
        Eql eql = new Eql("DEFAULT");
        if(tran != null) {
            eql.useTran(tran);
        }
        return eql.update("updateUser").params(userDTO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 删除登录用户信息
    *@Param: [UserDO]
    *@return: Integer
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    @Override
    public Integer deleteUser(UserDTO userDTO, EqlTran tran){
        Eql eql = new Eql("DEFAULT");
        if(tran != null) {
            eql.useTran(tran);
        }
        return eql.delete("deleteUser").params(userDTO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 根据主键获取登录用户
    *@Param: [UserDO]
    *@return: UserDO
    *@Author: zhaotao
    *@date: 2018/11/15
    */
    @Override
    public UserDTO getUser(UserDTO userDTO){
        return new Eql().selectFirst("getUser").params(userDTO).returnType(UserDTO.class).execute();
    }

    @Override
    public List<UserDTO> listauthUserList(UserDTO userDTO) {
        return new Eql().select("listauthUserList").params(userDTO).returnType(UserDTO.class).execute();
    }

    @Override
    public List<UserDTO> selectunauthUserList(UserDTO userDTO) {
        return new Eql().select("selectunauthUserList").params(userDTO).returnType(UserDTO.class).execute();

    }
    /**
    *@Description: 更改启用禁用状态
    *@Param: [userDO, tran]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/22
    */
    @Override
    public Integer updateIsEnabled(UserDTO userDTO) {
        return new Eql("DEFAULT").update("updateIsEnabled").params(userDTO).returnType(Integer.class).execute();
    }

    /*
    * 用户登录获取用户信息
    * @Author zhaotao
    * @Date  2018/11/23 16:45
    * @Param [userDTO]
    * @return com.ccicnavi.bims.sso.common.pojo.SSOUser
    **/
    @Override
    public SSOUser login(UserDTO userDTO) {
        return new Eql("DEFAULT").selectFirst("login").params(userDTO).returnType(SSOUser.class).execute();
    }


}
