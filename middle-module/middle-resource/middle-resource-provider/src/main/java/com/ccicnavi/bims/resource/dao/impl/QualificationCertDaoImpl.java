package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.QualificationCertDao;
import com.ccicnavi.bims.resource.pojo.QualificationCertDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationCertDaoImpl implements QualificationCertDao {

    /**
     *查询人员资格证书
     */
    @Override
    public List<QualificationCertDO> listQualificationCertDO(QualificationCertDO qualificationCertDO)throws Exception{
        return new Eql().select("listQualificationCertDO").params(qualificationCertDO).returnType(QualificationCertDO.class).execute();
    }

    /**
     *新增人员资格证书
     */
    @Override
    public Integer insertQualificationCertDO(QualificationCertDO qualificationCertDO)throws Exception{
        return new Eql().insert("insertQualificationCertDO").params(qualificationCertDO).returnType(Integer.class).execute();
    }

    /**
     *更改人员资格证书
     */
    @Override
    public Integer updateQualificationCertDO(QualificationCertDO qualificationCertDO)throws Exception{
        return new Eql().insert("updateQualificationCertDO").params(qualificationCertDO).returnType(Integer.class).execute();
    }

    /**
     *删除人员资格证书
     */
    @Override
    public Integer deleteQualificationCertDO(QualificationCertDO qualificationCertDO)throws Exception{
        return new Eql().insert("deleteQualificationCertDO").params(qualificationCertDO).returnType(Integer.class).execute();
    }

    /**
     *根据主键查询人员资格证书
     */
    @Override
    public QualificationCertDO getQualificationCertDO(QualificationCertDO qualificationCertDO)throws Exception{
        return new Eql().selectFirst("getQualificationCertDO").params(qualificationCertDO).returnType(QualificationCertDO.class).execute();
    }

    /**
     *分页查询人员工作经历
     */
    @Override
    public PageBean<QualificationCertDO> getQualificationCertPage(PageParameter<QualificationCertDO> pageParameter)throws Exception{
        EqlPage page = new EqlPage(pageParameter.getStartIndex(),pageParameter.pageRows);
        List<QualificationCertDO> qualificationCertDOS = new Eql().select("getQualificationCertPage").params(pageParameter.getParameter()).returnType(QualificationCertDO.class).limit(page).execute();
        return  new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),qualificationCertDOS);
    }
}
