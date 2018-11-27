package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.EquipService;
import com.ccicnavi.bims.resource.dao.EquipDao;
import com.ccicnavi.bims.resource.dao.EquipTestDao;
import com.ccicnavi.bims.resource.dao.EquipUseDao;
import com.ccicnavi.bims.resource.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备信息api接口实现类
 * @author: panyida
 * @create: 2018-11-14 16:10
 **/
@Slf4j
@Service
public class EquipServiceImpl implements EquipService {

    @Autowired
    private EquipDao equipDao;

    @Autowired
    private EquipTestDao equipTestDao;

    @Autowired
    private EquipUseDao equipUseDao;

    @Reference(timeout = 3000)
    IdWorkerService idWorkerService;

    /**
     * @Author panyida
     * @Description 设备信息查询(公共接口)
     * @Date 16:28 2018/11/14
     * @Param [equipDO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipDO>
     */
    @Override
    public PageBean<EquipDO> listEquip(PageParameter<EquipDTO> pageParameter) {
        PageBean<EquipDO> listEquipDO = null;
        try {
            listEquipDO = equipDao.listEquip(pageParameter);
        } catch (Exception e) {
            log.error("设备信息查询错误", e);
        }
        return listEquipDO;
    }

    /**
     * @Author MengZiJie
     * @Description 设备台账查询
     * @Data 2018/11/25 17:29
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.EquipDO>
     */
    @Override
    public PageBean<EquipDTO> listEquipByTest(PageParameter<EquipDTO> pageParameter) {
        PageBean<EquipDTO> listEquipDO = null;
        try {
            listEquipDO = equipDao.listEquipByTest(pageParameter);
        } catch (Exception e) {
            log.error("设备信息查询错误", e);
        }
        return listEquipDO;
    }

    /**
     * @Author MengZiJie
     * @Description 到期提醒查询
     * @Data 2018/11/23 11:24
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.EquipDO>
     */
    @Override
    public PageBean<EquipDO> expireListEquip(PageParameter<EquipDTO> pageParameter) {
        PageBean<EquipDO> listEquipDO = null;
        try {
            EquipDTO equipDTO = pageParameter.getParameter();
            Integer expireDay = equipDTO.getExpireDay();
            if(expireDay > 0){
                /**获取当前时间：年/月/日*/
                Date vardate = new Date();
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String newDate = sdf.format(vardate);
                calendar.setTime(vardate);
                /**减去提醒的天数*/
                calendar.add(Calendar.DAY_OF_MONTH, +expireDay);
                vardate = calendar.getTime();
                equipDTO.setTestValidDate(vardate);
            }
            listEquipDO =  equipDao.listEquip(pageParameter);
        } catch (Exception e) {
            log.error("到期查询失败",e);
        }
        return listEquipDO;
    }

    /**
     * @Author MengZiJie
     * @Description 获取设备信息及领用、检定记录
     * @Data 2018/11/23 20:35
     * @Param [equipDTO]
     * @Return com.ccicnavi.bims.resource.pojo.EquipDTO
     */
    @Override
    public EquipDTO getEquipInfolist(EquipDTO equipDTO) {
        //创建检定记录对象
        EquipTestDTO equipTestDTO = new EquipTestDTO();
        //创建领用记录对象
        EquipUseDTO equipUseDTO = new EquipUseDTO();
        EquipDTO equipInfo = equipDao.getEquip(equipDTO);
        if(equipInfo != null){
            /**设置相关参数*/
            equipTestDTO.setEquipUuid(equipDTO.getEquipUuid());
            /**获取设备相关检定记录*/
            List<EquipTestDO> equipTestDO = equipTestDao.getEquipTestList(equipTestDTO);
            if(equipTestDO.size() > 0){
                equipInfo.setEquipTestDTO(equipTestDO);
            }
            /**设置相关参数*/
            equipUseDTO.setEquipUuid(equipDTO.getEquipUuid());
            /**获取设备相关*/
            List<EquipUseDO> equipUses = equipUseDao.getEquipUseList(equipUseDTO);
            if(equipUses.size() > 0){
                equipInfo.setEquipUseDO(equipUses);
            }
            return equipInfo;
        }
        return null;
    }

