package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.EquipUseDao;
import com.ccicnavi.bims.resource.pojo.EquipUseDO;
import com.ccicnavi.bims.resource.pojo.EquipUseDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @program: bims-backend
 * @description: 设备领用归还信息持久层接口实现类
 * @author: panyida
 * @create: 2018-11-14 20:21
 **/
@Service
public class EquipUseDaoImpl implements EquipUseDao {
    /**
     * @Author panyida
     * @Description 根据设备领用归还信息主键获取设备领用归还信息
     * @Date 16:29 2018/11/14
     * @Param [equipUseUuid]
     * @Return com.ccicnavi.bims.resource.pojo.EquipUseDO
     */
    @Override
    public EquipUseDO getEquipUse(EquipUseDO equipUseDO){
        return new Eql().selectFirst("getEquipUse").params(equipUseDO).returnType(EquipUseDO.class).execute();
    }

    /**
     * @Author MengZiJie
     * @Description 根据uuids查询设备领用信息
     * @Data 2018/11/23 17:33
     * @Param [equipUseDTO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipUseDTO>
     */
    @Override
    public List<EquipUseDO> getEquipUseList(EquipUseDTO equipUseDTO) {
        return new Eql().select("getEquipUseList").params(equipUseDTO).returnType(EquipUseDO.class).execute();
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
        EqlPage eqlPage = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        List<EquipUseDO> listEquipUse = new Eql().select("listEquipUse").params(pageParameter.getParameter()).returnType(EquipUseDO.class).limit(eqlPage).execute();
        return new PageBean<>(eqlPage.getTotalRows(),eqlPage.getTotalPages(),eqlPage.getCurrentPage(),eqlPage.getPageRows(),eqlPage.getStartIndex(),listEquipUse);
    }

    /**
     * @Author panyida
     * @Description 新增设备领用归还信息
     * @Date 16:29 2018/11/14
     * @Param [equipUseDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertEquipUse(EquipUseDO equipUseDO, EqlTran tran){
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).insert("insertEquipUse").params(equipUseDO).returnType(Integer.class).execute();
        }
        return eql.insert("insertEquipUse").params(equipUseDO).returnType(Integer.class).execute();
    }

    /**
     * @Author panyida
     * @Description 更新设备领用归还信息
     * @Date 16:30 2018/11/14
     * @Param [equipUseDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateEquipUse(EquipUseDO equipUseDO, EqlTran tran){
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("updateEquipUse").params(equipUseDO).returnType(Integer.class).execute();
        }
        return eql.update("updateEquipUse").params(equipUseDO).returnType(Integer.class).execute();
    }

    /**
     * @Author panyida
     * @Description 根据设备领用归还信息主键删除设备领用归还信息
     * @Date 16:30 2018/11/14
     * @Param [equipUseUuid]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquipUse(EquipUseDTO equipUseDTO, EqlTran tran){
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).delete("deleteEquipUse").params(equipUseDTO).returnType(Integer.class).execute();
        }
        return eql.delete("deleteEquipUse").params(equipUseDTO).returnType(Integer.class).execute();
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
        EqlPage eqlPage = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        List<EquipUseDTO> listEquipUseDTO = new Eql().select("listEquipUseDTO").params(pageParameter.getParameter()).returnType(EquipUseDTO.class).limit(eqlPage).execute();
        return new PageBean<>(eqlPage.getTotalRows(),eqlPage.getTotalPages(),eqlPage.getCurrentPage(),eqlPage.getPageRows(),eqlPage.getStartIndex(),listEquipUseDTO);
    }
}
