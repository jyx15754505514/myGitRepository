package com.ccicnavi.bims.resource.equip.service;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.impl.EquipDaoImpl;
import com.ccicnavi.bims.resource.dao.impl.EquipTestDaoImpl;
import com.ccicnavi.bims.resource.dao.impl.EquipUseDaoImpl;
import com.ccicnavi.bims.resource.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.text.ParsePosition;
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

    //调用设备信息
    EquipDaoImpl equipDaoImpl = new EquipDaoImpl();

    //调用设备领用记录
    EquipTestDaoImpl equipTestDaoImpl = new EquipTestDaoImpl();

    //调用设备检定记录
    EquipUseDaoImpl equipUseDaoImpl = new EquipUseDaoImpl();

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
            System.out.println(equipDOPageBean.getProducts().size()+"条");
        } catch (Exception e) {
            log.error("查询设备信息失败",e);
        }
    }

    /**
     * @Author MengZiJie
     * @Description 设备台账查询
     * @Data 2018/11/25 17:52
     */
    @Test
    public void listEquipByTest(){
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
        vardate = calendar.getTime();
        System.out.println("参数："+vardate);
        equipDTO.setNowDate(vardate);
        pageParameter.setParameter(equipDTO);
        PageBean<EquipDTO> equipDOPageBean = equipDaoImpl.listEquipByTest(pageParameter);
        System.out.println(equipDOPageBean.getProducts().size()+"条");
        for (int i = 0;i < equipDOPageBean.getProducts().size(); i++) {
            System.out.println("第"+(i+1)+"条"+equipDOPageBean.getProducts().get(i).getEquipUuid());
            System.out.println(equipDOPageBean.getProducts().get(i).getEquipTestUuid());
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
            calendar.add(Calendar.DAY_OF_MONTH, +expireDay);
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
     * @Author MengZiJie
     * @Description 获取设备信息及领用、检定记录
     * @Data 2018/11/25 11:41
     * @Param []
     * @Return void
     */
    @Test
    public void getEquipInfolist(){
        //创建设备信息对象
        EquipDTO equipDTO = new EquipDTO();
        //创建检定记录对象
        EquipTestDTO equipTestDTO = new EquipTestDTO();
        //创建领用记录对象
        EquipUseDTO equipUseDTO = new EquipUseDTO();
        //查询设备信息
        equipDTO.setEquipUuid("equip_uuid_a");
        equipDTO.setAppSysUuid("yewu2.0");
        equipDTO.setOrgUuid("yewu2.0");
        equipDTO.setProdCatalogUuid("yewu2.0");
        EquipDTO equip = equipDaoImpl.getEquip(equipDTO);
        if(equipDTO != null){
            /**设置相关参数*/
            equipTestDTO.setAppSysUuid(equipDTO.getAppSysUuid());
            equipTestDTO.setOrgUuid(equipDTO.getOrgUuid());
            equipTestDTO.setProdCatalogUuid(equipDTO.getProdCatalogUuid());
            equipTestDTO.setEquipUuid(equipDTO.getEquipUuid());
            /**获取设备相关检定记录*/
            List<EquipTestDO> equipTestDO = equipTestDaoImpl.getEquipTestList(equipTestDTO);
            if(equipTestDO.size() > 0){
                equipDTO.setEquipTestDTO(equipTestDO);
            }
            /**设置相关参数*/
            equipUseDTO.setAppSysUuid(equipDTO.getAppSysUuid());
            equipUseDTO.setOrgUuid(equipDTO.getOrgUuid());
            equipUseDTO.setProdCatalogUuid(equipDTO.getProdCatalogUuid());
            equipUseDTO.setEquipUuid(equipDTO.getEquipUuid());
            /**获取设备相关*/
            List<EquipUseDO> equipUses = equipUseDaoImpl.getEquipUseList(equipUseDTO);
            if(equipUses.size() > 0){
                equipDTO.setEquipUseDO(equipUses);
            }
        }
        System.out.println(equipDTO);
        System.out.println("设备领用记录："+equipDTO.getEquipUseDO().size());
        System.out.println("设备检定记录："+equipDTO.getEquipTestDTO().size());
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

    /**
     * @Author MengZiJie
     * @Description 获取当前时间 类型Date() 格式yyyy-MM-dd
     * @Data 2018/11/25 17:15
     */
    @Test
    public void getDate(){
        /**获取当前时间：年/月/日*/
        Date vardate = new Date();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String newDate = sdf.format(vardate);
        System.out.println("当前时间（字符串）为："+newDate);
        ParsePosition pos = new ParsePosition(0);
        Date parse = sdf.parse(newDate, pos);
        System.out.println("yyyy-MM-dd格式结果为："+parse);
    }
}