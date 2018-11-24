package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.EquipDao;
import com.ccicnavi.bims.resource.pojo.EquipDO;
import com.ccicnavi.bims.resource.pojo.EquipDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备信息持久层实现类
 * @author: panyida
 * @create: 2018-11-14 16:00
 **/
@Service
public class EquipDaoImpl implements EquipDao {

    /**
     * @Author panyida
     * @Description 根据设备信息主键获取设备信息
     * @Date 16:29 2018/11/14
     * @Param [equipUuid]
     * @Return com.ccicnavi.bims.resource.pojo.EquipDO
     */
    @Override
    public EquipDTO getEquip(EquipDTO equipDTO){
        return new Eql().selectFirst("getEquip").params(equipDTO).returnType(EquipDTO.class).execute();
    }

    /**
     * @Author MengZiJie
     * @Description 根据uuids 查询设备信息
     * @Data 2018/11/23 15:57
     * @Param [equipDTO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipDO>
     */
    @Override
    public List<EquipDTO> getEquipList(EquipDTO equipDTO) {
        return new Eql().select("getEquipList").params(equipDTO).returnType(EquipDTO.class).execute();
    }


    /**
     * @Author panyida
     * @Description 设备信息查询
     * @Date 16:28 2018/11/14
     * @Param [equipDO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipDO>
     */
    @Override
    public PageBean<EquipDO> listEquip(PageParameter<EquipDTO> pageParameter){
        EqlPage eqlPage = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        List<EquipDO> listEquip = new Eql().select("listEquip").params(pageParameter.getParameter()).returnType(EquipDO.class).limit(eqlPage).execute();
        return new PageBean<>(eqlPage.getTotalRows(),eqlPage.getTotalPages(),eqlPage.getCurrentPage(),eqlPage.getPageRows(),eqlPage.getStartIndex(),listEquip);
    }

    /**
     * @Author panyida
     * @Description 新增设备信息
     * @Date 16:29 2018/11/14
     * @Param [equipDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertEquip(EquipDO equipDO,EqlTran tran){
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).insert("insertEquip").params(equipDO).returnType(Integer.class).execute();
        }
        return eql.insert("insertEquip").params(equipDO).returnType(Integer.class).execute();
    }

    /**
     * @Author panyida
     * @Description 更新设备信息
     * @Date 16:30 2018/11/14
     * @Param [equipDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateEquip(EquipDO equipDO,EqlTran tran){
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("updateEquip").params(equipDO).returnType(Integer.class).execute();
        }
        return eql.update("updateEquip").params(equipDO).returnType(Integer.class).execute();
    }

    /**
     * @Author panyida
     * @Description 根据设备信息主键删除设备信息
     * @Date 16:30 2018/11/14
     * @Param [equipDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquip(EquipDTO equipDTO, EqlTran tran){
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).delete("deleteEquip").params(equipDTO).returnType(Integer.class).execute();
        }
        return eql.delete("deleteEquip").params(equipDTO).returnType(Integer.class).execute();
    }

}
