package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.EquipTestDO;
import com.ccicnavi.bims.resource.pojo.EquipTestDTO;
import org.n3r.eql.EqlTran;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备检定信息持久层接口
 * @author: panyida
 * @create: 2018-11-14 20:19
 **/
public interface EquipTestDao {
    /**
     * @Author panyida
     * @Description 设备检定信息查询
     * @Date 11:44 2018/11/14
     * @Param [equipTestDO]
     * @Return java.util.List<com.ccicnavi.bims.ource.pojo.EquipTestDO>
     */
    PageBean<EquipTestDO> listEquipTest(PageParameter<EquipTestDO> pageParameter);

    /**
     * @Author panyida
     * @Description 根据设备检定信息主键获取设备检定信息
     * @Date 11:45 2018/11/14
     * @Param [equipUuid]
     * @Return com.ccicnavi.bims.ource.pojo.EquipTestDO
     */
    EquipTestDO getEquipTest(EquipTestDO equipTestDO);

    /**
     * @Author MengZiJie
     * @Description 根据uuids获取设备信息
     * @Data 2018/11/23 18:18
     * @Param [equipTestDTO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipTestDO>
     */
    List<EquipTestDO> getEquipTestList(EquipTestDTO equipTestDTO);

    /**
     * @Author panyida
     * @Description 新增设备检定信息
     * @Date 11:45 2018/11/14
     * @Param [equipTestDO]
     * @Return java.lang.Integer
     */
    Integer insertEquipTest(EquipTestDO equipTestDO, EqlTran tran);

    /**
     * @Author panyida
     * @Description 更新设备检定信息
     * @Date 11:46 2018/11/14
     * @Param [equipTestDO]
     * @Return java.lang.Integer
     */
    Integer updateEquipTest(EquipTestDO equipTestDO,EqlTran tran);

    /**
     * @Author panyida
     * @Description 根据设备检定信息主键删除设备检定信息
     * @Date 11:46 2018/11/14
     * @Param [equipTestUuid]
     * @Return java.lang.Integer
     */
    Integer deleteEquipTest(EquipTestDTO equipTestDTO,EqlTran tran);

    /**
     * @Author panyida
     * @Description 设备检定查询（包含器具五要素字段）
     * @Date 11:44 2018/11/14
     * @Param [EquipTestDTO]
     * @Return java.util.List<com.ccicnavi.bims.ource.pojo.EquipTestDTO>
     */
    PageBean<EquipTestDTO> listEquipTestDTO(PageParameter<EquipTestDTO> pageParameter);

}
