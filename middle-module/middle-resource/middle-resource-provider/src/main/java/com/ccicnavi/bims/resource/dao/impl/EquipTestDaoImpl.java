package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.EquipTestDao;
import com.ccicnavi.bims.resource.pojo.EquipHoldDO;
import com.ccicnavi.bims.resource.pojo.EquipTestDO;
import com.ccicnavi.bims.resource.pojo.EquipTestDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
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
    public PageBean<EquipTestDO> listEquipTest(PageParameter<EquipTestDO> pageParameter){
        EqlPage eqlPage = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        List<EquipTestDO> listEquipTest = new Eql("druid").select("listEquipTest").params(pageParameter.getParameter()).returnType(EquipTestDO.class).limit(eqlPage).execute();
        return new PageBean<>(eqlPage.getTotalRows(),eqlPage.getTotalPages(),eqlPage.getCurrentPage(),eqlPage.getPageRows(),eqlPage.getStartIndex(),listEquipTest);
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

    /**
     * @Author panyida
     * @Description 设备检定查询（包含器具五要素字段）
     * @Date 16:28 2018/11/14
     * @Param [EquipTestDTO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipTestDTO>
     */
    @Override
    public PageBean<EquipTestDTO> listEquipTestDTO(PageParameter<EquipTestDTO> pageParameter){
        EqlPage eqlPage = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        List<EquipTestDTO> listEquipTestDTO = new Eql("druid").select("listEquipTestDTO").params(pageParameter.getParameter()).returnType(EquipTestDTO.class).limit(eqlPage).execute();
        return new PageBean<>(eqlPage.getTotalRows(),eqlPage.getTotalPages(),eqlPage.getCurrentPage(),eqlPage.getPageRows(),eqlPage.getStartIndex(),listEquipTestDTO);
    }
}
