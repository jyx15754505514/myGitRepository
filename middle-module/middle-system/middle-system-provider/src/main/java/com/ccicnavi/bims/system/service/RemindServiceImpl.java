package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.RemindDao;
import com.ccicnavi.bims.system.dao.impl.RemindDaoImpl;
import com.ccicnavi.bims.system.pojo.RemindDO;
import com.ccicnavi.bims.system.pojo.RemindDTO;
import com.ccicnavi.bims.system.service.api.RemindService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 提醒设置api实现
 * @author: zqq
 * @create: 2018-11-15 11:06
 */
@Service
public class RemindServiceImpl implements RemindService {

    private final static Logger log = LoggerFactory.getLogger(RemindDaoImpl.class);

    @Autowired
    private RemindDao sysRemindDao;
    @Override
    public PageBean<RemindDO> listRemind(PageParameter<RemindDO> PageParameter){
        try {
            return sysRemindDao.listRemind(PageParameter);
        }catch (Exception e) {
            log.info("根据条件查询提醒设置失败" + e);
            return null;
        }
     //   return new PageBean<RoleDO>(0,0,0,0,0,new ArrayList<RemindDO>());
    }

    @Override
    public Integer insertRemind(RemindDO remind){
        try {
           Integer num =  sysRemindDao.insertRemind(remind,null);
            return num;
        }catch (Exception e) {
            log.error("新增提醒设置失败", e);
            return 0;
        }
    }

    @Override
    public Integer updateRemind(RemindDO remind){
        try {
            Integer num = sysRemindDao.updateRemind(remind,null);
            return num;
        }catch (Exception e) {
            log.error("修改提醒设置失败", e);
            return 0;
        }
    }

    @Override
    public Integer deleteRemind(RemindDO remind){
        try {
            Integer num = sysRemindDao.deleteRemind(remind,null);
             return num;
        }catch (Exception e) {
            log.error("删除提醒设置失败", e);
            return 0;
        }
    }

    @Override
    public RemindDO getRemind(RemindDO remind){
        try {
            RemindDO remindDO = sysRemindDao.getRemind(remind);
            return remindDO;
        }catch (Exception e) {
            log.error("根据主键获取提醒设置失败", e);
            return null;
        }
    }

    @Override
    public PageBean<RemindDTO> listRemindOrg(PageParameter<RemindDO> pageParameter){
        try {
            return sysRemindDao.listRemindOrg(pageParameter);
        } catch (Exception e) {
            log.error("根据条件查询设置提醒失败", e);
            return null;
        }
    }

    @Override
    public List<RemindDO> listRemindList(RemindDO remind) {

        try {
            return sysRemindDao.listRemindList(remind);
        } catch (Exception e) {
            log.error("根据条件查询设置提醒失败", e);
           return null;
        }
    }
}
