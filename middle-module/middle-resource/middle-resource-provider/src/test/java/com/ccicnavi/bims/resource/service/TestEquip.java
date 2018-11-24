package com.ccicnavi.bims.resource.service;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.impl.EquipDaoImpl;
import com.ccicnavi.bims.resource.pojo.EquipDO;
import com.ccicnavi.bims.resource.pojo.EquipDTO;
import org.junit.Test;

import java.util.List;

/**
  * @author songyateng
  * @description 测试设备信息持久层实现类
  * @date 2018/11/24 11:07
  */
public class TestEquip {
    EquipDaoImpl equipDaoImpl = new EquipDaoImpl();

    /**
     * @author songyateng
     * @description 根据设备信息主键获取设备信息
     * @date 2018/11/24 11:10
     */
    @Test
    public void getEquip() {
        try {
            EquipDTO equipDTO = new EquipDTO();
            equipDTO.setEquipUuid("nihaoa");
            EquipDTO equip = equipDaoImpl.getEquip(equipDTO);
            System.err.println(equip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @author songyateng
     * @description 根据uuids 查询设备信息
     * @date 2018/11/24 11:19
     */
    @Test
    public void getEquipList() {
        try {
            EquipDTO equipUseDTO = new EquipDTO();
            equipUseDTO.setAppSysUuid("yingyongxitongid");
            List<EquipDTO> equipList = equipDaoImpl.getEquipList(equipUseDTO);
            System.err.println(equipList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @author songyateng
     * @description 设备信息查询
     * @date 2018/11/24 11:25
     */
    @Test
    public void listEquip() {
        try {
            PageParameter<EquipDTO> pageParameter = new PageParameter();
            EquipDTO equipDTO = new EquipDTO();
            pageParameter.setStartIndex(1);
            pageParameter.setPageRows(1);
            pageParameter.setStartPage(1);
            PageBean<EquipDO> equipDOPageBean = equipDaoImpl.listEquip(pageParameter);
            System.err.println(equipDOPageBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
      * @author songyateng
      * @description 新增设备信息
      * @date 2018/11/24 11:36
      */
    @Test
    public void insertEquip(){
        try {
            EquipDO equipDO = new EquipDO();
            equipDO.setEquipUuid("tytytyty");
            equipDO.setIsDeleted("N");
            equipDO.setProdCatalogUuid("123");
            equipDO.setOrgUuid("guishujigouid");
            equipDO.setAppSysUuid("yingyongxitongid");
            System.err.print(equipDaoImpl.insertEquip(equipDO, null));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    /**
      * @author songyateng
      * @description 更新设备信息
      * @date 2018/11/24 11:46
      */
    @Test
    public void updateEquip() {
        try {
            EquipDO equipDO = new EquipDO();
            equipDO.setEquipUuid("zhujiana");
            equipDO.setIsDeleted("N");
            equipDO.setProdCatalogUuid("xiugaiwancheng");
            equipDO.setOrgUuid("xiugaiwancheng");
            equipDO.setAppSysUuid("xiugaiwancheng");
            System.err.print(equipDaoImpl.updateEquip(equipDO, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
      * @author songyateng
      * @description 根据设备信息主键删除设备信息
      * @date 2018/11/24 11:54
      */
    @Test
    public void deleteEquip(){
        try{
            EquipDTO equipDTO = new EquipDTO();
            equipDTO.setEquipUuid("tytytyty");
            System.err.print(equipDaoImpl.deleteEquip(equipDTO, null));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}