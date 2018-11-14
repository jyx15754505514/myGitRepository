package com.ccicnavi.bims.customer.api;


import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;

import java.util.List;

/**
 * 分包方资质接口层
 */

public interface SubcQualifiService {

    List<SubcQualifiDO> listSubcQuali(SubcQualifiDO subcQuali);

    int saveSubcQuali(SubcQualifiDO subcQuali);

    int removeSubcQuali(String subcQualifiUuid);

    int updateSubcQuali(SubcQualifiDO subcQuali);

}
