package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.RemindDO;
import com.ccicnavi.bims.system.pojo.RemindDTO;
import org.n3r.eql.EqlTran;

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
   *@Description: 根据主键查询描述设置
   *@Param: sysremind
   *@return: SysRemindDO
   *@Author: zqq
   *@date: 2018/11/15
   */

    public RemindDO getRemind(RemindDO remind);

    /**
    *@Description: 连表查询提醒设置
    *@Param: pageParameter
    *@return: PageBean<RemindDTO>
    *@Author: 本人姓名
    *@date: 2018/11/15
    */

   public PageBean<RemindDTO> listRemindOrg(PageParameter<RemindDO> pageParameter);


}
