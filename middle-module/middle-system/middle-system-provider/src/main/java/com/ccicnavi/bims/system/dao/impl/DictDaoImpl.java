package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.DictDao;
import com.ccicnavi.bims.system.pojo.DictTypeDO;
import com.ccicnavi.bims.system.pojo.DictValueDO;

import java.util.List;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/20 09:23
 * @Description:
 */
public class DictDaoImpl implements DictDao {
    @Override
    public List<DictTypeDO> listDictType(List<String> types) throws Exception {
        return EqlUtils.getInstance("DEFAULT").select("listDictType").params(types).returnType(DictTypeDO.class).execute();
    }

    @Override
    public List<DictValueDO> listDictValue(List<String> types) throws Exception {
        return EqlUtils.getInstance("DEFAULT").select("listDictValue").params(types).returnType(DictValueDO.class).execute();
    }
}
