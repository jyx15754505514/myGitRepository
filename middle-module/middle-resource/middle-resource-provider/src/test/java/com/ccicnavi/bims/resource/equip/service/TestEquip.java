package com.ccicnavi.bims.resource.equip.service;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.impl.EquipDaoImpl;
import com.ccicnavi.bims.resource.pojo.EquipDO;
import com.ccicnavi.bims.resource.pojo.EquipDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
  * @author songyateng
  * @description 测试设备信息持久层实现类
  * @date 2018/11/24 11:07
  */
@Slf4j
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
            equipDTO.setEquipUuid("equip_uuid_a");
            equipDTO.setAppSysUuid("yewu2.0");
            equipDTO.setOrgUuid("yewu2.0");
            equipDTO.setProdCatalogUuid("yewu2.0");
            EquipDTO equip = equipDaoImpl.getEquip(equipDTO);
            System.err.println(equip);
        } catch (Exception e) {
            log.error("获取设备信息失败",e);
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
            equipUseDTO.setAppSysUuid("yewu2.0");
            equipUseDTO.setOrgUuid("yewu2.0");
            equipUseDTO.setProdCatalogUuid("yewu2.0");
            List<String> uuids  = new ArrayList<String>();
            uuids.add("equip_uuid_a");
            uuids.add("equip_uuid_b");
            //uuids.add("equip_uuid_c");
            equipUseDTO.setEquipUuids(uuids);
            List<EquipDTO> equipList = equipDaoImpl.getEquipList(equipUseDTO);
            System.err.println(equipList);
            System.out.println(equipList.size()+"条");
        } catch (Exception e) {
            log.error("批量获取设备信息失败",e);
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
            //设置分页参数
            pageParameter.setStartIndex(1);
            pageParameter.setPageRows(3);
            pageParameter.setStartPage(1);
            //设置查询参数
            equipDTO.setAppSysUuid("yewu2.0");
            equipDTO.setOrgUuid("yewu2.0");
            equipDTO.setProdCatalogUuid("yewu2.0");
            PageBean<EquipDO> equipDOPageBean = equipDaoImpl.listEquip(pageParameter);
            System.err.println(equipDOPageBean);
        } catch (Exception e) {
            log.error("查询设备信息失败",e);
        }
    }

    /**
     * @Author MengZiJie
     * @Description 超期提醒查询
     * @Data 2018/11/25 9:47
     */
    @Test
    public void expireListEquip(){
        Integer expireDay = 7;
        try {
            PageParameter<EquipDTO> pageParameter = new PageParameter();
            EquipDTO equipDTO = new EquipDTO();
            //设置分页参数
            pageParameter.setStartIndex(1);
            pageParameter.setPageRows(3);
            pageParameter.setStartPage(1);
            //设置查询参数
            equipDTO.setAppSysUuid("yewu2.0");
            equipDTO.setOrgUuid("yewu2.0");
            equipDTO.setProdCatalogUuid("yewu2.0");
            /**获取当前时间：年/月/日*/
            Date vardate = new Date();
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String newDate = sdf.format(vardate);
            calendar.setTime(vardate);
            /**减去提醒的天数*/
            calendar.add(Calendar.DAY_OF_MONTH, -expireDay);
            vardate = calendar.getTime();
            System.out.println("到期时间为：" +vardate);
            equipDTO.setTestValidDate(vardate);
            pageParameter.setParameter(equipDTO);
            PageBean<EquipDO> equipDOPageBean = equipDaoImpl.listEquip(pageParameter);
            System.err.println(equipDOPageBean);
            System.out.println(equipDOPageBean.getProducts().size()+"条");
        } catch (Exception e) {
            log.error("查询超期设备失败",e);
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
            equipDO.setEquipUuid("equip_uuid_d");
            equipDO.setIsDeleted("N");
            equipDO.setProdCatalogUuid("yewu2.0");
            equipDO.setOrgUuid("yewu2.0");
            equipDO.setAppSysUuid("yewu2.0");
            System.err.print(equipDaoImpl.insertEquip(equipDO, null));
        } catch (Exception e){
            log.error("添加设备信息失败",e);
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
            equipDO.setEquipUuid("equip_uuid_d");
            equipDO.setEquipName("斯伯丁篮球");
            equipDO.setIsDeleted("N");
            equipDO.setProdCatalogUuid("yewu2.0");
            equipDO.setOrgUuid("yewu2.0");
            equipDO.setAppSysUuid("yewu2.0");
            System.err.print(equipDaoImpl.updateEquip(equipDO, null));
        } catch (Exception e) {
            log.error("更新设备信息失败",e);
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
            equipDTO.setEquipUuid("equip_uuid_d");
            System.err.print(equipDaoImpl.deleteEquip(equipDTO, null));
        } catch (Exception e){
            log.error("删除设备失败",e);
        }
    }
}