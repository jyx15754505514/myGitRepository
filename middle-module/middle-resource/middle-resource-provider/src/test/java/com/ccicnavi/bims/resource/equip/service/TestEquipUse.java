package com.ccicnavi.bims.resource.equip.service;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.impl.EquipUseDaoImpl;
import com.ccicnavi.bims.resource.pojo.EquipUseDO;
import com.ccicnavi.bims.resource.pojo.EquipUseDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author songyateng
 * @Description 测试设备领用归还信息
 * @Date $time$ $date$
 * @Param $param$
 * @Return $return$
 */
@Slf4j
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
            EquipUseDO equipUseDO = new EquipUseDO();
            equipUseDO.setAppSysUuid("yewu2.0");
            equipUseDO.setOrgUuid("yewu2.0");
            equipUseDO.setProdCatalogUuid("yewu2.0");
            equipUseDO.setEquipUseUuid("equip_use_uuid_a");
            EquipUseDO equipUse = equipUseDaoImpl.getEquipUse(equipUseDO);
            System.out.println(equipUse);
        } catch (Exception e){
            log.error("获取设备领用信息失败",e);
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
            equipUseDTO.setAppSysUuid("yewu2.0");
            equipUseDTO.setOrgUuid("yewu2.0");
            equipUseDTO.setProdCatalogUuid("yewu2.0");
            equipUseDTO.setEquipUuid("equip_uuid_a");
            /*List<String> equipUse = new ArrayList<String>();
            equipUse.add("equip_use_uuid_a");
            equipUse.add("equip_use_uuid_b");
            equipUse.add("equip_use_uuid_c");
            equipUseDTO.setEquipUseUuids(equipUse);*/
            List<EquipUseDO> equipUseList = equipUseDaoImpl.getEquipUseList(equipUseDTO);
            System.out.println(equipUseList);
            System.out.println(equipUseList.size()+"条");
        }catch (Exception e){
            log.error("批量获取设备领用记录失败",e);
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
            log.error("查询设备领用记录失败",e);
        }
    }

    /**
      * @author songyateng
      * @description 添加设备领用信息
      * @date 2018/11/23 20:16
      */
    @Test
    public void insertEquipUse(){
        try {
            EquipUseDO equipUseDO = new EquipUseDO();
            equipUseDO.setEquipUseUuid("equip_use_uuid_d");
            equipUseDO.setEquipUuid("equip_uuid_a");
            equipUseDO.setIsDeleted("N");
            equipUseDO.setProdCatalogUuid("yewu2.0");
            equipUseDO.setOrgUuid("yewu2.0");
            equipUseDO.setAppSysUuid("yewu2.0");
            System.err.print(equipUseDaoImpl.insertEquipUse(equipUseDO, null));
        } catch (Exception e){
            log.error("添加设备领用记录失败",e);
        }
    }
    
    /**
      * @author songyateng
      * @description 更新设备领用记录
      * @date 2018/11/23 20:25
      */
    @Test
    public void updateEquipUse(){
        try {
            EquipUseDO equipUseDO = new EquipUseDO();
            equipUseDO.setEquipUseUuid("equip_use_uuid_a");
            //equipUseDO.setEquipUuid("equip_uuid_a");
            equipUseDO.setIsDeleted("N");
            equipUseDO.setProdCatalogUuid("yewu2.0");
            equipUseDO.setOrgUuid("yewu2.0");
            equipUseDO.setAppSysUuid("yewu2.0");
            equipUseDO.setUsePerson("admin");
            System.err.print(equipUseDaoImpl.updateEquipUse(equipUseDO, null));
        }  catch (Exception e){
            log.error("更新设备领用记录失败",e);
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
            //equipUseDTO.setEquipUseUuid("equip_use_uuid_a");
            equipUseDTO.setEquipUuid("equip_uuid_a");
            System.err.print(equipUseDaoImpl.deleteEquipUse(equipUseDTO, null));
        } catch (Exception e){
            log.error("删除设备领用记录失败",e);
        }
    }
    /**
      * @author songyateng
      * @description 查询设备领用记录
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
            equipUseDTO.setAppSysUuid("yewu2.0");
            equipUseDTO.setOrgUuid("yewu2.0");
            equipUseDTO.setProdCatalogUuid("yewu2.0");
            PageBean<EquipUseDTO> equipUseDTOPageBean = equipUseDaoImpl.listEquipUseDTO(pageParameter);
            System.out.println(equipUseDTOPageBean);
        } catch (Exception e) {
            log.error("查询设备领用记录失败",e);
        }
    }
}