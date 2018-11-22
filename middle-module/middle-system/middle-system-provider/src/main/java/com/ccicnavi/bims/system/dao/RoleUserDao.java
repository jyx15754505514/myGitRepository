package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.system.pojo.RoleUserDO;
import com.ccicnavi.bims.system.pojo.RoleUserDTO;
import com.ccicnavi.bims.system.pojo.UserDTO;
import org.n3r.eql.EqlTran;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 用户角色中间表Dao层
 * @author: zhangxingbiao
 * @create: 2018-11-21 22:00
 */
public interface RoleUserDao {
    /*
     *@Description: 新增用户角色
     *@Param: personDTO  tran
     *@return:
     *@Author: zhangxingbiao
     *@date: 2018/11/21
     */
    Integer insertRoleUser(UserDTO userDTO, EqlTran tran);
    Integer insertRoleUser(RoleUserDO roleUserDO, EqlTran tran);

    /**
     * 更新用户角色信息
     * @param userDTO
     * @return Integer
     * @throws Exception
     */
    public Integer updateRoleUser(UserDTO userDTO, EqlTran tran);

    /**
    *@Description: 删除角色信息
    *@Param: [userDTO, tran]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/22
    */
    public Integer deleteRoleUser(UserDTO userDTO, EqlTran tran);
    /**
    *@Description: 查询用户角色
    *@Param: [userDTO, tran]
    *@return: com.ccicnavi.bims.system.pojo.UserDTO
    *@Author: zhangxingbiao
    *@date: 2018/11/22
    */
    public List<RoleUserDO> listRoleUser(UserDTO userDTO, EqlTran tran);
}
