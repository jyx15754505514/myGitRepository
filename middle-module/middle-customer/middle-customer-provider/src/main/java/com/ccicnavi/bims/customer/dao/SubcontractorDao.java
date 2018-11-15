package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.customer.pojo.SubcontractorDO;

import java.util.List;

/**
 *@program: bims-backend
 *@description: 分包方信息dao接口
 *@author: WangYingLing
 *@create: 2018-11-14 23:33
 */

public interface SubcontractorDao {

    /**
     *@Description: 查询全部分包方信息
     *@Param: [subcontractor]
     *@return: List<SubcontractorDO>
     *@Author: WangYingLing
     *@date: 2018/11/15
     */
    List<SubcontractorDO> listSubcontractor(SubcontractorDO subcontractor);

    /**
     *@Description: 新增分包方信息
     *@Param: [subcontractor]
     *@return: int
     *@Author: WangYingLing
     *@date: 2018/11/15
     */
    int saveSubcontractor(SubcontractorDO subcontractor);

    /**
     *@Description: 删除分包方信息
     *@Param: [subcontractorUuid]
     *@return: int
     *@Author: WangYingLing
     *@date: 2018/11/15
     */
    int removeSubcontractor(String subcontractorUuid);

    /**
     *@Description: 修改分包方信息
     *@Param: [subcontractor]
     *@return: int
     *@Author: WangYingLing
     *@date: 2018/11/15
     */
    int updateSubcontractor(SubcontractorDO subcontractor);

    /**
     *@Description: 查询分包方信息（根据主键获取）
     *@Param: [subcontractor]
     *@return: SubcontractorDO
     *@Author: WangYingLing
     *@date: 2018/11/15
     */
    SubcontractorDO getSubcontractor(SubcontractorDO subcontractor);

}
