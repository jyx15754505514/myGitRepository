package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.EquipTestDao;
import com.ccicnavi.bims.resource.pojo.EquipTestDO;
import com.ccicnavi.bims.resource.pojo.EquipTestDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
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
    public EquipTestDO getEquipTest(EquipTestDO equipTestDO){
        return new Eql().selectFirst("getEquipTest").params(equipTestDO).returnType(EquipTestDO.class).execute();
    }

    /**
     * @Author MengZiJie
     * @Description 根据uuids查询设备信息
     * @Data 2018/11/23 19:50
     * @Param [equipTestDTO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipTestDO>
     */
    @Override
    public List<EquipTestDO> getEquipTestList(EquipTestDTO equipTestDTO) {
        return new Eql().select("getEquipTestList").params(equipTestDTO).returnType(EquipTestDO.class).execute();
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
        List<EquipTestDO> listEquipTest = new Eql().select("listEquipTest").params(pageParameter.getParameter()).returnType(EquipTestDO.class).limit(eqlPage).execute();
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
    public Integer insertEquipTest(EquipTestDO equipTestDO, EqlTran tran){
        if(tran != null){
            return new Eql().useTran(tran).insert("insertEquipTest").params(equipTestDO).returnType(Integer.class).execute();
        }
        return new Eql().insert("insertEquipTest").params(equipTestDO).returnType(Integer.class).execute();
    }

    /**
     * @Author panyida
     * @Description 更新设备检定信息
     * @Date 16:30 2018/11/14
     * @Param [equipTestDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateEquipTest(EquipTestDO equipTestDO, EqlTran tran){
        if(tran != null){
            return new Eql().useTran(tran).update("updateEquipTest").params(equipTestDO).returnType(Integer.class).execute();
        }
        return new Eql().update("updateEquipTest").params(equipTestDO).returnType(Integer.class).execute();
    }

    /**
     * @Author panyida
     * @Description 根据设备检定信息主键删除设备检定信息
     * @Date 16:30 2018/11/14
     * @Param [equipTestDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquipTest(EquipTestDTO equipTestDTO, EqlTran tran){
        if(tran != null){
            return new Eql().useTran(tran).delete("deleteEquipTest").params(equipTestDTO).returnType(Integer.class).execute();
        }
        return new Eql().delete("deleteEquipTest").params(equipTestDTO).returnType(Integer.class).execute();
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
        List<EquipTestDTO> listEquipTestDTO = new Eql().select("listEquipTestDTO").params(pageParameter.getParameter()).returnType(EquipTestDTO.class).limit(eqlPage).execute();
        return new PageBean<>(eqlPage.getTotalRows(),eqlPage.getTotalPages(),eqlPage.getCurrentPage(),eqlPage.getPageRows(),eqlPage.getStartIndex(),listEquipTestDTO);
    }
}
