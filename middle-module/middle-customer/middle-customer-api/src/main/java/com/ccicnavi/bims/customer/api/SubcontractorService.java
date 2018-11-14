package com.ccicnavi.bims.customer.api;


import com.ccicnavi.bims.customer.pojo.SubcontractorDO;

import java.util.List;

/**
 * 分包方信息接口层
 */

public interface SubcontractorService {

    /**查询全部分包方信息*/
    List<SubcontractorDO> listSubcontractor(SubcontractorDO subcontractor);

    /**新增分包方信息*/
    int saveSubcontractor(SubcontractorDO subcontractor);

    /**删除分包方信息*/
    int removeSubcontractor(String subcontractorUuid);

    /**修改分包方信息*/
    int updateSubcontractor(SubcontractorDO subcontractor);

    /**根据主键返回对应的分包方信息*/
    SubcontractorDO getSubcontractor(SubcontractorDO subcontractor);

}
