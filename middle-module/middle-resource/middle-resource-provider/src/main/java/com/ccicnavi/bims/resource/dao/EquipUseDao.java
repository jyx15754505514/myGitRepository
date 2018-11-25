package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.EquipUseDO;
import com.ccicnavi.bims.resource.pojo.EquipUseDTO;
import org.n3r.eql.EqlTran;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备领用归还信息持久层接口
 * @author: panyida
 * @create: 2018-11-14 20:19
 **/
public interface EquipUseDao {
    /**
     * @Author panyida
     * @Description 设备领用归还信息查询
     * @Date 11:44 2018/11/14
     * @Param [equipUseDO]
     * @Return java.util.List<com.ccicnavi.bims.ource.pojo.EquipUseDO>
     */
    PageBean<EquipUseDO> listEquipUse(PageParameter<EquipUseDO> pageParameter);

    /**
     * @Author panyida
     * @Description 根据设备领用归还信息主键获取设备领用归还信息
     * @Date 11:45 2018/11/14
     * @Param [equipUuid]
     * @Return com.ccicnavi.bims.ource.pojo.EquipUseDO
     */
    EquipUseDO getEquipUse(EquipUseDO equipUseDO);

    /**
     * @Author MengZiJie
     * @Description 根据uuids查询设备领用信息
     * @Data 2018/11/23 17:32
     * @Param [equipUseDTO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipUseDTO>
     */
    List<EquipUseDO> getEquipUseList(EquipUseDTO equipUseDTO);

    /**
     * @Author panyida
     * @Description 新增设备领用归还信息
     * @Date 11:45 2018/11/14
     * @Param [equipUseDO]
     * @Return java.lang.Integer
     */
    Integer insertEquipUse(EquipUseDO equipUseDO,EqlTran tran);

    /**
     * @Author panyida
     * @Description 更新设备领用归还信息
     * @Date 11:46 2018/11/14
     * @Param [equipUseDO]
     * @Return java.lang.Integer
     */
    Integer updateEquipUse(EquipUseDO equipUseDO,EqlTran tran);

    /**
     * @Author panyida
     * @Description 根据设备领用归还信息主键删除设备领用归还信息
     * @Date 11:46 2018/11/14
     * @Param [equipUseUuid]
     * @Return java.lang.Integer
     */
    Integer deleteEquipUse(EquipUseDTO equipUseDTO,EqlTran tran);

    /**
     * @Author panyida
     * @Description 设备领用归还信息查询（包含器具五要素字段）
     * @Date 11:44 2018/11/14
     * @Param [EquipUseDTO]
     * @Return java.util.List<com.ccicnavi.bims.ource.pojo.EquipUseDTO>
     */
    PageBean<EquipUseDTO> listEquipUseDTO(PageParameter<EquipUseDTO> pageParameter);
}
