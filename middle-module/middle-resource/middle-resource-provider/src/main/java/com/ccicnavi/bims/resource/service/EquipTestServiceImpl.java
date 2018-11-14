package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.api.EquipTestService;
import com.ccicnavi.bims.resource.dao.EquipTestDao;
import com.ccicnavi.bims.resource.pojo.EquipTestDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

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

    /**
     * @Author panyida
     * @Description 根据设备检定信息主键获取设备检定信息
     * @Date 16:29 2018/11/14
     * @Param [equipTestUuid]
     * @Return com.ccicnavi.bims.resource.pojo.EquipTestDO
     */
    @Override
    public EquipTestDO getEquipTest(String equipTestUuid){
        EquipTestDO equipTestDO = null;
        try {
            equipTestDO = equipTestDao.getEquipTest(equipTestUuid);
        } catch (Exception e) {
            log.debug("根据设备检定信息主键获取设备检定信息错误",e);
            e.printStackTrace();
        }
        return equipTestDO;
    }

    /**
     * @Author panyida
     * @Description 设备检定信息查询
     * @Date 16:28 2018/11/14
     * @Param [equipTestDO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipTestDO>
     */
    @Override
    public List<EquipTestDO> listEquipTest(EquipTestDO equipTestDO){
        List<EquipTestDO> listEquipTestDO = null;
        try {
            listEquipTestDO = equipTestDao.listEquipTest(equipTestDO);
        } catch (Exception e) {
            log.debug("设备检定信息查询错误",e);
            e.printStackTrace();
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
        Integer count = null;
        try {
            count = equipTestDao.insertEquipTest(equipTestDO);
        } catch (Exception e) {
            log.debug("新增设备检定信息错误",e);
            e.printStackTrace();
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
        Integer count = null;
        try {
            count = equipTestDao.updateEquipTest(equipTestDO);
        } catch (Exception e) {
            log.debug("更新设备检定信息错误",e);
            e.printStackTrace();
        }
        return count;
    }

    /**
     * @Author panyida
     * @Description 根据设备检定信息主键删除设备检定信息
     * @Date 16:30 2018/11/14
     * @Param [equipTestDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquipTest(EquipTestDO equipTestDO){
        Integer count = null;
        try {
            count = equipTestDao.deleteEquipTest(equipTestDO);
        } catch (Exception e) {
            log.debug("根据设备检定信息主键删除设备检定信息错误",e);
            e.printStackTrace();
        }
        return count;
    }
}
