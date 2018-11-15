package com.ccicnavi.bims.resource.api;

import com.ccicnavi.bims.resource.pojo.EquipTestDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备检定信息api接口
 * @author: panyida
 * @create: 2018-11-14 11:30
 **/
public interface EquipTestService {

    /**
     * @Author panyida
     * @Description 设备检定查询
     * @Date 11:44 2018/11/14
     * @Param [equipTestDO]
     * @Return java.util.List<com.ccicnavi.bims.ource.pojo.EquipTestDO>
     */
    List<EquipTestDO> listEquipTest(EquipTestDO equipTestDO);

    /**
     * @Author panyida
     * @Description 根据设备检定主键获取设备检定
     * @Date 11:45 2018/11/14
     * @Param [equipTestUuid]
     * @Return com.ccicnavi.bims.ource.pojo.EquipTestDO
     */
    EquipTestDO getEquipTest(String equipTestUuid);

    /**
     * @Author panyida
     * @Description 新增设备检定
     * @Date 11:45 2018/11/14
     * @Param [equipTestDO]
     * @Return java.lang.Integer
     */
    Integer insertEquipTest(EquipTestDO equipTestDO);

    /**
     * @Author panyida
     * @Description 更新设备检定
     * @Date 11:46 2018/11/14
     * @Param [equipTestDO]
     * @Return java.lang.Integer
     */
    Integer updateEquipTest(EquipTestDO equipTestDO);

    /**
     * @Author panyida
     * @Description 根据设备检定主键删除设备检定
     * @Date 11:46 2018/11/14
     * @Param [equipTestDO]
     * @Return java.lang.Integer
     */
    Integer deleteEquipTest(String equipTestUuid);
}
