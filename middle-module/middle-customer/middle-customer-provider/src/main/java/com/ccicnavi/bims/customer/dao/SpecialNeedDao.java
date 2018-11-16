package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.customer.pojo.SpecialNeedDO;

import java.util.List;

/**
 *@program: bims-backend
 *@description: 客户特殊需求信息dao接口
 *@author: WangYingLing
 *@create: 2018-11-14 23:33
 */

public interface SpecialNeedDao {

   /**
    *@Description: 查询全部客户特殊需求信息
    *@Param: [specialNeed]
    *@return: List<SpecialNeedDO>
    *@Author: WangYingLing
    *@date: 2018/11/15
    */
    List<SpecialNeedDO> listSpecialNeed();

    /**
     *@Description: 新增客户特殊需求信息
     *@Param: [specialNeed]
     *@return: int
     *@Author: WangYingLing
     *@date: 2018/11/15
     */
    int saveSpecialNeed(SpecialNeedDO specialNeed);

    /**
     *@Description: 删除客户特殊需求信息
     *@Param: [needUuid]
     *@return: int
     *@Author: WangYingLing
     *@date: 2018/11/15
     */
    int removeSpecialNeed(String needUuid);

    /**
     *@Description: 修改客户特殊需求信息
     *@Param: [specialNeed]
     *@return: int
     *@Author: WangYingLing
     *@date: 2018/11/15
     */
    int updateSpecialNeed(SpecialNeedDO specialNeed);

    /**
     *@Description: 查询客户特殊需求信息（根据主键获取）
     *@Param: [specialNeed]
     *@return: SpecialNeedDO
     *@Author: WangYingLing
     *@date: 2018/11/15
     */
    SpecialNeedDO getSpecialNeed(SpecialNeedDO specialNeed);

}
