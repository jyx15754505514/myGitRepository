package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.customer.pojo.SubcontractorDO;

import java.util.List;

public interface SubcontractorDao {

    List<SubcontractorDO> listSubcontractor(SubcontractorDO subcontractor);

    int saveSubcontractor(SubcontractorDO subcontractor);

    int removeSubcontractor(String subcontractorUuid);

    int updateSubcontractor(SubcontractorDO subcontractor);

    SubcontractorDO getSubcontractor(SubcontractorDO subcontractor);

}
