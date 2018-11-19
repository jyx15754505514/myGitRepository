package com.ccicnavi.bims.customer.api;


import com.ccicnavi.bims.customer.pojo.SubcontractorDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 分包方信息接口定义
 * @author: WangYingLing
 * @create: 2018-11-15 09:19
 */

public interface SubcontractorService {

    /**查询全部分包方信息*/
    List<SubcontractorDO> listSubcontractor(SubcontractorDO subcontractor) throws Exception;

    /**新增分包方信息*/
    int saveSubcontractor(SubcontractorDO subcontractor) throws Exception;

    /**删除分包方信息*/
    int removeSubcontractor(SubcontractorDO subcontractor) throws Exception;

    /**修改分包方信息*/
    int updateSubcontractor(SubcontractorDO subcontractor) throws Exception;

    /**根据主键返回对应的分包方信息*/
    SubcontractorDO getSubcontractor(SubcontractorDO subcontractor) throws Exception;

}
