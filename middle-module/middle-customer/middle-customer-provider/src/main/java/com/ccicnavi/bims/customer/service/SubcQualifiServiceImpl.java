package com.ccicnavi.bims.customer.provider;

import com.ccicnavi.bims.customer.api.SubcQualifiService;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;

import javax.annotation.Resource;
import java.util.List;

public class SubcQualifiServiceImpl implements SubcQualifiService {

    @Resource
    SubcQualifiService subcQualifiService;

    @Override
    public List<SubcQualifiDO> listSubcQuali(SubcQualifiDO subcQuali) {
        return subcQualifiService.listSubcQuali(subcQuali);
    }

    @Override
    public int saveSubcQuali(SubcQualifiDO subcQuali) {
        return subcQualifiService.saveSubcQuali(subcQuali);
    }

    @Override
    public int removeSubcQuali(String subcQualifiUuid) {
        return subcQualifiService.removeSubcQuali(subcQualifiUuid);
    }

    @Override
    public int updateSubcQuali(SubcQualifiDO subcQuali) {
        return subcQualifiService.updateSubcQuali(subcQuali);
    }
}
