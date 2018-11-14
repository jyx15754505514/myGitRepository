package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.AreaDao;
import com.ccicnavi.bims.system.pojo.AreaDO;
import com.ccicnavi.bims.system.service.api.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/* *
 * @Author MengZiJie
 * @Description 地区管理
 * @Date 19:59 2018/11/14
 */
@Slf4j
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
        List<AreaDO> listArea = null;
        try {
            listArea = areaDao.listArea(areaDO);
        } catch (Exception e) {
            log.debug("查询地区失败",e);
            e.printStackTrace();
        }
        return listArea;
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
        AreaDO area = null;
        try {
            area = areaDao.getArea(areaDO);
        } catch (Exception e) {
            log.debug("获取地区失败",e);
            e.printStackTrace();
        }
        return area;
    }

    /* *
     * @Author MengZiJie
     * @Description 添加地区
     * @Date 20:01 2018/11/14
     * @Param [areaDO]
     * @Return int
     */
    @Override
    public Integer insertArea(AreaDO areaDO) {
        int area = 0;
        try {
            area = areaDao.insertArea(areaDO);
        } catch (Exception e) {
            log.debug("添加地区失败",e);
            e.printStackTrace();
        }
        return area;
    }

    /* *
     * @Author MengZiJie
     * @Description 更细地区
     * @Date 20:01 2018/11/14
     * @Param [areaDO]
     * @Return int
     */
    @Override
    public Integer updateArea(AreaDO areaDO) {
        int area = 0;
        try {
            area = updateArea(areaDO);
        } catch (Exception e) {
            log.debug("更新地区失败",e);
            e.printStackTrace();
        }
        return area;
    }

    /* *
     * @Author MengZiJie
     * @Description 删除地区
     * @Date 20:01 2018/11/14
     * @Param [areaDO]
     * @Return int
     */
    @Override
    public Integer deleteArea(AreaDO areaDO) {
        int area = 0;
        try {
            area = areaDao.deleteArea(areaDO);
        } catch (Exception e) {
            log.debug("删除地区失败",e);
            e.printStackTrace();
        }
        return area;
    }
}
