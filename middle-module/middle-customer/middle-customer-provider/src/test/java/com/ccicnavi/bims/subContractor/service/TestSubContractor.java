package com.ccicnavi.bims.subContractor.service;


import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.dao.Impl.SubcontractorDaoImpl;
import com.ccicnavi.bims.customer.pojo.SubcontractorDO;
import org.junit.Test;

import java.text.SimpleDateFormat;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/20 20:31
 * @Description:
 */
public class TestSubContractor {

    private static SimpleDateFormat timeFormat = new SimpleDateFormat("yyMMddHHmmss");


    /**
     * 分包方列表
     **/
    @Test
    public void listSubcontractor() {
        try {
            SubcontractorDaoImpl subcontractorDaoImpl = new SubcontractorDaoImpl();
            PageParameter<SubcontractorDO> pageParameter = new PageParameter<>();
            pageParameter.startPage = 1;
            pageParameter.pageRows = 2;
            SubcontractorDO subcontractorDO = new SubcontractorDO();
            pageParameter.setParameter(subcontractorDO);
            subcontractorDaoImpl.listSubcontractor(pageParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }/**
     * 分包方新增
     **/
    @Test
    public void insertSubcontractor() {
        try {
            SubcontractorDaoImpl subcontractorDaoImpl = new SubcontractorDaoImpl();
            SubcontractorDO subcontractorDO = new SubcontractorDO();
            subcontractorDaoImpl.insertSubcontractor(subcontractorDO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
