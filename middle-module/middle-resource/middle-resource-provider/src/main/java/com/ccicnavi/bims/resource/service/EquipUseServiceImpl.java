package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.EquipUseService;
import com.ccicnavi.bims.resource.dao.EquipUseDao;
import com.ccicnavi.bims.resource.pojo.EquipTestDTO;
import com.ccicnavi.bims.resource.pojo.EquipUseDO;
import com.ccicnavi.bims.resource.pojo.EquipUseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
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

    @Reference(url = "dubbo://127.0.0.1:20880",timeout = 1000)
    IdWorkerService idWorkerService;
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
            log.error("根据设备领用归还信息主键获取设备领用归还信息错误",e);
        }
        return equipUseDO;
    }

    /**
     * @Author MengZiJie
     * @Description 根据uuids查询设备领用信息
     * @Data 2018/11/23 17:30
     * @Param [equipUseDTO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipUseDTO>
     */
    @Override
    public List<EquipUseDO> getEquipUseList(EquipUseDTO equipUseDTO) {
        List<EquipUseDO> equipUseDO = null;
        try {
            equipUseDO = equipUseDao.getEquipUseList(equipUseDTO);
        } catch (Exception e) {
            log.error("获取领用信息失败",e);
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
    public PageBean<EquipUseDO> listEquipUse(PageParameter<EquipUseDO> pageParameter){
        PageBean<EquipUseDO> listEquipUseDO = null;
        try {
            listEquipUseDO = equipUseDao.listEquipUse(pageParameter);
        } catch (Exception e) {
            log.error("设备领用归还信息查询错误",e);
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
            String equipUseUuid = idWorkerService.getId(new Date());
            equipUseDO.setEquipUseUuid(equipUseUuid);
            count = equipUseDao.insertEquipUse(equipUseDO,null);
        } catch (Exception e) {
            log.error("新增设备领用归还信息错误",e);
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
            count = equipUseDao.updateEquipUse(equipUseDO,null);
        } catch (Exception e) {
            log.error("更新设备领用归还信息错误",e);
        }
        return count;
    }

    /**
     * @Author panyida
     * @Description
     * @Date 16:30 2018/11/14根据设备领用归还信息主键删除设备领用归还信息
     * @Param [equipUseUuid]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquipUse(EquipUseDTO equipUseDTO){
        Integer count = null;
        try {
            count = equipUseDao.deleteEquipUse(equipUseDTO,null);
        } catch (Exception e) {
            log.error("根据设备领用归还信息主键删除设备领用归还信息错误",e);
        }
        return count;
    }

    /**
     * @Author panyida
     * @Description 设备领用归还信息查询（包含器具五要素字段）
     * @Date 16:28 2018/11/14
     * @Param [EquipTestDTO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipTestDTO>
     */
    @Override
    public PageBean<EquipUseDTO> listEquipUseDTO(PageParameter<EquipUseDTO> pageParameter){
        PageBean<EquipUseDTO> listEquipUseDTO = null;
        try {
            listEquipUseDTO = equipUseDao.listEquipUseDTO(pageParameter);
        } catch (Exception e) {
            log.error("设备领用归还信息查询（包含器具五要素字段）错误",e);
        }
        return listEquipUseDTO;
    }
}
