package com.ccicnavi.bims.resource.service;

import com.ccicnavi.bims.resource.api.EquipService;
import com.ccicnavi.bims.resource.dao.EquipDao;
import com.ccicnavi.bims.resource.pojo.EquipDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备信息api接口实现类
 * @author: panyida
 * @create: 2018-11-14 16:10
 **/
@Service
public class EquipServiceImpl implements EquipService {

    @Autowired
    private EquipDao equipDao;
    
    /**
     * @Author panyida 
     * @Description 设备信息查询
     * @Date 16:12 2018/11/14
     * @Param [equipDO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipDO>
     */
    @Override
    public List<EquipDO> listEquip(EquipDO equipDO){
        return equipDao.listEquip(equipDO);
    }

    /**
     * @Author panyida
     * @Description 根据设备信息主键获取设备信息
     * @Date 16:26 2018/11/14
     * @Param [equipUuid]
     * @Return com.ccicnavi.bims.resource.pojo.EquipDO
     */
    @Override
    public EquipDO getEquip(String equipUuid) {
        return equipDao.getEquip(equipUuid);
    }

    /**
     * @Author panyida
     * @Description 新增设备信息
     * @Date 16:26 2018/11/14
     * @Param [equipDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertEquip(EquipDO equipDO) {
        return equipDao.insertEquip(equipDO);
    }

    /**
     * @Author panyida
     * @Description 更新设备信息
     * @Date 16:27 2018/11/14
     * @Param [equipDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateEquip(EquipDO equipDO) {
        return equipDao.updateEquip(equipDO);
    }

    /**
     * @Author panyida
     * @Description 根据设备信息主键删除设备信息
     * @Date 16:27 2018/11/14
     * @Param [equipDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquip(EquipDO equipDO) {
        return equipDao.deleteEquip(equipDO);
    }
}
