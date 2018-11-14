package com.ccicnavi.bims.customer.service;

import com.ccicnavi.bims.customer.api.SubcontractorService;
import com.ccicnavi.bims.customer.pojo.SubcontractorDO;

import javax.annotation.Resource;
import java.util.List;

public class SubcontractorServiceImpl implements SubcontractorService{

    @Resource
    SubcontractorService subcontractorService;

    @Override
    public List<SubcontractorDO> listSubcontractor(SubcontractorDO subcontractor) {
        return subcontractorService.listSubcontractor(subcontractor);
    }

    @Override
    public int saveSubcontractor(SubcontractorDO subcontractor) {
        return subcontractorService.saveSubcontractor(subcontractor);
    }

    @Override
    public int removeSubcontractor(String subcontractorUuid) {
        return subcontractorService.removeSubcontractor(subcontractorUuid);
    }

    @Override
    public int updateSubcontractor(SubcontractorDO subcontractor) {
        return subcontractorService.updateSubcontractor(subcontractor);
    }
}
