package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.RemindDO;
import com.ccicnavi.bims.system.pojo.RemindDTO;


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
    *@Param: PageParameter
    *@return: PageBean<RemindDO>
    *@Author: zqq
    *@date: 2018/11/15
    */

    public PageBean<RemindDO> listRemind(PageParameter<RemindDO> PageParameter);

   /**
   *@Description: 新增提醒设置
   *@Param: sysremind
   *@return: Integer
   *@Author: zqq
   *@date: 2018/11/15
   */

    public Integer insertRemind(RemindDO remind);

    /**
    *@Description: 修改提醒设置
    *@Param: sysremind
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/15
    */

    public Integer updateRemind(RemindDO remind);

   /**
   *@Description: 删除提醒设置
   *@Param: sysremind
   *@return: Integer
   *@Author: zqq
   *@date: 2018/11/15
   */

    public Integer deleteRemind(RemindDO remind);

   /**
   *@Description: 根据主键查询提醒设置
   *@Param: sysremind
   *@return: SysRemindDO
   *@Author: zqq
   *@date: 2018/11/15
   */

    public RemindDO getRemind(RemindDO remind);
    /**
    *@Description: 连表查询提醒设置
    *@Param: remind
    *@return: List<RemindDTO>
    *@Author: zqq
    *@date: 2018/11/16
    */

    public PageBean<RemindDTO> listRemindOrg(PageParameter<RemindDO> pageParameter);
    /**
    *@Description: 查询提醒设置(不分页)
    *@Param: remind
    *@return: List<RemindDO>
    *@Author: zqq
    *@date: 2018/11/19
    */

    public List<RemindDO>  listRemindList(RemindDO remind);
}
