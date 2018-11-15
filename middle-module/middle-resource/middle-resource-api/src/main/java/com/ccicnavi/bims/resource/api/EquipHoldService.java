package com.ccicnavi.bims.resource.api;


import com.ccicnavi.bims.resource.pojo.EquipHoldDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备保管信息api接口
 * @author: panyida
 * @create: 2018-11-14 11:30
 **/
public interface EquipHoldService {

    /**
     * @Author panyida
     * @Description 设备保管查询
     * @Date 11:44 2018/11/14
     * @Param [EquipHoldDO]
     * @Return java.util.List<com.ccicnavi.bims.ource.pojo.EquipHoldDO>
     */
    List<EquipHoldDO> listEquipHold(EquipHoldDO EquipHoldDO);

    /**
     * @Author panyida
     * @Description 根据设备主键获取设备保管
     * @Date 11:45 2018/11/14
     * @Param [EquipHoldUuid]
     * @Return com.ccicnavi.bims.ource.pojo.EquipHoldDO
     */
    EquipHoldDO getEquipHold(String EquipHoldUuid);

    /**
     * @Author panyida
     * @Description 新增设备保管
     * @Date 11:45 2018/11/14
     * @Param [EquipHoldDO]
     * @Return java.lang.Integer
     */
    Integer insertEquipHold(EquipHoldDO EquipHoldDO);

    /**
     * @Author panyida
     * @Description 更新设备保管
     * @Date 11:46 2018/11/14
     * @Param [EquipHoldDO]
     * @Return java.lang.Integer
     */
    Integer updateEquipHold(EquipHoldDO EquipHoldDO);

    /**
     * @Author panyida
     * @Description 根据设备主键删除设备保管
     * @Date 11:46 2018/11/14
     * @Param [EquipHoldDO]
     * @Return java.lang.Integer
     */
    Integer deleteEquipHold(String EquipHoldUuid);
}
