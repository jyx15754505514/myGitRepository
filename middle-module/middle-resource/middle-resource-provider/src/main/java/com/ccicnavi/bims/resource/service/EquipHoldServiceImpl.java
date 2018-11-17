package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.EquipHoldService;
import com.ccicnavi.bims.resource.dao.EquipHoldDao;
import com.ccicnavi.bims.resource.pojo.EquipHoldDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @program: bims-backend
 * @description: 设备保管信息api实现类
 * @author: panyida
 * @create: 2018-11-14 17:29
 **/
@Slf4j
@Service
public class EquipHoldServiceImpl implements EquipHoldService {
    
    @Autowired
    EquipHoldDao equipHoldDao;

    /**
     * @Author panyida
     * @Description 根据设备保管信息主键获取设备保管信息
     * @Date 16:29 2018/11/14
     * @Param [equipHoldUuid]
     * @Return com.ccicnavi.bims.resource.pojo.EquipHoldDO
     */
    @Override
    public EquipHoldDO getEquipHold(String equipHoldUuid){
        EquipHoldDO equipHoldDO = null;
        try {
            equipHoldDO = equipHoldDao.getEquipHold(equipHoldUuid);
        } catch (Exception e) {
            log.error("根据设备保管信息主键获取设备保管信息错误",e);
        }
        return equipHoldDO;
    }

    /**
     * @Author panyida
     * @Description 设备保管信息查询
     * @Date 16:28 2018/11/14
     * @Param [equipHoldDO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipHoldDO>
     */
    @Override
    public PageBean<EquipHoldDO> listEquipHold(PageParameter<EquipHoldDO> pageParameter){
        PageBean<EquipHoldDO> listEquipHoldDO = null;
        try {
            listEquipHoldDO = equipHoldDao.listEquipHold(pageParameter);
        } catch (Exception e) {
            log.error("设备保管信息查询错误",e);
        }
        return listEquipHoldDO;
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
        Integer count = null;
        try {
            count = equipHoldDao.insertEquipHold(equipHoldDO);
        } catch (Exception e) {
            log.error("新增设备保管信息错误",e);
        }
        return count;
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
        Integer count = null;
        try {
            count = equipHoldDao.updateEquipHold(equipHoldDO);
        } catch (Exception e) {
            log.error("更新设备保管信息错误",e);
        }
        return count;
    }

    /**
     * @Author panyida
     * @Description 根据设备保管信息主键删除设备保管信息
     * @Date 16:30 2018/11/14
     * @Param [equipHoldDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquipHold(String equipHoldUuid){
        Integer count = null;
        try {
            count = equipHoldDao.deleteEquipHold(equipHoldUuid);
        } catch (Exception e) {
            log.error("根据设备保管信息主键删除设备保管信息错误",e);
        }
        return count;
    }
}
