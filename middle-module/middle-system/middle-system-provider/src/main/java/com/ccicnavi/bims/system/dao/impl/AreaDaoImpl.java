package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.AreaDao;
import com.ccicnavi.bims.system.pojo.AreaDO;
import org.n3r.eql.Eql;
import java.util.List;

/* *
 * @Author MengZiJie
 * @Description 地区管理
 * @Date 16:48 2018/11/14
 */
public class AreaDaoImpl implements AreaDao {


    private List<AreaDO> area;

    /** *
     * @Author MengZiJie
     * @Description 查询所有
     * @Date 16:48 2018/11/14
     * @Param [areaDO]
     * @Return java.util.List<com.ccicnavi.bims.system.pojo.AreaDO>
     */
    @Override
    public List<AreaDO> listArea(AreaDO areaDO) {
        List<AreaDO> listArea = null;
        try {
            listArea = EqlUtils.getInstance("druid").select("listArea").params(areaDO).returnType(AreaDO.class).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listArea;
    }

    /**获取指定的地区*/
    @Override
    public AreaDO getArea(AreaDO areaDO) {
        AreaDO area = null;
        try {
            area = EqlUtils.getInstance("druid").selectFirst("getArea").params(areaDO).returnType(AreaDO.class).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return area;
    }

    /**添加地区*/
    @Override
    public int insertArea(AreaDO areaDO) {
        int area = 0;
        try {
            area = EqlUtils.getInstance("druid").insert("insertArea").params(areaDO).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return area;
    }

    /**更新地区信息*/
    @Override
    public int updateArea(AreaDO areaDO) {
        int area = 0;
        try {
            area = EqlUtils.getInstance("druid").update("updateArea").params(areaDO).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return area;
    }

    /**删除地区*/
    @Override
    public int deleteArea(AreaDO areaDO) {
        int area = 0;
        try {
            area = EqlUtils.getInstance("druid").delete("deleteArea").params(areaDO).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return area;
    }
}
