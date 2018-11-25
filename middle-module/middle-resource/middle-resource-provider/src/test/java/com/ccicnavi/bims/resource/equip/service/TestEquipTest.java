package com.ccicnavi.bims.resource.equip.service;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.impl.EquipTestDaoImpl;
import com.ccicnavi.bims.resource.pojo.EquipTestDO;
import com.ccicnavi.bims.resource.pojo.EquipTestDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
  * @author songyateng
  * @description 测试设备检定信息
  * @date 2018/11/23 17:00
  */
@Slf4j
public class TestEquipTest {

    EquipTestDaoImpl equipUseDaoImpl = new EquipTestDaoImpl();

    /**
      * @author songyateng
      * @description 根据设备检定信息主键获取设备检定信息
      * @date 2018/11/23 17:04
      */
    @Test
    public void getEquipTest(){
        try {
            EquipTestDO equipUseDO = new EquipTestDO();
            equipUseDO.setEquipTestUuid("equip_test_uuid_a");
            equipUseDO.setAppSysUuid("yewu2.0");
            equipUseDO.setOrgUuid("yewu2.0");
            equipUseDO.setProdCatalogUuid("yewu2.0");
            EquipTestDO equipTest = equipUseDaoImpl.getEquipTest(equipUseDO);
            System.err.println(equipTest);
        } catch (Exception e){
           log.error("获取设备检定记录失败",e);
        }
    }

    /**
      * @author songyateng
      * @description 根据uuids查询设备信息
      * @date 2018/11/24 9:25
      */
    @Test
    public void getEquipTestList(){
        try {
            EquipTestDTO equipUseDTO = new EquipTestDTO();
            equipUseDTO.setAppSysUuid("yewu2.0");
            equipUseDTO.setOrgUuid("yewu2.0");
            equipUseDTO.setProdCatalogUuid("yewu2.0");
            /*List<String> equipUuids = new ArrayList<>();
            equipUuids.add("equip_test_uuid_a");
            equipUuids.add("equip_test_uuid_b");
            equipUuids.add("equip_test_uuid_c");
            equipUseDTO.setEquipTestUuids(equipUuids);*/
            equipUseDTO.setEquipUuid("equip_uuid_a");
            List<EquipTestDO> equipTestList = equipUseDaoImpl.getEquipTestList(equipUseDTO);
            System.err.println(equipTestList);
            System.out.println(equipTestList.size()+"条");
        }catch (Exception e){
            log.error("批量获取设备检定记录",e);
        }
    }
    
    /**
      * @author songyateng
      * @description 设备检定信息查询
      * @date 2018/11/24 9:31
      */
    @Test
    public void listEquipTest(){
        try {
            PageParameter<EquipTestDO> pageParameter = new PageParameter();
            EquipTestDO equipUseDO = new EquipTestDO();
            pageParameter.setStartIndex(1);
            pageParameter.setPageRows(1);
            pageParameter.setStartPage(1);
            PageBean<EquipTestDO> equipTestDOPageBean = equipUseDaoImpl.listEquipTest(pageParameter);
            System.err.println(equipTestDOPageBean);
        }catch (Exception e){
            log.error("查询设备检定记录失败",e);
        }
    }

    /**
      * @author songyateng
      * @description 新增设备检定信息
      * @date 2018/11/24 9:34
      */
    @Test
    public void insertEquipTest(){
        try {
            EquipTestDO equipUseDO = new EquipTestDO();
            equipUseDO.setEquipTestUuid("equip_test_uuid_c");
            equipUseDO.setEquipUuid("equip_uuid_a");
            equipUseDO.setIsDeleted("N");
            equipUseDO.setProdCatalogUuid("yewu2.0");
            equipUseDO.setOrgUuid("yewu2.0");
            equipUseDO.setAppSysUuid("yewu2.0");
            System.err.print(equipUseDaoImpl.insertEquipTest(equipUseDO, null));
        } catch (Exception e){
            log.error("新增设备失败",e);
        }
    }

    /**
      * @author songyateng
      * @description 更新设备检定信息
      * @date 2018/11/24 9:39
      */
    @Test
    public void updateEquipTest(){
        try {
            EquipTestDO equipUseDO = new EquipTestDO();
            equipUseDO.setEquipTestUuid("equip_test_uuid_c");
            //equipUseDO.setEquipUuid("equip_uuid_a");
            equipUseDO.setIsDeleted("N");
            equipUseDO.setCertNo("A02");
            equipUseDO.setProdCatalogUuid("yewu2.0");
            equipUseDO.setOrgUuid("yewu2.0");
            equipUseDO.setAppSysUuid("yewu2.0");
            System.err.print(equipUseDaoImpl.updateEquipTest(equipUseDO, null));
        } catch (Exception e){
            log.error("更新设备信息失败",e);
        }
    }

    /**
      * @author songyateng
      * @description 根据设备领用归还信息主键删除设备领用归还信息
      * @date 2018/11/24 9:43
      */
    @Test
    public void deleteEquipTest(){
        try {
            EquipTestDTO equipTestDTO = new EquipTestDTO();
            //equipTestDTO.setEquipTestUuid("equip_test_uuid_c");
            equipTestDTO.setEquipUuid("equip_uuid_a");
            System.err.print(equipUseDaoImpl.deleteEquipTest(equipTestDTO, null));
        } catch (Exception e){
            log.error("删除失败",e);
        }
    }
    
    /**
      * @author songyateng
      * @description 查询设备检定记录(关联查询)
      * @date 2018/11/24 9:47
      */
    @Test
    public void listEquipTestDTO(){
        try {
            PageParameter<EquipTestDTO> pageParameter = new PageParameter();
            EquipTestDTO equipTestDTO = new EquipTestDTO();
            pageParameter.setStartIndex(1);
            pageParameter.setPageRows(1);
            pageParameter.setStartPage(1);
            equipTestDTO.setAppSysUuid("yewu2.0");
            equipTestDTO.setProdCatalogUuid("yewu2.0");
            equipTestDTO.setOrgUuid("yewu2.0");
            PageBean<EquipTestDTO> equipTestDTOPageBean = equipUseDaoImpl.listEquipTestDTO(pageParameter);
            System.out.println(equipTestDTOPageBean);
        } catch (Exception e) {
            log.error("查询设备检定记录",e);
        }
    }
}
