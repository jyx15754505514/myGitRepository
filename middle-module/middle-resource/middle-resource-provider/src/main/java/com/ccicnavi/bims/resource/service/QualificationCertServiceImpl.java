package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.QualificationCertService;
import com.ccicnavi.bims.resource.dao.QualificationCertDao;
import com.ccicnavi.bims.resource.dao.impl.QualificationCertDaoImpl;
import com.ccicnavi.bims.resource.pojo.QualificationCertDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class QualificationCertServiceImpl implements QualificationCertService {

    private final static Logger log = LoggerFactory.getLogger(QualificationCertDaoImpl.class);

    @Autowired
    QualificationCertDao resQualificationCertDao;

    /**
     *查询人员资格证书
     */
    @Override
    public List<QualificationCertDO> listQualificationCertDO(QualificationCertDO qualificationCertDO){
        try {
            return resQualificationCertDao.listQualificationCertDO(qualificationCertDO);
        } catch (Exception e) {
            log.error("查询人员资格证书失败",e);
            return null;
        }
    }

    /**
     *新增人员资格证书
     */
    @Override
    public Integer insertQualificationCertDO(QualificationCertDO qualificationCertDO){
        try {
            return resQualificationCertDao.insertQualificationCertDO(qualificationCertDO);
        } catch (Exception e) {
            log.error("新增人员资格证书失败",e);
            return null;
        }
    }

    /**
     *修改人员资格证书
     */
    @Override
    public Integer updateQualificationCertDO(QualificationCertDO qualificationCertDO){
        try {
            return resQualificationCertDao.updateQualificationCertDO(qualificationCertDO);
        } catch (Exception e) {
            log.error("修改人员资格证书失败",e);
            return null;
        }
    }

    /**
     *删除人员资格证书
     */
    @Override
    public Integer deleteQualificationCertDO(QualificationCertDO qualificationCertDO){
        try {
            return resQualificationCertDao.deleteQualificationCertDO(qualificationCertDO);
        } catch (Exception e) {
            log.error("删除人员资格证书失败",e);
            return null;
        }
    }

    /**
     *根据主键查询人员资格证书
     */
    @Override
    public QualificationCertDO getQualificationCertDO(QualificationCertDO qualificationCertDO){
        try {
            return resQualificationCertDao.getQualificationCertDO(qualificationCertDO);
        } catch (Exception e) {
            log.error("根据主键查询人员资格证书失败",e);
            return null;
        }
    }

    /**
     *分页查询人员工作经历
     */
    @Override
    public PageBean<QualificationCertDO> getQualificationCertPage(PageParameter<QualificationCertDO> pageParameter){
        try {
            return resQualificationCertDao.getQualificationCertPage(pageParameter);
        } catch (Exception e) {
            log.error("分页查询人员资格证书失败",e);
            return null;
        }
    }
}
