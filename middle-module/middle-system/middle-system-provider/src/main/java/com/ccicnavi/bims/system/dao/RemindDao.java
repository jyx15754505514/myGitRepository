package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.system.pojo.RemindDTO;
import com.ccicnavi.bims.system.pojo.SysRemindDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 提醒设置dao
 * @author: zqq
 * @create: 2018-11-15 09:27
 */
public interface RemindDao {

   /**
   *@Description: 查询提醒设置
   *@Param: sysremind
   *@return: List<SysRemindDO>
   *@Author: zqq
   *@date: 2018/11/15
   */

    public List<SysRemindDO> listSysremind(SysRemindDO sysremind)throws Exception;

   /**
   *@Description: 新增提醒设置
   *@Param: sysremind
   *@return: Integer
   *@Author: zqq
   *@date: 2018/11/15
   */

    public Integer insertSysremind(SysRemindDO sysremind)throws Exception;

    /**
    *@Description: 修改提醒设置
    *@Param: sysremind
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/15
    */

    public Integer updateSysremind(SysRemindDO sysremind)throws Exception;

    /**
    *@Description: 删除提醒设置
    *@Param: sysremind
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/15
    */

    public Integer deleteSysremind(SysRemindDO sysremind)throws Exception;

   /**
   *@Description: 根据主键查询描述设置
   *@Param: sysremind
   *@return: SysRemindDO
   *@Author: zqq
   *@date: 2018/11/15
   */

    public SysRemindDO getSysremind(SysRemindDO sysremind)throws Exception;

    /**
    *@Description: 连表查询提醒设置
    *@Param: sysremind
    *@return: List<RemindDTO>
    *@Author: 本人姓名
    *@date: 2018/11/15
    */

    public List<RemindDTO> listremindorg(SysRemindDO sysremind)throws Exception;
}
