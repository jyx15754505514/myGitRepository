package com.ccicnavi.bims.customer.api;


import com.ccicnavi.bims.customer.pojo.SubcontractorDO;

import java.util.List;

/**
 * 分包方信息接口层
 */

public interface SubcontractorService {

    List<SubcontractorDO> listSubcontractor(SubcontractorDO subcontractor);

    int saveSubcontractor(SubcontractorDO subcontractor);

    int removeSubcontractor(String subcontractorUuid);

    int updateSubcontractor(SubcontractorDO subcontractor);



}
