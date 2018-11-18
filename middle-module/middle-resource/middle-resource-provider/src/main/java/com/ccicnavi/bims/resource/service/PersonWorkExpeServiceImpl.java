package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.PersonWorkExpeService;
import com.ccicnavi.bims.resource.dao.PersonWorkExpeDao;
import com.ccicnavi.bims.resource.dao.impl.PersonWorkExpeDaoImpl;
import com.ccicnavi.bims.resource.pojo.PersonWorkExpeDO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service
public class PersonWorkExpeServiceImpl implements PersonWorkExpeService {
    private final static Logger log = LoggerFactory.getLogger(PersonWorkExpeDaoImpl.class);

    @Autowired
    PersonWorkExpeDao resPersonWorkExpeDao;

    /**
     *查询人员工作经历
     */
    @Override
    public List<PersonWorkExpeDO> listPersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO){
        try {
            return resPersonWorkExpeDao.listPersonWorkExpeDO(personWorkExpeDO);
        } catch (Exception e) {
            log.error("查询人员工作经历信息失败",e);
            return null;
        }
    }

    /**
     *新增人员工作经历
     */
    @Override
    public Integer insertPersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO){
        try {
            return resPersonWorkExpeDao.insertPersonWorkExpeDO(personWorkExpeDO);
        } catch (Exception e) {
            log.error("新增人员工作经历信息失败", e);
            return null;
        }
    }

    /**
     *修改人员工作经历
     */
    @Override
    public Integer updatePersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO){
        try {
            return resPersonWorkExpeDao.updatePersonWorkExpeDO(personWorkExpeDO);
        } catch (Exception e) {
            log.error("修改人员工作经历信息失败", e);
            return null;
        }
    }

    /**
     *删除人员工作经历
     */
    @Override
    public Integer deletePersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO){
        try {
            return resPersonWorkExpeDao.deletePersonWorkExpeDO(personWorkExpeDO);
        } catch (Exception e) {
            log.error("删除人员工作经历信息失败", e);
            return null;
        }
    }

    /**
     *根据主键查询人员工作经历
     */
    @Override
    public PersonWorkExpeDO getPersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO){
        try {
            return resPersonWorkExpeDao.getPersonWorkExpeDO(personWorkExpeDO);
        } catch (Exception e) {
            log.error("根据主键查询人员工作经历信息失败", e);
            return null;
        }
    }

    /**
     *分页查询人员工作经历
     */
    @Override
    public PageBean<PersonWorkExpeDO> getPersonWorkExpePage(PageParameter<PersonWorkExpeDO> pageParameter){
        try {
            return resPersonWorkExpeDao.getPersonWorkExpePage(pageParameter);
        } catch (Exception e) {
            log.error("分页查询人员工作经历信息失败", e);
            return null;
        }
    }


}
