package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.EquipService;
import com.ccicnavi.bims.resource.dao.EquipDao;
import com.ccicnavi.bims.resource.pojo.EquipDO;
import com.ccicnavi.bims.resource.pojo.EquipDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.SimpleDateFormat;
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

    /**
     * @Author panyida
     * @Description 设备信息查询
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
                /**加上提醒的天数*/
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
     * @Author panyida
     * @Description 根据设备信息主键获取设备信息
     * @Date 16:29 2018/11/14
     * @Param [equipUuid]
     * @Return com.ccicnavi.bims.resource.pojo.EquipDO
     */
    @Override
    public EquipDO getEquip(String equipUuid){
        EquipDO equipDO = null;
        try {
            equipDO = equipDao.getEquip(equipUuid);
        } catch (Exception e) {
            log.error("根据设备信息主键获取设备信息错误",e);
        }
        return equipDO;
    }

    /**
     * @Author MengZiJie
     * @Description 根据uuids查询设备
     * @Data 2018/11/23 15:34
     * @Param [equipDTO]
     * @Return java.util.List<com.ccicnavi.bims.resource.pojo.EquipDTO>
     */
    @Override
    public List<EquipDO> getEquipList(EquipDTO equipDTO) {
        List<EquipDO> equipDO = null;
        try {
            equipDO = equipDao.getEquipList(equipDTO);
        } catch (Exception e) {
            log.error("获取信息失败",e);
        }
        return equipDO;
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
        Integer count = null;
        try {
            count = equipDao.updateEquip(equipDO,null);
        } catch (Exception e) {
            log.error("更新设备信息错误",e);
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
        Integer count = null;
        try {
            count = equipDao.deleteEquip(equipDTO,null);
        } catch (Exception e) {
            log.error("根据设备信息主键删除设备信息错误",e);
        }
        return count;
    }



}
