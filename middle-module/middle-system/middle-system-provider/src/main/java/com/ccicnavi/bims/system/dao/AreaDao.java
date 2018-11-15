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
    List<AreaDO> listArea(AreaDO areaDO) throws Exception;
    /**获取指定的地区*/
    AreaDO getArea(AreaDO areaDO) throws Exception;
    /**新增地区信息*/
    Integer insertArea(AreaDO areaDO) throws Exception;
    /**更新地区信息*/
    Integer updateArea(AreaDO areaDO) throws Exception;
    /**删除地区*/
    Integer deleteArea(AreaDO areaDO) throws Exception;
}
