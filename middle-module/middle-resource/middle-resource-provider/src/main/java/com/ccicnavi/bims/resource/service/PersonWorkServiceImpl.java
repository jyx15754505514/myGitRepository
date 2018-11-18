package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.PersonWorkService;
import com.ccicnavi.bims.resource.dao.PersonWorkDao;
import com.ccicnavi.bims.resource.dao.impl.PersonWorkDaoImpl;
import com.ccicnavi.bims.resource.pojo.PersonWorkDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class PersonWorkServiceImpl implements PersonWorkService {
    private final static Logger log = LoggerFactory.getLogger(PersonWorkDaoImpl.class);

    @Autowired
    PersonWorkDao resPersonWorkDao;

    /**
     *查询人员工作信息
     */
    @Override
    public List<PersonWorkDO> listPersonWorkDO(PersonWorkDO personWorkDO){
        try {
            return resPersonWorkDao.listPersonWorkDO(personWorkDO);
        } catch (Exception e) {
            log.error("查询人员工作信息失败",e);
            return null;
        }
    }

    /**
     *新增人员工作信息
     */
    @Override
    public Integer insertPersonWorkDO(PersonWorkDO personWorkDO){
        try {
            return resPersonWorkDao.insertPersonWorkDO(personWorkDO);
        } catch (Exception e) {
            log.error("新增人员工作信息失败",e);
            return null;
        }
    }

    /**
     *修改人员工作信息
     */
    @Override
    public Integer updatePersonWorkDO(PersonWorkDO personWorkDO){
        try {
            return resPersonWorkDao.updatePersonWorkDO(personWorkDO);
        } catch (Exception e) {
            log.error("修改人员工作信息失败",e);
            return null;
        }
    }

    /**
     *删除人员工作信息
     */
    @Override
    public Integer deletePersonWorkDO(PersonWorkDO personWorkDO){
        try {
            return resPersonWorkDao.deletePersonWorkDO(personWorkDO);
        } catch (Exception e) {
            log.error("删除人员工作信息失败",e);
            return null;
        }
    }

    /**
     *根据主键查询人员工作信息
     */
    @Override
    public PersonWorkDO getPersonWorkDO(PersonWorkDO personWorkDO){
        try {
            return resPersonWorkDao.getPersonWorkDO(personWorkDO);
        } catch (Exception e) {
            log.error("根据主键查询人员工作信息失败",e);
            return null;
        }
    }

    /**
     *分页查询人员工作信息
     */
    @Override
    public PageBean<PersonWorkDO> getPersonWorkPage(PageParameter<PersonWorkDO> pageParameter){
        try {
            return resPersonWorkDao.getPersonWorkPage(pageParameter);
        } catch (Exception e) {
            log.error("分页查询人员工作信息失败",e);
            return null;
        }
    }


}
