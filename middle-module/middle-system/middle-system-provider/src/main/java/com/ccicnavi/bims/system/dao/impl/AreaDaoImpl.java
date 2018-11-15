package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.system.dao.AreaDao;
import com.ccicnavi.bims.system.pojo.AreaDO;
import org.springframework.stereotype.Service;
import java.util.List;

/* *
 * @Author MengZiJie
 * @Description 地区管理
 * @Date 16:48 2018/11/14
 */
@Service
public class AreaDaoImpl implements AreaDao {

    /** *
     * @Author MengZiJie
     * @Description 查询所有
     * @Date 16:48 2018/11/14
     * @Param [areaDO]
     * @Return java.util.List<com.ccicnavi.bims.system.pojo.AreaDO>
     */
    @Override
    public List<AreaDO> listArea(AreaDO areaDO) {
        return EqlUtils.getInstance("DEFAULT").select("listArea").params(areaDO).returnType(AreaDO.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 获取指定的地区
     * @Date 16:48 2018/11/14
     * @Param [areaDO]
     * @Return com.ccicnavi.bims.system.pojo.AreaDO
     */
    @Override
    public AreaDO getArea(AreaDO areaDO) {
        return EqlUtils.getInstance("DEFAULT").selectFirst("getArea").params(areaDO).returnType(AreaDO.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 添加地区
     * @Date 16:48 2018/11/14
     * @Param [areaDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertArea(AreaDO areaDO) {
        return EqlUtils.getInstance("DEFAULT").insert("insertArea").params(areaDO).returnType(Integer.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 更新地区信息
     * @Date 16:48 2018/11/14
     * @Param [areaDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateArea(AreaDO areaDO) {
        return EqlUtils.getInstance("DEFAULT").update("updateArea").params(areaDO).returnType(Integer.class).execute();
    }

    /* *
     * @Author MengZiJie
     * @Description 删除地区
     * @Date 16:48 2018/11/14
     * @Param [areaDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteArea(AreaDO areaDO) {
        return EqlUtils.getInstance("DEFAULT").delete("deleteArea").params(areaDO).returnType(Integer.class).execute();
    }
}
