package com.ccicnavi.bims.customer.api;

import com.ccicnavi.bims.customer.pojo.SpecialNeedDO;

import java.util.List;

/**
 * 客户特殊需求信息接口
 */

public interface SpecialNeedService {

    List<SpecialNeedDO> listSpecialNeed(SpecialNeedDO specialNeed);

    int saveSpecialNeed(SpecialNeedDO specialNeed);

    int removeSpecialNeed(String needUuid);

    int updateSpecialNeed(SpecialNeedDO specialNeed);

}
