package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.customer.pojo.SpecialNeedDO;

import java.util.List;

public interface SpecialNeedDao {

    List<SpecialNeedDO> listSpecialNeed(SpecialNeedDO specialNeed);

    int saveSpecialNeed(SpecialNeedDO specialNeed);

    int removeSpecialNeed(String needUuid);

    int updateSpecialNeed(SpecialNeedDO specialNeed);

    SpecialNeedDO getSpecialNeed(SpecialNeedDO specialNeed);

}
