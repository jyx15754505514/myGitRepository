package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.resource.dao.EquipTestDao;
import com.ccicnavi.bims.resource.pojo.EquipTestDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备检定信息持久层接口实现类
 * @author: panyida
 * @create: 2018-11-14 20:21
 **/
@Service
public class EquipTestDaoImpl implements EquipTestDao {
    /**
     * @Author panyida
     * @Description 根据设备检定信息主键获取设备检定信息
     * @Date 16:29 2018/11/14
     * @Param [equipTestUuid]
     * @Return com.ccicnavi.bims.resource.pojo.EquipTestDO
     */
    @Override
    public EquipTestDO getEquipTest(String equipTestUuid){
        return EqlUtils.getInstance("druid").selectFirst("getEquipTest").params(equipTestUuid).returnType(EquipTestDO.class).execute();
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
        return EqlUtils.getInstance("druid").select("listEquipTest").params(equipTestDO).returnType(EquipTestDO.class).execute();
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
        return EqlUtils.getInstance("druid").insert("insertEquipTest").params(equipTestDO).returnType(Integer.class).execute();
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
        return EqlUtils.getInstance("druid").update("updateEquipTest").params(equipTestDO).returnType(Integer.class).execute();
    }

    /**
     * @Author panyida
     * @Description 根据设备检定信息主键删除设备检定信息
     * @Date 16:30 2018/11/14
     * @Param [equipTestDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquipTest(String equipTestUuid){
        return EqlUtils.getInstance("druid").delete("deleteEquipTest").params(equipTestUuid).returnType(Integer.class).execute();
    }
}
