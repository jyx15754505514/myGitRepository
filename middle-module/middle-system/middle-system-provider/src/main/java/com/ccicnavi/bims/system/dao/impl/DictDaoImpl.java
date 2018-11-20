package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.DictDao;
import com.ccicnavi.bims.system.pojo.DictTypeDO;
import com.ccicnavi.bims.system.pojo.DictValueDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 数据字典的Dao实现
 * @author: zhangxingbiao
 * @create: 2018-11-20 10:41
 */
@Service
public class DictDaoImpl implements DictDao {


    /**
    *@Description: 根据父级类型uuid查询字典数据
    *@Param: [dictParentUuid]
    *@return: java.util.List<com.ccicnavi.bims.system.pojo.DictValueDO>
    *@Author: zhangxingbiao
    *@date: 2018/11/20
    */
    @Override
    public List<DictValueDO> listDictValue(String dictParentUuid) throws Exception {
        return new Eql("DEFAULT").select("listDictValue").params(dictParentUuid).returnType(DictValueDO.class).execute();
    }
}
