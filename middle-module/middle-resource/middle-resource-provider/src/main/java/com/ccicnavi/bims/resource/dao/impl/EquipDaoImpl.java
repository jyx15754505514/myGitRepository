package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.resource.dao.EquipDao;
import com.ccicnavi.bims.resource.pojo.EquipDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备信息持久层实现类
 * @author: panyida
 * @create: 2018-11-14 16:00
 **/
@Slf4j
@Service
public class EquipDaoImpl implements EquipDao {

    /**
     * @Author panyida
     * @Description 根据设备信息主键获取设备信息
     * @Date 16:29 2018/11/14
     * @Param [equipUuid]
     * @Return com.ccicnavi.bims.resource.pojo.EquipDO
     */
    @Override
    public EquipDO getEquip(String equipUuid){
        EquipDO equipDO = null;
        try {
            equipDO = EqlUtils.getInstance("druid").select("getEquip").params(equipUuid).returnType(EquipDO.class).execute();
        } catch (Exception e) {
            log.debug("根据设备信息主键获取设备信息错误",e);
            e.printStackTrace();
        }
        return equipDO;
    }

    /**
     * @Author panyida
     * @Description 设备信息查询
     * @Date 16:28 2018/11/14
     * @Param [equipDO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipDO>
     */
    @Override
    public List<EquipDO> listEquip(EquipDO equipDO){
        List<EquipDO> listEquipDO = null;
        try {
            listEquipDO = EqlUtils.getInstance("druid").select("listEquip").params(equipDO).returnType(EquipDO.class).execute();
        } catch (Exception e) {
            log.debug("设备信息查询错误",e);
            e.printStackTrace();
        }
        return listEquipDO;
    }

    /**
     * @Author panyida
     * @Description 新增设备信息
     * @Date 16:29 2018/11/14
     * @Param [equipDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertEquip(EquipDO equipDO){
        Integer count = null;
        try {
            count = EqlUtils.getInstance("druid").select("insertEquip").params(equipDO).returnType(Integer.class).execute();
        } catch (Exception e) {
            log.debug("新增设备信息错误",e);
            e.printStackTrace();
        }
        return count;
}

    /**
     * @Author panyida
     * @Description 更新设备信息
     * @Date 16:30 2018/11/14
     * @Param [equipDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateEquip(EquipDO equipDO){
        Integer count = null;
        try {
            count = EqlUtils.getInstance("druid").select("updateEquip").params(equipDO).returnType(EquipDO.class).execute();
        } catch (Exception e) {
            log.debug("更新设备信息错误",e);
            e.printStackTrace();
        }
        return count;
    }

    /**
     * @Author panyida
     * @Description 根据设备信息主键删除设备信息
     * @Date 16:30 2018/11/14
     * @Param [equipDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquip(EquipDO equipDO){
        Integer count = null;
        try {
            count = EqlUtils.getInstance("druid").select("updateEquip").params(equipDO).returnType(EquipDO.class).execute();
        } catch (Exception e) {
            log.debug("根据设备信息主键删除设备信息错误",e);
            e.printStackTrace();
        }
        return count;
    }
}
