package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.system.pojo.RemindDO;


import java.util.List;

/**
 * @program: bims-backend
 * @description: 提醒设置api接口
 * @author: zqq
 * @create: 2018-11-15 11:02
 **/
public interface RemindService {

    /**
    *@Description: 查询提醒设置
    *@Param: sysremind
    *@return: List<SysRemindDO>
    *@Author: zqq
    *@date: 2018/11/15
    */

    public List<RemindDO> listRemind(RemindDO remind)throws Exception;

   /**
   *@Description: 新增提醒设置
   *@Param: sysremind
   *@return: Integer
   *@Author: zqq
   *@date: 2018/11/15
   */

    public Integer insertRemind(RemindDO remind)throws Exception;

    /**
    *@Description: 修改提醒设置
    *@Param: sysremind
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/15
    */

    public Integer updateRemind(RemindDO remind)throws Exception;

   /**
   *@Description: 删除提醒设置
   *@Param: sysremind
   *@return: Integer
   *@Author: zqq
   *@date: 2018/11/15
   */

    public Integer deleteRemind(RemindDO remind)throws Exception;

   /**
   *@Description: 根据主键查询提醒设置
   *@Param: sysremind
   *@return: SysRemindDO
   *@Author: zqq
   *@date: 2018/11/15
   */

    public RemindDO getRemind(RemindDO remind)throws Exception;
}
