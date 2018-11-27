package com.ccicnavi.bims.system.dao.impl;


import com.ccicnavi.bims.system.dao.DictValueDao;
import com.ccicnavi.bims.system.pojo.DictTypeDTO;
import com.ccicnavi.bims.system.pojo.DictValueDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 数据字典数值
 * @author: zhangxingbiao
 * @create: 2018-11-20 11:06
 */
@Service
@Slf4j
public class DictValueDaoImpl implements DictValueDao {

    /**
     * @Description: 新增数据字典数值
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    @Override
    public Integer insertDictValue(DictValueDO dictValueDO) {
        return new Eql("DEFAULT").insert("insertDictValue").params(dictValueDO).returnType(Integer.class).execute();
    }

    /**
     * @Description: 删除数据字典数值
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    @Override
    public Integer deleteDictValue(DictTypeDTO dictTypeDTO) {
        return new Eql("DEFAULT").update("deleteDictValue").params(dictTypeDTO).returnType(Integer.class).execute();
    }

    /**
     * @Description: 更改数据字典数值
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    @Override
    public Integer updateDictValue(DictValueDO dictValueDO) {
        return new Eql("DEFAULT").update("updateDictValue").params(dictValueDO).returnType(Integer.class).execute();
    }

    /**
     * 查询字典值列表根据字典类别ID和所属机构和所属产品线ID查询
     *
     * @return java.util.List<com.ccicnavi.bims.system.pojo.DictValueDO>
     * @author TXW
     * @date 2018/11/26 17:40
     * @params [dictParentUuid]
     */
    @Override
    public List<DictValueDO> listDictValue(DictTypeDTO dictTypeDTO) {
        return new Eql("DEFAULT").select("listDictValue").params(dictTypeDTO).returnType(DictValueDO.class).execute();
    }

    /**
     * 根据主键获取对应数据字典数值信息
     * @param dictValueDO
     * @return
     * @throws Exception
     */
    @Override
    public DictValueDO getDictValue(DictValueDO dictValueDO) {
        return new Eql("DEFAULT").selectFirst("getDictValue").params(dictValueDO).returnType(DictValueDO.class).execute();
    }
}