    /**
     * @Author panyida
     * @Description 根据设备信息主键获取设备信息
     * @Date 16:29 2018/11/14
     * @Param [equipUuid]
     * @Return com.ccicnavi.bims.resource.pojo.EquipDO
     */
    @Override
    public EquipDTO getEquip(EquipDTO equipDTO){
        EquipDTO equip = null;
        try {
            equip = equipDao.getEquip(equipDTO);
        } catch (Exception e) {
            log.error("根据设备信息主键获取设备信息错误",e);
        }
        return equip;
    }

    /**
     * @Author MengZiJie
     * @Description 根据uuids查询设备
     * @Data 2018/11/23 15:34
     * @Param [equipDTO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipDTO>
     */
    @Override
    public List<EquipDTO> getEquipList(EquipDTO equipDTO) {
        List<EquipDTO> equipDTOList = null;
        try {
            equipDTOList = equipDao.getEquipList(equipDTO);
        } catch (Exception e) {
            log.error("获取信息失败",e);
        }
        return equipDTOList;
    }

    /**
     * @Author panyida
     * @Description 更新设备信息
     * @Date 16:30 2018/11/14
     * @Param [equipDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer updateEquip(EquipDO equipDO){
        /**创建事务*/
        EqlTran eqlTran = new Eql().newTran();
        /**定义检定记录对象*/
        EquipTestDTO equipTestDTO = new EquipTestDTO();
        EquipTestDO equipTestDO = new EquipTestDO();
        /**自定义list*/
        List<String> testUuidList = new ArrayList<>();
        Integer count = 0;
        try {
            eqlTran.start();
            equipTestDO.setCertNo(equipDO.getCertNo());//证书号
            equipTestDO.setTestDate(equipDO.getTestDate());//检测日期
            equipTestDO.setTestCycle(equipDO.getTestCycle());//检定周期
            equipTestDO.setIsLongTerm(equipDO.getIsLongTerm());//是否长期有效
            equipTestDO.setTestValidDate(equipDO.getTestValidDate());//检定有效日期
            equipTestDO.setTestResult(equipDO.getTestResult());//检定结果
            equipTestDO.setTestType(equipDO.getTestType());//检测类型
            equipTestDO.setTestFee(equipDO.getTestFee());//费用
            equipTestDO.setFeeDesc(equipDO.getFeeDesc());//费用说明
            equipTestDO.setStandardDesc(equipDO.getStandardDesc());//依据技术文件
            equipTestDO.setOnlineCertUrl(equipDO.getOnlineCertUrl());//证书在线url
            /**查询对应检定记录*/
            equipTestDTO.setEquipUuid(equipDO.getEquipUuid());
            List<EquipTestDO> equipTestList = equipTestDao.getEquipTestList(equipTestDTO);
            if(equipTestList.size() > 0){
                for (int i = 0;i < equipTestList.size();i++) {
                    EquipTestDO  equipTestInfo = equipTestList.get(i);
                    if(!StringUtils.isEmpty(equipTestInfo.getCertNo())){
                        testUuidList.add(equipTestInfo.getEquipTestUuid());
                        equipTestDO.setEquipTestUuid(equipTestInfo.getEquipTestUuid());
                        equipTestDao.updateEquipTest(equipTestDO,eqlTran);
                    }
                }
                if(testUuidList.size() <= 0){
                    /**获取主键*/
                    String equipTestUuid = idWorkerService.getId(new Date());
                    /**设置相关参数*/
                    equipTestDO.setEquipTestUuid(equipTestUuid);
                    equipTestDO.setEquipUuid(equipDO.getEquipUuid());
                    equipTestDO.setOrgUuid(equipDO.getOrgUuid());//设置组织机构id
                    equipTestDO.setProdCatalogUuid(equipDO.getProdCatalogUuid());//设置产品线id
                    equipTestDO.setAppSysUuid(equipDO.getAppSysUuid());//设置应用系统id
                    equipTestDao.insertEquipTest(equipTestDO,eqlTran);
                }
            } else {
                /**获取主键*/
                String equipTestUuid = idWorkerService.getId(new Date());
                /**设置相关参数*/
                equipTestDO.setEquipTestUuid(equipTestUuid);
                equipTestDO.setEquipUuid(equipDO.getEquipUuid());
                equipTestDO.setProdCatalogUuid(equipDO.getProdCatalogUuid());//设置产品线id
                equipTestDO.setOrgUuid(equipDO.getOrgUuid());//设置组织机构id
                equipTestDO.setAppSysUuid(equipDO.getAppSysUuid());//设置应用系统id
                equipTestDao.insertEquipTest(equipTestDO,eqlTran);
            }
            count = equipDao.updateEquip(equipDO,null);
            eqlTran.commit();
        } catch (Exception e) {
            log.error("更新设备信息错误",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
        return count;
    }

    /**
     * @Author panyida
     * @Description 新增设备信息
     * @Date 16:29 2018/11/14
     * @Param [equipDO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertEquip(EquipDO equipDO){
        Integer count = null;
        try {
            //获取主键
            String equipUuid = idWorkerService.getId(new Date());
            equipDO.setEquipUuid(equipUuid);
            count = equipDao.insertEquip(equipDO,null);
        } catch (Exception e) {
            log.error("新增设备信息错误",e);
        }
        return count;
    }

    /**
     * @Author panyida
     * @Description 根据设备信息主键删除设备信息
     * @Date 16:30 2018/11/14
     * @Param [equipUuid]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquip(EquipDTO equipDTO){
        Integer count = 0;
        try {
            count = equipDao.deleteEquip(equipDTO,null);
        } catch (Exception e) {
            log.error("根据设备信息主键删除设备信息错误",e);
        }
        return count;
    }

    /**
     * @Author MengZiJie
     * @Description 删除器具台账(器具、检定、领用信息)
     * @Data 2018/11/26 10:31
     * @Param [equipDTO]
     * @Return java.lang.Integer
     */
    @Override
    public Integer deleteEquipInfo(EquipDTO equipDTO) {
        /**创建事务*/
        EqlTran eqlTran = new Eql().newTran();
        /**定义检定记录对象*/
        EquipTestDTO equipTestDTO = new EquipTestDTO();
        /**定义领用记录对象*/
        EquipUseDTO equipUseDTO = new EquipUseDTO();
        Boolean equip = true;
        try {
            eqlTran.start();
            Integer count = equipDao.deleteEquip(equipDTO,eqlTran);
            if(count <= 0){
                equip = false;
            }
            /**判断是否是批量操作*/
            if(equipDTO.getEquipUuid() != null){
                equipTestDTO.setEquipUuid(equipDTO.getEquipUuid());
                equipUseDTO.setEquipUuid(equipDTO.getEquipUuid());
            }else if(equipDTO.getEquipUuids().size() > 0){
                equipTestDTO.setEquipUuids(equipDTO.getEquipUuids());
                equipUseDTO.setEquipUuids(equipDTO.getEquipUuids());
            }
            /**删除设备检定记录*/
            Integer equipTest = equipTestDao.deleteEquipTest(equipTestDTO,eqlTran);
            if(equipTest <= 0){
                equip = false;
            }
            /**删除设备领用记录*/
            Integer equipUse = equipUseDao.deleteEquipUse(equipUseDTO,eqlTran);
            if(equipUse <= 0){
                equip = false;
            }
            if(equip = true){
                eqlTran.commit();
                return count;
            }
        } catch (Exception e) {
            log.error("删除设备台账失败",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
        return -1;
    }

}
