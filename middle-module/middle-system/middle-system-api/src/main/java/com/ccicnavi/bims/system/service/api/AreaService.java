package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.system.pojo.AreaDO;
import java.util.List;
/* *
 * @Author MengZiJie
 * @Description 地区管理
 * @Date 19:57 2018/11/14
 */
public interface AreaService {

    /* *
     * @Author MengZiJie
     * @Description 查询所有地区
     * @Date 19:57 2018/11/14
     * @Param [areaDO]
     * @Return java.util.List<com.ccicnavi.bims.system.pojo.AreaDO>
     */
    List<AreaDO> listArea(AreaDO areaDO);
    /* *
     * @Author MengZiJie
     * @Description 获取指定地区
     * @Date 19:57 2018/11/14
     * @Param [areaDO]
     * @Return com.ccicnavi.bims.system.pojo.AreaDO
     */
    AreaDO getArea(AreaDO areaDO);
    /* *
     * @Author MengZiJie
     * @Description 新增地区
     * @Date 19:57 2018/11/14
     * @Param [areaDO]
     * @Return java.lang.Integer
     */
    Integer insertArea(AreaDO areaDO);
    /* *
     * @Author MengZiJie
     * @Description 更新地区
     * @Date 19:57 2018/11/14
     * @Param [areaDO]
     * @Return java.lang.Integer
     */
    Integer updateArea(AreaDO areaDO);
    /* *
     * @Author MengZiJie
     * @Description 删除地区
     * @Date 19:57 2018/11/14
     * @Param [areaDO]
     * @Return java.lang.Integer
     */
    Integer deleteArea(AreaDO areaDO);
}
