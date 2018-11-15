package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.resource.dao.EquipHoldDao;
import com.ccicnavi.bims.resource.pojo.EquipHoldDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备保管信息持久层接口实现类
 * @author: panyida
 * @create: 2018-11-14 18:27
 **/
@Service
public class EquipHoldDaoImpl implements EquipHoldDao {

    /**
     * @Author panyida
     * @Description 根据设备保管信息主键获取设备保管信息
     * @Date 16:29 2018/11/14
     * @Param [equipHoldUuid]
     * @Return com.ccicnavi.bims.resource.pojo.EquipHoldDO
     */
    @Override
    public EquipHoldDO getEquipHold(String equipHoldUuid){
        return EqlUtils.getInstance("druid").selectFirst("getEquipHold").params(equipHoldUuid).returnType(EquipHoldDO.class).execute();
    }

    /**
     * @Author panyida
     * @Description 设备保管信息查询
     * @Date 16:28 2018/11/14
     * @Param [equipHoldDO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipHoldDO>
     */
    @Override
    public List<EquipHoldDO> listEquipHold(EquipHoldDO equipHoldDO){
        return EqlUtils.getInstance("druid").select("listEquipHold").params(equipHoldDO).returnType(EquipHoldDO.class).execute();
    }

    /**
     * @Author panyida
     * @Description 新增设备保管信息
     * @Date 16:29 2018/11/14
     * @Param [equipHoldDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertEquipHold(EquipHoldDO equipHoldDO){
        return EqlUtils.getInstance("druid").insert("insertEquipHold").params(equipHoldDO).returnType(Integer.class).execute();
    }

    /**
     * @Author panyida
     * @Description 更新设备保管信息
     * @Date 16:30 2018/11/14
     * @Param [equipHoldDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateEquipHold(EquipHoldDO equipHoldDO){
        return EqlUtils.getInstance("druid").update("updateEquipHold").params(equipHoldDO).returnType(Integer.class).execute();
    }

    /**
     * @Author panyida
     * @Description 根据设备保管信息主键删除设备保管信息
     * @Date 16:30 2018/11/14
     * @Param [equipHoldDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquipHold(EquipHoldDO equipHoldDO){
        return EqlUtils.getInstance("druid").delete("deleteEquipHold").params(equipHoldDO).returnType(Integer.class).execute();
    }
}
