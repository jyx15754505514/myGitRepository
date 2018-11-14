package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.resource.pojo.EquipHoldDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备保管信息持久层接口
 * @author: panyida
 * @create: 2018-11-14 18:23
 **/
public interface EquipHoldDao {
    /**
     * @Author panyida
     * @Description 设备保管信息查询
     * @Date 11:44 2018/11/14
     * @Param [equipHoldDO]
     * @Return java.util.List<com.ccicnavi.bims.ource.pojo.EquipHoldDO>
     */
    List<EquipHoldDO> listEquipHold(EquipHoldDO equipHoldDO);

    /**
     * @Author panyida
     * @Description 根据设备保管信息主键获取设备保管信息
     * @Date 11:45 2018/11/14
     * @Param [equipUuid]
     * @Return com.ccicnavi.bims.ource.pojo.EquipHoldDO
     */
    EquipHoldDO getEquipHold(String equipUuid);

    /**
     * @Author panyida
     * @Description 新增设备保管信息
     * @Date 11:45 2018/11/14
     * @Param [equipHoldDO]
     * @Return java.lang.Integer
     */
    Integer insertEquipHold(EquipHoldDO equipHoldDO);

    /**
     * @Author panyida
     * @Description 更新设备保管信息
     * @Date 11:46 2018/11/14
     * @Param [equipHoldDO]
     * @Return java.lang.Integer
     */
    Integer updateEquipHold(EquipHoldDO equipHoldDO);

    /**
     * @Author panyida
     * @Description 根据设备保管信息主键删除设备保管信息
     * @Date 11:46 2018/11/14
     * @Param [equipHoldDO]
     * @Return java.lang.Integer
     */
    Integer deleteEquipHold(EquipHoldDO equipHoldDO);
}
