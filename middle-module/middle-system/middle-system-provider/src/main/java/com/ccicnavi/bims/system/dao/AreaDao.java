package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.system.pojo.AreaDO;
import com.ccicnavi.bims.system.pojo.LogDO;

import java.util.List;

/* *
 * @Author MengZiJie
 * @Description 地区管理
 * @Date 16:48 2018/11/14
 */
public interface AreaDao {

    /**查询所有的地区*/
    List<AreaDO> listArea(AreaDO areaDO);
    /**获取指定的地区*/
    AreaDO getArea(AreaDO areaDO);
    /**新增地区信息*/
    int insertArea(AreaDO areaDO);
    /**更新地区信息*/
    int updateArea(AreaDO areaDO);
    /**删除地区*/
    int deleteArea(AreaDO areaDO);
}
