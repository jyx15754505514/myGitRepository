package com.ccicnavi.bims.resource.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.EquipUseDO;
import com.ccicnavi.bims.resource.pojo.EquipUseDTO;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备领用归还信息api接口
 * @author: panyida
 * @create: 2018-11-14 11:30
 **/
public interface EquipUseService {

    /**
     * @Author panyida
     * @Description 设备领用归还查询
     * @Date 11:44 2018/11/14
     * @Param [equipUseDO]
     * @Return java.util.List<com.ccicnavi.bims.ource.pojo.EquipUseDO>
     */
    PageBean<EquipUseDO> listEquipUse(PageParameter<EquipUseDO> pageParameter);

    /**
     * @Author panyida
     * @Description 根据设备主键获取设备领用归还
     * @Date 11:45 2018/11/14
     * @Param [equipUseUuid]
     * @Return com.ccicnavi.bims.ource.pojo.EquipUseDO
     */
    EquipUseDO getEquipUse(EquipUseDO equipUseDO);

    /**
     * @Author MengZiJie
     * @Description 根据uuids获取领用信息
     * @Data 2018/11/23 17:16
     * @Param [equipUseDTO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipUseDTO>
     */
    List<EquipUseDO> getEquipUseList(EquipUseDTO equipUseDTO);

    /**
     * @Author panyida
     * @Description 新增设备领用归还
     * @Date 11:45 2018/11/14
     * @Param [equipUseDO]
     * @Return java.lang.Integer
     */
    Integer insertEquipUse(EquipUseDO equipUseDO);

    /**
     * @Author panyida
     * @Description 更新设备领用归还
     * @Date 11:46 2018/11/14
     * @Param [equipUseDO]
     * @Return java.lang.Integer
     */
    Integer updateEquipUse(EquipUseDO equipUseDO);

    /**
     * @Author panyida
     * @Description 根据设备领用归还主键删除设备领用归还
     * @Date 11:46 2018/11/14
     * @Param [equipUseUuid]
     * @Return java.lang.Integer
     */
    Integer deleteEquipUse(EquipUseDTO equipUseDTO);

    /**
     * @Author panyida
     * @Description 设备领用归还查询（包含器具五要素字段）
     * @Date 11:44 2018/11/14
     * @Param [EquipUseDTO]
     * @Return java.util.List<com.ccicnavi.bims.ource.pojo.EquipUseDTO>
     */
    PageBean<EquipUseDTO> listEquipUseDTO(PageParameter<EquipUseDTO> pageParameter);
}
