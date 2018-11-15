package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.api.EquipUseService;
import com.ccicnavi.bims.resource.dao.EquipUseDao;
import com.ccicnavi.bims.resource.pojo.EquipUseDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备领用归还信息api接口实现类
 * @author: panyida
 * @create: 2018-11-14 20:13
 **/
@Slf4j
@Service
public class EquipUseServiceImpl implements EquipUseService {

    @Autowired
    EquipUseDao equipUseDao;

    /**
     * @Author panyida
     * @Description 根据设备领用归还信息主键获取设备领用归还信息
     * @Date 16:29 2018/11/14
     * @Param [equipUseUuid]
     * @Return com.ccicnavi.bims.resource.pojo.EquipUseDO
     */
    @Override
    public EquipUseDO getEquipUse(String equipUseUuid){
        EquipUseDO equipUseDO = null;
        try {
            equipUseDO = equipUseDao.getEquipUse(equipUseUuid);
        } catch (Exception e) {
            log.debug("根据设备领用归还信息主键获取设备领用归还信息错误",e);
            e.printStackTrace();
        }
        return equipUseDO;
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
        List<EquipUseDO> listEquipUseDO = null;
        try {
            listEquipUseDO = equipUseDao.listEquipUse(equipUseDO);
        } catch (Exception e) {
            log.debug("设备领用归还信息查询错误",e);
            e.printStackTrace();
        }
        return listEquipUseDO;
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
        Integer count = null;
        try {
            count = equipUseDao.insertEquipUse(equipUseDO);
        } catch (Exception e) {
            log.debug("新增设备领用归还信息错误",e);
            e.printStackTrace();
        }
        return count;
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
        Integer count = null;
        try {
            count = equipUseDao.updateEquipUse(equipUseDO);
        } catch (Exception e) {
            log.debug("更新设备领用归还信息错误",e);
            e.printStackTrace();
        }
        return count;
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
        Integer count = null;
        try {
            count = equipUseDao.deleteEquipUse(equipUseUuid);
        } catch (Exception e) {
            log.debug("根据设备领用归还信息主键删除设备领用归还信息错误",e);
            e.printStackTrace();
        }
        return count;
    }
}
