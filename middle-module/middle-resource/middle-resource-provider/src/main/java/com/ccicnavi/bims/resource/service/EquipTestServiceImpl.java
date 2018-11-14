package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.api.EquipTestService;
import com.ccicnavi.bims.resource.dao.EquipTestDao;
import com.ccicnavi.bims.resource.pojo.EquipTestDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备检定信息api接口实现类
 * @author: panyida
 * @create: 2018-11-14 20:13
 **/
@Service
public class EquipTestServiceImpl implements EquipTestService {

    @Autowired
    EquipTestDao equipTestDao;

    /**
     * @Author panyida
     * @Description 设备检定信息查询
     * @Date 16:12 2018/11/14
     * @Param [EquipTestDO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipTestDO>
     */
    @Override
    public List<EquipTestDO> listEquipTest(EquipTestDO equipHoldDO){
        return equipTestDao.listEquipTest(equipHoldDO);
    }

    /**
     * @Author panyida
     * @Description 根据设备检定信息主键获取设备信息
     * @Date 16:26 2018/11/14
     * @Param [equipUuid]
     * @Return com.ccicnavi.bims.resource.pojo.EquipTestDO
     */
    @Override
    public EquipTestDO getEquipTest(String equipUuid){
        return equipTestDao.getEquipTest(equipUuid);
    }

    /**
     * @Author panyida
     * @Description 新增设备检定信息
     * @Date 16:26 2018/11/14
     * @Param [EquipTestDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertEquipTest(EquipTestDO EquipTestDO){
        return equipTestDao.insertEquipTest(EquipTestDO);
    }

    /**
     * @Author panyida
     * @Description 更新设备检定信息
     * @Date 16:27 2018/11/14
     * @Param [EquipTestDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateEquipTest(EquipTestDO EquipTestDO){
        return equipTestDao.updateEquipTest(EquipTestDO);
    }

    /**
     * @Author panyida
     * @Description 根据设备检定信息主键删除设备信息
     * @Date 16:27 2018/11/14
     * @Param [EquipTestDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquipTest(EquipTestDO EquipTestDO){
        return equipTestDao.deleteEquipTest(EquipTestDO);
    }
}
