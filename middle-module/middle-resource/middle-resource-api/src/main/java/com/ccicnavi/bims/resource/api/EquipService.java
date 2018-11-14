package com.ccicnavi.bims.resource.api;


import com.ccicnavi.bims.resource.pojo.EquipDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备信息api接口
 * @author: panyida
 * @create: 2018-11-14 11:30
 **/
public interface EquipService {

    /**
     * @Author panyida
     * @Description 设备信息查询
     * @Date 11:44 2018/11/14
     * @Param [equipDO]
     * @Return java.util.List<com.ccicnavi.bims.ource.pojo.EquipDO>
     */
    List<EquipDO> findEquipList(EquipDO equipDO);

    /**
     * @Author panyida
     * @Description 根据设备主键获取设备信息
     * @Date 11:45 2018/11/14
     * @Param [equipUuid]
     * @Return com.ccicnavi.bims.ource.pojo.EquipDO
     */
    EquipDO getEquip(String equipUuid);

    /**
     * @Author panyida
     * @Description 新增设备信息
     * @Date 11:45 2018/11/14
     * @Param [equipDO]
     * @Return java.lang.Integer
     */
    Integer insertEquip(EquipDO equipDO);

    /**
     * @Author panyida
     * @Description 更新设备信息
     * @Date 11:46 2018/11/14
     * @Param [equipDO]
     * @Return java.lang.Integer
     */
    Integer updateEquip(EquipDO equipDO);

    /**
     * @Author panyida
     * @Description 根据设备信息主键删除设备信息
     * @Date 11:46 2018/11/14
     * @Param [equipDO]
     * @Return java.lang.Integer
     */
    Integer deleteEquip(EquipDO equipDO);
}
