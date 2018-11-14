package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.resource.dao.EquipTestDao;
import com.ccicnavi.bims.resource.pojo.EquipTestDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备检定信息持久层接口实现类
 * @author: panyida
 * @create: 2018-11-14 20:21
 **/
public class EquipTestDaoImpl implements EquipTestDao {
    /**
     * @Author panyida
     * @Description 根据设备检定信息主键获取设备检定信息
     * @Date 16:29 2018/11/14
     * @Param [equipTestUuid]
     * @Return com.ccicnavi.bims.resource.pojo.EquipTestDO
     */
    @Override
    public EquipTestDO getEquipTest(String equipTestUuid){
        EquipTestDO equipTestDO = null;
        try {
            equipTestDO = EqlUtils.getInstance("druid").select("getEquip").params(equipTestUuid).returnType(EquipTestDO.class).execute();
        } catch (Exception e) {
            log.debug("根据设备检定信息主键获取设备检定信息错误",e);
            e.printStackTrace();
        }
        return equipTestDO;
    }

    /**
     * @Author panyida
     * @Description 设备检定信息查询
     * @Date 16:28 2018/11/14
     * @Param [equipTestDO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipTestDO>
     */
    @Override
    public List<EquipTestDO> listEquipTest(EquipTestDO equipTestDO){
        List<EquipTestDO> listEquipTestDO = null;
        try {
            listEquipTestDO = EqlUtils.getInstance("druid").select("listEquip").params(equipTestDO).returnType(EquipTestDO.class).execute();
        } catch (Exception e) {
            log.debug("设备检定信息查询错误",e);
            e.printStackTrace();
        }
        return listEquipTestDO;
    }

    /**
     * @Author panyida
     * @Description 新增设备检定信息
     * @Date 16:29 2018/11/14
     * @Param [equipTestDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertEquipTest(EquipTestDO equipTestDO){
        Integer count = null;
        try {
            count = EqlUtils.getInstance("druid").select("insertEquip").params(equipTestDO).returnType(Integer.class).execute();
        } catch (Exception e) {
            log.debug("新增设备检定信息错误",e);
            e.printStackTrace();
        }
        return count;
    }

    /**
     * @Author panyida
     * @Description 更新设备检定信息
     * @Date 16:30 2018/11/14
     * @Param [equipTestDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateEquipTest(EquipTestDO equipTestDO){
        Integer count = null;
        try {
            count = EqlUtils.getInstance("druid").select("updateEquip").params(equipTestDO).returnType(EquipTestDO.class).execute();
        } catch (Exception e) {
            log.debug("更新设备检定信息错误",e);
            e.printStackTrace();
        }
        return count;
    }

    /**
     * @Author panyida
     * @Description 根据设备检定信息主键删除设备检定信息
     * @Date 16:30 2018/11/14
     * @Param [equipTestDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquipTest(EquipTestDO equipTestDO){
        Integer count = null;
        try {
            count = EqlUtils.getInstance("druid").select("updateEquip").params(equipTestDO).returnType(EquipTestDO.class).execute();
        } catch (Exception e) {
            log.debug("根据设备检定信息主键删除设备检定信息错误",e);
            e.printStackTrace();
        }
        return count;
    }
}
