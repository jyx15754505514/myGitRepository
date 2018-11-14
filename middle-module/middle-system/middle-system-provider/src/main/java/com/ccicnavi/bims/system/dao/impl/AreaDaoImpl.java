package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.system.dao.AreaDao;
import com.ccicnavi.bims.system.pojo.AreaDO;
import org.n3r.eql.Eql;
import java.util.List;

/**
 * @Auther: mzj
 * @Date: 2018/11/14 10:25
 * @Description:地区管理
 */
public class AreaDaoImpl implements AreaDao {

    Eql eql = new Eql();

    /**查询所有的地区*/
    @Override
    public List<AreaDO> listArea(AreaDO areaDO) {
        return eql.select("listArea").params(areaDO).returnType(AreaDO.class).execute();
    }

    /**获取指定的地区*/
    @Override
    public AreaDO getArea(AreaDO areaDO) {
        return eql.selectFirst("getArea").params(areaDO).returnType(AreaDO.class).execute();
    }

    /**添加地区*/
    @Override
    public int insertArea(AreaDO areaDO) {
        return eql.insert("insertArea").params(areaDO).execute();
    }

    /**更新地区信息*/
    @Override
    public int updateArea(AreaDO areaDO) {
        return eql.update("updateArea").params(areaDO).execute();
    }

    /**删除地区*/
    @Override
    public int deleteArea(AreaDO areaDO) {
        return eql.delete("deleteArea").params(areaDO).execute();
    }
}
