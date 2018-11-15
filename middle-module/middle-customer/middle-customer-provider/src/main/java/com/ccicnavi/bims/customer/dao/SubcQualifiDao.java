package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;

import java.util.List;

public interface SubcQualifiDao {

    List<SubcQualifiDO> listSubcuQuali(SubcQualifiDO subcuQuali);

    int saveSubcuQuali(SubcQualifiDO subcuQuali);

    int removeSubcuQuali(String subcQualifiUuid);

    int updateSubcuQuali(SubcQualifiDO subcuQuali);

    SubcQualifiDO getSubcQuali(SubcQualifiDO subcQuali);

}
