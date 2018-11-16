package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.EquipTestService;
import com.ccicnavi.bims.resource.dao.EquipTestDao;
import com.ccicnavi.bims.resource.pojo.EquipTestDO;
import com.ccicnavi.bims.resource.pojo.EquipTestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


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
            log.error("根据设备检定信息主键获取设备检定信息错误",e);
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
        Integer count = null;
        try {
            count = equipTestDao.insertEquipTest(equipTestDO);
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
        Integer count = null;
        try {
            count = equipTestDao.updateEquipTest(equipTestDO);
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
    public Integer deleteEquipTest(String equipTestUuid){
        Integer count = null;
        try {
            count = equipTestDao.deleteEquipTest(equipTestUuid);
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
