package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.resource.dao.EquipDao;
import com.ccicnavi.bims.resource.pojo.EquipDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备信息持久层实现类
 * @author: panyida
 * @create: 2018-11-14 16:00
 **/
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
        return EqlUtils.getInstance("druid").selectFirst("getEquip").params(equipUuid).returnType(EquipDO.class).execute();
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
        return EqlUtils.getInstance("druid").select("listEquip").params(equipDO).returnType(EquipDO.class).execute();
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
        return EqlUtils.getInstance("druid").insert("insertEquip").params(equipDO).returnType(Integer.class).execute();
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
        return EqlUtils.getInstance("druid").update("updateEquip").params(equipDO).returnType(Integer.class).execute();
    }

    /**
     * @Author panyida
     * @Description 根据设备信息主键删除设备信息
     * @Date 16:30 2018/11/14
     * @Param [equipDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquip(String equipUuid){
        return EqlUtils.getInstance("druid").delete("deleteEquip").params(equipUuid).returnType(Integer.class).execute();
    }

    public static void main(String[]args){
        System.out.println("开始");
/*
        Integer count = EqlUtils.getInstance("druid").insert("insertEquip").params(equipDO).returnType(Integer.class).execute();
*/
/*
        EquipDO equipDO = new EquipDO();
        equipDO.setEquipUuid("EquipUuid");
        equipDO.setEquipName("123EquipName");
        equipDO.setEquipNameEn("123EquipNameEn");
        equipDO.setControlCode("123ControlCode");
        equipDO.setEquipSpec("123EquipSpec");
        equipDO.setEquipModel("123EquipModel");
        equipDO.setFactoryNo("123FactoryNo");
        equipDO.setManufacture("123Manufacture");
        equipDO.setFactoryLevel("123FactoryLevel");
        equipDO.setMeasureRange("123MeasureRange");
        equipDO.setAccuracyLevel("123AccuracyLevel");
        equipDO.setEquipAbc("A");
        equipDO.setStatusUuid("123StatusUuid");
        equipDO.setOrgUuid("123OrgUuid");
        equipDO.setAppSysUuid("123AppSysUuid");*/        //Integer count = EqlUtils.getInstance("druid").update("updateEquip").params(equipDO).returnType(Integer.class).execute();
        //List<EquipDO> listEquipDO = EqlUtils.getInstance("druid").select("getEquip").params("EquipUuid").returnType(EquipDO.class).execute();
        EquipDO equipDO = new EquipDO();
        equipDO.setEquipUuid("EquipUuid");
        Integer count = EqlUtils.getInstance("druid").delete("deleteEquip").params(equipDO).returnType(Integer.class).execute();
        System.out.println("结果"+count);
    }
}
