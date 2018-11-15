package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.resource.dao.QualificationCertDao;
import com.ccicnavi.bims.resource.pojo.QualificationCertDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationCertDaoImpl implements QualificationCertDao {
    /**
     *查询人员资格证书
     */
    @Override
    public List<QualificationCertDO> listQualificationCertDO(QualificationCertDO qualificationCertDO) {
        return new Eql().select("listQualificationCertDO").params(qualificationCertDO).returnType(QualificationCertDO.class).execute();
    }

    /**
     *新增人员资格证书
     */
    @Override
    public Integer insertQualificationCertDO(QualificationCertDO qualificationCertDO) {
        return new Eql().insert("insertQualificationCertDO").params(qualificationCertDO).returnType(Integer.class).execute();
    }

    /**
     *更改人员资格证书
     */
    @Override
    public Integer updateQualificationCertDO(QualificationCertDO qualificationCertDO) {
        return new Eql().insert("updateQualificationCertDO").params(qualificationCertDO).returnType(Integer.class).execute();
    }

    /**
     *删除人员资格证书
     */
    @Override
    public Integer deleteQualificationCertDO(QualificationCertDO qualificationCertDO) {
        return new Eql().insert("deleteQualificationCertDO").params(qualificationCertDO).returnType(Integer.class).execute();
    }

    /**
     *根据主键查询人员资格证书
     */
    @Override
    public QualificationCertDO getQualificationCertDO(QualificationCertDO qualificationCertDO){
        return new Eql().selectFirst("getQualificationCertDO").params(qualificationCertDO).returnType(QualificationCertDO.class).execute();
    }
}
