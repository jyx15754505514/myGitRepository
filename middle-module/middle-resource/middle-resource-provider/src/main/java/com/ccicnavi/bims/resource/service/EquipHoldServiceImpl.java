package com.ccicnavi.bims.resource.service;

import com.ccicnavi.bims.resource.api.EquipHoldService;
import com.ccicnavi.bims.resource.dao.EquipHoldDao;
import com.ccicnavi.bims.resource.pojo.EquipHoldDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备保管信息api实现类
 * @author: panyida
 * @create: 2018-11-14 17:29
 **/
@Service
public class EquipHoldServiceImpl implements EquipHoldService {
    
    @Autowired
    private EquipHoldDao equipHoldDao;

    /**
     * @Author panyida
     * @Description 设备保管信息查询
     * @Date 16:12 2018/11/14
     * @Param [EquipHoldDO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipHoldDO>
     */
    @Override
    public List<EquipHoldDO> listEquipHold(EquipHoldDO equipHoldDao){
        return equipHoldDao.listEquipHold(equipHoldDao);
    }

    /**
     * @Author panyida
     * @Description 根据设备保管信息主键获取设备保管信息
     * @Date 16:26 2018/11/14
     * @Param [equipUuid]
     * @Return com.ccicnavi.bims.resource.pojo.EquipHoldDO
     */
    @Override
    public EquipHoldDO getEquipHold(String equipUuid){
        return equipHoldDao.getEquipHold(equipUuid);
    }

    /**
     * @Author panyida
     * @Description 新增设备保管信息
     * @Date 16:26 2018/11/14
     * @Param [EquipHoldDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertEquipHold(EquipHoldDO EquipHoldDO){
        return equipHoldDao.insertEquipHold(EquipHoldDO);
    }

    /**
     * @Author panyida
     * @Description 更新设备保管信息
     * @Date 16:27 2018/11/14
     * @Param [EquipHoldDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateEquipHold(EquipHoldDO EquipHoldDO){
        return equipHoldDao.updateEquipHold(EquipHoldDO);
    }

    /**
     * @Author panyida
     * @Description 根据设备保管信息主键删除设备保管信息
     * @Date 16:27 2018/11/14
     * @Param [EquipHoldDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquipHold(EquipHoldDO EquipHoldDO){
        return equipHoldDao.deleteEquipHold(EquipHoldDO);
    }
}
