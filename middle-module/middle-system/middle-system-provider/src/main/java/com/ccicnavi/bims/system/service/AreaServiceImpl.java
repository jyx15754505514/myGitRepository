package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.AreaDao;
import com.ccicnavi.bims.system.pojo.AreaDO;
import com.ccicnavi.bims.system.service.api.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/* *
 * @Author MengZiJie
 * @Description 地区管理
 * @Date 19:59 2018/11/14
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaDao areaDao;

    /* *
     * @Author MengZiJie
     * @Description 查找所有
     * @Date 20:00 2018/11/14
     * @Param [areaDO]
     * @Return java.util.List<com.ccicnavi.bims.system.pojo.AreaDO>
     */
    @Override
    public List<AreaDO> listArea(AreaDO areaDO) {
        return areaDao.listArea(areaDO);
    }

    /* *
     * @Author MengZiJie
     * @Description 获取指定地区信息
     * @Date 20:00 2018/11/14
     * @Param [areaDO]
     * @Return com.ccicnavi.bims.system.pojo.AreaDO
     */
    @Override
    public AreaDO getArea(AreaDO areaDO) {
        return areaDao.getArea(areaDO);
    }

    /* *
     * @Author MengZiJie
     * @Description 添加地区
     * @Date 20:01 2018/11/14
     * @Param [areaDO]
     * @Return int
     */
    @Override
    public int insertArea(AreaDO areaDO) {
        return areaDao.insertArea(areaDO);
    }

    /* *
     * @Author MengZiJie
     * @Description 更细地区
     * @Date 20:01 2018/11/14
     * @Param [areaDO]
     * @Return int
     */
    @Override
    public int updateArea(AreaDO areaDO) {
        return updateArea(areaDO);
    }

    /* *
     * @Author MengZiJie
     * @Description 删除地区
     * @Date 20:01 2018/11/14
     * @Param [areaDO]
     * @Return int
     */
    @Override
    public int deleteArea(AreaDO areaDO) {
        return areaDao.deleteArea(areaDO);
    }
}
