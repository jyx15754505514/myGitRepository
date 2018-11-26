package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.EquipTestService;
import com.ccicnavi.bims.resource.dao.EquipTestDao;
import com.ccicnavi.bims.resource.pojo.EquipTestDO;
import com.ccicnavi.bims.resource.pojo.EquipTestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备检定信息api接口实现类
 * @author: panyida
 * @create: 2018-11-14 20:13
 **/
@Slf4j
@Service
public class EquipTestServiceImpl implements EquipTestService {

    @Autowired
    EquipTestDao equipTestDao;
    @Reference(timeout = 3000)
    IdWorkerService idWorkerService;
    /**
     * @Author panyida
     * @Description 根据设备检定信息主键获取设备检定信息
     * @Date 16:29 2018/11/14
     * @Param [equipTestUuid]
     * @Return com.ccicnavi.bims.resource.pojo.EquipTestDO
     */
    @Override
    public EquipTestDO getEquipTest(EquipTestDO equipTestDO){
        EquipTestDO equipTest = null;
        try {
            equipTest = equipTestDao.getEquipTest(equipTestDO);
        } catch (Exception e) {
            log.error("根据设备检定信息主键获取设备检定信息错误",e);
        }
        return equipTest;
    }

    /**
     * @Author MengZiJie
     * @Description 根据uuids查询设备信息
     * @Data 2018/11/23 18:23
     * @Param [equipTestDTO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipTestDO>
     */
    @Override
    public List<EquipTestDO> getEquipTestList(EquipTestDTO equipTestDTO) {
        List<EquipTestDO> equipTest = null;
        try {
            equipTest = equipTestDao.getEquipTestList(equipTestDTO);
            return null;
        } catch (Exception e) {
            log.error("获取设备检定信息失败",e);
        }
        return equipTest;
    }

    /**
     * @Author panyida
     * @Description 设备检定信息查询
     * @Date 16:28 2018/11/14
     * @Param [equipTestDO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipTestDO>
     */
    @Override
    public PageBean<EquipTestDO> listEquipTest(PageParameter<EquipTestDO> pageParameter){
        PageBean<EquipTestDO> listEquipTestDO = null;
        try {
            listEquipTestDO = equipTestDao.listEquipTest(pageParameter);
        } catch (Exception e) {
            log.error("设备检定信息查询错误",e);
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
        Integer count = 0;
        try {
            String equipTestUuid  = idWorkerService.getId(new Date());
            equipTestDO.setEquipTestUuid(equipTestUuid);
            count = equipTestDao.insertEquipTest(equipTestDO,null);
        } catch (Exception e) {
            log.error("新增设备检定信息错误",e);
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
        Integer count = 0;
        try {
            count = equipTestDao.updateEquipTest(equipTestDO,null);
        } catch (Exception e) {
            log.error("更新设备检定信息错误",e);
        }
        return count;
    }

    /**
     * @Author panyida
     * @Description 根据设备检定信息主键删除设备检定信息
     * @Date 16:30 2018/11/14
     * @Param [equipTestUuid]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquipTest(EquipTestDTO equipTestDTO){
        Integer count = 0;
        try {
            count = equipTestDao.deleteEquipTest(equipTestDTO,null);
        } catch (Exception e) {
            log.error("根据设备检定信息主键删除设备检定信息错误",e);
        }
        return count;
    }

    /**
     * @Author panyida
     * @Description 设备检定查询（包含器具五要素字段）
     * @Date 16:28 2018/11/14
     * @Param [EquipTestDTO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipTestDTO>
     */
    @Override
    public PageBean<EquipTestDTO> listEquipTestDTO(PageParameter<EquipTestDTO> pageParameter){
        PageBean<EquipTestDTO> listEquipTestDTO = null;
        try {
            listEquipTestDTO = equipTestDao.listEquipTestDTO(pageParameter);
        } catch (Exception e) {
            log.error("设备检定查询（包含器具五要素字段）错误",e);
        }
        return listEquipTestDTO;
    }
}
