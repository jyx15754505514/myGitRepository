package com.ccicnavi.bims.resource.service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.impl.EquipUseDaoImpl;
import com.ccicnavi.bims.resource.pojo.EquipUseDO;
import com.ccicnavi.bims.resource.pojo.EquipUseDTO;
import org.junit.Test;
import java.util.List;

/**
 * @Author songyateng
 * @Description 测试设备领用归还信息
 * @Date $time$ $date$
 * @Param $param$
 * @Return $return$
 */
public class TestEquipUse {
    EquipUseDaoImpl equipUseDaoImpl = new EquipUseDaoImpl();
    /**
      * @author songyateng
      * @description 主键获取设备领用归还信息
      * @date 2018/11/23 18:19
      */
    @Test
    public void getEquipUseTest(){
        try {
        EquipUseDO equipUseDO = equipUseDaoImpl.getEquipUse("zhujian");
            System.out.println(equipUseDO);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
      * @author songyateng
      * @description 根据uuids查询设备领用信息
      * @date 2018/11/23 19:59
      */
    @Test
    public void getEquipUseList(){
        try {
            EquipUseDTO equipUseDTO = new EquipUseDTO();
            equipUseDTO.setAppSysUuid("zhujian");
            List<EquipUseDO> aaa = equipUseDaoImpl.getEquipUseList(equipUseDTO);
            System.out.println(aaa);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
      * @author songyateng
      * @description 设备领用归还信息查询
      * @date 2018/11/23 20:00
      */
    @Test
    public void listEquipUse(){
        try {
            PageParameter<EquipUseDO> pageParameter = new PageParameter();
            EquipUseDO equipUseDO = new EquipUseDO();
            pageParameter.setStartIndex(1);
            pageParameter.setPageRows(1);
            pageParameter.setStartPage(1);
            PageBean<EquipUseDO> equipUseDOPageBean = equipUseDaoImpl.listEquipUse(pageParameter);
            System.out.println(equipUseDOPageBean);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
      * @author songyateng
      * @description 
      * @date 2018/11/23 20:16
      */
    @Test
    public void insertEquipUse(){
        try {
            EquipUseDO equipUseDO = new EquipUseDO();
            equipUseDO.setEquipUseUuid("zhujian1");
            equipUseDO.setEquipUuid("qiju");
            equipUseDO.setIsDeleted("N");
            equipUseDO.setProdCatalogUuid("123");
            equipUseDO.setOrgUuid("guishujigouid");
            equipUseDO.setAppSysUuid("yingyongxitongid");
            System.err.print(equipUseDaoImpl.insertEquipUse(equipUseDO, null));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    /**
      * @author songyateng
      * @description 
      * @date 2018/11/23 20:25
      */
    @Test
    public void updateEquipUse(){
        try {
            EquipUseDO equipUseDO = new EquipUseDO();
            equipUseDO.setEquipUseUuid("zhujian1");
            equipUseDO.setEquipUuid("t");
            equipUseDO.setIsDeleted("N");
            equipUseDO.setProdCatalogUuid("t");
            equipUseDO.setOrgUuid("t");
            equipUseDO.setAppSysUuid("t");
            System.err.print(equipUseDaoImpl.updateEquipUse(equipUseDO, null));
        }  catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
      * @author songyateng
      * @description 根据设备领用归还信息主键删除设备领用归还信息
      * @date 2018/11/23 22:28
      */
    @Test
    public void deleteEquipUse(){
        try{
            EquipUseDTO equipUseDTO = new EquipUseDTO();
            equipUseDTO.setEquipUseUuid("zhujian1");
            System.err.print(equipUseDaoImpl.deleteEquipUse(equipUseDTO, null));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
      * @author songyateng
      * @description 
      * @date 2018/11/23 22:33
      */
    @Test
    public void listEquipUseDTO() {
        try {
            PageParameter<EquipUseDTO> pageParameter = new PageParameter();
            EquipUseDTO equipUseDTO = new EquipUseDTO();
            pageParameter.setStartIndex(1);
            pageParameter.setPageRows(1);
            pageParameter.setStartPage(1);
            PageBean<EquipUseDTO> equipUseDTOPageBean = equipUseDaoImpl.listEquipUseDTO(pageParameter);
            System.out.println(equipUseDTOPageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}