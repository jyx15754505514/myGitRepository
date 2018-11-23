package com.ccicnavi.bims.customer.service;

import com.ccicnavi.bims.customer.dao.Impl.CustInvoiceDaoImpl;
import com.ccicnavi.bims.customer.pojo.CustInvoiceDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: LiJie
 * @create: 2018-11-16 11:31
 */
public class TestCustInvoice {

    @org.junit.Test
    public void listCustAddr() {
        CustInvoiceDaoImpl custAddrDao=new CustInvoiceDaoImpl();
        List<CustInvoiceDO> custAddrDOS = custAddrDao.listCustInvoice(new CustInvoiceDO());
        System.out.println(custAddrDOS);
    }
}
