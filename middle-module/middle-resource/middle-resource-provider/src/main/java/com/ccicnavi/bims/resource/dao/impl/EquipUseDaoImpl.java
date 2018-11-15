package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.resource.dao.EquipUseDao;
import com.ccicnavi.bims.resource.pojo.EquipUseDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备领用归还信息持久层接口实现类
 * @author: panyida
 * @create: 2018-11-14 20:21
 **/
@Service
public class EquipUseDaoImpl implements EquipUseDao {
    /**
     * @Author panyida
     * @Description 根据设备领用归还信息主键获取设备领用归还信息
     * @Date 16:29 2018/11/14
     * @Param [equipUseUuid]
     * @Return com.ccicnavi.bims.resource.pojo.EquipUseDO
     */
    @Override
    public EquipUseDO getEquipUse(String equipUseUuid){
        return EqlUtils.getInstance("druid").selectFirst("getEquipUse").params(equipUseUuid).returnType(EquipUseDO.class).execute();
    }

    /**
     * @Author panyida
     * @Description 设备领用归还信息查询
     * @Date 16:28 2018/11/14
     * @Param [equipUseDO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipUseDO>
     */
    @Override
    public List<EquipUseDO> listEquipUse(EquipUseDO equipUseDO){
        return EqlUtils.getInstance("druid").select("listEquipUse").params(equipUseDO).returnType(EquipUseDO.class).execute();
    }

    /**
     * @Author panyida
     * @Description 新增设备领用归还信息
     * @Date 16:29 2018/11/14
     * @Param [equipUseDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertEquipUse(EquipUseDO equipUseDO){
        return EqlUtils.getInstance("druid").insert("insertEquipUse").params(equipUseDO).returnType(Integer.class).execute();
    }

    /**
     * @Author panyida
     * @Description 更新设备领用归还信息
     * @Date 16:30 2018/11/14
     * @Param [equipUseDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateEquipUse(EquipUseDO equipUseDO){
        return EqlUtils.getInstance("druid").update("updateEquipUse").params(equipUseDO).returnType(Integer.class).execute();
    }

    /**
     * @Author panyida
     * @Description 根据设备领用归还信息主键删除设备领用归还信息
     * @Date 16:30 2018/11/14
     * @Param [equipUseUuid]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquipUse(String equipUseUuid){
        return EqlUtils.getInstance("druid").delete("deleteEquipUse").params(equipUseUuid).returnType(Integer.class).execute();
    }
}
